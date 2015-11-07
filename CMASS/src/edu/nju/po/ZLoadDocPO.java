package edu.nju.po;

public class ZLoadDocPO {
	int zLoadDocID;
	long date;
	int tranceID;
	String targetBusinessHall;
	int CarID;
	String watcher;
	String driver;
	int[] itemIDs;
	double price;
	public ZLoadDocPO(int zLoadDocID, long date, int tranceID,
			String targetBusinessHall, int carID, String watcher,
			String driver, int[] itemIDs, double price) {
		super();
		this.zLoadDocID = zLoadDocID;
		this.date = date;
		this.tranceID = tranceID;
		this.targetBusinessHall = targetBusinessHall;
		CarID = carID;
		this.watcher = watcher;
		this.driver = driver;
		this.itemIDs = itemIDs;
		this.price = price;
	}
	public int getzLoadDocID() {
		return zLoadDocID;
	}
	public void setZLoadDocID(int zLoadDocID) {
		this.zLoadDocID = zLoadDocID;
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
		return targetBusinessHall;
	}
	public void setTargetBusinessHall(String targetBusinessHall) {
		this.targetBusinessHall = targetBusinessHall;
	}
	public int getCarID() {
		return CarID;
	}
	public void setCarID(int carID) {
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
	public int[] getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(int[] itemIDs) {
		this.itemIDs = itemIDs;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
