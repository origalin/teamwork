package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;

public interface CarDataService {
	public ArrayList<CarPO> findCar();
	public void saveCar(CarPO po);
}
