package edu.nju.po;

import java.io.Serializable;
import java.util.Date;

public class InWareHouseDocLineItem implements Serializable{
	String SendDocID;
	Date date;
	String destination;
	String district;
	String location;
	
	@Override
	public String toString() {
		return "InWareHouseDocLineItem [SendDocID=" + SendDocID + ", date=" + date + ", destination=" + destination
				+ ", district=" + district + ", location=" + location + "]";
	}

	public InWareHouseDocLineItem(String sendDocID, Date date, String district) {
		super();
		SendDocID = sendDocID;
		this.date = date;
		
		this.district = district;
	}
	
	public InWareHouseDocLineItem(String sendDocID, Date date, String district, String location) {
		super();
		SendDocID = sendDocID;
		this.date = date;
		this.district = district;
		this.location = location;
	}
	public InWareHouseDocLineItem(String sendDocID, Date date, String destination, String district, String location) {
		super();
		SendDocID = sendDocID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
	}
	public String getSendDocID() {
		return SendDocID;
	}
	public void setSendDocID(String sendDocID) {
		SendDocID = sendDocID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	
	

	
	

}
