package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.transformlogicservice.OverDocService;
import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public class OverDoc implements OverDocService{
	String institutionID;
	String staffID;
	OverDocPO po;

	public OverDoc(String institutionID, String staffID) {
		// TODO 自动生成的构造函数存根
		this.institutionID = institutionID;
		this.staffID = staffID;
	}

	@Override
	public void saveOverDocPO(OverDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getOverDocSequence() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void changeOverDocSequence(int sequence) {
		// TODO 自动生成的方法存根
		
	}



	@Override
	public OverDocVO findOverDocVO(int ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getUncheckedOverDocPOs() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public OverDocVO createOverDocVO(String[] itemIDs, String[] receivers) {
		// TODO Auto-generated method stub
		po = new OverDocPO(itemIDs, receivers, System.currentTimeMillis(), staffID);
		po.setID("13"+getOverDocSequence());
		return null;
	}

}
