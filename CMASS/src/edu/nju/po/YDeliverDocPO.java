package edu.nju.po;

public class YDeliverDocPO extends Doc{
	long date;
	String courier;
	String[] itemIDs;
	public YDeliverDocPO(long date, String courier, String[] itemIDs) {
		super();
		this.date = date;
		this.courier = courier;
		this.itemIDs = itemIDs;
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
