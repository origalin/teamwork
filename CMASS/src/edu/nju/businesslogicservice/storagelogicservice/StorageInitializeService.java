package edu.nju.businesslogicservice.storagelogicservice;

import java.rmi.RemoteException;

import edu.nju.po.RecordPO;

public interface StorageInitializeService {
	public void clear(String storageID) throws RemoteException;
	public void addNewStorageItem(RecordPO recordPO) throws RemoteException;

}
