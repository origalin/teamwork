package edu.nju.businesslogic.transferbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.transformlogicservice.YArrivalDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OperationPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.tools.StringTools;
import edu.nju.vo.YArrivalDocVO;

public class YArrivalDoc implements YArrivalDocService {
	String institutionID, staffID;
	private YArrivalDocPO po;
	private Collectionbl collectionbl;
	private TransferDoc transferDoc;
	private Institution institution;
	private TransferDataService transferDataService; 
	Logisticsquerybl logisticsquerybl;
	SystemBl systemBl;

	public YArrivalDoc( String staffID) throws RemoteException {
		super();
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = DataFactory.getTransferDataService();
		transferDataService.setInstitutionID(institutionID);
		collectionbl = new Collectionbl(staffID);
		logisticsquerybl = new Logisticsquerybl();
		systemBl = new SystemBl();
	}

	public YArrivalDoc() {
		// TODO Auto-generated constructor stub
	}

	public void confirmSave() throws RemoteException {
		saveYArrivalDocPO(po);
		changeYArrivalSequence();
		int num = po.getItemAndState().length;
		for(int i = 0;i<num;i++) {
			logisticsquerybl.changePosition(po.getItemAndState()[i][0], "����ѵ���"+institution.getCity(institutionID)+institution.getInstitutionName(staffID));
		}
		systemBl.saveOperation(new OperationPO(new Date(), staffID, institution.getStaffName(staffID), "����Ӫҵ�����ﵥ"));
	}
	
	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) throws RemoteException {
		// TODO �Զ����ɵķ������
		transferDataService.saveYArrivalDocPO(po);
	}

	@Override
	public String getYArrivalSequence() throws RemoteException {
		// TODO �Զ����ɵķ������
		return transferDataService.getYArrivalSequence();
	}

	@Override
	public void changeYArrivalSequence() throws RemoteException {
		// TODO �Զ����ɵķ������
		String next = SequenceCalc.calcNextSequence6(getYArrivalSequence());
		transferDataService.changeYArrivalSequence(next);
	}

	@Override
	public YArrivalDocVO findYArrivalDocVO(String ID) throws RemoteException, DatabaseNULLException {
		// TODO �Զ����ɵķ������
		return new YArrivalDocVO(transferDataService.getYArrivalDocPO(ID, false));
	}

	@Override
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs() throws RemoteException {
		// TODO �Զ����ɵķ������
		return transferDataService.getAllYArrivalDoc();
	}

	@Override
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates) throws RemoteException, DatabaseNULLException {
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
		po = new YArrivalDocPO("02"+getYArrivalSequence(), new Date(), fromDocID, transferDocPO.getFrom(), itemAndState);
		return new YArrivalDocVO(po);
	}

	@Override
	public String getAddressByID(String itemID) throws RemoteException, DatabaseNULLException {
		// TODO Auto-generated method stub
		return collectionbl.getSendDocPOByID(itemID).getrAddress();
	}

	@Override
	public String[] getCouriers() throws RemoteException {
		// TODO Auto-generated method stub
		return StringTools.toGroup( institution.getCourierID(institutionID));
	}



}
