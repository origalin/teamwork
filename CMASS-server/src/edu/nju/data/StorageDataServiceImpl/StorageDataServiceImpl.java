package edu.nju.data.StorageDataServiceImpl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;
import edu.nju.tools.Time;

public class StorageDataServiceImpl implements StorageDataService {

	public StorageDataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(ArrayList<RecordPO> recordPO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RecordPO recordPO) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Fly() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Train() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RecordPO> getInWareHouseDocPO_Car() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getInWareHouseDocID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getOutWareHouseDocID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocPO out) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInWareHouseDoc(InWareHouseDocPO in) {
		// TODO Auto-generated method stub

	}

	@Override
	public WareHousePO getWareHouse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		String sql="truncate table 仓库存储货物;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("仓库已清空");

	}
public static void main(String[] args) {
//	StorageDataServiceImpl serviceImpl=new StorageDataServiceImpl();
//	RecordPO recordPO=new RecordPO("0025010010",new Date() , "北京", "汽运区", 000003, "002500");
//	serviceImpl.clear();
	
	
}
	@Override
	public void addNewStorageItem(RecordPO recordPO) {
		String date=Time.toDaysTime(recordPO.getDate());
		String distriction=recordPO.getDistrict();
		String storageID=recordPO.getStorageID();
		String sql="UPDATE 仓库存储货物 SET StorageItem_ID='"+recordPO.getItemID()+"',入库日期='"+date+"',目的地='"+recordPO.getDestination()+
				"' WHERE StorageItem_ID IS NULL && 区='"+distriction+"'&&仓库ID='"+storageID+"' LIMIT 1;";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void setPercent(double p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAlarm(double p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(double t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateInWarehouseDoc(InWareHouseDocPO t) {
		// TODO Auto-generated method stub

	}

	@Override
	public RecordPO find(int StorageItemID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPercent(String district) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<RecordPO> getOutWarehouseDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InWareHouseDocPO> getInWarehouseDoc() {
		// TODO Auto-generated method stub
		return null;
	}

}
