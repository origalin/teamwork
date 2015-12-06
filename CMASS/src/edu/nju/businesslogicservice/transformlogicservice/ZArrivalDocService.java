package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po) throws RemoteException;//保存中转中心到达单持久化对象
	public String getZArrivalSequence() throws RemoteException;//获取到达单基准序列号
	public void changeZArrivalSequence() throws RemoteException;//改变基准序列号
	public ZArrivalDocVO findZArrivalDocVO(String ID) throws RemoteException, DatabaseNULLException;//获取到达单VO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs() throws RemoteException;
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException;
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException;
	public void  confirmSave() throws RemoteException;
}
