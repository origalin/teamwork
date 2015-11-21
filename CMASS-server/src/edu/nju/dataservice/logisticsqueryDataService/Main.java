package edu.nju.dataservice.logisticsqueryDataService;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;

public class Main {

	

	public static void main(String[] args) {
		 System.out.println("Service Start!");
		 try {
			 System.out.println("Service Start!");
				LogisticsDataService logisticsDataService=new LogisticsDataServiceImpl();
				//ע��ͨѶ�˿�
				LocateRegistry.createRegistry(6600);
				//ע��ͨѶ·��
				Naming.rebind("rmi://127.0.0.1:6600/LogisticsDataService", logisticsDataService);
				System.out.println("Service Start!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
