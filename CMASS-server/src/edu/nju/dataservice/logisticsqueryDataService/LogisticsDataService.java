package edu.nju.dataservice.logisticsqueryDataService;

import edu.nju.po.PositionPO;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
public interface LogisticsDataService extends Remote {
	
	public abstract void changePosition(String ItemID,String pos) throws RemoteException;
	public abstract void createPosition(String Item,String pos,String destination) throws RemoteException;
	public abstract PositionPO positionQuery(String ItemID) throws RemoteException;

}
