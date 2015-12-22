package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.YArrivalDocPO;
import edu.nju.presentation.financeui.rentMoneyPanel;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po)throws RemoteException;//保存营业厅到达单持久化对象
	public String getYArrivalSequence()throws RemoteException;//获取到达单基准序列号
	public void changeYArrivalSequence()throws RemoteException;//改变基准序列号
	public YArrivalDocVO findYArrivalDocVO(String ID)throws RemoteException, DatabaseNULLException;//获取到达单VO
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs()throws RemoteException;
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates)throws RemoteException, DatabaseNULLException;
	public String getAddressByID(String itemID)throws RemoteException, DatabaseNULLException;
	public String[] getCouriers() throws RemoteException;
	public String getcoutierName(String courierID)throws RemoteException;
	public void  confirmSave()throws RemoteException;
	public void checkHas(String id)throws RemoteException,DatabaseNULLException;
}
