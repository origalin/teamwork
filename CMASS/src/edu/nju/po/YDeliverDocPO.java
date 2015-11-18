package edu.nju.po;

public class YDeliverDocPO extends Doc{
	String YdeliverDocID;
	long date;
	String courier;
	String[] itemIDs;
	public YDeliverDocPO(String ydeliverDocID, long date, String courier, String[] itemIDs) {
		super();
		YdeliverDocID = ydeliverDocID;
		this.date = date;
		this.courier = courier;
		this.itemIDs = itemIDs;
	}
	public String getYdeliverDocID() {
		return YdeliverDocID;
	}
	public void setYdeliverDocID(String ydeliverDocID) {
		YdeliverDocID = ydeliverDocID;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String[] getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}
	
}
