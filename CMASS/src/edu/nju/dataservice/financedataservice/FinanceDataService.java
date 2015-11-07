package edu.nju.dataservice.financedataservice;
import edu.nju.po.*;
import edu.nju.tools.*;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

import java.util.ArrayList;
public interface FinanceDataService{
	public ArrayList<AccountPO> getAccountPO();//得到PO的原因是为了可以对账户增删改查
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime); 
	public ArrayList<PayDocVO> getPayDoc();//无参的是为了生成总支出，需要截至当前的所有付款单来计算
	public ArrayList<GatheringDocVO> getGatheringDoc();//无参的是为了生成总收入
}
