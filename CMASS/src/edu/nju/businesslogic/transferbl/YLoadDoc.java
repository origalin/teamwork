package edu.nju.businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.YLoadDocService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OperationPO;
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
	SystemBl systemBl;
	Driver driver;

	public YLoadDoc(String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		logisticsquerybl = new Logisticsquerybl();
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		systemBl = new SystemBl();
		driver = new Driver();
	}
	public YLoadDoc() throws RemoteException {

		this(null);
	}
	public void confirmSave() throws RemoteException {
		saveYloadDocPO(po);
		changeTranceID();
		changeYloadSequence();
		for(int i = 0;i<po.getItemIDs().length;i++) {
			logisticsquerybl.changePosition(po.getItemIDs()[i], "已装车，送往"+po.getTarget());	
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中营业厅装车单"));
		
	}
	@Override
	public void saveYloadDocPO(YLoadDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		transferDataService.saveYLoadDocPO(po);
	}


	@Override
	public String getYloadSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getYLoadSequence();
	}

	@Override
	public void changeYloadSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getYloadSequence());
		transferDataService.changeYLoadSequence(next);
	}

	@Override
	public YLoadDocVO createYLoadDocVO(String carID, String target,
			String watcher,String driver, String[] itemIDs) throws RemoteException {
		// TODO 自动生成的方法存根
		po = new YLoadDocPO("00"+getYloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver,institutionID, itemIDs, priceCalc(target));
		return new YLoadDocVO(po);
	}

	@Override
	public YLoadDocVO getYLoadDocVO(String ID) throws RemoteException, DatabaseNULLException {
		// TODO 自动生成的方法存根
		return new YLoadDocVO(transferDataService.getYLoadDocPO(ID, false));
	}

	@Override
	public ArrayList<YLoadDocPO> getUncheckedyLoadDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllYLoadDoc();
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YLoadDocPO getYloadDocPOByID(String ID) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		return transferDataService.getYLoadDocPO(ID, true);
	}
	@Override
	public String getTransferCenter() throws RemoteException {
		// TODO Auto-generated method stub
		return institution.getInstitutionName(institution.getInstitutionName(institution.getTransferCenterID(institutionID)));
	}
	@Override
	public String[][] getDrivers() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> driverIDs = driver.getDirverID(institution.getName(institutionID));
		ArrayList<String> driverNames = new ArrayList<String>();
		for(String ID : driverIDs) {
			driverNames.add(driver.getDirverName(ID,institution.getName(institutionID)));
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
	private String getTranceID() throws RemoteException {
		return transferDataService.getTransferID();
	}
	private void changeTranceID() throws RemoteException {
		String next = SequenceCalc.calcNextSequence6(getTranceID());
		transferDataService.changeTransferID(next);
	}
	private double priceCalc(String target) {
		return 600;
	}
	public ArrayList<YLoadDocPO> getUnPaidYLoadDocPOs() throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getunPaidYLoadDocPO();
	}
	@Override
	public int getDriverTime(String driverID) throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getDriverTime_YLoad(driverID);
	}
}
