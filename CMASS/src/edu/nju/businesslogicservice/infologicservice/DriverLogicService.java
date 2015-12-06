package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.po.DriverPO;
import edu.nju.vo.DriverVO;

public interface DriverLogicService {
	public void saveDriver(DriverPO po) throws RemoteException;//±£´æË¾»úPO
	public ArrayList<DriverVO> getDriveVOList(String institutionName)throws RemoteException;
	public void deleteDriver(DriverPO po) throws RemoteException;

}
