package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po) throws RemoteException;//������ת����װ�����־û�����
	public String getZloadSequence() throws RemoteException;//��ȡװ������׼���к�
	public void changeZloadSequence() throws RemoteException;//�ı��׼���к�
	public ZLoadDocVO createZLoadDocVO(String carID,String target,String watcher,String driver,String[] itemIDs) throws RemoteException;//����װ����VO
	public ZLoadDocVO getZLoadDocVO(String ID) throws RemoteException;//��ȡװ����VO/
	public ZLoadDocPO getZLoadDocPO(String ID) throws RemoteException;
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() throws RemoteException;
	public double[] getPriceToday();
	public String[] getSubBusinessHall();
	public String[][] getDrivers() throws RemoteException;
	public int getDriverTime(String drrverID) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
