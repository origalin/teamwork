package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po) throws RemoteException;//������ת���ĵ��ﵥ�־û�����
	public String getZArrivalSequence() throws RemoteException;//��ȡ���ﵥ��׼���к�
	public void changeZArrivalSequence() throws RemoteException;//�ı��׼���к�
	public ZArrivalDocVO findZArrivalDocVO(String ID) throws RemoteException, DatabaseNULLException;//��ȡ���ﵥVO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs() throws RemoteException;
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException;
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException;
	public void  confirmSave() throws RemoteException;
}
