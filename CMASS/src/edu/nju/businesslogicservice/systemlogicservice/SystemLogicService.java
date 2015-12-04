package edu.nju.businesslogicservice.systemlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.nju.po.AccountPO;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.OperationPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;
import edu.nju.vo.OperationVO;
import edu.nju.vo.SendDocVO;

public interface SystemLogicService {
	public ArrayList<OperationVO> getOperationVOList(Date beginTime,Date endTime) throws RemoteException;//获取操作记录VOList
	public void saveOperation(OperationPO po) throws RemoteException;
	
}
