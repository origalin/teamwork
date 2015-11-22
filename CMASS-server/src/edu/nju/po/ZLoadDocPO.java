package edu.nju.po;

import java.util.Date;

public class ZLoadDocPO extends Doc{
	Date date;
	int tranceID;
	String targetBusinessHall;
	String CarID;
	String watcher;
	String driver;
	String[] itemIDs;
	double price;
	public ZLoadDocPO(String id, Date date, int tranceID,
			String targetBusinessHall, String carID, String watcher,
			String driver, String[] itemIDs, double price) {
		super();
		this.ID = id;
		this.date = date;
		this.tranceID = tranceID;
		this.targetBusinessHall = targetBusinessHall;
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
	public int getTranceID() {
		return tranceID;
	}
	public void setTranceID(int tranceID) {
		this.tranceID = tranceID;
	}
	public String getTargetBusinessHall() {
		return targetBusinessHall;
	}
	public void setTargetBusinessHall(String targetBusinessHall) {
		this.targetBusinessHall = targetBusinessHall;
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
