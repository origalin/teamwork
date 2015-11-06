package edu.nju.businesslogic.storagebl;

import edu.nju.businesslogicservice.storagelogicservice.StorageLogicService;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;

public class Storagebl implements StorageLogicService{

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID) {
		// 对运输模块有依赖，ArrayList<Integer> getSendDocIDList(int TransferID)
		return null;
	}

	@Override
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID) {
		// 对运输模块有依赖，ArrayList<Integer> getSendDocIDList(int YloadDocID)
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID) {
		// 对运输模块有依赖，ArrayList<Integer> getSendDocIDList(int TransferID)
		return null;
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID) {
		// 对运输模块有依赖，ArrayList<Integer> getSendDocIDList(int ZloadDocID)
		return null;
	}

	@Override
	public void updateOutWareHouseDoc(int OutWareHouseDocID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNewStorageItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlarm(double p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPercent(double p) {
		// TODO Auto-generated method stub
		
	}

}
