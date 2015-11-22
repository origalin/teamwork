package edu.nju.po;

import java.util.Date;

public class PayDocPO extends Doc{
//	int ID;
	Date date;
	double money;
	String payer;
	String account;
	PayType type;
	String back;
	public PayDocPO(String payDocID, Date date, double money, String payer,
			String account, PayType type, String back) {
		super();
		ID = payDocID;
		this.date = date;
		this.money = money;
		this.payer = payer;
		this.account = account;
		this.type = type;
		this.back=back;
	}
	public String getPayDocID() {
		return ID;
	}
	public void setPayDocID(String payDocID) {
		ID = payDocID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public PayType getType() {
		return type;
	}
	public void setType(PayType type) {
		this.type = type;
	}
	

}
