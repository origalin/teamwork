package edu.nju.businesslogicservice.financelogicservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.PayDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;
import edu.nju.vo.YLoadDocVO;
import edu.nju.vo.ZLoadDocVO;
import edu.nju.vo.showStaffSalaryVO;

public interface FinanceLogicService {
	//账户管理部分
	public ArrayList<AccountPO> getAccountPO();//就是要得到accountPO数据层的引用
	//查看成本收益表部分
	public double getTotalIncome();//得到总收入
	public double getTotalPayment();//得到总支出
	//查看经营情况表部分
	public ArrayList<PayDocVO> getPayDoc(String startTime,String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime);
	//成本管理部分
	public ArrayList<InstitutionVO> getInstitutionList();//得到所有机构列表，财务人员手动填写各个机构的租金并生成付款单
	//得到每个中转单与装车单的列表，在条目选择运费时依次显示它们，并根据它们的运费属性显示运费，最后生成付款单
	public ArrayList<TransferDoc_CarVO> getCarTransferList();
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<YLoadDocVO> getYLoadDocList();
	public ArrayList<ZLoadDocVO> getZLoadDocList();
	//工资部分
	public ArrayList<showStaffSalaryVO> getShowStaffSalaryList();
	public ArrayList<AccountVO> getAccount();
	
}
