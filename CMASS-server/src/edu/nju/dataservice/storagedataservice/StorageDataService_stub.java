//package edu.nju.dataservice.storagedataservice;
//
//import java.util.ArrayList;
//
//import edu.nju.po.InWareHouseDocPO;
//import edu.nju.po.OutWareHouseDocPO;
//import edu.nju.po.RecordPO;
//import edu.nju.po.WareHousePO;
//
//public class StorageDataService_stub implements StorageDataService{
//	public void update(ArrayList<RecordPO> l){
//		System.out.println("Recordlist update success!");
//	}
//	
//	
//	public void clear(){
//		System.out.println("Record clear success!");
//	}
//	
//	
//	public ArrayList<RecordPO> getRecordList(){
//		ArrayList<RecordPO> t=new ArrayList<RecordPO>();
//		t.add(new RecordPO());//这边可以提供一些参数用来构造PO
//		t.add(new RecordPO());
//		return t;
//		}
//	
//	
//	public void modify(double t){
//		System.out.println("Modified!");
//	}
//	
//	
//	public void updateInWarehouseDoc(InWareHouseDocPO t){
//		System.out.println("updateInWarehouseDoc  success!");
//	}
//	
//	
//	public RecordPO find(int StorageItemID){
//		RecordPO p=new RecordPO();//需要加参数
//		return p;}
//	
//	
//	public double getPercent(String district){return 0.35;}
//	
//	
//	public ArrayList<RecordPO> getOutWarehouseDoc(){
//		ArrayList<RecordPO> t=new ArrayList<RecordPO>();
//		t.add(new RecordPO());//这边可以提供一些参数用来构造PO
//		t.add(new RecordPO());
//		return t;}//??
//	
//	
//	public ArrayList<InWareHouseDocPO> getInWarehouseDoc(){
//		ArrayList<InWareHouseDocPO> t=new ArrayList<InWareHouseDocPO>();
//		t.add(new InWareHouseDocPO());//这边可以提供一些参数用来构造PO
//		t.add(new InWareHouseDocPO());
//		return t;}
//
//
//	@Override
//	public long getInWareHouseDocID() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	public ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public long getOutWareHouseDocID() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//	@Override
//	public void updateOutWareHouseDoc(OutWareHouseDocPO out) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void updateInWareHouseDoc(InWareHouseDocPO in) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void setPercent(double p) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public void setAlarm(double p) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public WareHousePO getWareHouse() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public void update(RecordPO recordPO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//	@Override
//	public ArrayList<RecordPO> getInWareHouseDocVO_Fly() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public ArrayList<RecordPO> getInWareHouseDocVO_Train() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public ArrayList<RecordPO> getInWareHouseDocVO_Car() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public void addNewStorageItem(RecordPO recordPO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//}
