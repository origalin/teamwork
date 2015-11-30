package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.DriverPO;

public interface DriverDataService extends Remote{
	public ArrayList<DriverPO> findDriver(String InstitutionName);
	public void addDriver(DriverPO po);
	public void changeDriver(DriverPO po);
	public void deleteDriver(DriverPO po);
}
