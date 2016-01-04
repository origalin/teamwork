package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;

import edu.nju.businesslogicservice.storagelogicservice.StorageInitializeService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageInitializebl implements StorageInitializeService{

	
	@Override
	public void clear(String storageID) throws RemoteException {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		storageDataService.clear(storageID);
		
	}

	@Override
	public void addNewStorageItem(RecordPO recordPO) throws RemoteException {
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		storageDataService.addNewStorageItem(recordPO);
		
	}

}
