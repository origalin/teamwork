package edu.nju.po;

public class StaffPO {
	String staffID;
	String name;
	Institutation institutation;
	Post post;
	Double baseSalary;
	Double bonusSalary;
	Double percentageSalary;
	boolean isPaid;
	String password;
	Post power;
	public StaffPO(String staffID, String name, Institutation institutation,
			Post post, Double baseSalary, Double bonusSalary,
			Double percentageSalary, boolean isPaid, String password, Post power) {
		super();
		this.staffID = staffID;
		this.name = name;
		this.institutation = institutation;
		this.post = post;
		this.baseSalary = baseSalary;
		this.bonusSalary = bonusSalary;
		this.percentageSalary = percentageSalary;
		this.isPaid = isPaid;
		this.password = password;
		this.power = power;
	}
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Institutation getInstitutation() {
		return institutation;
	}
	public void setInstitutation(Institutation institutation) {
		this.institutation = institutation;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Post getPower() {
		return power;
	}
	public void setPower(Post power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "StaffPO [staffID=" + staffID + ", name=" + name
				+ ", institutation=" + institutation + ", post=" + post
				+ ", baseSalary=" + baseSalary + ", bonusSalary=" + bonusSalary
				+ ", percentageSalary=" + percentageSalary + ", isPaid="
				+ isPaid + ", password=" + password + ", power=" + power + "]";
	}
	
}
