package edu.nju.vo;

import java.util.Date;

import edu.nju.po.YLoadDocPO;
import edu.nju.tools.Time;

public class YLoadDocVO extends Doc{
	String date;
	String tranceID;
	String target;
	String CarID;
	String watcher;
	String driver;
	String businessHallID;
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getBusinessHallID() {
		return businessHallID;
	}
	public void setBusinessHallID(String businessHallID) {
		this.businessHallID = businessHallID;
	}
	String[] itemIDs;
	String price;
	public YLoadDocVO(YLoadDocPO po) {
		this.date = Time.toDaysTime(po.getDate());
		this.ID = po.getID();
		this.tranceID = String.valueOf(po.getTranceID());
		this.target = po.getTarget();
		this.CarID = po.getCarID();
		this.watcher = po.getWatcher();
		this.driver = po.getDriver();
		this.businessHallID = po.getBusinessHallID();
		this.itemIDs = po.getItemIDs();
		this.price = String.valueOf(po.getPrice());
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTranceID() {
		return tranceID;
	}
	public void setTranceID(String tranceID) {
		this.tranceID = tranceID;
	}
	public String getTargetBusinessHall() {
		return target;
	}
	public void setTargetBusinessHall(String targetBusinessHall) {
		this.target = targetBusinessHall;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
