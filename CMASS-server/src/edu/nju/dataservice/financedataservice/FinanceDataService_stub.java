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
		//得到财务人员填写的总租金
		return rent;
	}

	@Override
	public void updatePayDoc(PayDocPO PO) {
		//更新付款单文件
		
	}

	@Override
	public void updateAccountInfo(String name, AccountPO account) {
		//修改账户名称
		
	}

	@Override
	public void deleteAccount(String name) {
		//删除该账户
	}

	@Override
	public void addAccount(String name) {
		//增加一个账户，其金额设为0
		
	}

	@Override
	public ArrayList<AccountPO> getAccount() {
		//得到公司的银行账户列表
		return AccountPOList;
	}

	@Override
	public ArrayList<PayDocPO> getPayDOc(Time startTime, Time endTime) {
		//得到期间付款单列表（PO）
		return PayDocPOList;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc(Time startTime,
			Time endTime) {
		//得到期间收款单列表（PO）
		return GatheringDocPOList;	}
*/
}
