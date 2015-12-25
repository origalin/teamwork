package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.DistancePO;

public interface DistanceLogicService {
	public double  getDistance(String city1,String city2) throws RemoteException;
	public void changeDistance(DistancePO po)throws RemoteException;
	public void addDistance(DistancePO po)throws RemoteException;
	public ArrayList<String> getCityList()throws RemoteException;
}
