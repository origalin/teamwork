package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogicservice.transformlogicservice.YArrivalDocService;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;

public class YArrivalDoc implements YArrivalDocService {
	String institutionID, staffID;
	private YArrivalDocPO po;
	private TransferDoc transferDoc;

	public YArrivalDoc( String staffID) {
		super();
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
	}

	public YArrivalDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) {
		// TODO 自动生成的方法存根

	}

	@Override
	public int getYArrivalSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void changeYArrivalSequence(int YArrivalSequence) {
		// TODO 自动生成的方法存根

	}

	@Override
	public YArrivalDocVO findYArrivalDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs() {
		// TODO 自动生成的方法存根
		return null;
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
