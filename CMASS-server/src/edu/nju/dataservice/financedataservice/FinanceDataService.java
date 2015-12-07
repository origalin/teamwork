package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;
public interface FinanceDataService extends Remote{
	//提供给审批单据的供接口
	public ArrayList<PayDocPO> getunchekedPayDocList()throws RemoteException;
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList()throws RemoteException;
	public void savePayDocPO(PayDocPO po)throws RemoteException;
	public void saveGatheringDocPO(GatheringDocPO po)throws RemoteException;
	
	public void addAccountPO(String accountName)throws RemoteException;
	public void deleteAccountPO(String accountName)throws RemoteException;
	public void modifyAccountPO(String oldAccountName,String newAccountName)throws RemoteException;
	public AccountPO checkAccountPO(String accountName)throws RemoteException;
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate)throws RemoteException;
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate)throws RemoteException; 
	public double getTotalPayment()throws RemoteException;//生成总支出
	public double getTotalIncome()throws RemoteException;//无参的是为了生成总收入
	//生成付款单
	public void createPayDoc(String payDocID,Date date, double money,String payMen,	String account, PayType type,String back)throws RemoteException;
	public PayDocPO getPayDocPO(String PayDocID)throws RemoteException;//支持预览
	//生成收款单
	public void createGatheringDoc(String GatheringDocID,Date date,Double money, String courier_ID,ArrayList<String> itemIDs,String account)throws RemoteException;
	public GatheringDocPO getGatheringDocPO(String GatheringDocID)throws RemoteException;//支持预览
	//生成收款单与生成付款单都需要的操作
	public ArrayList<AccountPO> getAccountList()throws RemoteException;
	public void addMoney(String accountName, double money)throws RemoteException;
	public void minusMoney(String accountName, double money)throws RemoteException;
}
