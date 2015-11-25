package edu.nju.businesslogic.transformbl;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.transformlogicservice.OverDocService;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataservice.transformdataservice.TransferDataService;
import edu.nju.po.OverDocPO;
import edu.nju.tools.SequenceCalc;
import edu.nju.vo.OverDocVO;

public class OverDoc implements OverDocService{
	String institutionID;
	String staffID;
	OverDocPO po;
	TransferDataService transferDataService;

	public OverDoc( String staffID) {
		// TODO 自动生成的构造函数存根
		this.staffID = staffID;
		this.institutionID = new Institution().getInstitutionID(staffID);
		transferDataService = new TransferDataServiceImpl(institutionID);
	}

	public OverDoc() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveOverDocPO(OverDocPO po) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public String getOverDocSequence() {
		// TODO 自动生成的方法存根
		return transferDataService.getOverSequence();
	}

	@Override
	public void changeOverDocSequence() {
		// TODO 自动生成的方法存根
		String next = SequenceCalc.calcNextSequence6(getOverDocSequence());
		transferDataService.changeOverSequence(next);
	}



	@Override
	public OverDocVO findOverDocVO(String  ID) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<OverDocPO> getUncheckedOverDocPOs() {
		// TODO 自动生成的方法存根
		return transferDataService.getAllOverDoc();
	}

	@Override
	public OverDocVO createOverDocVO(String[] itemIDs, String[] receivers) {
		// TODO Auto-generated method stub
		po = new OverDocPO("13"+getOverDocSequence(),itemIDs, receivers, new Date(), staffID);
		return new OverDocVO(po);
	}

}
