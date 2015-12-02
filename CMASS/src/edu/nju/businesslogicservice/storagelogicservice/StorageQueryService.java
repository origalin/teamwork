package edu.nju.businesslogicservice.storagelogicservice;

import java.util.ArrayList;

import edu.nju.po.RecordPO;

public interface StorageQueryService {

	public ArrayList<RecordPO> getInWareHouseDocVO_Fly(String s);
	public ArrayList<RecordPO> getInWareHouseDocVO_Train(String s);
	public ArrayList<RecordPO> getInWareHouseDocVO_Car(String s);
}
