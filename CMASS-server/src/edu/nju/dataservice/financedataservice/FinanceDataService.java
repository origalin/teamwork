package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;



import java.util.ArrayList;
public interface FinanceDataService{
	//�ṩ���������ݵĹ��ӿ�
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void saveOverDocPO(PayDocPO po);
	public void saveGatheringDocPO(GatheringDocPO po);
	
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountPO checkAccountPO(String accountName);
	public ArrayList<AccountPO> getAccountPO();//�õ�PO��ԭ����Ϊ�˿��Զ��˻���ɾ�Ĳ�
	public ArrayList<PayDocPO> getPayDoc(String startTime, String endTime);
	public ArrayList<GatheringDocPO> getGatheringDoc(String startTime,String endTime); 
	public ArrayList<PayDocPO> getPayDoc();//�޲ε���Ϊ��������֧������Ҫ������ǰ�����и��������
	public ArrayList<GatheringDocPO> getGatheringDoc();//�޲ε���Ϊ������������
	//���ɸ��
	public void createPayDoc(String payDocID, double money,	String account, PayType type,String back);
	public PayDocPO getPayDocPO(String PayDocID);//֧��Ԥ��
	//�����տ
	public void createGatheringDoc(String GatheringDocID,Double money, String courier_name,ArrayList<String> itemIDs);
	public GatheringDocPO getGatheringDocPO(String GatheringDocID);//֧��Ԥ��
}
