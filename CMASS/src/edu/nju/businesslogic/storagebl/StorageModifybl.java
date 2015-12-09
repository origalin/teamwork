package edu.nju.businesslogic.storagebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.storagelogicservice.StorageModifyService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageModifybl implements StorageModifyService
{

	public void storageModify(String district,String storageID){
		StorageDataService storageDataService=DataFactory.getStorageImpl();
		storageDataService.storageModify(district,storageID);
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Train() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocVO_Car() {
		// TODO Auto-generated method stub
		return null;
	}

}
