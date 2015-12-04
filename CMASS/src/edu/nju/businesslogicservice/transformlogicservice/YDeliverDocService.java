package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public interface YDeliverDocService {
	public void saveYDeliverDocPO(YDeliverDocPO po) throws RemoteException;//保存派件单持久化对象
	public String getYDeliverSequence() throws RemoteException;//获取派件单序列基准号
	public YDeliverDocVO createYDeliverDoc(String[][] courierAndID) throws RemoteException;//创建派件单VO
	public ArrayList<YDeliverDocVO> findYDeliverDocVOs(String courierID) throws RemoteException;//获取派件单VO
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() throws RemoteException;
	public YDeliverDocPO getDeliverDocPOsByID(String staffID) throws RemoteException;
	public YDeliverDocVO getDeliverDocVOsByID(String YDeliverDocID) throws RemoteException;
	public void changeYDeliverDocSequence() throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
