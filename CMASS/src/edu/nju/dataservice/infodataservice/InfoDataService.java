package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public interface InfoDataService {
	public ArrayList<StaffPO> getBusinessManList();
	public ArrayList<DriverPO> findDriver();
	public ArrayList<CarPO> findCar();
	public int findSalary();
	public ArrayList<StaffPO> findStaff();
	public ArrayList<InstitutionPO> findInstitution();
	public double  getDistance(String city1,String city2);
	public void saveDriver(DriverPO po);
	public void saveCar(CarPO po);
	public void saveSalary (StaffPO po);
	public void saveStaff(StaffPO po);
	public void saveInstitution (InstitutionPO po);
	public void saveDistance(String city1,String city2,double distance);
}
