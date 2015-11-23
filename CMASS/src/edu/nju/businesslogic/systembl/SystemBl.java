package edu.nju.businesslogic.systembl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;




import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;

public class SystemBl implements SystemLogicService{
	SystemDataService systemDataService;
	public SystemBl() {
		super();
//		list= new ArrayList<PositionPO>();
		try {
			this.systemDataService = systemDataService=(SystemDataService)Naming.lookup("rmi://127.0.0.1:6601/SystemDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}


	@Override
	public ArrayList<edu.nju.vo.OperationVO> getOperationVOList(long beginTime,
			long endTime) {
		// �߼���������ݲ㷵�ص�PO����VO���ظ�չʾ��
		return null;
	}

	@Override
	public AccountVO getAccountVO(int id) {
		// �߼���������ݲ㷵�ص�PO����VO���ظ�չʾ��
		return null;
	}

	@Override
	public void saveAccount(AccountPO po) {
		
	}

	

}
