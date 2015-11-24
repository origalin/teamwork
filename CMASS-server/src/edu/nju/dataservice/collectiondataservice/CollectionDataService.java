package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;

public interface CollectionDataService {
	public void saveSendDocPO(SendDocPO po);
	public String getSequence();
	public void changeSequence(String sequence);
	ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity);
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID);
	public ArrayList<SendDocPO> getAllSendDoc();
	public double getCourierMoney(String courierID);
	public ArrayList<String> getSendDocIDList(String courierID);
	public void appendCourierMoney(String courierID,String itemID,double money);
	public void cleanCourierMessage(String courierID);
}
