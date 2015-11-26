package edu.nju.dataservice.collectiondataservice;

import java.util.ArrayList;
import java.util.List;

import edu.nju.po.*;

public interface CollectionDataService {
	public void saveSendDocPO(SendDocPO po);

	public SendDocPO getSendDocPOByID(String ID);

	public String getSequence();

	public void changeSequence(String sequence);

	public ArrayList<SendDocPO> getAllSendDoc();

	public void saveCourierMoneyPO(CourierMoneyPO po);
	
	public CourierMoneyPO getCourierMoneyPO(String courierID);
}
