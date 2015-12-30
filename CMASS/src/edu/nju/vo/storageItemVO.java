package edu.nju.vo;

import java.util.Date;

import edu.nju.po.RecordPO;

public class storageItemVO {
	String itemID;
	Date date;
	String destination;
	String district;
	String row;//代替原来的排架位，6位的数字，2位排号，2位架号，2位位号
	String shelf;
	String pos;
	String storageID;//仓库ID
	public storageItemVO(RecordPO po) {
		itemID=po.getItemID();
		date=po.getDate();
		destination=po.getDestination();
		district=po.getDistrict();
		row=po.getLocation().substring(0, 2);
		shelf=po.getLocation().substring(2, 4);
		pos=po.getLocation().substring(4, 6);
		storageID=po.getStorageID();
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
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getStorageID() {
		return storageID;
	}
	public void setStorageID(String storageID) {
		this.storageID = storageID;
	}

}
