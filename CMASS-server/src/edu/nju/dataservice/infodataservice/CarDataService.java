package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.CarPO;

public interface CarDataService extends Remote{
	public ArrayList<CarPO> findCar(String institutionName);
	public void addCar(CarPO po);
	public void changeCar(CarPO po);
	public void deleteCar(CarPO po);
}
