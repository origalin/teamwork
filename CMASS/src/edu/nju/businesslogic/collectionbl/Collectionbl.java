package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sound.midi.Sequence;
import javax.tools.Tool;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.transformbl.OverDoc;
import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.data.collectionDataServiceImpl.CollectionDataServiceImpl;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
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
	OverDoc overDoc;

	public Collectionbl( String staffID) {
		super();
		this.staffID = staffID;
		collectionData = new CollectionDataServiceImpl();
		overDoc = new OverDoc(staffID);
	}
	
	public Collectionbl(){
		this.institutionID=null;
		this.staffID=null;
	}

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public double getDistance(String city) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public String getSequence() {
		// TODO 自动生成的方法存根
		return collectionData.getSequence();
	}

	@Override
	public void changeSequence() {
		// TODO 自动生成的方法存根
		String sequence = SequenceCalc.calcNextSequence5(getSequence());
		collectionData.changeSequence(sequence);
	}


	@Override
	public PositionPO QueryGoodsInfo(int SendDocID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO 自动生成的方法存根
		return collectionData.getAllSendDoc();
	}

	@Override
	public double getCourierMoney(String courier) {
		// TODO 自动生成的方法存根
		return collectionData.getCourierMoney(courier);
	}
	private void appendCourierMoney(String courierID){
		collectionData.appendCourierMoney(staffID, po.getID(), po.getSumPrice());
	}



	@Override
	public int timeEstimate(String sCity, String rCity) {
		// TODO 自动生成的方法存根
		ArrayList<HistoryTimePO> historyTimePOs = getHistoryPO(sCity, rCity);
		int sum = 0;
		for(int i = 0;i < historyTimePOs.size();i++) {
			sum+=historyTimePOs.get(i).getDays();
		}
		return sum/historyTimePOs.size();
	}

	@Override
	public double priceCalc(String sCity, String rCity, int packing,
			double[] volume, double weight,int sendType) {
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
	public SendDocVO findSendDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<HistoryTimePO> getHistoryPO(String sCity,String rCity) {
		// TODO 自动生成的方法存根
		return collectionData.getHistoryPO(sCity, rCity);
	}

	@Override
	public SendDocVO createSendDocVO(String sName,String sCity, String sAddress,
			String sUnit, String sTelePhone, String sMobilePhone, String rName,String rCity,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, double weight, double[] volume,
			String itemKind, int packageType, int sendType) {
		// TODO 自动生成的方法存根
		int time = timeEstimate(sCity, rCity);
		double price = priceCalc(sCity, rCity, packageType, volume, weight,sendType);
		Date date = new Date();
		String id = sendType+institutionID.substring(0, 4)+getSequence();
		po = new SendDocPO(id,sName, sAddress, sCity, sUnit, sTelePhone, sMobilePhone, rName, rAddress, rCity, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, itemKind, packageType, price, packageType, date, time);
		return new SendDocVO(po);

	}

	@Override
	public SendDocVO getSendDocVOByID(String itemID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SendDocPO getSendDocPOByID(String itemID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getSendDocsByID(String courier_ID) {
		// TODO Auto-generated method stub
		return collectionData.getSendDocIDList(courier_ID);
	}

	@Override
	public void saveSendDocCreateGatheringDoc(String courierID) {
		// TODO Auto-generated method stub
		collectionData.cleanCourierMessage(courierID);
	}
	
}
