package edu.nju.dataservice.financedataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.tools.Time;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

public class FinanceDataService_stub implements FinanceDataService{

	@Override
	public ArrayList<AccountPO> getAccountPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayDocPO> getPayDoc(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc(String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayDocPO> getPayDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAccountPO(String accountName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountPO(String accountName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountPO checkAccountPO(String accountName) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOverDocPO(PayDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGatheringDoc(String GatheringDocID, Double money,
			String courier_name, ArrayList<String> itemIDs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPayDoc(String payDocID, double money, String account,
			PayType type,String back) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*
	public FinanceDataService_stub(int rent,
			ArrayList<AccountPO> accountPOList,
			ArrayList<PayDocPO> payDocPOList,
			ArrayList<GatheringDocPO> gatheringDocPOList) {
		super();
		this.rent = rent;
		AccountPOList = accountPOList;
		PayDocPOList = payDocPOList;
		GatheringDocPOList = gatheringDocPOList;
	}

	int rent;
	ArrayList<AccountPO> AccountPOList;
	ArrayList<PayDocPO> PayDocPOList;
	ArrayList<GatheringDocPO> GatheringDocPOList;
	@Override
	public int getRent() {
		//�õ�������Ա��д�������
		return rent;
	}

	@Override
	public void updatePayDoc(PayDocPO PO) {
		//���¸���ļ�
		
	}

	@Override
	public void updateAccountInfo(String name, AccountPO account) {
		//�޸��˻�����
		
	}

	@Override
	public void deleteAccount(String name) {
		//ɾ�����˻�
	}

	@Override
	public void addAccount(String name) {
		//����һ���˻���������Ϊ0
		
	}

	@Override
	public ArrayList<AccountPO> getAccount() {
		//�õ���˾�������˻��б�
		return AccountPOList;
	}

	@Override
	public ArrayList<PayDocPO> getPayDOc(Time startTime, Time endTime) {
		//�õ��ڼ丶��б�PO��
		return PayDocPOList;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc(Time startTime,
			Time endTime) {
		//�õ��ڼ��տ�б�PO��
		return GatheringDocPOList;	}
*/
}

