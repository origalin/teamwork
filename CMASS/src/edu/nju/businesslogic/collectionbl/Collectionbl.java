package edu.nju.businesslogic.collectionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.midi.Sequence;
import javax.tools.Tool;

import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.transferbl.OverDoc;
import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.data.collectionDataServiceImpl.CollectionDataServiceImpl;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.SendDocVO;

public class Collectionbl implements CollectionLogicService{
	SendDocPO po ;
	String institutionID;
	String staffID;
	CollectionDataService collectionData;
	TransferDataService transferData;
	Institution institution;
	Distance distance;
	Logisticsquerybl logisticsquerybl;

	public Collectionbl( String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		institution = new Institution();
		collectionData = DataFactory.getCollectionDataService();
		this.institutionID = institution.getInstitutionID(staffID);
		transferData = DataFactory.getTransferDataService();
		transferData.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		distance = new Distance();
	}
	
	public Collectionbl(){
		this.institutionID=null;
		this.staffID=null;
	}
	public void  confirmSave() throws RemoteException {
		saveSendDocPO(po);
		changeSequence();
		logisticsquerybl.createPosition(po.getID(),institution.getCity(institutionID)+institution.getInstitutionName(institutionID)+"已揽件",po.getrCity()+po.getrAddress());
	}

	@Override
	public void saveSendDocPO(SendDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		collectionData.saveSendDocPO(po);
		
	}

	@Override
	public double getDistance(String city) throws RemoteException {
		// TODO 自动生成的方法存根
		String sCity = institution.getCity(institutionID);
		return distance.getDistance(sCity, city);
	}

	@Override
	public String getSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return collectionData.getSequence();
	}

	@Override
	public void changeSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String sequence = SequenceCalc.calcNextSequence5(getSequence());
		collectionData.changeSequence(sequence);
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() throws RemoteException {
		// TODO 自动生成的方法存根
		return collectionData.getAllSendDoc();
	}

	@Override
	public double getCourierMoney(String courier) throws RemoteException {
		// TODO 自动生成的方法存根
		return collectionData.getCourierMoneyPO(courier).getCourierMoney(courier);
	}
	private void appendCourierMoney(String courierID) throws RemoteException{
		collectionData.getCourierMoneyPO(courierID).appendMoney(staffID, po.getID(), po.getSumPrice());
	}



	@Override
	public int timeEstimate(String sCity, String rCity) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<HistoryTimePO> historyTimePOs = getHistoryPO(sCity, rCity);
		int sum = 0;
		if(historyTimePOs.size()==0) {
			return 0;
		}
		for(int i = 0;i < historyTimePOs.size();i++) {
			sum+=historyTimePOs.get(i).getDays();
		}
		return sum/historyTimePOs.size();
	}

	@Override
	public double priceCalc(String sCity, String rCity, int packing,
			double[] volume, double weight,int sendType) throws RemoteException {
		// TODO 自动生成的方法存根
		double mayWeight = volume[0]*volume[1]*volume[2]/5000;
		if(weight<=mayWeight) {
			weight = mayWeight;
		}
		int x = 0;
		switch (sendType) {
		case 0:
			x = 25;
			break;
		case 1:
			x = 23;
			break;
		case 2:
			x = 18;
			break;

		default:
			break;
		}
		int y = 0;
		switch (packing) {
		case 1:
			y = 5;
			break;
		case 2:
			y = 10;
			break;
		case 3:
			y = 1;
			break;
		case 4:
			y = 5;
			break;

		default:
			break;
		}
		return weight*getDistance(rCity)*x/1000+y;
	}

	@Override
	public ArrayList<HistoryTimePO> getHistoryPO(String sCity,String rCity) throws RemoteException {
		// TODO 自动生成的方法存根
		return transferData.getHistoryTimePO(sCity, rCity);
	}

	@Override
	public SendDocVO createSendDocVO(String sName,String sCity, String sAddress,
			String sUnit, String sTelePhone, String sMobilePhone, String rName,String rCity,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, double weight, double[] volume,
			String itemKind, int packageType, int sendType) throws RemoteException {
		// TODO 自动生成的方法存根
		int time = timeEstimate(sCity, rCity);
		double price = priceCalc(sCity, rCity, packageType, volume, weight,sendType);
		Date date = new Date();
		String id = sendType+institutionID.substring(0, 4)+getSequence();
		po = new SendDocPO(id,sName, sAddress, sCity, sUnit, sTelePhone, sMobilePhone, rName, rAddress, rCity, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, itemKind, packageType, price, sendType, date, time);
		return new SendDocVO(po);

	}

	@Override
	public SendDocVO getSendDocVOByID(String itemID) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		return new SendDocVO(collectionData.getSendDocPOByID(itemID));
	}

	@Override
	public SendDocPO getSendDocPOByID(String itemID) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		return collectionData.getSendDocPOByID(itemID);
	}

	@Override
	public ArrayList<String> getSendDocsByID(String courier_ID) throws RemoteException {
		// TODO Auto-generated method stub
		return collectionData.getCourierMoneyPO(courier_ID).getCourierSendDoc(courier_ID);
	}

	@Override
	public void saveSendDocCreateGatheringDoc(String courierID) throws RemoteException {
		// TODO Auto-generated method stub
		collectionData.getCourierMoneyPO(courierID).cleanCourierMessage(courierID);
	}
	
}
