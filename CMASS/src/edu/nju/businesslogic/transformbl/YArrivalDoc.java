package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.YArrivalDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.YArrivalDocVO;

public class YArrivalDoc implements YArrivalDocService {
	String institutionID, staffID;
	private YArrivalDocPO po;
	private TransferDoc transferDoc;
	private Institution institution;
	private TransferDataService transferDataService; 

	public YArrivalDoc( String staffID) {
		super();
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
		institution = new Institution();
		this.institutionID = institution.getInstitutionID(staffID);
		transferDataService = new TransferDataServiceImpl(institutionID);
	}

	public YArrivalDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) {
		// TODO �Զ����ɵķ������
		transferDataService.saveYArrivalDocPO(po);
	}

	@Override
	public String getYArrivalSequence() {
		// TODO �Զ����ɵķ������
		return transferDataService.getYArrivalSequence();
	}

	@Override
	public void changeYArrivalSequence() {
		// TODO �Զ����ɵķ������
		String next = SequenceCalc.calcNextSequence6(getYArrivalSequence());
		transferDataService.changeYArrivalSequence(next);
	}

	@Override
	public YArrivalDocVO findYArrivalDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs() {
		// TODO �Զ����ɵķ������
		return transferDataService.getAllYArrivalDoc();
	}

	@Override
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates) {
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
	public String getAddressByID(String itemID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getCouriers() {
		// TODO Auto-generated method stub
		return null;
	}



}
