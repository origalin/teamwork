package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public interface InstitutionDataService {
	public ArrayList<StaffPO> getBusinessManList();
	
	
	public int findSalary();
	public ArrayList<StaffPO> findStaff();
	public ArrayList<InstitutionPO> findInstitution();
	public double  getDistance(String city1,String city2);
	
	
	public void saveSalary (StaffPO po);
	public void saveStaff(StaffPO po);
	public void saveInstitution (InstitutionPO po);
	public void saveDistance(String city1,String city2,double distance);
}
