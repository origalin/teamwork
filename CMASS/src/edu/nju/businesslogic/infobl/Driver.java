package edu.nju.businesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.vo.CarVO;
import edu.nju.vo.DriverVO;


public class Driver implements DriverLogicService{
	DriverDataService driverDataService;
	public Driver(){
		super();
		this.driverDataService=DataFactory.getDriverDataService();
	}
	
	
	@Override
	public ArrayList<DriverVO> getDriveVOList(String institutionName) throws RemoteException{
		// TODO Auto-generated method stub
		ArrayList<DriverVO> driverVOList=new ArrayList<DriverVO>();
		ArrayList<DriverPO> driverPOList=new ArrayList<DriverPO>();
	
			driverPOList=driverDataService.findDriver(institutionName);
	
		for(DriverPO po:driverPOList){
			driverVOList.add(new DriverVO(po.getDriverID(),po.getName(),po.getSex(),po.getBirthday(),po.getIdentity(),po.getTel(),po.getInstitution(),po.getBeginLimit(),po.getEndLimit()));
		}
		
		return driverVOList;
	}






	@Override
	public void saveDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(driverDataService.isVaild(po.getDriverID(), po.getInstitution())){
			driverDataService.changeDriver(po);
		}else{
			driverDataService.addDriver(po);
		}

	}



}
