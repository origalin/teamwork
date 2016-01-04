package edu.nju.dataFactory;

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

public interface AbstractFactory {
	public StorageDataService getStorageImpl() ;

	public LogisticsDataService getLogisticsDataService() ;

	public CarDataService getCarDataService() ;
	
	public DriverDataService getDriverDataService() ;
	
	public DistanceDataService getDistanceDataService();

	public InstitutionDataService getInstitutionDataService();

	public SystemDataService getSystemDataService() ;

	public TransferDataService getTransferDataService() ;

	public CollectionDataService getCollectionDataService() ;
	
	public  FinanceDataService getFinanceDataService();

}
