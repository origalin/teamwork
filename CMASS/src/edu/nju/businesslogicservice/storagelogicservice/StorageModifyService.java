package edu.nju.businesslogicservice.storagelogicservice;

import java.util.ArrayList;

import edu.nju.po.RecordPO;

public interface StorageModifyService {
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Train();
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() ;

	
	public void storageModify(String district,String storageID);

	
	public ArrayList<RecordPO> getInWareHouseDocVO_Car();

}
