package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.tools.*;
import java.util.ArrayList;
public interface FinanceDataService{
	//得到财务人员填写的总租金
	public int getRent();
	//更新付款单文件
	public void updatePayDoc(PayDocPO PO);	
	//修改账户名称
	public void updateAccountInfo(String name,AccountPO account);
	//删除该账户
	public void deleteAccount(String name);
	//增加一个账户，其金额设为0
	public void addAccount(String name);
	//得到公司的银行账户列表
	public ArrayList<AccountPO> getAccount();
	//得到期间付款单列表（PO）
	public ArrayList<PayDocPO>getPayDOc(Time startTime,Time endTime);
	//得到期间收款单列表（PO）
	public ArrayList<GatheringDocPO>getGatheringDoc(Time startTime,Time endTime);
		
}
