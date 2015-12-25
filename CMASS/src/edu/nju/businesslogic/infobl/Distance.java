package edu.nju.businesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.DistanceLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.po.DistancePO;

public class Distance implements DistanceLogicService{
	DistanceDataService distanceDataService;
	public Distance(){
		super();
		this.distanceDataService=DataFactory.getDistanceDataService();
	}
	
	
	
	
	@Override
	public double getDistance(String city1, String city2) throws RemoteException {
		// TODO Auto-generated method stub
		double distance=distanceDataService.getDistance(city1, city2);
		return distance;
	}

	@Override
	public void changeDistance(DistancePO po) throws RemoteException {
		// TODO Auto-generated method stub
		distanceDataService.changeDistance(po);
	}

	@Override
	public void addDistance(DistancePO po) throws RemoteException {
		// TODO Auto-generated method stub
		distanceDataService.addDistance(po);
	}




	@Override
	public ArrayList<String> getCityList() throws RemoteException {
		return distanceDataService.getCityList();
	}

}
