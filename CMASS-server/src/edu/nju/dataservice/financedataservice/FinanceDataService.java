package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;
public interface FinanceDataService extends Remote{
	//�ṩ���������ݵĹ��ӿ�
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
	public double getTotalPayment()throws RemoteException;//������֧��
	public double getTotalIncome()throws RemoteException;//�޲ε���Ϊ������������
	//���ɸ��
	public void createPayDoc(String payDocID,Date date, double money,String payMen,	String account, PayType type,String back)throws RemoteException;
	public PayDocPO getPayDocPO(String PayDocID)throws RemoteException;//֧��Ԥ��
	//�����տ
	public void createGatheringDoc(String GatheringDocID,Date date,Double money, String courier_ID,ArrayList<String> itemIDs,String account)throws RemoteException;
	public GatheringDocPO getGatheringDocPO(String GatheringDocID)throws RemoteException;//֧��Ԥ��
	//�����տ�����ɸ������Ҫ�Ĳ���
	public ArrayList<AccountPO> getAccountList()throws RemoteException;
	public void addMoney(String accountName, double money)throws RemoteException;
	public void minusMoney(String accountName, double money)throws RemoteException;
	public double getCourierMoney(String staffID, Date date)throws RemoteException;
}
