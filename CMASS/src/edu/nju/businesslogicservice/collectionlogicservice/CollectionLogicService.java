package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.List;

import edu.nju.po.*;
import edu.nju.vo.SendDocVO;

public interface CollectionLogicService {
	public void saveSendDocPO(SendDocPO po);
	public int getDistance(String city);
	public int getSequence();
	public void changeSequence(int sequence);
	public void saveHistory(HistoryPO po);
	public List<PositionPO> QueryGoodsInfo(int SendDocID);
	public List<SendDocPO> getAllSendDoc();
	public int getCourierMoney(String courier);
	public List<Integer> getSendDocIDList(String courier);
	public SendDocVO createSendDocVO();
	public 
}
