package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.vo.CarVO;

public interface CarLogicService {
	public void saveCar(CarPO po) throws RemoteException ;//保存车辆PO
	public ArrayList<CarVO> getCarList(String institutionName) throws RemoteException;//获得车辆信息
	public void deleteCar(CarPO po) throws RemoteException;
	
}
