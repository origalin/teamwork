package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogicservice.transformlogicservice.ZLoadDocService;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.ZLoadDocVO;

public class ZLoadDoc implements ZLoadDocService{
	String institutionID;
	String staffID;
	ZLoadDocPO po;
	public ZLoadDoc( String staffID) {
		super();
		this.staffID = staffID;
	}
	public ZLoadDoc(){
		this.institutionID=null;
		this.staffID=null;
	}

	@Override
	public void saveZloadDocPO(ZLoadDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public String getZloadSequence() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public int[] getSendDocIDList(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public void changeZloadSequence(int ZloadSequence) {
		// TODO �Զ����ɵķ������
		
	}



	@Override
	public ZLoadDocVO findZLoadDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public double[] getPriceToday() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String[] getSubBusinessHall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ZLoadDocVO createZLoadDocVO(String carID, String target, String watcher, String driver, String[] itemIDs) {
		// TODO Auto-generated method stub
		po = new ZLoadDocPO("05"+getZloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver, itemIDs, priceCalc(target));
		return new ZLoadDocVO(po);
	}
	private String getTranceID() {
		return null;
	}
	private void changeTranceID(String TranceID) {
		
	}
	private double priceCalc(String target) {
		return 0;
	}
	public ArrayList<ZLoadDocPO> getUnPaidZLoadDocPOs() {
		// TODO Auto-generated method stub
		return null;
	}
}
