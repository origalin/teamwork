package edu.nju.businesslogicservice.storagelogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.RecordPO;

public interface StorageModifyService {
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Train();
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() ;

	
	public void storageModify(String district,String currPersonID,String storageID,int quantity) throws RemoteException;
	public void storageRealease(String storageID) throws RemoteException;
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Car();

}
