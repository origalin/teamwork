package edu.nju.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javafx.beans.binding.StringBinding;

public class OutWareHouseDocPO extends Doc {
//	int OutWareHouseDocID;
	String outWareHouseDocID;
	Date outDate;
	String transferPattern;
	String storageID;
	
	ArrayList<OutRecord> outRecords;
	
	
	public OutWareHouseDocPO(String outWareHouseDocID, Date outDate, String transferPattern, String storageID) {
		super();
		this.outWareHouseDocID = outWareHouseDocID;
		this.outDate = outDate;
		this.transferPattern = transferPattern;
		this.storageID = storageID;
		outRecords=new ArrayList<OutRecord>();
	}
	public void listAppend(OutRecord outRecord){
		outRecords.add(outRecord);
		return ;
	}
	@Override
	public String getID(){
		return outWareHouseDocID;
	}
	@Override
	public void setID(String s){
		this.outWareHouseDocID=s;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getTransferPattern() {
		return transferPattern;
	}
	public void setTransferPattern(String transferPattern) {
		this.transferPattern = transferPattern;
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}
	public OutWareHouseDocPO(String outWareHouseDocID, Date outDate, String transferPattern, String storageID,
			ArrayList<OutRecord> outRecords) {
		super();
		this.outWareHouseDocID = outWareHouseDocID;
		this.outDate = outDate;
		this.transferPattern = transferPattern;
		this.storageID = storageID;
		this.outRecords = outRecords;
	}
	public OutWareHouseDocPO(String outWareHouseDocID,
			ArrayList<OutRecord> outRecords) {
		super();
		ID = outWareHouseDocID;
		this.outRecords = outRecords;
	}
	public String getOutWareHouseDocID() {
		return outWareHouseDocID;
	}
	public void setOutWareHouseDocID(String outWareHouseDocID) {
		outWareHouseDocID = outWareHouseDocID;
	}
	public ArrayList<OutRecord> getOutRecords() {
		return outRecords;
	}
	public void setOutRecords(ArrayList<OutRecord> outRecords) {
		this.outRecords = outRecords;
	}
	@Override
	public String toString() {
		return "OutWareHouseDocPO [outWareHouseDocID=" + outWareHouseDocID + ", outDate=" + outDate
				+ ", transferPattern=" + transferPattern + ", storageID=" + storageID + ", outRecords=" + outRecords
				+ "]";
	}
	
	
}
