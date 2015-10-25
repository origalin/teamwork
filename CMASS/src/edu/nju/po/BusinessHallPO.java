package edu.nju.po;

public class BusinessHallPO extends InstitutionPO{
	BusinessHallPO(String name,String type,String city){
		this.city = city;
		this.type = type;
		this.name = name;
	}
	@Override
	void setStaffID(StaffPO po) {
		// TODO 自动生成的方法存根
		
	}

}
