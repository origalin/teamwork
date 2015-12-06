package edu.nju.po;

import java.util.ArrayList;

public abstract class InstitutionPO {
	ArrayList<StaffPO> staffList;
	InstitutionPO parentInstitution;
	String city;
	String name;
	Institutation type;
	double rent;
	
	//缺少职务判断，待修改
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
