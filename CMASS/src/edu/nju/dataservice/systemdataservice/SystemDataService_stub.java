package edu.nju.dataservice.systemdataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.OperationPO;


public class SystemDataService_stub {
	public ArrayList<OperationPO>  findOperationLog(){
		ArrayList<OperationPO> t=new ArrayList<OperationPO>();
		t.add(new OperationPO());//这边可以提供一些参数用来构造PO
		t.add(new OperationPO());
		return t;
	}
	public ArrayList<AccountPO> findAccount(){
		ArrayList<AccountPO> t=new ArrayList<AccountPO>();
		String name1 = "",name2="";
		t.add(new AccountPO(name1));//这边可以提供一些参数用来构造PO
		t.add(new AccountPO(name2));
		return t;
	}
	public void saveOperationLog(OperationPO po){
		System.out.println("saveOperation  success!");
	}
	public void  saveAccount(AccountPO po){
		System.out.println("saveAccount  success!");
	}
}
