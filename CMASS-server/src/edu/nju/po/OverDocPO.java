package edu.nju.po;

public class OverDocPO extends Doc{
	
	String[] itemID;//¿ìµÝid
	String[] receiver;
	Long date;
	String courier;

	public OverDocPO(String[] itemID, String[] receiver, Long date, String courier) {
		super();
		this.itemID = itemID;
		this.receiver = receiver;
		this.date = date;
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
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}

	
}
