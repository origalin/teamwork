package edu.nju.businesslogic.systembl;

import java.util.ArrayList;


import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;

public class SystemBl implements SystemLogicService{

	@Override
	public ArrayList<edu.nju.vo.OperationVO> getOperationVOList(long beginTime,
			long endTime) {
		// 逻辑层根据数据层返回的PO创建VO返回给展示层
		return null;
	}

	@Override
	public AccountVO getAccountVO(int id) {
		// 逻辑层根据数据层返回的PO创建VO返回给展示层
		return null;
	}

	@Override
	public void saveAccount(AccountPO po) {
		
	}

	

}
