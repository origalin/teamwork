package edu.nju.po;

import java.util.ArrayList;


public class InWareHouseDocPO extends Doc{
	int InWareHouseDocID;
	ArrayList<RecordPO> recordPOs;
	public int getInWareHouseDocID() {
		return InWareHouseDocID;
	}
	public void setInWareHouseDocID(int inWareHouseDocID) {
		InWareHouseDocID = inWareHouseDocID;
	}
	public ArrayList<RecordPO> getRecordPOs() {
		return recordPOs;
	}
	public void setRecordPOs(ArrayList<RecordPO> recordPOs) {
		this.recordPOs = recordPOs;
	}
	
}
