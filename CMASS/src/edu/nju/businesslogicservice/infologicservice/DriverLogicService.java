package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.DriverPO;
import edu.nju.vo.DriverVO;

public interface DriverLogicService {
	public void saveDriver(DriverPO po) throws RemoteException;//保存司机PO
	public ArrayList<DriverVO> getDriveVOList(String institutionName)throws RemoteException;
	public void deleteDriver(DriverPO po) throws RemoteException;
	public void saveDriverSalary(String id)throws RemoteException, DatabaseNULLException;//根据司机id 设为已付款
	double getDriverCommision(String driverID)throws RemoteException, DatabaseNULLException;//根据ID查找这个司机每次的钱数
	public ArrayList<String> getDirverID(String institutionName)throws RemoteException;//
	public String getDirverName(String driverID, String institutionName)throws RemoteException;
	public DriverPO getDriver(String driverID)throws RemoteException, DatabaseNULLException;
	
	public void saveMoney(Double money,String id)throws RemoteException;

}
