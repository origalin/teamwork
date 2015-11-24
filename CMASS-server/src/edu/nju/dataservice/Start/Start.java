package edu.nju.dataservice.Start;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;
import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.dataservice.approvedataservice.ApproveDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;

public class Start {

	public Start() {
	
	}
	
	public static void main(String[] args) {
		 
		 try {				
				LogisticsDataService logisticsDataService=new LogisticsDataServiceImpl();
				StorageDataService storageDataService=new StorageDataServiceImpl();
				
				//ע��ͨѶ�˿�
				LocateRegistry.createRegistry(6600);
				//ע��ͨѶ·��
				Naming.rebind("rmi://127.0.0.1:6600/LogisticsDataService", logisticsDataService);
				Naming.rebind("rmi://127.0.0.1:6600/storageDataService", storageDataService);
				System.out.println("Service Start!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
