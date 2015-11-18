package edu.nju.vo;

import edu.nju.po.Doc;

public class YDeliverDocVO extends Doc{
	String YdeliverDocID;
	String date;
	String courier;
	String[] itemIDs;
	public YDeliverDocVO(String ydeliverDocID, String date, String courier, String[] itemIDs) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
