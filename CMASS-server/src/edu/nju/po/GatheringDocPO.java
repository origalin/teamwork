package edu.nju.po;

import java.util.ArrayList;
import java.util.Date;

//（收款日期、收款金额、收款快递员、对应的所有快递订单条形码号。）

public class GatheringDocPO extends Doc {
	Date date;
	Double money;
	String courier_name;
	ArrayList<String> itemIDs;
	public GatheringDocPO(String GatheringDocID,Date date,Double money, String courier_name,ArrayList<String> itemIDs) {
		super();
		this.ID=GatheringDocID;
		this.money = money;
		this.courier_name = courier_name;
		this.itemIDs = itemIDs;
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getCourier_name() {
		return courier_name;
	}
	public void setCourier_name(String courier_name) {
		this.courier_name = courier_name;
	}
	public ArrayList<String> getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(ArrayList<String> itemIDs) {
		this.itemIDs = itemIDs;
	}
	
	
}
