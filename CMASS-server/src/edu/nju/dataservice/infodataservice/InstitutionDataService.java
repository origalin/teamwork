package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public interface InstitutionDataService {
	
	public ArrayList<StaffPO> findStaff(String institutionName);
	public void addStaff(StaffPO po);
	public void changeStaff(StaffPO po);
	public void deleteStaff(StaffPO po);
	
	public ArrayList<StaffPO> getBusinessManList();
	
	public ArrayList<InstitutionPO> findInstitution();
	public void saveInstitution (InstitutionPO po);
	
	//账户密码权限管理
	
		public StaffPO getAccout(String staffID);
		public void saveAccount(StaffPO po);
	
	
	


}
