package edu.nju.dataFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.data.SystemDataServiceImpl.SystemDataServiceImpl;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;

public class DataFactory {
	static StorageDataService storageDataService = null;
	static LogisticsDataService logisticsDataService = null;
	static CarDataService carDataService=null;
	static DriverDataService driverDataService=null;
	static DistanceDataService distanceDataService=null;
	static InstitutionDataService institutionDataService=null;
	static SystemDataService systemDataService=null;

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

	public static CarDataService getCarDataService() {

		try {
			if (carDataService == null)
				carDataService = (CarDataService) Naming
						.lookup("rmi://127.0.0.1:6600/CarDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carDataService;
	}
	
	public static DriverDataService getDriverDataService() {

		try {
			if (driverDataService == null)
				driverDataService = (DriverDataService) Naming
						.lookup("rmi://127.0.0.1:6600/DriverDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverDataService;
	}
	
	public static DistanceDataService getDistanceDataService() {

		try {
			if (distanceDataService == null)
				distanceDataService = (DistanceDataService) Naming
						.lookup("rmi://127.0.0.1:6600/DistanceDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distanceDataService;
	}

	public static InstitutionDataService getInstitutionDataService() {

		try {
			if (institutionDataService == null)
				institutionDataService= (InstitutionDataService) Naming
						.lookup("rmi://127.0.0.1:6600/InstitutionDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return institutionDataService;
	}

	public static SystemDataService getSystemDataService() {

		try {
			if (systemDataService == null)
				systemDataService = (SystemDataService) Naming
						.lookup("rmi://127.0.0.1:6600/SystemDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemDataService;
	}

}
