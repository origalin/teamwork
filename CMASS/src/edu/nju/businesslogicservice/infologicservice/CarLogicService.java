package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.CarPO;
import edu.nju.vo.CarVO;

public interface CarLogicService {
	public void saveCar(CarPO po);//保存车辆PO
	public ArrayList<CarVO> getCarList();//获得车辆信息
}
