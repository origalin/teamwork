package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.DriverPO;

public interface DriverDataService {
	public ArrayList<DriverPO> findDriver();
	public void saveDriver(DriverPO po);
	
}
