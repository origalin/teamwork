package edu.nju.po;

import java.io.Serializable;
import java.util.Date;

public class YDeliverDocPO extends Doc{
	Date date;
	String courier;
	String[] itemIDs;
	boolean dealed = false;
	public boolean isDealed() {
		return dealed;
	}
	public void setDealed(boolean dealed) {
		this.dealed = dealed;
	}
	public YDeliverDocPO(String id,Date date, String courier, String[] itemIDs) {
		super();
		this.ID = id;
		this.date = date;
		this.courier = courier;
		this.itemIDs = itemIDs;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
