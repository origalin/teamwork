package edu.nju.businesslogicservice.storagelogicservice;

import java.util.ArrayList;

import edu.nju.po.RecordPO;

public interface StorageModifyService {
	public void setAlarm(double p);
	public void setPercent(double p);
	public ArrayList<RecordPO> getInWareHouseDocVO_Train();
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() ;

	
	

	
	public ArrayList<RecordPO> getInWareHouseDocVO_Car();

}
