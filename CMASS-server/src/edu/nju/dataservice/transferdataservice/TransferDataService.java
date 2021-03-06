package edu.nju.dataservice.transferdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.*;

public interface TransferDataService extends Remote{
	public void setInstitutionID(String institutionID)throws RemoteException;
	public void saveTransferDocPO(TransferDocPO po)throws RemoteException;
	public String getTransferSequence()throws RemoteException;
	public void changeTransferSequence(String TransferSequence)throws RemoteException;
	public void saveZLoadDocPO(ZLoadDocPO po)throws RemoteException;
	public String getZLoadSequence()throws RemoteException;
	public void changeZLoadSequence(String ZLoadSequence)throws RemoteException;
	public void saveYLoadDocPO(YLoadDocPO po)throws RemoteException;
	public String getYLoadSequence()throws RemoteException;
	public void changeYLoadSequence(String ZLoadSequence)throws RemoteException;
	public void saveZArrivalDocPO(ZArrivalDocPO po)throws RemoteException;
	public String getZArrivalSequence()throws RemoteException;
	public void changeZArrivalSequence(String ZArrivalSequence)throws RemoteException;
	public void saveYArrivalDocPO(YArrivalDocPO po)throws RemoteException;
	public String getYArrivalSequence()throws RemoteException;
	public void changeYArrivalSequence(String YArrivalSequence)throws RemoteException;
	public void saveYDeliverDocPO(YDeliverDocPO po)throws RemoteException;
	public String getYDeliverSequence()throws RemoteException;
	public void changeYDeliverSequence(String YDeliverSequence)throws RemoteException;
	public void saveOverDocPO(OverDocPO po)throws RemoteException;
	public String getOverSequence()throws RemoteException;
	public void changeOverSequence(String OverSequence)throws RemoteException;
	public TransferDocPO getTransferDocPO(String TransferDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public ZLoadDocPO getZLoadDocPO(String ZLoadDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public YLoadDocPO getYLoadDocPO(String YLoadDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public ZArrivalDocPO getZArrivalDocPO(String ZArrivalDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public YArrivalDocPO getYArrivalDocPO(String YArrivalDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public YDeliverDocPO getYDeliverDocPO(String YDeliverDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public OverDocPO getOverDocPO(String OverDocID,boolean normal)throws RemoteException, DatabaseNULLException;
	public ArrayList<YDeliverDocPO> getAllYDeliverDoc()throws RemoteException;
	public ArrayList<YArrivalDocPO> getAllYArrivalDoc()throws RemoteException;
	public ArrayList<ZArrivalDocPO> getAllZArrivalDoc()throws RemoteException;
	public ArrayList<TransferDocPO> getAllTransferDoc()throws RemoteException;
	public ArrayList<YLoadDocPO> getAllYLoadDoc()throws RemoteException;
	public ArrayList<ZLoadDocPO> getAllZloadDoc()throws RemoteException;
	public ArrayList<OverDocPO> getAllOverDoc()throws RemoteException;
	public String getTransferID()throws RemoteException;
	public String getTransferID_Plain()throws RemoteException;
	public String getTransferID_Train()throws RemoteException;
	public void changeTransferID(String transferDocID)throws RemoteException;
	public void changeTransferID_Plain(String transferDocID)throws RemoteException;
	public void changeTransferID_Train(String transferDocID)throws RemoteException;
	public ArrayList<TransferDocPO>getunPaidTransferDocPO()throws RemoteException;
	public ArrayList<YLoadDocPO>getunPaidYLoadDocPO()throws RemoteException;
	public ArrayList<ZLoadDocPO>getunPaidZLoadDocPO()throws RemoteException;
	public void saveHistoryTimePO(HistoryTimePO po)throws RemoteException;
	public ArrayList<HistoryTimePO> getHistoryTimePO(String sCity,String rCity)throws RemoteException;
	public int  getDriverTime_YLoad(String driverID)throws RemoteException;
	public int  getDriverTime_ZLoad(String driverID)throws RemoteException;
	public ArrayList<YDeliverDocPO> getYDeliverDocPOByCourier(String courierID)throws RemoteException;
}
