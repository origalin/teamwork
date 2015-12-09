package edu.nju.businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.ZArrivalDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OperationPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public class ZArrivalDoc implements ZArrivalDocService{
	String institutionID, staffID;
	private ZArrivalDocPO po;
	private TransferDoc transferDoc;
	private YLoadDoc yLoadDoc;
	private Institution institution;
	private TransferDataService transferDataService;
	private Logisticsquerybl logisticsquerybl;
	private SystemBl systemBl;
	public ZArrivalDoc( String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
		yLoadDoc = new YLoadDoc(staffID);
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		logisticsquerybl = new Logisticsquerybl();
		systemBl = new SystemBl();
	}
	

	public ZArrivalDoc() {
		// TODO Auto-generated constructor stub
	}
	public void confirmSave() throws RemoteException {
		saveZArrivalDocPO(po);
		changeZArrivalSequence();
		for(int i = 0;i < po.getItemAndState().length;i++) {
			logisticsquerybl.changePosition(po.getItemAndState()[i][0], "快递已到达"+institution.getCity(institutionID)+institution.getInstitutionName(staffID));	
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "生成中转中心到达单"));
	}
	@Override
	public void saveZArrivalDocPO(ZArrivalDocPO po) throws RemoteException {
		// TODO 自动生成的方法存根
		transferDataService.saveZArrivalDocPO(po);
	}

	@Override
	public String getZArrivalSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getZArrivalSequence();
	}

	@Override
	public void changeZArrivalSequence() throws RemoteException {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getZArrivalSequence());
		transferDataService.changeZArrivalSequence(next);
	}


	@Override
	public ZArrivalDocVO findZArrivalDocVO(String ID) throws RemoteException, DatabaseNULLException {
		// TODO 自动生成的方法存根
		return new ZArrivalDocVO(transferDataService.getZArrivalDocPO(ID, false));
	}

	@Override
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs() throws RemoteException {
		// TODO 自动生成的方法存根
		return transferDataService.getAllZArrivalDoc();
	}

	@Override
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		TransferDocPO transferDocPO = transferDoc.geTransferDocPOByID(fromDocID);
		String[][] itemAndState = new String[transferDocPO.getItemIDs().length][2];
		for(int i = 0;i<transferDocPO.getItemIDs().length;i++) {
			itemAndState[i][0] = transferDocPO.getItemIDs()[i];
			itemAndState[i][1] = "0";
		}
		for(int i = 0;i<changeStates.length;i++) {
			for(int j = 0;j<transferDocPO.getItemIDs().length;j++) {
				if(changeStates[i][0].equals(itemAndState[j][0])) {
					itemAndState[j][1] = changeStates[i][1];
				}
			}
		}
		po = new ZArrivalDocPO("02"+getZArrivalSequence(), new Date(), fromDocID, transferDocPO.getFrom(), itemAndState);
		return new ZArrivalDocVO(po);
	}
	@Override
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		YLoadDocPO yLoadDocPO = yLoadDoc.getYloadDocPOByID(fromDocID);
		String[][] itemAndState = new String[yLoadDocPO.getItemIDs().length][2];
		for(int i = 0;i<yLoadDocPO.getItemIDs().length;i++) {
			itemAndState[i][0] = yLoadDocPO.getItemIDs()[i];
			itemAndState[i][1] = "0";
		}
		for(int i = 0;i<changeStates.length;i++) {
			for(int j = 0;j<yLoadDocPO.getItemIDs().length;j++) {
				if(changeStates[i][0].equals(itemAndState[j][0])) {
					itemAndState[j][1] = changeStates[i][1];
				}
			}
		}
		po = new ZArrivalDocPO("02"+getZArrivalSequence(), new Date(), fromDocID, "待定", itemAndState);
		return new ZArrivalDocVO(po);
	}

}
