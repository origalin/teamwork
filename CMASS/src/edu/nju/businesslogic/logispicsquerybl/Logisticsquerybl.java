package edu.nju.businesslogic.logispicsquerybl;

import java.util.ArrayList;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.po.PositionPO;
import edu.nju.vo.PositionVO;

public class Logisticsquerybl implements LogispicsQueryLogicService{

	ArrayList<PositionPO> list= new ArrayList<PositionPO>();
	@Override
	public PositionVO historyQuery(int SendDocID) {
		// 对数据层有依赖，遍历持久化文件
		return null;
	}
	
	public void changePosition(long ItemID,String pos){
		//对自己数据层有依赖，更新数据层的物流信息
	}
	
	public void createPosition(long Item,String pos){
		//对自己数据层有依赖，创建新快递的历史轨迹对象
		
	}
	

}
