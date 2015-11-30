package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;

import edu.nju.po.DistancePO;

public interface DistanceDataService extends Remote{
	public double  getDistance(String city1,String city2);
	
	
	public void changeDistance(DistancePO po);
	public void addDistance(DistancePO po);
	
}
