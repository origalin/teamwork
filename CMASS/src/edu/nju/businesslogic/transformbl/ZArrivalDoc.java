package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.ZArrivalDocService;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.vo.ZArrivalDocVO;

public class ZArrivalDoc implements ZArrivalDocService{
	String institutionID, staffID;
	
	public ZArrivalDoc(String institutionID, String staffID) {
		super();
		this.institutionID = institutionID;
		this.staffID = staffID;
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
		return null;
	}
	@Override
	public ZArrivalDocVO createZArrivalDocVO_YLoadDoc(String fromDocID, String[][] changeStates) {
		// TODO Auto-generated method stub
		return null;
	}

}
