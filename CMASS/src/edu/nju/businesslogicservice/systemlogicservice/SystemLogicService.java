package edu.nju.businesslogicservice.systemlogicservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.AccountPO;
import edu.nju.po.HistoryPO;
import edu.nju.po.OperationPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;
import edu.nju.vo.OperationVO;
import edu.nju.vo.SendDocVO;

public interface SystemLogicService {
	public ArrayList<OperationVO> getOperationVOList(long beginTime,long endTime);//获取操作记录VOList
	public AccountVO getAccountVO(int id);//获取账户VO
	
	public void  saveAccount(AccountPO po);//保存账户的PO
}
