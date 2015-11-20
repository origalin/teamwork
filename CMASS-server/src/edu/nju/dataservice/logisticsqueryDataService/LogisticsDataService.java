package edu.nju.dataservice.logisticsqueryDataService;

import edu.nju.po.PositionPO;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
public interface LogisticsDataService extends Remote{
	
	public void changePosition(String ItemID,String pos) throws RemoteException;
	public void createPosition(String Item,String pos) throws RemoteException;
	PositionPO positionQuery(String ItemID) throws RemoteException;

}
