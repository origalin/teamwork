package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YArrivalDocService;
import edu.nju.po.YArrivalDocPO;
import edu.nju.vo.YArrivalDocVO;

public class YArrivalDoc implements YArrivalDocService {
	String institutionID, staffID;

	public YArrivalDoc(String institutionID, String staffID) {
		super();
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveYArrivalDocPO(YArrivalDocPO po) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public int getYArrivalSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeYArrivalSequence(int YArrivalSequence) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public YArrivalDocVO findYArrivalDocVO(int ID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YArrivalDocPO> getUncheckedYaArrivalDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public YArrivalDocVO createYArrivalDocVO(String fromDocID, String[][] changeStates) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public boolean createYDeliverDoc(String[][] table) {
		// TODO Auto-generated method stub
		return false;
	}

}
