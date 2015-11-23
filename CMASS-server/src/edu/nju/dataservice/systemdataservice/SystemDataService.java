package edu.nju.dataservice.systemdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;


public interface SystemDataService extends Remote{
	public ArrayList<OperationPO>  findOperationLog(long beginTime,long endTime);
	public ArrayList<AccountPO> findAccount(int number);
	public void saveOperationLog(OperationPO po);
	public void  saveAccount(AccountPO po);
}
