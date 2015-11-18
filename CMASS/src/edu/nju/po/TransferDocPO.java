package edu.nju.po;


public class TransferDocPO extends Doc{
	//long TransferDocID;
	long date;
	int planeNum;
	int TrainNum;
	int CarNum;
	String tranceID;
	int corriage;
	int container;
	String from;
	String targetCity;
	String[] itemIDs;
	double price;
	public String getTransferDocID() {
		return ID;
	}
	public void setTransferDocID(String transferDocID) {
		this.ID = transferDocID;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getPlaneNum() {
		return planeNum;
	}
	public void setPlaneNum(int planeNum) {
		this.planeNum = planeNum;
	}
	public int getTrainNum() {
		return TrainNum;
	}
	public void setTrainNum(int trainNum) {
		TrainNum = trainNum;
	}
	public int getCarNum() {
		return CarNum;
	}
	public void setCarNum(int carNum) {
		CarNum = carNum;
	}
	public String getTranceID() {
		return tranceID;
	}
	public void setTranceID(String tranceID) {
		this.tranceID = tranceID;
	}
	public int getCorriage() {
		return corriage;
	}
	public void setCorriage(int corriage) {
		this.corriage = corriage;
	}
	public int getContainer() {
		return container;
	}
	public void setContainer(int container) {
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
