package edu.nju.po;

import java.util.Date;

public class YLoadDocPO extends Doc{
	Date date;
	String tranceID;
	String target;
	String CarID;
	String watcher;
	String driver;
	String[] itemIDs;
	double price;
	boolean paid;
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public YLoadDocPO(String id,Date date, String tranceID,
			String targetBusinessHall, String carID, String watcher,
			String driver, String[] itemIDs, double price) {
		super();
		this.ID = id;
		this.date = date;
		this.tranceID = tranceID;
		this.target = targetBusinessHall;
		CarID = carID;
		this.watcher = watcher;
		this.driver = driver;
		this.itemIDs = itemIDs;
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTranceID() {
		return tranceID;
	}
	public void setTranceID(String tranceID) {
		this.tranceID = tranceID;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCarID() {
		return CarID;
	}
	public void setCarID(String carID) {
		CarID = carID;
	}
	public String getWatcher() {
		return watcher;
	}
	public void setWatcher(String watcher) {
		this.watcher = watcher;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String[] getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(String[] itemIDs) {
		this.itemIDs = itemIDs;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
