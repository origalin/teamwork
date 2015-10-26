package edu.nju.dataservice.storagedataservice;

import java.util.ArrayList;

import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;

public interface StorageDataService{
	public void update(ArrayList<RecordPO> l);
	
	
	public void clear();
	
	
	public ArrayList<RecordPO> getRecordList();
	
	public void modify(double t);
	
	
	public void updateInWarehouseDoc(InWareHouseDocPO t);
	
	
	public RecordPO find(int StorageItemID);
	
	
	public double getPercent(String district);
	
	
	public ArrayList<RecordPO> getOutWarehouseDoc();
	
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc();

}
