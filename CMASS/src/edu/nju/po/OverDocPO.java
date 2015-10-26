package edu.nju.po;

public class OverDocPO {
	int OverDocID;
	int itemID;
	String receiver;
	Long date;
	public OverDocPO(int overDocID, int itemID, String receiver, Long date) {
		super();
		OverDocID = overDocID;
		this.itemID = itemID;
		this.receiver = receiver;
		this.date = date;
	}
	public int getOverDocID() {
		return OverDocID;
	}
	public void setOverDocID(int overDocID) {
		OverDocID = overDocID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	
}
