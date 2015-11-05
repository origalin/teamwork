package edu.nju.vo;

public class InWareHouseDocLineItem {
	int SendDocID;
	String date;
	String destination;
	int district;
	int row;
	int shelf;
	int point;
	
	
	public InWareHouseDocLineItem(int sendDocID, String date, String destination, int district, int row, int shelf, int point) {
		super();
		SendDocID = sendDocID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.row = row;
		this.shelf = shelf;
		this.point = point;
	}
	public int getSendDocID() {
		return SendDocID;
	}
	public void setSendDocID(int sendDocID) {
		SendDocID = sendDocID;
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
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
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
