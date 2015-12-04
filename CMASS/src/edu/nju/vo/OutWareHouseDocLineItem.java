package edu.nju.vo;

public class OutWareHouseDocLineItem {
	String SendDocID;
	String outDate;
	String transformPattern;//装运形式
	String destination;
	
	
	public String getSendDocID() {
		return SendDocID;
	}
	public void setSendDocID(String sendDocID) {
		SendDocID = sendDocID;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getTransformPattern() {
		return transformPattern;
	}
	public void setTransformPattern(String transformPattern) {
		this.transformPattern = transformPattern;
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
		
		this.transformPattern = transformPattern;
		this.destination = destination;
	}
	public String toString2(){
		return SendDocID+","+transformPattern+","+destination;
	}
	
	public String toString(){
		return SendDocID+","+outDate+","+transformPattern+","+destination;
	}
	public boolean equals(OutWareHouseDocLineItem ou){
		return this.toString().equals(ou.toString());
	}
	
	public boolean equalsRoughly(OutWareHouseDocLineItem ou){
		String s1=SendDocID+","+outDate+","+transformPattern;
		String s2=ou.SendDocID+","+ou.outDate+","+ou.transformPattern;
		return s1.equals(s2);
		
	}

}
