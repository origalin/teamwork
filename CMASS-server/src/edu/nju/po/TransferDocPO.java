package edu.nju.po;

import java.util.Date;

public class TransferDocPO extends Doc{
	//long TransferDocID;
	Date date;
	String planeNum;
	String TrainNum;
	String CarNum;
	String tranceID;
	String corriage;
	String container;
	String from;
	String targetCity;
	String[] itemIDs;
	double price;
	boolean paid;
	public String toString(){
	String rees="";
	rees+=ID+" "+date;
	return rees;
	}
	public TransferDocPO() {};
	public TransferDocPO(String ID,Date date, String planeNum, String trainNum, String carNum, String tranceID, String corriage,
			String container, String from, String targetCity, String[] itemIDs, double price) {
		super();
		this.ID = ID;
		this.date = date;
		this.planeNum = planeNum;
		TrainNum = trainNum;
		CarNum = carNum;
		this.tranceID = tranceID;
		this.corriage = corriage;
		this.container = container;
		this.from = from;
		this.targetCity = targetCity;
		this.itemIDs = itemIDs;
		this.price = price;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public String getTransferDocID() {
		return ID;
	}
	public void setTransferDocID(String transferDocID) {
		this.ID = transferDocID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlaneNum() {
		return planeNum;
	}
	public void setPlaneNum(String planeNum) {
		this.planeNum = planeNum;
	}
	public String getTrainNum() {
		return TrainNum;
	}
	public void setTrainNum(String trainNum) {
		TrainNum = trainNum;
	}
	public String getCarNum() {
		return CarNum;
	}
	public void setCarNum(String carNum) {
		CarNum = carNum;
	}
	public String getTranceID() {
		return tranceID;
	}
	public void setTranceID(String tranceID) {
		this.tranceID = tranceID;
	}
	public String getCorriage() {
		return corriage;
	}
	public void setCorriage(String corriage) {
		this.corriage = corriage;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTargetCity() {
		return targetCity;
	}
	public void setTargetCity(String targetCity) {
		this.targetCity = targetCity;
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
