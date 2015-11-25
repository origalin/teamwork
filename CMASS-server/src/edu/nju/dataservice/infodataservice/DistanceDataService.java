package edu.nju.dataservice.infodataservice;

import edu.nju.po.DistancePO;

public interface DistanceDataService {
	public double  getDistance(String city1,String city2);
	
	
	public void changeDistance(DistancePO po);
	public void addDistance(DistancePO po);
	
}
