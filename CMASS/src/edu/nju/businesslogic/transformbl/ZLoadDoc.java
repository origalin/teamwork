package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
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
	private Logisticsquerybl logisticsquerybl;
	private YLoadDoc yLoadDoc;
	public ZLoadDoc( String staffID) {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = new TransferDataServiceImpl(institutionID);
		logisticsquerybl = new Logisticsquerybl();
	}
	public ZLoadDoc(){
		this.institutionID=null;
		this.staffID=null;
	}
	public void confirmSave() {
		saveZloadDocPO(po);
		changeTranceID();
		for(int i = 0;i < po.getItemIDs().length;i++) {
			logisticsquerybl.changePosition(po.getItemIDs()[i], "�����װ����������"+institution.getInstitutionName(po.getTargetBusinessHall()));
		}
	}
	@Override
	public void saveZloadDocPO(ZLoadDocPO po) {
		// TODO �Զ����ɵķ������
		transferDataService.saveZLoadDocPO(po);
	}

	@Override
	public String getZloadSequence() {
		// TODO �Զ����ɵķ������
		return transferDataService.getZLoadSequence();
	}

	@Override
	public void changeZloadSequence() {
		// TODO �Զ����ɵķ������
		String next = SequenceCalc.calcNextSequence6(getZloadSequence());
		transferDataService.changeZLoadSequence(next);
	}



	@Override
	public ZLoadDocVO getZLoadDocVO(String ID) {
		// TODO �Զ����ɵķ������
		return new ZLoadDocVO(transferDataService.getZLoadDocPO(ID, false));
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() {
		// TODO �Զ����ɵķ������
		return transferDataService.getAllZloadDoc();
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
	public String[][] getDrivers() {
		// TODO Auto-generated method stub
		ArrayList<String> subInstitution = institution.getSubInstitution(institutionID);
		
		ArrayList<String[][]> subDrivers = new ArrayList<String[][]>();
		int num;
		for(int i = 0;i<subInstitution.size();i++) {
			yLoadDoc = new YLoadDoc(staffID);
			yLoadDoc.setInstitutionID(subInstitution.get(i));
			subDrivers.add(yLoadDoc.getDrivers());
			num+=yLoadDoc.getDrivers().length;
		}
		String[][] allDrivers = new String[num][2];
		int j = 0;
		for(String[][] s : subDrivers) {
			for(int i = 0;i<s.length;i++) {
				allDrivers[j+i][0] = s[i][0];
				allDrivers[j+i][0] = s[i][1];
			}
			j+=s.length;
		}
		return allDrivers;
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
	private void changeTranceID() {
		String next = SequenceCalc.calcNextSequence6(getTranceID());
		transferDataService.changeTransferID(next);
	}
	private double priceCalc(String target) {
		return 600;
	}
	public ArrayList<ZLoadDocPO> getUnPaidZLoadDocPOs() {
		// TODO Auto-generated method stub
		return transferDataService.getunPaidZLoadDocPO();
	}
	@Override
	public int getDriverTime(String drrverID) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ZLoadDocPO getZLoadDocPO(String ID) {
		// TODO Auto-generated method stub
		return transferDataService.getZLoadDocPO(ID, true);
	}
}
