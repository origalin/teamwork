package edu.nju.businesslogicservice.infologicservice;

import edu.nju.po.DistancePO;

public interface DistanceLogicService {
	public double  getDistance(String city1,String city2);
	public void changeDistance(DistancePO po);
	public void addDistance(DistancePO po);
}
