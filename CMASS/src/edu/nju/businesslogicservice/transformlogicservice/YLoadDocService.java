package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po) throws RemoteException;//����Ӫҵ��װ�����־û�����
	public String getYloadSequence() throws RemoteException;//��ȡװ������׼���к�
	public void changeYloadSequence() throws RemoteException;//�ı��׼���к�
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) throws RemoteException;//����װ����VO
	public YLoadDocVO getYLoadDocVO(String ID) throws RemoteException, DatabaseNULLException;//��ȡװ����VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() throws RemoteException;
	public double[] getPriceToday();
	public YLoadDocPO getYloadDocPOByID(String ID) throws RemoteException, DatabaseNULLException;
	public String getTransferCenter() throws RemoteException;
	public String[][] getDrivers();
	public int getDriverTime(String drrverID) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
