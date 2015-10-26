package edu.nju.dataservice.storagedataservice;

import java.util.ArrayList;

import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;

public class StorageDataService_stub implements StorageDataService{
	public void update(ArrayList<RecordPO> l){
		System.out.println("Recordlist update success!");
	}
	
	
	public void clear(){
		System.out.println("Record clear success!");
	}
	
	
	public ArrayList<RecordPO> getRecordList(){
		ArrayList<RecordPO> t=new ArrayList<RecordPO>();
		t.add(new RecordPO());//��߿����ṩһЩ������������PO
		t.add(new RecordPO());
		return t;
		}
	
	
	public void modify(double t){
		System.out.println("Modified!");
	}
	
	
	public void updateInWarehouseDoc(InWareHouseDocPO t){
		System.out.println("updateInWarehouseDoc  success!");
	}
	
	
	public RecordPO find(int StorageItemID){
		RecordPO p=new RecordPO();//��Ҫ�Ӳ���
		return p;}
	
	
	public double getPercent(String district){return 0.35;}
	
	
	public ArrayList<RecordPO> getOutWarehouseDoc(){
		ArrayList<RecordPO> t=new ArrayList<RecordPO>();
		t.add(new RecordPO());//��߿����ṩһЩ������������PO
		t.add(new RecordPO());
		return t;}//??
	
	
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc(){
		ArrayList<InWareHouseDocPO> t=new ArrayList<InWareHouseDocPO>();
		t.add(new InWareHouseDocPO());//��߿����ṩһЩ������������PO
		t.add(new InWareHouseDocPO());
		return t;}


}
