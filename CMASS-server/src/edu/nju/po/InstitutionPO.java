package edu.nju.po;

import java.util.ArrayList;

public abstract class InstitutionPO {
	ArrayList<StaffPO> staffPOs;
	ArrayList<InstitutionPO> subInstitution;
	String city;
	String name;
	Institutation type;
	double rent;
	public ArrayList<StaffPO> getStaffPOs() {
		return staffPOs;
	}
	public void setStaffPOs(ArrayList<StaffPO> staffPOs) {
		this.staffPOs = staffPOs;
	}
	public ArrayList<InstitutionPO> getSubInstitution() {
		return subInstitution;
	}
	public void setSubInstitution(ArrayList<InstitutionPO> subInstitution) {
		this.subInstitution = subInstitution;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Institutation getType() {
		return type;
	}
	public void setType(Institutation type) {
		this.type = type;
	}
	//ȱ��ְ���жϣ����޸�
	void addStaff(StaffPO po){
		this.staffPOs.add(po);
		setStaffID(po);
	}
	void addSubInstitusion(InstitutionPO po) {
		this.subInstitution.add(po);
	}
	void removeStaff(StaffPO po) {
		this.staffPOs.remove(po);
	}
	void removeSubInstution(InstitutionPO po) {
		this.subInstitution.remove(po);
	}
	abstract void setStaffID(StaffPO po);

}
