package edu.nju.dataFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;

public class DataFactory {

	
	public DataFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static StorageDataService getStorageImpl(){

		StorageDataService storageDataService = null;
		try {
			storageDataService = (StorageDataService)Naming.lookup("rmi://127.0.0.1:6600/storageDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storageDataService;
	}
	
	public static LogisticsDataService getLogisticsDataService(){
		LogisticsDataService logisticsDataService =null;
		try {
			logisticsDataService= (LogisticsDataService)Naming.lookup("rmi://127.0.0.1:6600/LogisticsDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logisticsDataService;
	}
	
	

}
