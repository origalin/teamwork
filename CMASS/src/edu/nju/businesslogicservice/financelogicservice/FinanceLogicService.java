package edu.nju.businesslogicservice.financelogicservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.SalaryPO;
import edu.nju.po.SendDocPO;
import edu.nju.po.StaffPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.PayDocVO;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;
import edu.nju.vo.YLoadDocVO;
import edu.nju.vo.ZLoadDocVO;
import edu.nju.vo.showStaffSalaryVO;

public interface FinanceLogicService {
	//提供给审批单据的供接口
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public void savePayDocPO(PayDocPO po);
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void saveGatheringDocPO(GatheringDocPO po);
	//账户管理部分
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountVO checkAccountPO(String accountName);
	
	//查看成本收益表部分
	public double getTotalIncome();//得到总收入
	public double getTotalPayment();//得到总支出
	//查看经营情况表部分
	public ArrayList<PayDocVO> getPayDoc(String startTime,String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime);
	//成本管理部分
	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public void setInstitutionList(ArrayList<InstitutionPO> InstitutionList);
	//得到每个中转单与装车单的列表，在条目选择运费时依次显示它们，并根据它们的运费属性显示运费，最后生成付款单
	/*
	public ArrayList<TransferDoc_CarVO> getCarTransferList();
	public void deleteTransferDoc_CarVO(int TransferDoc_CarID);
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	public void deleteTransferDoc_TrainVO(int TransferDoc_TrainID);
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public void deleteTransferDoc_PlaneVO(int TransferDoc_PlaneID);
	*/
	public ArrayList<TransferDocPO> getUnpaidCarTransferList();
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList);
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList();
	public void setYLoadDocList(ArrayList<YLoadDocPO>YLoadDocList);
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList();
	public void setZLoadDocList(ArrayList<ZLoadDocPO>ZLoadDocList);
	//工资部分
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void setStaffList(ArrayList<StaffPO> staffList);//原理同deleteInstitution
	public String getStaffSalaryName(String staffID);////工资管理要显示人员的名字
	public double calculateSalary(String ID);
	public void createPayDoc(PayDocVO vo);
	public PayDocVO reviewPayDoc(double money,String payMen,String account, PayType type,String back);
	public PayDocVO getPayDocVO(String PayDocID);//支持预览收款单
	public void resetSalary();
	public void resetRent();
	public SalaryPO getSalaryPO(String staffID);
	public void saveSalaryPO(SalaryPO po);
	//生成收款单部分
		public void createGatheringDoc(GatheringDocVO vo);//实现的时候需要先得到SendDocPOList
		public GatheringDocVO reviewGatheringDoc(String courier_ID,String account);
		public GatheringDocVO getGatheringDocVO(String GatheringDocID);//支持预览收款单
		public void setSendDocList(String courier_ID);//将这部分寄件单设为已经生成收款单
	//生成付款单和生成收款单共有的部分,账户管理界面显示也会用到
		public ArrayList<AccountVO> getAccountList();
		//收款单
		public void addMoney(String accountName,double money);
		//付款单
		public void minusMoney(String accountName,double money);
	
}

