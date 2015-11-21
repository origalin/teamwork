package edu.nju.dataservice.logisticsqueryDataService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;

public class Main {

	

	public static void main(String[] args) {
		 
		 try {
			
				LogisticsDataService logisticsDataService=new LogisticsDataServiceImpl();
				//注册通讯端口
				LocateRegistry.createRegistry(6600);
				//注册通讯路径
				Naming.rebind("rmi://127.0.0.1:6600/LogisticsDataService", logisticsDataService);
				System.out.println("Service Start!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
