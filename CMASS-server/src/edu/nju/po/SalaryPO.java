package edu.nju.po;

import java.io.Serializable;

public class SalaryPO implements Serializable{
	String id;
	Double baseSalary;
	Double bonusSalary;
	Double percentageSalary;
	boolean isPaid;
	public SalaryPO(String id, Double baseSalary, Double bonusSalary,
			Double percentageSalary, boolean isPaid) {
		super();
		this.id = id;
		this.baseSalary = baseSalary;
		this.bonusSalary = bonusSalary;
		this.percentageSalary = percentageSalary;
		this.isPaid = isPaid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public Double getBonusSalary() {
		return bonusSalary;
	}
	public void setBonusSalary(Double bonusSalary) {
		this.bonusSalary = bonusSalary;
	}
	public Double getPercentageSalary() {
		return percentageSalary;
	}
	public void setPercentageSalary(Double percentageSalary) {
		this.percentageSalary = percentageSalary;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
}
