package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YDeliverDocService;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public class YDeliverDoc implements YDeliverDocService{
	String institutionID,  staffID;

	public YDeliverDoc(String institutionID, String staffID) {
		// TODO �Զ����ɵĹ��캯�����
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public int getYDeliverSequence() {
		// TODO �Զ����ɵķ������
		return 0;
	}

	@Override
	public void changeYDeliverDocSequence(int sequence) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public YDeliverDocVO createYDeliverDocVO(String courier) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public YDeliverDocVO findYDeliverDocVO(int courierID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getDeliverDocPOsByID(String staffID) {
		// TODO �Զ����ɵķ������
		return null;
	}

	public ArrayList<YDeliverDocVO> getDeliverDocVOsByID(String staffID) {
		// TODO Auto-generated method stub
		return null;
	}

}
