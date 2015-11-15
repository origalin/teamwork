package edu.nju.businesslogic.collectionbl;

import java.util.ArrayList;
import java.util.List;

import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.vo.SendDocVO;

public class Collectionbl implements CollectionLogicService{

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
	public List<SendDocPO> getAllSendDoc() {
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
	public SendDocVO createSendDocVO(String sName, String sAddress,
			String sUnit, String sTelePhone, String sMobilePhone, String rName,
			String rAddress, String rUnit, String rTelePhone,
			String rMobilePhone, int itemNum, double weight, double[] volume,
			String itemKind, int packageType, int sendType) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}
