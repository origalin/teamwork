package edu.nju.businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.ZLoadDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OperationPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.tools.StringTools;
import edu.nju.vo.ZLoadDocVO;

public class ZLoadDoc implements ZLoadDocService{
	String institutionID;
	String staffID;
	ZLoadDocPO po;
	private Institution institution;
	private TransferDataService transferDataService;
	private Logisticsquerybl logisticsquerybl;
	private Collectionbl collectionbl;
	private YLoadDoc yLoadDoc;
	private SystemBl systemBl;
	public ZLoadDoc( String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		systemBl = new SystemBl();
		collectionbl = new Collectionbl(staffID);
	}
	public ZLoadDoc() throws RemoteException{
		this(null);
	}
	public void confirmSave() throws RemoteException {
		saveZloadDocPO(po);
		changeTranceID();
		for(int i = 0;i < po.getItemIDs().length;i++) {
			logisticsquerybl.changePosition(po.getItemIDs()[i], "快递已装车，将送往"+institution.getName(po.getTargetBusinessHall()));
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中转中心装车单"));
	}
	@Override
	public void saveZloadDocPO(ZLoadDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		transferDataService.saveZLoadDocPO(po);
	}

	@Override
	public String getZloadSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getZLoadSequence();
	}

	@Override
	public void changeZloadSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getZloadSequence());
		transferDataService.changeZLoadSequence(next);
	}



	@Override
	public ZLoadDocVO getZLoadDocVO(String ID) throws RemoteException, DatabaseNULLException {
		// TODO 自动生成的方法存根
		return new ZLoadDocVO(transferDataService.getZLoadDocPO(ID, false));
	}

	@Override
	public ArrayList<ZLoadDocPO> getUncheckedZLoadDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllZloadDoc();
	}

	@Override
	public double[] getPriceToday() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String[] getSubBusinessHall() throws RemoteException {
		// TODO Auto-generated method stub
		String[] subID =  StringTools.toGroup(institution.getSubInstitutionID(institutionID));
		String[] subName = new String[subID.length];
		for(int i = 0;i< subID.length;i++) {
			subName[i]=institution.getName(subID[i]);
		}
		return subName;
	}

	@Override
	public String[][] getDrivers() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> subInstitution = institution.getSubInstitutionID(institutionID);
		
		ArrayList<String[][]> subDrivers = new ArrayList<String[][]>();
		int num = 0;
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
				allDrivers[j+i][1] = s[i][1];
			}
			j+=s.length;
		}
		return allDrivers;
	}

	@Override
	public ZLoadDocVO createZLoadDocVO(String carID, String target, String watcher, String driver, String[] itemIDs) throws RemoteException {
		// TODO Auto-generated method stub
		po = new ZLoadDocPO("05"+getZloadSequence(), new Date(), getTranceID(), target, carID, watcher, driver,institutionID, itemIDs, priceCalc(target));
		return new ZLoadDocVO(po);
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
	public ArrayList<ZLoadDocPO> getUnPaidZLoadDocPOs() throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getunPaidZLoadDocPO();
	}
	@Override
	public int getDriverTime(String driverID) throws RemoteException {
		// TODO Auto-generated method stub
		return transferDataService.getDriverTime_ZLoad(driverID);
	}
	@Override
	public ZLoadDocPO getZLoadDocPO(String ID) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		return transferDataService.getZLoadDocPO(ID, true);
	}
	@Override
	public void checkHas(String id) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		collectionbl.checkHas(id);
	}
}
