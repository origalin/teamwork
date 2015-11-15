package Main;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;


public class Main {

	public Main() {
		try {
			LogisticsDataService logisticsDateService=new LogisticsDataServiceImpl();
			//注册通讯端口
			LocateRegistry.createRegistry(6600);
			//注册通讯路径
			Naming.rebind("rmi://127.0.0.1:6600/PersonService", logisticsDateService);
			System.out.println("Service Start!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
