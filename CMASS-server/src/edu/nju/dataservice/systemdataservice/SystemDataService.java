package edu.nju.dataservice.systemdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;
import edu.nju.po.StaffPO;


public interface SystemDataService extends Remote{
	public ArrayList<OperationPO>  findOperationLog(Date beginTime,Date endTime)throws RemoteException;
	public void saveOperationLog(OperationPO po)throws RemoteException;
	
	
	
}
