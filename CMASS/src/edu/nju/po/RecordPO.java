package edu.nju.po;
//入库单（快递编号、入库日期、目的地、区号、排号、
//架号、位号）
//相当于storageitempo
public class RecordPO {
	int itemID;
	String date;
	String destination;
	String district;
	int row;
	int shelf;
	int point;
	public RecordPO(int itemID, String date, String destination,
			String district, int row, int shelf, int point) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.row = row;
		this.shelf = shelf;
		this.point = point;
	}
	public RecordPO() {
		// TODO 自动生成的构造函数存根
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getShelf() {
		return shelf;
	}
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
