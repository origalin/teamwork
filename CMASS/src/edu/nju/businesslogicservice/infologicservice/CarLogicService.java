package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.vo.CarVO;

public interface CarLogicService {
	public void saveCar(CarPO po);//���泵��PO
	public ArrayList<CarVO> getCarList(String institutionName);//��ó�����Ϣ
	public void deleteCar(CarPO po);
	
}
