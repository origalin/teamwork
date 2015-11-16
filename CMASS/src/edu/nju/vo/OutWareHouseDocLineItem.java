package edu.nju.vo;

public class OutWareHouseDocLineItem {
	String SendDocID;
	String outDate;
	String transformPattern;//装运形式
	String destination;
	
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
