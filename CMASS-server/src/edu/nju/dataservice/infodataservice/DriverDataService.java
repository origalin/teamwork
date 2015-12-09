package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.DriverPO;

public interface DriverDataService extends Remote{
	public ArrayList<DriverPO> findDriver(String InstitutionName)throws RemoteException;
	public void addDriver(DriverPO po)throws RemoteException;
	public void changeDriver(DriverPO po)throws RemoteException;
	public void deleteDriver(DriverPO po)throws RemoteException;
	public boolean isVaild(String id,String institutionName) throws RemoteException;
	public DriverPO getDriver(String id)throws RemoteException;
	
	public void saveMoney(Double money,String id)throws RemoteException;
}
