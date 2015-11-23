package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.vo.AccountVO;

import java.util.Date;
import java.util.ArrayList;
public interface FinanceDataService{
	//�ṩ���������ݵĹ��ӿ�
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void savePayDocPO(PayDocPO po);
	public void saveGatheringDocPO(GatheringDocPO po);
	public ArrayList<AccountPO> getAccount();//���ڽ���ѡ�����п��Ը�����˻�
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountPO checkAccountPO(String accountName);
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate);
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate); 
	public double getTotalPayment();//������֧��
	public double getTotalIncome();//�޲ε���Ϊ������������
	//���ɸ��
	public void createPayDoc(String payDocID, double money,	String account, PayType type,String back);
	public PayDocPO getPayDocPO(String PayDocID);//֧��Ԥ��
	//�����տ
	public void createGatheringDoc(String GatheringDocID,Double money, String courier_name,ArrayList<String> itemIDs);
	public GatheringDocPO getGatheringDocPO(String GatheringDocID);//֧��Ԥ��
}
