package edu.nju.po;

import java.util.ArrayList;
import java.util.Date;

//���տ����ڡ��տ���տ���Ա����Ӧ�����п�ݶ���������š���

public class GatheringDocPO extends Doc {
	Date date;
	Double money;
	String courier_name;
	ArrayList<String> itemIDs;
	String account;
	public GatheringDocPO(String GatheringDocID,Date date,Double money, String courier_name,ArrayList<String> itemIDs,String account) {
		super();
		this.ID=GatheringDocID;
		this.money = money;
		this.courier_name = courier_name;
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	
}
