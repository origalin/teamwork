package edu.nju.businesslogicservice.storagelogicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.RecordPO;

public interface StorageQueryService {

	public ArrayList<RecordPO> getInWareHouseDocVO_Fly(String currPersonID,String s) throws RemoteException;
	public ArrayList<RecordPO> getInWareHouseDocVO_Train(String currPersonID,String s) throws RemoteException;
	public ArrayList<RecordPO> getInWareHouseDocVO_Car(String currPersonID,String s) throws RemoteException;
}
