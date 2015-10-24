package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.List;

import edu.nju.po.*;

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
	public void saveTransferDocPO(TransferDocPO po);
	public int getTransferSequence();
	public void changeTransferSequence(int TransferSequence);
	public void saveZloadDocPO(ZLoadDocPO po);
	public int getZloadSequence();
	public void changeZloadSequence(int ZloadSequence);
	public void saveZArrivalDocPO(ZArrivalDocPO po);
	public int getZArrivalSequence();
	public void changeZArrivalSequence(int ZArrivalSequence);
	public void saveYArrivalDocPO(YArrivalDocPO po);
	public int getYArrivalSequence();
	public void changeYArrivalSequence(int YArrivalSequence);
	public void saveYDeliverDocPO(YDeliverDocPO po);
	public int getYDeliverSequence();
	
}
