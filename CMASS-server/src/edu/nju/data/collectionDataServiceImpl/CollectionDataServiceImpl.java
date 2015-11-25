package edu.nju.data.collectionDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;

public class CollectionDataServiceImpl extends UnicastRemoteObject implements CollectionDataService{

	protected CollectionDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSequence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeSequence(String sequence) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PositionPO> QueryGoodsInfo(int SendDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getCourierMoney(String courier) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<String> getSendDocIDList(String courier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void appendCourierMoney(String courierID, String itemID, double money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cleanCourierMessage(String courierID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HistoryTimePO> getHistoryPO(String sCity, String rCity) {
		// TODO Auto-generated method stub
		return null;
	}

}
