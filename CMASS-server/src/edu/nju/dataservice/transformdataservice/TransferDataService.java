package edu.nju.dataservice.transformdataservice;

import java.util.ArrayList;

import edu.nju.po.*;

public interface TransferDataService {
	public void saveTransferDocPO(TransferDocPO po);
	public String getTransferSequence();
	public void changeTransferSequence(String TransferSequence);
	public void saveZLoadDocPO(ZLoadDocPO po);
	public String getZLoadSequence();
	public void changeZLoadSequence(String ZLoadSequence);
	public void saveZArrivalDocPO(ZArrivalDocPO po);
	public String getZArrivalSequence();
	public void changeZArrivalSequence(String ZArrivalSequence);
	public void saveYArrivalDocPO(YArrivalDocPO po);
	public String getYArrivalSequence();
	public void changeYArrivalSequence(String YArrivalSequence);
	public void saveYDeliverDocPO(YDeliverDocPO po);
	public String getYDeliverSequence();
	public void changeYDeliverSequence(String YDeliverSequence);
	public void saveOverDocPO(OverDocPO po);
	public String getOverSequence();
	public void changeOverSequence(String OverSequence);
	public TransferDocPO getTransferDocPO(String TransferDocID);
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID);
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID);
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID);
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID);
	public OverDocPO getOverDocPO(String OverDocID);
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc();
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc();
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc();
	public ArrayList<TransferDocPO> getAllTransferDoc();
	public ArrayList<YLoadDocPO> getAllYLoadDoc();
	public ArrayList<ZLoadDocPO> getAllZloadDoc();
	public ArrayList<OverDocPO> getAllOverDoc();
	public String getTransferID(String institutionID);
	
	
}
