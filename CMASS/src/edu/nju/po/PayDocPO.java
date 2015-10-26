package edu.nju.po;

public class PayDocPO {
	int PayDocID;
	long date;
	double money;
	String payer;
	int account;
	PayType type;
	String back;
	public PayDocPO(int payDocID, long date, double money, String payer,
			int account, PayType type, String back) {
		super();
		PayDocID = payDocID;
		this.date = date;
		this.money = money;
		this.payer = payer;
		this.account = account;
		this.type = type;
		this.back = back;
	}
	public int getPayDocID() {
		return PayDocID;
	}
	public void setPayDocID(int payDocID) {
		PayDocID = payDocID;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
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
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public PayType getType() {
		return type;
	}
	public void setType(PayType type) {
		this.type = type;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
	

}
