package edu.nju.dataservice.financedataservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.tools.Time;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

public class FinanceDataService_stub implements FinanceDataService{

	@Override
	public ArrayList<AccountPO> getAccountPO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PayDocVO> getPayDoc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GatheringDocVO> getGatheringDoc() {
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
		//�õ��ڼ丶��б���PO��
		return PayDocPOList;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc(Time startTime,
			Time endTime) {
		//�õ��ڼ��տ�б���PO��
		return GatheringDocPOList;	}
*/
}