package edu.nju.vo;

import java.util.Date;

public class OutWareHouseDocLineItem {
	String SendDocID;
	
	
	String destination;
	
	
	
	public OutWareHouseDocLineItem(String sendDocID, String destination) {
		super();
		SendDocID = sendDocID;
		this.destination = destination;
	}
	public OutWareHouseDocLineItem(String sendDocID) {
		super();
		SendDocID = sendDocID;
		
	}
	public String getSendDocID() {
		return SendDocID;
	}
	public void setSendDocID(String sendDocID) {
		SendDocID = sendDocID;
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
	
	
	
	@Override
	public String toString() {
		return "OutWareHouseDocLineItem [SendDocID=" + SendDocID + ", destination=" + destination + "]";
	}
	public boolean equals(OutWareHouseDocLineItem ou){
		return this.toString().equals(ou.toString());
	}
	
	

}
