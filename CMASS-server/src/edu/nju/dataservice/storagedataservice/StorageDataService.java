package edu.nju.dataservice.storagedataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

public interface StorageDataService extends Remote{
	public void update(ArrayList<RecordPO> recordPO);
	public void update(RecordPO recordPO);
	
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly();


	public ArrayList<RecordPO> getInWareHouseDocVO_Train();


	public ArrayList<RecordPO> getInWareHouseDocVO_Car();
	public long getInWareHouseDocID();//得到这次生成入库单的id应为多少
	
	ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList);//出库时生成出库单用
	
	public long getOutWareHouseDocID();//得到这次生成出库单的id应为多少
	
	void updateOutWareHouseDoc(OutWareHouseDocPO out);
	
	void updateInWareHouseDoc(InWareHouseDocPO in);
	
	WareHousePO getWareHouse();
	
	public void clear();
	
	public void addNewStorageItem(RecordPO recordPO) ;
	
	public void setPercent(double p);
	
	public void setAlarm(double p);
	
	
	public void modify(double t);
	
	
	public void updateInWarehouseDoc(InWareHouseDocPO t);
	
	
	public RecordPO find(int StorageItemID);
	
	
	public double getPercent(String district);
	
	
	public ArrayList<RecordPO> getOutWarehouseDoc();
	
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc();

}
