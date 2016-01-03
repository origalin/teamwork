package edu.nju.vo;

public class exCostIncomDocVO {
	public exCostIncomDocVO(double cost, double income, double profit) {
		super();
		this.cost = cost;
		this.income = income;
		this.profit = profit;
	}
	double cost;
	double income;
	double profit;
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
}
