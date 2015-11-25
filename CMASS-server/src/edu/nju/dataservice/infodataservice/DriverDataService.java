package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.DriverPO;

public interface DriverDataService {
	public ArrayList<DriverPO> findDriver(String InstitutionName);
	public void addDriver(DriverPO po);
	public void changeDriver(DriverPO po);
	public void deleteDriver(DriverPO po);
}
