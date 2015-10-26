package edu.nju.po;

import java.util.ArrayList;

public class OutWareHouseDocPO {
	int OutWareHouseDocID;
	ArrayList<OutRecord> outRecords;
	public OutWareHouseDocPO(int outWareHouseDocID,
			ArrayList<OutRecord> outRecords) {
		super();
		OutWareHouseDocID = outWareHouseDocID;
		this.outRecords = outRecords;
	}
	public int getOutWareHouseDocID() {
		return OutWareHouseDocID;
	}
	public void setOutWareHouseDocID(int outWareHouseDocID) {
		OutWareHouseDocID = outWareHouseDocID;
	}
	public ArrayList<OutRecord> getOutRecords() {
		return outRecords;
	}
	public void setOutRecords(ArrayList<OutRecord> outRecords) {
		this.outRecords = outRecords;
	}
	
	
}
