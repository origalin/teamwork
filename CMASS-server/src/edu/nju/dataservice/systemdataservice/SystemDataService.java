package edu.nju.dataservice.systemdataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;


public interface SystemDataService {
	public ArrayList<OperationPO>  findOperationLog(long beginTime,long endTime);
	public ArrayList<AccountPO> findAccount(int number);
	public void saveOperationLog(OperationPO po);
	public void  saveAccount(AccountPO po);
}
