package edu.nju.vo;

import java.util.ArrayList;
import java.util.Date;

public class GatheringDocVO extends Doc{
	Date date;
	Double money;
	String courier_ID;
	ArrayList<String> itemIDs;
	String account;
	public GatheringDocVO(String GatheringDocID,Date date,Double money, String courier_ID,ArrayList<String> itemIDs,String account) {
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
