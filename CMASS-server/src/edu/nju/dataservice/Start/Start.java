package edu.nju.dataservice.Start;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import com.mysql.jdbc.Driver;

import edu.nju.data.InfoDataServiceImpl.CarDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.DistanceDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.DriverDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.InstitutionDataServiceImpl;
import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;
import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.data.SystemDataServiceImpl.SystemDataServiceImpl;
import edu.nju.dataservice.approvedataservice.ApproveDataService;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;

public class Start {

	public Start() {
	
	}
	
	public static void main(String[] args) {
		 
		 try {				
				LogisticsDataService logisticsDataService=new LogisticsDataServiceImpl();
				StorageDataService storageDataService=new StorageDataServiceImpl();
				
				SystemDataService systemDataService=new SystemDataServiceImpl();
				CarDataService carDataService=new CarDataServiceImpl();
				DistanceDataService distanceDataService=new DistanceDataServiceImpl();
				DriverDataService driverDataService=new DriverDataServiceImpl();
				InstitutionDataService institutionDataService=new InstitutionDataServiceImpl();
				
				//注册通讯端口
				LocateRegistry.createRegistry(6600);
				//注册通讯路径
				Naming.rebind("rmi://127.0.0.1:6600/LogisticsDataService", logisticsDataService);
				Naming.rebind("rmi://127.0.0.1:6600/storageDataService", storageDataService);
				Naming.rebind("rmi://127.0.0.1:6600/SystemDataService", systemDataService);
				
				Naming.rebind("rmi://127.0.0.1:6600/CarDataService", carDataService);
				Naming.rebind("rmi://127.0.0.1:6600/DistanceDataService", distanceDataService);
				Naming.rebind("rmi://127.0.0.1:6600/DriverDataService", driverDataService);
				Naming.rebind("rmi://127.0.0.1:6600/InstitutionDataService", institutionDataService);
				
				System.out.println("Service Start!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
