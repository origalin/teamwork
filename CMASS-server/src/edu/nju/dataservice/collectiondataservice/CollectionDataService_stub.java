package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;


import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataService_stub implements CollectionDataService {

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO �Զ����ɵķ������
		ArrayList<PositionPO> list = new ArrayList<PositionPO>();
		return list;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO �Զ����ɵķ������
		ArrayList<SendDocPO> list = new ArrayList<SendDocPO>();
		return list;
	}

	@Override
	public double getCourierMoney(String courier) {
		return 100;
	}

	@Override
	public ArrayList<String> getSendDocIDList(String courier) {
		// TODO �Զ����ɵķ������
		return null;//new int[]{0002512345,1002523423,2002598233};
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
	public void appendCourierMoney(String courierID, String itemID, double money) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void cleanCourierMessage(String courierID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity) {
		// TODO Auto-generated method stub
		return null;
	}

}
