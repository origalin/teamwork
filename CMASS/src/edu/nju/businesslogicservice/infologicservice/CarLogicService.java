package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.vo.CarVO;

public interface CarLogicService {
	public void saveCar(CarPO po) throws RemoteException ;//���泵��PO
	public ArrayList<CarVO> getCarList(String institutionName) throws RemoteException;//��ó�����Ϣ
	public void deleteCar(CarPO po) throws RemoteException;
	
}
