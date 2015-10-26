package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.tools.*;
import java.util.ArrayList;
public interface FinanceDataService{
	//�õ�������Ա��д�������
	public int getRent();
	//���¸���ļ�
	public void updatePayDoc(PayDocPO PO);	
	//�޸��˻�����
	public void updateAccountInfo(String name,AccountPO account);
	//ɾ�����˻�
	public void deleteAccount(String name);
	//����һ���˻���������Ϊ0
	public void addAccount(String name);
	//�õ���˾�������˻��б�
	public ArrayList<AccountPO> getAccount();
	//�õ��ڼ丶��б�PO��
	public ArrayList<PayDocPO>getPayDOc(Time startTime,Time endTime);
	//�õ��ڼ��տ�б�PO��
	public ArrayList<GatheringDocPO>getGatheringDoc(Time startTime,Time endTime);
		
}
