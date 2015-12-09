package edu.nju.vo;

import java.util.Date;

import edu.nju.po.TransferDocPO;

public class TransferDocVO extends Doc{
	//long TransferDocID;
	String date;
	String planeNum;
	String TrainNum;
	String CarNum;
	String tranceID;
	String corriage;
	String container;
	String from;
	String targetCity;
	String watcher;
	public String getWatcher() {
		return watcher;
	}
	public void setWatcher(String watcher) {
		this.watcher = watcher;
	}
	String[] itemIDs;
	String price;
	public TransferDocVO(TransferDocPO PO) {
		// TODO Auto-generated constructor stub
	}
	public String getTransferDocID() {
		return ID;
	}
	public void setTransferDocID(String transferDocID) {
		this.ID = transferDocID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
