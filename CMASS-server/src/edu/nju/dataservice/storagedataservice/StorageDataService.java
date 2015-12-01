package edu.nju.dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.WareHousePO;

public interface StorageDataService extends Remote{
	public StorageLocation getValidLocation(String sID,String distriction) throws RemoteException;
	public void markPositionOccupied(ArrayList<StorageLocation> list) throws RemoteException;
	public String getCurrInWare_ID() throws RemoteException;
	public void saveInWareHouseDoc(InWareHouseDocPO in) throws RemoteException;
	public void update(ArrayList<RecordPO> recordPO) throws RemoteException;
	public void update(RecordPO recordPO) throws RemoteException;
	
	
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID) throws RemoteException;


	public ArrayList<RecordPO> getInWareHouseDocPO_Train(String storageID)throws RemoteException;


	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID) throws RemoteException;
	public long getInWareHouseDocID() throws RemoteException;//得到这次生成入库单的id应为多少
	
	ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) throws RemoteException;//出库时生成出库单用
	
	public long getOutWareHouseDocID() throws RemoteException;//得到这次生成出库单的id应为多少
	
	void updateOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException;
	
	void updateInWareHouseDoc(InWareHouseDocPO in) throws RemoteException;
	
	WareHousePO getWareHouse() throws RemoteException;
	
	public void clear() throws RemoteException;
	
	public void addNewStorageItem(RecordPO recordPO)  throws RemoteException;
	
	public void setPercent(double p) throws RemoteException;
	
	public void setAlarm(double p) throws RemoteException;
	
	
	public void modify(double t) throws RemoteException;
	
	
	
	
	
	public RecordPO find(int StorageItemID) throws RemoteException;
	
	
	public double getPercent(String district) throws RemoteException;
	
	
	public ArrayList<RecordPO> getOutWarehouseDoc() throws RemoteException;
	
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() throws RemoteException;

}
