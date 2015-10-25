package edu.nju.po;

public class AccountPO {
	String name;
	Double balance;
	public AccountPO(String name, Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	public AccountPO(String name) {
		super();
		this.name = name;
		this.balance = 0.0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
