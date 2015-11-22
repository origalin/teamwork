package edu.nju.po;

import java.util.Date;

public class OverDocPO extends Doc{
	
	String[] itemID;//¿ìµÝid
	String[] receiver;
	Date date;
	String courier;

	public OverDocPO(String id,String[] itemID, String[] receiver, Date date, String courier) {
		super();
		this.ID = id;
		this.itemID = itemID;
		this.receiver = receiver;
		this.date = date;
		this.courier = courier;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public String getOverDocID() {
		return ID;
	}
	public void setOverDocID(String overDocID) {
		ID = overDocID;
	}
	public String[] getItemID() {
		return itemID;
	}
	public void setItemID(String[] itemID) {
		this.itemID = itemID;
	}
	public String[] getReceiver() {
		return receiver;
	}
	public void setReceiver(String[] receiver) {
		this.receiver = receiver;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
}
