package edu.nju.po;

public class OutRecord {
	int itemID;
	String date;
	String destination;
	String tranceType;
	int  other;
	public OutRecord(int itemID, String date, String destination,
			String tranceType, int other) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.tranceType = tranceType;
		this.other = other;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTranceType() {
		return tranceType;
	}
	public void setTranceType(String tranceType) {
		this.tranceType = tranceType;
	}
	public int getOther() {
		return other;
	}
	public void setOther(int other) {
		this.other = other;
	}
	
}
