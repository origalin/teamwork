package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;



import java.util.Date;
import java.util.ArrayList;
public interface FinanceDataService{
	//提供给审批单据的供接口
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void savePayDocPO(PayDocPO po);
	public void saveGatheringDocPO(GatheringDocPO po);
	
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountPO checkAccountPO(String accountName);
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate);
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate); 
	public double getTotalPayment();//生成总支出
	public double getTotalIncome();//无参的是为了生成总收入
	//生成付款单
	public void createPayDoc(String payDocID, double money,	String account, PayType type,String back);
	public PayDocPO getPayDocPO(String PayDocID);//支持预览
	//生成收款单
	public void createGatheringDoc(String GatheringDocID,Double money, String courier_name,ArrayList<String> itemIDs);
	public GatheringDocPO getGatheringDocPO(String GatheringDocID);//支持预览
}
