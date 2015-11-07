package edu.nju.po;

import java.util.ArrayList;

public class OutWareHouseDocPO extends Doc{
//	int OutWareHouseDocID;
	ArrayList<OutRecord> outRecords;
	public OutWareHouseDocPO(int outWareHouseDocID,
			ArrayList<OutRecord> outRecords) {
		super();
		ID = outWareHouseDocID;
		this.outRecords = outRecords;
	}
	public int getOutWareHouseDocID() {
		return ID;
	}
	public void setOutWareHouseDocID(int outWareHouseDocID) {
		ID = outWareHouseDocID;
	}
	public ArrayList<OutRecord> getOutRecords() {
		return outRecords;
	}
	public void setOutRecords(ArrayList<OutRecord> outRecords) {
		this.outRecords = outRecords;
	}
	
	
}
