package edu.nju.po;


public class YLoadDocPO extends Doc{
	long date;
	int tranceID;
	String target;
	String CarID;
	String watcher;
	String driver;
	String[] itemIDs;
	double price;
	public YLoadDocPO(long date, int tranceID,
			String targetBusinessHall, String carID, String watcher,
			String driver, String[] itemIDs, double price) {
		super();
		this.date = date;
		this.tranceID = tranceID;
		this.target = targetBusinessHall;
		CarID = carID;
		this.watcher = watcher;
		this.driver = driver;
		this.itemIDs = itemIDs;
		this.price = price;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getTranceID() {
		return tranceID;
	}
	public void setTranceID(int tranceID) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
