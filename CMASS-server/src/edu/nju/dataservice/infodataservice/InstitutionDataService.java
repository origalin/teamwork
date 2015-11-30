package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public interface InstitutionDataService extends Remote{
	
	public ArrayList<StaffPO> findStaff(String institutionName);
	public void addStaff(StaffPO po);
	public void changeStaff(StaffPO po);
	public void deleteStaff(StaffPO po);
	
	public ArrayList<StaffPO> getBusinessManList();
	
	public ArrayList<InstitutionPO> findInstitution();
	public void saveInstitution (InstitutionPO po);
	
	//�˻�����Ȩ�޹���
	
		public StaffPO getAccout(String staffID);
		public void saveAccount(StaffPO po);
	
	
	


}
