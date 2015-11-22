package edu.nju.vo;

public class AccountVO {
	String name;
	Double balance;
	public AccountVO(String name, Double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
	public AccountVO(String name) {
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
