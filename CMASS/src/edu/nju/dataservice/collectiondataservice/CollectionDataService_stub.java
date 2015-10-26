package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;


import edu.nju.po.HistoryPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataService_stub implements CollectionDataService {

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Double getDistance(String city) {
		// TODO 自动生成的方法存根
		return 33.0;
	}

	@Override
	public int getSequence() {
		// TODO 自动生成的方法存根
		return 10086;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveHistory(HistoryPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO 自动生成的方法存根
		ArrayList<PositionPO> list = new ArrayList<PositionPO>();
		return list;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO 自动生成的方法存根
		ArrayList<SendDocPO> list = new ArrayList<SendDocPO>();
		return list;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO 自动生成的方法存根
		return 100;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO 自动生成的方法存根
		return new int[]{0002512345,1002523423,2002598233};
	}

}
