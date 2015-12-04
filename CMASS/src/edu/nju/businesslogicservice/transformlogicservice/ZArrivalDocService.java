package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public interface ZArrivalDocService {
	public void saveZArrivalDocPO(ZArrivalDocPO po) throws RemoteException;//������ת���ĵ��ﵥ�־û�����
	public String getZArrivalSequence() throws RemoteException;//��ȡ���ﵥ��׼���к�
	public void changeZArrivalSequence() throws RemoteException;//�ı��׼���к�
	public ZArrivalDocVO findZArrivalDocVO(String ID) throws RemoteException;//��ȡ���ﵥVO
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs() throws RemoteException;
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates) throws RemoteException;
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
