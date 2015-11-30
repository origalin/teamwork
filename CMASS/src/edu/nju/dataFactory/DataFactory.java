package edu.nju.dataFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;

public class DataFactory {
	static StorageDataService storageDataService = null;
	static LogisticsDataService logisticsDataService = null;

	public DataFactory() {
		// TODO Auto-generated constructor stub
	}

	public static StorageDataService getStorageImpl() {

		try {
			if (storageDataService == null)
				storageDataService = (StorageDataService) Naming.lookup("rmi://127.0.0.1:6600/storageDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storageDataService;
	}

	public static LogisticsDataService getLogisticsDataService() {

		try {
			if (logisticsDataService == null)
				logisticsDataService = (LogisticsDataService) Naming
						.lookup("rmi://127.0.0.1:6600/LogisticsDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logisticsDataService;
	}

}
