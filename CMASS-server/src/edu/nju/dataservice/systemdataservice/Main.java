package edu.nju.dataservice.systemdataservice;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import edu.nju.data.SystemDataServiceImpl.SystemDataServiceImpl;


public class Main {
	public static void main(String[] args) {
		 
		 try {
				SystemDataService systemDataService=new SystemDataServiceImpl();
				//ע��ͨѶ�˿�
				LocateRegistry.createRegistry(6601);
				//ע��ͨѶ·��
				Naming.rebind("rmi://127.0.0.1:6601/SystemDataService", systemDataService);
				System.out.println("Service Start!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
