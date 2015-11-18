package edu.nju.data.FinanceDataServiceImpl;

import java.util.ArrayList;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;

public class FinanceDataServiceImpl implements FinanceDataService{
	ArrayList<PayDocPO> uncheckedPayDocList;
	ArrayList<GatheringDocPO> uncheckedGatheringDocList;
	public static void main(String args){
		FinanceDataServiceImpl temp=new FinanceDataServiceImpl();
	}
	//提供给审批单据的供接口
	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		return uncheckedPayDocList;
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		return uncheckedGatheringDocList;
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
		// TODO Auto-generated method stub
		return null;
	}

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
	
	
	//生成付款单
	@Override
	public void createPayDoc(String payDocID, double money, String account,
			PayType type, String back) {
		
		
	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) {
		
		return null;
	}
	
	//生成收款单
	@Override
	public void createGatheringDoc(String GatheringDocID, Double money,
			String courier_name, ArrayList<String> itemIDs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID) {
		// TODO Auto-generated method stub
		return null;
	}

}
