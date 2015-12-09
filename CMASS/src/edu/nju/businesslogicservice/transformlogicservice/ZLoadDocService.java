package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public interface ZLoadDocService {
	public void saveZloadDocPO(ZLoadDocPO po) throws RemoteException;//保存中转中心装车单持久化对象
	public String getZloadSequence() throws RemoteException;//获取装车单基准序列号
	public void changeZloadSequence() throws RemoteException;//改变基准序列号
	public ZLoadDocVO createZLoadDocVO(String carID,String target,String watcher,String driver,String[] itemIDs) throws RemoteException;//创建装车单VO
	public ZLoadDocVO getZLoadDocVO(String ID) throws RemoteException, DatabaseNULLException;//获取装车单VO/
	public ZLoadDocPO getZLoadDocPO(String ID) throws RemoteException, DatabaseNULLException;
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() throws RemoteException;
	public double[] getPriceToday();
	public String[] getSubBusinessHall() throws RemoteException;
	public String[][] getDrivers() throws RemoteException;
	public int getDriverTime(String drrverID) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
