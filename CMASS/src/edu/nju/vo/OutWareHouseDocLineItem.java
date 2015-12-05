package edu.nju.vo;

import java.util.Date;

public class OutWareHouseDocLineItem {
	String SendDocID;
	Date outDate;
	
	String destination;
	
	
	
	public OutWareHouseDocLineItem(String sendDocID, Date outDate) {
		super();
		SendDocID = sendDocID;
		this.outDate = outDate;
	}
	public String getSendDocID() {
		return SendDocID;
	}
	public void setSendDocID(String sendDocID) {
		SendDocID = sendDocID;
	}
	

	
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public OutWareHouseDocLineItem(String sendDocID,  String transformPattern, String destination) {
		super();
		SendDocID = sendDocID;
		
		
		this.destination = destination;
	}
	
	
	
	public boolean equals(OutWareHouseDocLineItem ou){
		return this.toString().equals(ou.toString());
	}
	
	

}
