package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;


import edu.nju.po.HistoryPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataService_stub implements CollectionDataService {

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getDistance(String city) {
		// TODO �Զ����ɵķ������
		return 33;
	}

	@Override
	public int getSequence() {
		// TODO �Զ����ɵķ������
		return 10086;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void saveHistory(HistoryPO po) {
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
	public int getCourierMoney(String courier) {
		// TODO �Զ����ɵķ������
		return 100;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO �Զ����ɵķ������
		return new int[]{0002512345,1002523423,2002598233};
	}

}
