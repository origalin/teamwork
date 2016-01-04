package edu.nju.dataFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;

public class ConcreteFactory implements AbstractFactory {
	static FinanceDataService financeDataService=null;
	static StorageDataService storageDataService = null;
	static LogisticsDataService logisticsDataService = null;
	static CarDataService carDataService=null;
	static DriverDataService driverDataService=null;
	static DistanceDataService distanceDataService=null;
	static InstitutionDataService institutionDataService=null;
	static SystemDataService systemDataService=null;
	static TransferDataService transferDataService = null;
	static CollectionDataService collectionDataService = null;
	static String url="rmi://127.0.0.1:6600/";
	
	
	private static ConcreteFactory factory=null;
	private ConcreteFactory() {
		super();
	}
	
	public static ConcreteFactory getInstance(){
		if(factory==null)
			factory=new ConcreteFactory();
		return factory;
		
	}

	public StorageDataService getStorageImpl() {

		try {
			if (storageDataService == null)
				storageDataService = (StorageDataService) Naming.lookup(url+"storageDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storageDataService;
	}

	public LogisticsDataService getLogisticsDataService() {

		try {
			if (logisticsDataService == null)
				logisticsDataService = (LogisticsDataService) Naming
						.lookup(url+"LogisticsDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return logisticsDataService;
	}

	public CarDataService getCarDataService() {

		try {
			if (carDataService == null)
				carDataService = (CarDataService) Naming
						.lookup(url+"CarDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carDataService;
	}
	
	public DriverDataService getDriverDataService() {

		try {
			if (driverDataService == null)
				driverDataService = (DriverDataService) Naming
						.lookup(url+"DriverDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driverDataService;
	}
	
	public DistanceDataService getDistanceDataService() {

		try {
			if (distanceDataService == null)
				distanceDataService = (DistanceDataService) Naming
						.lookup(url+"DistanceDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distanceDataService;
	}

	public InstitutionDataService getInstitutionDataService() {

		try {
			if (institutionDataService == null)
				institutionDataService= (InstitutionDataService) Naming
						.lookup(url+"InstitutionDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return institutionDataService;
	}

	public SystemDataService getSystemDataService() {

		try {
			if (systemDataService == null)
				systemDataService = (SystemDataService) Naming
						.lookup(url+"SystemDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return systemDataService;
	}

	public TransferDataService getTransferDataService() {
		// TODO Auto-generated method stub
		try {
			if (transferDataService == null)
				transferDataService = (TransferDataService) Naming
						.lookup(url+"transferDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transferDataService;
	}

	public CollectionDataService getCollectionDataService() {
		// TODO Auto-generated method stub
		try {
			if (collectionDataService == null)
				collectionDataService = (CollectionDataService) Naming
						.lookup(url+"collectionDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collectionDataService;
	}
	
	public  FinanceDataService getFinanceDataService(){
		try{
			if(financeDataService==null){
				financeDataService=(FinanceDataService)Naming.lookup(url+"FinanceDataService");
				System.out.println("连接应该没有问题");
			}
		}catch(MalformedURLException|RemoteException|NotBoundException e){
			System.out.println("连接错误");
			e.printStackTrace();
			
		}
		return financeDataService;
	}
}
