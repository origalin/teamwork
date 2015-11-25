package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.YLoadDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.YLoadDocVO;

public class YLoadDoc implements YLoadDocService{
	String institutionID;
	String staffID;
	YLoadDocPO po;
	private TransferDataService transferDataService;
	private Institution institution;

	public YLoadDoc(String staffID) {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
	}
	public YLoadDoc() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO �Զ����ɵķ������
		transferDataService.saveYLoadDocPO(po);
	}

	@Override
	public String[] getSendDocIDList(String id) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public String getYloadSequence() {
		// TODO �Զ����ɵķ������
		return transferDataService.getYLoadSequence();
	}

	@Override
	public void changeYloadSequence() {
		// TODO �Զ����ɵķ������
		String next = SequenceCalc.calcNextSequence6(getYloadSequence());
		transferDataService.changeYLoadSequence(next);
	}

	@Override
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) {
		// TODO �Զ����ɵķ������
		po = new YLoadDocPO("00"+getYloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver, itemIDs, priceCalc(target));
		return new YLoadDocVO(po);
	}

	@Override
	public YLoadDocVO findYLoadDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return transferDataService.getAllYLoadDoc();
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
		return transferDataService.getTransferID();
	}
	private void changeTranceID() {
		String next = SequenceCalc.calcNextSequence6(getTranceID());
		transferDataService.changeTransferID(next);
	}
	private double priceCalc(String target) {
		return 600;
	}
	public ArrayList<YLoadDocPO> getUnPaidYLoadDocPOs() {
		// TODO Auto-generated method stub
		return null;
	}
}
