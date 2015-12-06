package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po) throws RemoteException;//�����ɼ����־û�����
	public String getYDeliverSequence() throws RemoteException;//��ȡ�ɼ������л�׼��
	public YDeliverDocVO createYDeliverDoc(String[][] courierAndID) throws RemoteException;//�����ɼ���VO
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID) throws RemoteException;//��ȡ�ɼ���VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() throws RemoteException;
	public YDeliverDocPO getDeliverDocPOsByID(String staffID) throws RemoteException, DatabaseNULLException;
	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID) throws RemoteException, DatabaseNULLException;
	public void changeYDeliverDocSequence() throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
