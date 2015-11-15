package edu.nju.data.StorageDataServiceImpl;

import java.util.ArrayList;

import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.RecordPO;
import edu.nju.po.WareHousePO;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewStorageItem(RecordPO recordPO) {
		// TODO Auto-generated method stub

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
