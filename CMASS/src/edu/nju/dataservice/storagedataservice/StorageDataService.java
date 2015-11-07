package edu.nju.dataservice.storagedataservice;

import java.util.ArrayList;

import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;

public interface StorageDataService{
	public void update(ArrayList<RecordPO> recordPO);
	
	public long getInWareHouseDocID();//�õ����������ⵥ��idӦΪ����
	
	ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList);//����ʱ���ɳ��ⵥ��
	
	public long getOutWareHouseDocID();//�õ�������ɳ��ⵥ��idӦΪ����
	
	void updateOutWareHouseDoc(OutWareHouseDocPO out);
	
	void updateInWareHouseDoc(InWareHouseDocPO in);
	
	public void clear();
	
	public void setPercent(double p);
	
	public void setAlarm(double p);
	
	
	public void modify(double t);
	
	
	public void updateInWarehouseDoc(InWareHouseDocPO t);
	
	
	public RecordPO find(int StorageItemID);
	
	
	public double getPercent(String district);
	
	
	public ArrayList<RecordPO> getOutWarehouseDoc();
	
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc();

}
