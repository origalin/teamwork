package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;

public class StorageTools {
	public ArrayList<OutWareHouseDocPO> getOutWareHouseDocList() throws RemoteException{
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		
		return storageDataService.getOutWareHouseDoc_unchecked();
	}
	
	public ArrayList<InWareHouseDocPO> getInWareHouseDocList() throws RemoteException{
StorageDataService storageDataService=DataFactory.getStorageImpl();
		
		return storageDataService.getInWarehouseDoc();
	}
	
	boolean hasItem(long SendDocID){
		return true;
	}
	public void updateStorage(ArrayList<RecordPO> aList){}


	
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public ArrayList<RecordPO> getInWareHouseDocVO_Train() {
		// TODO Auto-generated method stub
		return null;
	}


	
	public ArrayList<RecordPO> getInWareHouseDocVO_Car() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveInWareHouseDocPO(InWareHouseDocPO in) throws RemoteException {
StorageDataService storageDataService=DataFactory.getStorageImpl();
		
		storageDataService.saveInWareHouseDoc(in);
		
	}

	public void saveOutWareHouseDocPO(OutWareHouseDocPO out) throws RemoteException {
StorageDataService storageDataService=DataFactory.getStorageImpl();
		
		storageDataService.saveOutWareHouseDoc(out);
		
	}


	
	

}
