package edu.nju.businesslogic.infobl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.CarLogicService;
import edu.nju.data.InfoDataServiceImpl.CarDataServiceImpl;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.po.CarPO;
import edu.nju.vo.CarVO;

public class Car implements CarLogicService{
	CarDataService carDataService=new CarDataServiceImpl();
	@Override
	public ArrayList<CarVO> getCarList(String institutionName) {
		ArrayList<CarVO> carVOList=new ArrayList<CarVO>();
		ArrayList<CarPO> carPOList=new ArrayList<CarPO>();
		carPOList=carDataService.findCar(institutionName);
		for(CarPO po:carPOList){
			carVOList.add(new CarVO(po.getCarID(),po.getEngineID(),po.getPlateID(),po.getUnderpanID(),po.getInstitutionName(),po.getBuyTime(),po.getYears()));
		}
		
		return carVOList;
		
	}
	@Override
	public void saveCar(CarPO po) {
		// TODO Auto-generated method stub
		if(carDataService.isVaild(po.getCarID(), po.getInstitutionName())){
			carDataService.changeCar(po);
		}else{
			carDataService.addCar(po);
		}
		
	}
	@Override
	public void deleteCar(CarPO po) {
		// TODO Auto-generated method stub
		carDataService.deleteCar(po);
	}


}
