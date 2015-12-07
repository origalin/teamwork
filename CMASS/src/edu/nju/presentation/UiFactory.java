package edu.nju.presentation;

import edu.nju.businesslogic.infobl.Car;
import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.OutWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.StorageQuerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.infologicservice.CarLogicService;
import edu.nju.businesslogicservice.infologicservice.DistanceLogicService;
import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.businesslogicservice.storagelogicservice.StorageQueryService;
import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;

public class UiFactory {

	static InWareHouseManagementService inWareHouseManagementService = null;
	static LogispicsQueryLogicService logispicsQueryLogicService = null;
	static StorageQueryService storageQueryService=null;
   static OutWareHouseManagementService outWareHouseManagementService=null;


	static SystemLogicService systemLogicService=null;
	static CarLogicService carLogicService=null;
	static DriverLogicService driverLogicService=null;
	static DistanceLogicService distanceLogicService=null;
	static InstitutionLogicService institutionLogicService=null;
	
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
	
	public static SystemLogicService getSystemLogicService(){
		if(systemLogicService==null)
			systemLogicService=new SystemBl();
		return systemLogicService;}
	
	public static CarLogicService getCarLogicService(){
		if(carLogicService==null)
			carLogicService=new Car();
		return carLogicService;}

	public static DriverLogicService getDriverLogicService(){
		if(driverLogicService==null)
			driverLogicService=new Driver();
		return driverLogicService;}
	
	public static DistanceLogicService getDistanceLogicService(){
		if(distanceLogicService==null)
			distanceLogicService=new Distance();
		return distanceLogicService;}
	
	public static InstitutionLogicService getInstitutionLogicService(){
		if(institutionLogicService==null)
			institutionLogicService=new Institution();
		return institutionLogicService;}
}
