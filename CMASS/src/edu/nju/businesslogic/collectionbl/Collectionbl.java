package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.vo.SendDocVO;

public class Collectionbl implements CollectionLogicService{
	SendDocPO po ;
	String institutionID;
	String staffID;

	public Collectionbl( String staffID) {
		super();
		this.staffID = staffID;
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
	public int getDistance(String city) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int getSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void saveHistory(HistoryTimePO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public PositionPO QueryGoodsInfo(int SendDocID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getAllSendDoc() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO 自动生成的方法存根
		return null;
	}


	@Override
	public int timeEstimate(String sCity, String rCity) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public double priceCalc(String sCity, String rCity, int packing,
			double[] volume, double weight) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public SendDocVO findSendDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public HistoryTimePO getHistoryPO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getUncheckedSendDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public SendDocVO createSendDocVO(String sName,String sCity, String sAddress,
			String sUnit, String sTelePhone, String sMobilePhone, String rName,String rCity,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, double weight, double[] volume,
			String itemKind, int packageType, int sendType) {
		// TODO 自动生成的方法存根
		int time = timeEstimate(sCity, rCity);
		double price = priceCalc(sCity, rCity, packageType, volume, weight);
		Date date = new Date();
		String id = sendType+institutionID.substring(0, 4)+getSequence();
		po = new SendDocPO(id,sName, sAddress, sCity, sUnit, sTelePhone, sMobilePhone, rName, rAddress, rCity, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, itemKind, packageType, price, packageType, date, time);
		return null;

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
	
}
