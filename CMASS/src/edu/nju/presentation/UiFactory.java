package edu.nju.presentation;

import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.OutWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.StorageQuerybl;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.businesslogicservice.storagelogicservice.StorageQueryService;
import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;

public class UiFactory {

	static InWareHouseManagementService inWareHouseManagementService = null;
	static LogispicsQueryLogicService logispicsQueryLogicService = null;
	static StorageQueryService storageQueryService=null;
static OutWareHouseManagementService outWareHouseManagementService=null;
	public UiFactory() {
		// TODO Auto-generated constructor stub
	}

	public static StorageQueryService getStorageQueryService(){
		if(storageQueryService==null)
			storageQueryService=new StorageQuerybl();
		return storageQueryService;
	}

	public static InWareHouseManagementService getInWareHouseManagementService() {
		if (inWareHouseManagementService == null)
			inWareHouseManagementService = new InWareHouseManagementbl();
		return inWareHouseManagementService;
	}

	public static LogispicsQueryLogicService getLogisticsQueryService() {
		if (logispicsQueryLogicService == null)
			logispicsQueryLogicService = new Logisticsquerybl();
		return logispicsQueryLogicService;
	}

	public static OutWareHouseManagementService getOutWareHouseManagementService(){
		if(outWareHouseManagementService==null)
			outWareHouseManagementService=new OutWareHouseManagementbl();
		return outWareHouseManagementService;}

}
