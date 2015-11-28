package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
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
	private Logisticsquerybl logisticsquerybl;

	public YLoadDoc(String staffID) {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		logisticsquerybl = new Logisticsquerybl();
	}
	public YLoadDoc() {
		// TODO Auto-generated constructor stub
	}
	public void confirmSave() {
		saveYloadDocPO(po);
		changeTranceID();
		changeYloadSequence();
		for(int i = 0;i<po.getItemIDs().length;i++) {
			logisticsquerybl.changePosition(po.getItemIDs()[i], "已装车，送往"+po.getTarget());	
		}
		
	}
	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO 自动生成的方法存根
		transferDataService.saveYLoadDocPO(po);
	}


	@Override
	public String getYloadSequence() {
		// TODO 自动生成的方法存根
		return transferDataService.getYLoadSequence();
	}

	@Override
	public void changeYloadSequence() {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getYloadSequence());
		transferDataService.changeYLoadSequence(next);
	}

	@Override
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) {
		// TODO 自动生成的方法存根
		po = new YLoadDocPO("00"+getYloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver, itemIDs, priceCalc(target));
		return new YLoadDocVO(po);
	}

	@Override
	public YLoadDocVO getYLoadDocVO(String ID) {
		// TODO 自动生成的方法存根
		return new YLoadDocVO(transferDataService.getYLoadDocPO(ID, false));
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() {
		// TODO 自动生成的方法存根
		return transferDataService.getAllYLoadDoc();
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YLoadDocPO getYloadDocPOByID(String ID) {
		// TODO Auto-generated method stub
		return transferDataService.getYLoadDocPO(ID, true);
	}
	@Override
	public String getTransferCenter() {
		// TODO Auto-generated method stub
		return institution.getInstitutionName(institution.getTransferCenterID(institutionID));
	}
	@Override
	public String[] getDrivers() {
		// TODO Auto-generated method stub
		ArrayList<String> driverIDs = institution.getDirverID(institutionID);
		ArrayList<String> driverNames = new ArrayList<String>();
		for(String ID : driverIDs) {
			driverNames.add(institution.getDirverName(ID));
		}
		return (String[]) driverNames.toArray();
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
		return transferDataService.getunPaidYLoadDocPO();
	}
	@Override
	public int getDriverTime(String drrverID) {
		// TODO Auto-generated method stub
		return 0;
	}
}
