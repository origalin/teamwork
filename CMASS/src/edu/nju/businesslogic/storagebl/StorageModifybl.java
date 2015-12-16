package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.storagelogicservice.StorageModifyService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.OperationPO;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public class StorageModifybl implements StorageModifyService
{

	public void storageModify(String district,String currPersonID,String storageID) throws RemoteException{
		
		
		InstitutionLogicService institutionLogicService=new Institution();
		String staffName=institutionLogicService.getStaffName(currPersonID);

		StorageDataService storageDataService=DataFactory.getStorageImpl();
		storageDataService.storageModify(district,storageID);

		OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "调整了"+storageID+"库存"+",机动区到"+district);
		SystemBl systemBl=new SystemBl();
		systemBl.saveOperation(operationPO);
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
