package edu.nju.dataservice.transformdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.*;

public interface TransferDataService extends Remote{
	public void setInstitutionID(String institutionID);
	public void saveTransferDocPO(TransferDocPO po);
	public String getTransferSequence();
	public void changeTransferSequence(String TransferSequence);
	public void saveZLoadDocPO(ZLoadDocPO po);
	public String getZLoadSequence();
	public void changeZLoadSequence(String ZLoadSequence);
	public void saveYLoadDocPO(YLoadDocPO po);
	public String getYLoadSequence();
	public void changeYLoadSequence(String ZLoadSequence);
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
	public TransferDocPO getTransferDocPO(String TransferDocID,boolean normal);
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID,boolean normal);
	public YLoadDocPO getYLoadDocPO(String YLoadDocID,boolean normal);
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID,boolean normal);
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID,boolean normal);
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID,boolean normal);
	public OverDocPO getOverDocPO(String OverDocID,boolean normal);
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc();
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc();
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc();
	public ArrayList<TransferDocPO> getAllTransferDoc();
	public ArrayList<YLoadDocPO> getAllYLoadDoc();
	public ArrayList<ZLoadDocPO> getAllZloadDoc();
	public ArrayList<OverDocPO> getAllOverDoc();
	public String getTransferID();
	public String getTransferID_Plain();
	public String getTransferID_Train();
	public void changeTransferID(String transferDocID);
	public void changeTransferID_Plain(String transferDocID);
	public void changeTransferID_Train(String transferDocID);
	public ArrayList<TransferDocPO>getunPaidTransferDocPO();
	public ArrayList<YLoadDocPO>getunPaidYLoadDocPO();
	public ArrayList<ZLoadDocPO>getunPaidZLoadDocPO();
	public void saveHistoryTimePO(HistoryTimePO po);
	public ArrayList<HistoryTimePO> getHistoryTimePO(String sCity,String rCity);
	public int  getDriverTime_YLoad(String driverID);
	public int  getDriverTime_ZLoad(String driverID);
}
