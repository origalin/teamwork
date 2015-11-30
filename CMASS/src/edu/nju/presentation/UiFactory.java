package edu.nju.presentation;

import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;

public class UiFactory {

	static InWareHouseManagementService inWareHouseManagementService=null;
	static LogispicsQueryLogicService logispicsQueryLogicService=null;
	public UiFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static InWareHouseManagementService getInWareHouseManagementService(){
		if(inWareHouseManagementService==null)
			inWareHouseManagementService=new InWareHouseManagementbl();
		return inWareHouseManagementService;
	}
	
	public static LogispicsQueryLogicService getLogisticsQueryService(){
		if(logispicsQueryLogicService==null)
			logispicsQueryLogicService=new Logisticsquerybl();
		return logispicsQueryLogicService;
	}
	
	

}
