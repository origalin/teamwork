package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.tools.*;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

import java.util.ArrayList;
public interface FinanceDataService{
	//提供给审批单据的供接口
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void saveOverDocPO(PayDocPO po);
	public void saveGatheringDocPO(GatheringDocPO po);
	
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountPO checkAccountPO(String accountName);
	public ArrayList<AccountPO> getAccountPO();//得到PO的原因是为了可以对账户增删改查
	public ArrayList<PayDocPO> getPayDoc(String startTime, String endTime);
	public ArrayList<GatheringDocPO> getGatheringDoc(String startTime,String endTime); 
	public ArrayList<PayDocPO> getPayDoc();//无参的是为了生成总支出，需要截至当前的所有付款单来计算
	public ArrayList<GatheringDocPO> getGatheringDoc();//无参的是为了生成总收入
	
}
