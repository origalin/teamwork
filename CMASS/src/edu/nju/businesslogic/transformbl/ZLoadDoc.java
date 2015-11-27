package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.ZLoadDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.ZLoadDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.ZLoadDocVO;

public class ZLoadDoc implements ZLoadDocService{
	String institutionID;
	String staffID;
	ZLoadDocPO po;
	private Institution institution;
	private TransferDataService transferDataService;
	public ZLoadDoc( String staffID) {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = new TransferDataServiceImpl(institutionID);
	}
	public ZLoadDoc(){
		this.institutionID=null;
		this.staffID=null;
	}

	@Override
	public void saveZloadDocPO(ZLoadDocPO po) {
		// TODO 自动生成的方法存根
		transferDataService.saveZLoadDocPO(po);
	}

	@Override
	public String getZloadSequence() {
		// TODO 自动生成的方法存根
		return transferDataService.getZLoadSequence();
	}

	@Override
	public String[] getSendDocIDList(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void changeZloadSequence() {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getZloadSequence());
		transferDataService.changeZLoadSequence(next);
	}



	@Override
	public ZLoadDocVO findZLoadDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() {
		// TODO 自动生成的方法存根
		return transferDataService.getAllZloadDoc();
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
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
		return transferDataService.getTransferID();
	}
	private void changeTranceID(String TranceID) {
		String next = SequenceCalc.calcNextSequence6(getTranceID());
		transferDataService.changeTransferID(next);
	}
	private double priceCalc(String target) {
		return 600;
	}
	public ArrayList<ZLoadDocPO> getUnPaidZLoadDocPOs() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getDriverTime(String drrverID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
