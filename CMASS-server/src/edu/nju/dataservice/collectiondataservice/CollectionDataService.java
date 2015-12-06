package edu.nju.dataservice.collectiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.*;

public interface CollectionDataService extends Remote{
	public void saveSendDocPO(SendDocPO po)throws RemoteException;

	public SendDocPO getSendDocPOByID(String ID)throws RemoteException, DatabaseNULLException;

	public String getSequence() throws RemoteException;

	public void changeSequence(String sequence)throws RemoteException;

	public ArrayList<SendDocPO> getAllSendDoc()throws RemoteException;

	public void saveCourierMoneyPO(CourierMoneyPO po)throws RemoteException;
	
	public CourierMoneyPO getCourierMoneyPO(String courierID)throws RemoteException;
}
