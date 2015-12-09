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
		if(driverDataService.isVaild(po.getDriverID(), po.getInstitution())){
			driverDataService.changeDriver(po);
		}else{
			driverDataService.addDriver(po);
		}
	}


	@Override
	public void deleteDriver(DriverPO po) throws RemoteException {
		// TODO Auto-generated method stub
		driverDataService.deleteDriver(po);

	}


	@Override
	public void saveDriverSalary(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DriverPO po=driverDataService.getDriver(id);
		po.setPaid(true);
		driverDataService.changeDriver(po);
		
	}


	@Override
	public double getDriverCommision(String driverID) throws RemoteException {
		// TODO Auto-generated method stub
		return driverDataService.getDriver(driverID).getMoney();
	}


	@Override
	public ArrayList<String> getDirverID(String institutionName)
			throws RemoteException {
		ArrayList<DriverPO> driverPOList=new ArrayList<DriverPO>();
		
		driverPOList=driverDataService.findDriver(institutionName);
ArrayList<String>idList=new ArrayList<String>();
	for(DriverPO po:driverPOList){
		idList.add(po.getDriverID());
		}	
	return idList;
	}

	


	@Override
	public String getDirverName(String driverID,String institutionName) throws RemoteException {

		ArrayList<DriverPO> driverPOList=new ArrayList<DriverPO>();
	
			driverPOList=driverDataService.findDriver(institutionName);
	String result=null;
		for(DriverPO po:driverPOList){
			if(po.getDriverID().equals(driverID)){
				result=po.getName();
			}
		}
		
		return result;
	}


	@Override
	public DriverPO getDriver(String driverID) throws RemoteException {
		return driverDataService.getDriver(driverID);
	}


	@Override
	public void saveMoney(Double money,String id) throws RemoteException {
		driverDataService.saveMoney(money, id);
		
	}



}
