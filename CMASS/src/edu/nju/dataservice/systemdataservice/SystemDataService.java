package edu.nju.dataservice.systemdataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;
import edu.nju.tools.Time;

public interface SystemDataService {
	public ArrayList<OperationPO>  findOperationLog();
	public ArrayList<AccountPO> findAccount(int number);
	public void saveOperationLog(OperationPO po);
	public void  saveAccount(AccountPO po);
}
