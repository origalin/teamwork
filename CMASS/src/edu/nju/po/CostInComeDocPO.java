package edu.nju.po;

public class CostInComeDocPO {
	double income,cost,profit;

	public CostInComeDocPO(double income, double cost) {
		super();
		this.income = income;
		this.cost = cost;
		this.profit = income-cost;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
		this.profit = income-cost;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
		this.profit = income-cost;
	}

	public double getProfit() {
		return profit;
	}

	
	
}
