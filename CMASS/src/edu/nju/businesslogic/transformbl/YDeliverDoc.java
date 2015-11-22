package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.YDeliverDocService;
import edu.nju.po.YDeliverDocPO;
import edu.nju.vo.YDeliverDocVO;

public class YDeliverDoc implements YDeliverDocService{
	String institutionID,  staffID;

	public YDeliverDoc(String institutionID, String staffID) {
		// TODO 自动生成的构造函数存根
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	public YDeliverDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveYDeliverDocPO(YDeliverDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public int getYDeliverSequence() {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void changeYDeliverDocSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public YDeliverDocVO createYDeliverDocVO(String courier) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public YDeliverDocVO findYDeliverDocVO(int courierID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getUncheckedDeliverDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<YDeliverDocPO> getDeliverDocPOsByID(String staffID) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ArrayList<YDeliverDocVO> getDeliverDocVOsByID(String staffID) {
		// TODO Auto-generated method stub
		return null;
	}

}
