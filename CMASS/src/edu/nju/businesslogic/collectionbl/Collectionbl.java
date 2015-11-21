package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;
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

	public Collectionbl(String institutionID, String staffID) {
		super();
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getDistance(String city) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int getSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeSequence(int sequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void saveHistory(HistoryTimePO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public PositionPO QueryGoodsInfo(int SendDocID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public List<SendDocPO> getAllSendDoc() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int getCourierMoney(String courier) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public int[] getSendDocIDList(String courier) {
		// TODO �Զ����ɵķ������
		return null;
	}


	@Override
	public int timeEstimate(String sCity, String rCity) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public double priceCalc(String sCity, String rCity, int packing,
			double[] volume, double weight) {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public SendDocVO findSendDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public HistoryTimePO getHistoryPO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<SendDocPO> getUncheckedSendDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SendDocVO createSendDocVO(String sName,String sCity, String sAddress,
			String sUnit, String sTelePhone, String sMobilePhone, String rName,String rCity,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, double weight, double[] volume,
			String itemKind, int packageType, int sendType) {
		// TODO �Զ����ɵķ������
		int time = timeEstimate(sCity, rCity);
		double price = priceCalc(sCity, rCity, packageType, volume, weight);
		long date = System.currentTimeMillis();
		po = new SendDocPO(sName, sAddress, sCity, sUnit, sTelePhone, sMobilePhone, rName, rAddress, rCity, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, itemKind, packageType, price, packageType, date, time);
		po.setID(sendType+institutionID.substring(0, 4)+getSequence());
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
