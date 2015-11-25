package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;

public interface CarDataService {
	public ArrayList<CarPO> findCar(String institutionName);
	public void addCar(CarPO po);
	public void changeCar(CarPO po);
	public void deleteCar(CarPO po);
}
