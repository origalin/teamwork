package edu.nju.po;

import java.util.ArrayList;


public class InWareHouseDocPO extends Doc{
	String InWareHouseDocID;
	ArrayList<RecordPO> recordPOs;
	public String getInWareHouseDocID() {
		return InWareHouseDocID;
	}
	public void setInWareHouseDocID(String inWareHouseDocID) {
		InWareHouseDocID = inWareHouseDocID;
	}
	public ArrayList<RecordPO> getRecordPOs() {
		return recordPOs;
	}
	public void setRecordPOs(ArrayList<RecordPO> recordPOs) {
		this.recordPOs = recordPOs;
	}
	
}
