package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.YArrivalDocPO;

import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public interface YArrivalDocService {
	public void saveYArrivalDocPO(YArrivalDocPO po)throws RemoteException;//����Ӫҵ�����ﵥ�־û�����
	public String getYArrivalSequence()throws RemoteException;//��ȡ���ﵥ��׼���к�
	public void changeYArrivalSequence()throws RemoteException;//�ı��׼���к�
	public YArrivalDocVO findYArrivalDocVO(String ID)throws RemoteException, DatabaseNULLException;//��ȡ���ﵥVO
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs()throws RemoteException;
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates)throws RemoteException, DatabaseNULLException;
	public String getAddressByID(String itemID)throws RemoteException, DatabaseNULLException;
	public String[] getCouriers() throws RemoteException;
	public String getcoutierName(String courierID)throws RemoteException;
	public void  confirmSave()throws RemoteException;
	public void checkHas(String id)throws RemoteException,DatabaseNULLException;
}
