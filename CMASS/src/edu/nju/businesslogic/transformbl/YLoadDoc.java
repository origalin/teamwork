package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.po.YLoadDocPO;
import edu.nju.vo.YLoadDocVO;

public class YLoadDoc implements YLoadDocService{
	String institutionID;
	String staffID;
	YLoadDocPO po;

	public YLoadDoc(String staffID) {
		super();
		this.staffID = staffID;
	}
	public YLoadDoc() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int getYloadSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeYloadSequence(int YloadSequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) {
		// TODO �Զ����ɵķ������
		po = new YLoadDocPO("00"+getYloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver, itemIDs, priceCalc(target));
		return null;
	}

	@Override
	public YLoadDocVO findYLoadDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public YLoadDocPO getYloadPOByID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getTransferCenter() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getDrivers() {
		// TODO Auto-generated method stub
		return null;
	}
	private String getTranceID() {
		return null;
	}
	private void changeTranceID() {
		
	}
	private double priceCalc(String target) {
		return 0;
	}
	public ArrayList<YLoadDocPO> getUnPaidYLoadDocPOs() {
		// TODO Auto-generated method stub
		return null;
	}
}
