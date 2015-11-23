package edu.nju.data.collectionDataServiceImpl;

import java.util.ArrayList;

import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataServiceImpl implements CollectionDataService{

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Double getDistance(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeSequence(String sequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveHistory(HistoryTimePO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO Auto-generated method stub
		return null;
	}

}
