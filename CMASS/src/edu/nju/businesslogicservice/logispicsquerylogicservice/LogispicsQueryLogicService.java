package edu.nju.businesslogicservice.logispicsquerylogicservice;

import edu.nju.vo.HistoryVO;

public interface LogispicsQueryLogicService {
	//根据一个寄件单编号查询该快件历史物流信息
	//但是现在没有维护快件这样一个类，历史轨迹信息存在哪里？
	public HistoryVO historyQuery(int SendDocID);

	

}
