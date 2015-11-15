package edu.nju.dataservice.logisticsqueryDataService;

import edu.nju.po.PositionPO;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
public interface LogisticsDataService extends Remote{
	
	public void changePosition(String ItemID,String pos);
	public void createPosition(String Item,String pos);
	PositionPO positionQuery(String ItemID);

}
