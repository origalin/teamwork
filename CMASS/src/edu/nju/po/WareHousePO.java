package edu.nju.po;
//区分于有库存的仓库
public class WareHousePO extends InstitutionPO{
	WareHousePO(String name,String type,String city){
		this.city = city;
		this.type = type;
		this.name = name;
	}
	@Override
	void setStaffID(StaffPO po) {
		// TODO 自动生成的方法存根
		
	}
	
}
