package edu.nju.dataservice.storagedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.exception.NoSpace;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.WareHousePO;

public interface StorageDataService extends Remote {

	public StorageLocation getValidLocation(String sID, String distriction) throws RemoteException, NoSpace;
	public void storageModify(String to,String storageID,int quantity)throws RemoteException;
	public void markPositionOccupied(ArrayList<StorageLocation> list) throws RemoteException;
    void storageRealease(String storageID)throws RemoteException;
	public String getCurrInWare_ID() throws RemoteException;

	public void saveInWareHouseDoc(InWareHouseDocPO in) throws RemoteException;

	public void saveOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException;

	

	public ArrayList<RecordPO> getInWareHouseDocPO_Fly(String storageID) throws RemoteException;

	public ArrayList<RecordPO> getInWareHouseDocPO_Train(String storageID) throws RemoteException;

	public ArrayList<RecordPO> getInWareHouseDocPO_Car(String storageID) throws RemoteException;

	

	void updateOutWareHouseDoc(OutWareHouseDocPO out) throws RemoteException;

	void updateInWareHouseDoc(InWareHouseDocPO in) throws RemoteException;

	

	public void clear(String storageID) throws RemoteException;

	public void addNewStorageItem(RecordPO recordPO) throws RemoteException;

	


	

	

	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() throws RemoteException;

	public ArrayList<OutWareHouseDocPO> getOutWareHouseDoc_unchecked() throws RemoteException;

	public String getCurrOutWare_ID() throws RemoteException;

}
