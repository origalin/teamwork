package edu.nju.businesslogic.logispicsquerybl;

import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.po.HistoryPO;
import edu.nju.vo.HistoryVO;

public class Logisticsquerybl implements LogispicsQueryLogicService{

	@Override
	public HistoryVO historyQuery(int SendDocID) {
		// 对运输模块有依赖，HistoryPO getHistoryPO(int SendDocID)
		return null;
	}
	

}
