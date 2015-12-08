package edu.nju.po;

import java.io.Serializable;
import java.util.Date;

public class OverDocPO extends Doc implements Serializable{
	Date date;
	String[] itemIDs;//¿ìµÝid
	String[] receiver;

	String courier;

	public OverDocPO(String id,String[] itemID, String[] receiver, Date date, String courier) {
		super();
		this.ID = id;
		this.itemIDs = itemID;
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
		return itemIDs;
	}
	public void setItemID(String[] itemID) {
		this.itemIDs = itemID;
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
