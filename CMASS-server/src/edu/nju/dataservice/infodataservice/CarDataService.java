package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.CarPO;

public interface CarDataService extends Remote {
	public ArrayList<CarPO> findCar(String institutionName) throws RemoteException;
	public void addCar(CarPO po) throws RemoteException;
	public void changeCar(CarPO po) throws RemoteException;
	public void deleteCar(CarPO po) throws RemoteException;
	public boolean isVaild(String id,String institutionName) throws RemoteException;
}
