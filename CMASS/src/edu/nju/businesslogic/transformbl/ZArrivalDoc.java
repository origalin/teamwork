package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogicservice.transformlogicservice.ZArrivalDocService;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.ZArrivalDocVO;

public class ZArrivalDoc implements ZArrivalDocService{
	String institutionID, staffID;
	private ZArrivalDocPO po;
	private TransferDoc transferDoc;
	private YLoadDoc yLoadDoc;
	public ZArrivalDoc( String staffID) {
		super();
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
		yLoadDoc = new YLoadDoc(staffID);
	}

	public ZArrivalDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveZArrivalDocPO(ZArrivalDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getZArrivalSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeZArrivalSequence(int ZArrivalSequence) {
		// TODO �Զ����ɵķ������
		
	}


	@Override
	public ZArrivalDocVO findZArrivalDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<ZArrivalDocPO> getUncheckedZArrivalDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ZArrivalDocVO createZArrivalDocVO_TransferDoc(String fromDocID, String[][] changeStates) {
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
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) {
		// TODO Auto-generated method stub
		YLoadDocPO yLoadDocPO = yLoadDoc.getYloadPOByID(fromDocID);
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
		po = new ZArrivalDocPO("02"+getZArrivalSequence(), new Date(), fromDocID, "����", itemAndState);
		return new ZArrivalDocVO(po);
	}

}
