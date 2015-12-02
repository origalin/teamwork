package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.dataFactory.DataFactory;
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
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
	}
	public YLoadDoc() {
		// TODO Auto-generated constructor stub
	}
	public void confirmSave() {
		saveYloadDocPO(po);
		changeTranceID();
		changeYloadSequence();
		for(int i = 0;i<po.getItemIDs().length;i++) {
			logisticsquerybl.changePosition(po.getItemIDs()[i], "��װ��������"+po.getTarget());	
		}
		
	}
	@Override
	public void saveYloadDocPO(YLoadDocPO po) {
		// TODO �Զ����ɵķ������
		transferDataService.saveYLoadDocPO(po);
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
	public YLoadDocVO getYLoadDocVO(String ID) {
		// TODO �Զ����ɵķ������
		return new YLoadDocVO(transferDataService.getYLoadDocPO(ID, false));
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
	public String[][] getDrivers() {
		// TODO Auto-generated method stub
		ArrayList<String> driverIDs = institution.getDirverID(institutionID);
		ArrayList<String> driverNames = new ArrayList<String>();
		for(String ID : driverIDs) {
			driverNames.add(institution.getDirverName(ID));
		}
		String[][] drivers = new String[driverIDs.size()][2];
		for(int i = 0;i < driverIDs.size();i++) {
			drivers[i][0] = driverIDs.get(i);
			drivers[i][1] = driverNames.get(i);
		}
		return drivers;
	}
	public String getInstitutionID() {
		return institutionID;
	}
	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
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
	public int getDriverTime(String driverID) {
		// TODO Auto-generated method stub
		return transferDataService.getDriverTime_YLoad(driverID);
	}
}
