package edu.nju.businesslogicservice.transformlogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public interface YLoadDocService {
	public void saveYloadDocPO(YLoadDocPO po) throws RemoteException;//保存营业厅装车单持久化对象
	public String getYloadSequence() throws RemoteException;//获取装车单基准序列号
	public void changeYloadSequence() throws RemoteException;//改变基准序列号
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) throws RemoteException;//创建装车单VO
	public YLoadDocVO getYLoadDocVO(String ID) throws RemoteException, DatabaseNULLException;//获取装车单VO
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() throws RemoteException;
	public double[] getPriceToday();
	public YLoadDocPO getYloadDocPOByID(String ID) throws RemoteException, DatabaseNULLException;
	public String getTransferCenter();
	public String[][] getDrivers();
	public int getDriverTime(String drrverID) throws RemoteException;
	public void  confirmSave() throws RemoteException;
}
