package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public interface OverDocService {
	public void saveOverDocPO(OverDocPO po);//�����ռ����־û�����
	public String getOverDocSequence() throws RemoteException;//��ȡ�ռ�����׼���к�
	public void changeOverDocSequence() throws RemoteException;//�ı��׼���к�
	public OverDocVO findOverDocVO(String ID);//��ȡ�ռ���VO
	public ArrayList<OverDocPO> getUncheckedOverDocPOs() throws RemoteException;
	public void  confirmSave() throws RemoteException, DatabaseNULLException;
	public OverDocVO createOverDocVO(String[] itemIDs ,String[] receivers) throws RemoteException;
}
