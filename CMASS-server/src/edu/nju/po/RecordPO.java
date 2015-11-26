package edu.nju.po;

import java.util.Date;

//入库单（快递编号、入库日期、目的地、区号、排号、
//架号、位号）
//相当于storageitempo
public class RecordPO {
	String itemID;
	Date date;
	String destination;
	String district;
	String location;//代替原来的排架位，6位的数字，2位排号，2位架号，2位位号
	String storageID;//仓库ID
	boolean isCoordinate=false;
	
	public RecordPO(String itemID, Date date, String destination, String district, String location) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
	}



	public RecordPO(String itemID, Date date, String destination, String district,String location, String storageID,
			boolean isCoordinate) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
		this.storageID = storageID;
		this.isCoordinate = isCoordinate;
	}
	
	

	public RecordPO(String itemID, Date date, String destination, String district, String location, String storageID) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.location = location;
		this.storageID = storageID;
	}
	
	



	public RecordPO(String itemID, Date date, String destination, String storageID) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.storageID = storageID;
	}



	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStorageID() {
		return storageID;
	}

	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}

	public boolean isCoordinate() {
		return isCoordinate;
	}

	public void setCoordinate(boolean isCoordinate) {
		this.isCoordinate = isCoordinate;
	}
	
}
