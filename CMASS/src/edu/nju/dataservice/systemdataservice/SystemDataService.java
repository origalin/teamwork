package edu.nju.dataservice.systemdataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;

public interface SystemDataService {
	public ArrayList<OperationPO>  findOperationLog();
	public ArrayList<AccountPO> findAccount();
	public void saveOperationLog(OperationPO po);
	public void  saveAccount(AccountPO po);
}
