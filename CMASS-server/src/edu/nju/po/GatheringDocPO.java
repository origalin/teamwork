package edu.nju.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

//（收款日期、收款金额、收款快递员、对应的所有快递订单条形码号。）

public class GatheringDocPO extends Doc implements Serializable{
	Date date;
	Double money;
	String courier_ID;
	ArrayList<String> itemIDs;
	String account;
	public GatheringDocPO(String GatheringDocID,Date date,Double money, String courier_ID,ArrayList<String> itemIDs,String account) {
		super();
		this.ID=GatheringDocID;
		this.money = money;
		this.courier_ID = courier_ID;
		this.itemIDs = itemIDs;
		this.date = date;
		this.account=account;
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
	public String getCourier_ID() {
		return courier_ID;
	}
	public void setCourier_ID(String courier_ID) {
		this.courier_ID = courier_ID;
	}
	public ArrayList<String> getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(ArrayList<String> itemIDs) {
		this.itemIDs = itemIDs;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
