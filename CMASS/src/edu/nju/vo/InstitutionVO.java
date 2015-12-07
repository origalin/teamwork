package edu.nju.vo;

import java.util.ArrayList;

import edu.nju.po.Institutation;
import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public class InstitutionVO {
	String id;
	Institutation type;
	String name;
	String city;
	InstitutionPO parentInstitution;
	double rent;
	boolean isPaid;
	ArrayList<StaffPO> staffList;
	

	public InstitutionVO(String id, Institutation type, String name,
			String city, InstitutionPO parentInstitution, double rent,
			boolean isPaid, ArrayList<StaffPO> staffList) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.city = city;
		this.parentInstitution = parentInstitution;
		this.rent = rent;
		this.isPaid = isPaid;
		this.staffList = staffList;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Institutation getType() {
		return type;
	}


	public void setType(Institutation type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public InstitutionPO getParentInstitution() {
		return parentInstitution;
	}


	public void setParentInstitution(InstitutionPO parentInstitution) {
		this.parentInstitution = parentInstitution;
	}


	public double getRent() {
		return rent;
	}


	public void setRent(double rent) {
		this.rent = rent;
	}


	public boolean isPaid() {
		return isPaid;
	}


	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}


	public ArrayList<StaffPO> getStaffList() {
		return staffList;
	}


	public void setStaffList(ArrayList<StaffPO> staffList) {
		this.staffList = staffList;
	}


	void addStaff(StaffPO po){
		this.staffList.add(po);
	}
	void deleteStaff(StaffPO po){
		this.staffList.remove(po);
	}

}
