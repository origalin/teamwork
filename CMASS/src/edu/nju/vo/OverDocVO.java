package edu.nju.vo;

import java.util.Date;

import edu.nju.po.OverDocPO;
import edu.nju.tools.Time;

public class OverDocVO extends Doc{
	
	String[] itemID;//¿ìµÝid
	String[] receiver;
	String date;
	String courier;

	public OverDocVO(OverDocPO po) {
		this.ID = po.getID();
		this.date = Time.toDaysTime(po.getDate());
		this.itemID = po.getItemID();
		this.receiver = po.getReceiver();
		this.courier = po.getCourier();
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
