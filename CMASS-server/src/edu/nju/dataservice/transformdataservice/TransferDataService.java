package edu.nju.dataservice.transformdataservice;

import java.util.ArrayList;

import edu.nju.po.*;

public interface TransferDataService {
	public void saveTransferDocPO(TransferDocPO po);
	public int getTransferSequence();
	public void changeTransferSequence(int TransferSequence);
	public void saveZLoadDocPO(ZLoadDocPO po);
	public int getZLoadSequence();
	public void changeZLoadSequence(int ZLoadSequence);
	public void saveZArrivalDocPO(ZArrivalDocPO po);
	public int getZArrivalSequence();
	public void changeZArrivalSequence(int ZArrivalSequence);
	public void saveYArrivalDocPO(YArrivalDocPO po);
	public int getYArrivalSequence();
	public void changeYArrivalSequence(int YArrivalSequence);
	public void saveYDeliverDocPO(YDeliverDocPO po);
	public int getYDeliverSequence();
	public void changeYDeliverSequence(int YDeliverSequence);
	public void saveOverDocPO(OverDocPO po);
	public int getOverSequence();
	public void changeOverSequence(int OverSequence);
	public TransferDocPO getTransferDocPO(int TransferDocID);
	public ZLoadDocPO getZLoadDocPO(int ZLoadDocID);
	public ZArrivalDocPO getZArrivalDocPO(int ZArrivalDocID);
	public YArrivalDocPO getYArrivalDocPO(int YArrivalDocID);
	public YDeliverDocPO getYDeliverDocPO(int YDeliverDocID);
	public OverDocPO getOverDocPO(int OverDocID);
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc();
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc();
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc();
	public ArrayList<TransferDocPO> getAllTransferDoc();
	public ArrayList<YLoadDocPO> getAllYLoadDoc();
	public ArrayList<ZLoadDocPO> getAllZloadDoc();
	
	
}
