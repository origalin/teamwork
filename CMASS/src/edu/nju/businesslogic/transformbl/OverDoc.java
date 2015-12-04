package edu.nju.businesslogic.transformbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.OverDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.HistoryTimePO;
import edu.nju.po.OperationPO;
import edu.nju.po.OverDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.OverDocVO;

public class OverDoc implements OverDocService{
	String institutionID;
	String staffID;
	OverDocPO po;
	TransferDataService transferDataService;
	Logisticsquerybl logisticsquerybl;
	Institution institution;
	Collectionbl collectionbl;
	SystemBl systemBl;

	public OverDoc( String staffID) throws RemoteException {
		// TODO 自动生成的构造函数存根
		this.staffID = staffID;
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		collectionbl = new Collectionbl(staffID);
		systemBl = new SystemBl();
	}

	public OverDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveOverDocPO(OverDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getOverDocSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getOverSequence();
	}

	@Override
	public void changeOverDocSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getOverDocSequence());
		transferDataService.changeOverSequence(next);
	}



	@Override
	public OverDocVO findOverDocVO(String  ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getUncheckedOverDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllOverDoc();
	}

	@Override
	public OverDocVO createOverDocVO(String[] itemIDs, String[] receivers) throws RemoteException {
		// TODO Auto-generated method stub
		po = new OverDocPO("13"+getOverDocSequence(),itemIDs, receivers, new Date(), staffID);
		return new OverDocVO(po);
	}

	@Override
	public void confirmSave() throws RemoteException {
		// TODO Auto-generated method stub
		transferDataService.saveOverDocPO(po);
		changeOverDocSequence();
		String start,end;
		int days;
		Calendar cal = Calendar.getInstance();  
		for(int i = 0;i< po.getItemID().length;i++) {
			  
	        cal.setTime(collectionbl.getSendDocPOByID(po.getItemID()[i]).getDate());    
	        long time1 = cal.getTimeInMillis();                 
	        cal.setTime(collectionbl.getSendDocPOByID(po.getItemID()[i]).getDate());    
	        long time2 = cal.getTimeInMillis();         
	        days=(int) ((time2-time1)/(1000*3600*24)); 
			start = collectionbl.getSendDocPOByID(po.getItemID()[i]).getsCity();
			end = collectionbl.getSendDocPOByID(po.getItemID()[i]).getrCity();
			transferDataService.saveHistoryTimePO(new HistoryTimePO(start, end, days));
			logisticsquerybl.changePosition(po.getItemID()[i], "快件已送达，收件人是："+po.getReceiver()[i]);	
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成收件单"));
		
	}

}
