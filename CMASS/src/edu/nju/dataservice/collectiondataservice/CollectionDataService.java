package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;

public interface CollectionDataService {
	public void saveSendDocPO(SendDocPO po);
	public Double getDistance(String city);
	public int getSequence();
	public void changeSequence(int sequence);
	public void saveHistory(HistoryPO po);
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID);
	public ArrayList<SendDocPO> getAllSendDoc();
	public int getCourierMoney(String courier);
	public int[] getSendDocIDList(String courier);
}
