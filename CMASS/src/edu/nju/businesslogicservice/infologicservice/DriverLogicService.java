package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.po.DriverPO;
import edu.nju.vo.DriverVO;

public interface DriverLogicService {
	public void saveDriver(DriverPO po) throws RemoteException;//����˾��PO
	public ArrayList<DriverVO> getDriveVOList(String institutionName)throws RemoteException;
	public void deleteDriver(DriverPO po) throws RemoteException;
	public void saveDriverSalary(String id)throws RemoteException;//����˾��id ��Ϊ�Ѹ���
	double getDriverCommision(String driverID)throws RemoteException;//����ID�������˾��ÿ�ε�Ǯ��
	public ArrayList<String> getDirverID(String institutionName)throws RemoteException;//
	public String getDirverName(String driverID, String institutionName)throws RemoteException;

}
