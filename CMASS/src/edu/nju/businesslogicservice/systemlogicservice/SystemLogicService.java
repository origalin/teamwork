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
	public ArrayList<OperationVO> getOperationVOList(long beginTime,long endTime);//��ȡ������¼VOList
	public AccountVO getAccountVO(int id);//��ȡ�˻�VO
	
	public void  saveAccount(AccountPO po);//�����˻���PO
}
