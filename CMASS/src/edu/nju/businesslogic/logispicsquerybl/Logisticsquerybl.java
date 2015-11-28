package edu.nju.businesslogic.logispicsquerybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;
import edu.nju.vo.PositionVO;

public class Logisticsquerybl implements LogispicsQueryLogicService {
	LogisticsDataService logisticsDataService;
	// ArrayList<PositionPO> list;

	public Logisticsquerybl() {
		super();
		this.logisticsDataService = DataFactory.getLogisticsDataService();
		

	}

	@Override
	public PositionVO historyQuery(String SendDocID) {
		// 对数据层有依赖，遍历持久化文件\
		PositionVO vo = null;
		try {

			PositionPO po = logisticsDataService.positionQuery(SendDocID);
			vo = new PositionVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("逻辑层快递查询失败");
			e.printStackTrace();
		}
		return vo;
	}

	public void changePosition(String ItemID, String pos) {
		// 对自己数据层有依赖，更新数据层的物流信息
		try {
			logisticsDataService.changePosition(ItemID, pos);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("逻辑层历史轨迹修改失败");
			e.printStackTrace();
		}
	}

	public void createPosition(String string, String pos,String  destination) {
		// 对自己数据层有依赖，创建新快递的历史轨迹对象
		try {
			logisticsDataService.createPosition(string, pos, destination);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("逻辑层历史轨迹记录创建失败");
			e.printStackTrace();
		}
	}

}
