package edu.nju.businesslogicservice.collectionlogicservice;

import java.util.List;

import edu.nju.po.HistoryPO;
import edu.nju.po.PositionPO;
import edu.nju.po.SendDocPO;
import edu.nju.vo.SendDocVO;

public class CollectionLogicServiceImpl implements CollectionLogicService{

	@Override
	public void saveSendDocPO(SendDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getDistance(String city) {
		// TODO �Զ����ɵķ������
		//������infobl
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
	public void saveHistory(HistoryPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public List<PositionPO> QueryGoodsInfo(int SendDocID) {
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
	public List<Integer> getSendDocIDList(String courier) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public SendDocVO createSendDocVO(String sName, String sAddress,
			String sUnit, String sPhone, String rName, String rAddress,
			String rUnit, String rPhone, int number, double weight,
			double[] volume, String kind, int packing, int type) {
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

		
}
