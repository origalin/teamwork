package edu.nju.businesslogic.logispicsquerybl;

import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.po.HistoryPO;
import edu.nju.vo.HistoryVO;
import edu.nju.vo.PositionVO;

public class Logisticsquerybl implements LogispicsQueryLogicService{

	@Override
	public PositionVO historyQuery(int SendDocID) {
		// 对运输模块有依赖，PositionPO getHistoryPO(int SendDocID)
		return null;
	}
	

}
