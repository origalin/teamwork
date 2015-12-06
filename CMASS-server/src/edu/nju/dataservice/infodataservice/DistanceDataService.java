package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import edu.nju.po.DistancePO;

public interface DistanceDataService extends Remote{
	public double  getDistance(String city1,String city2) throws RemoteException;
	
	
	public void changeDistance(DistancePO po)throws RemoteException;
	public void addDistance(DistancePO po)throws RemoteException;
	
}
