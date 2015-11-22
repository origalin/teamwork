package edu.nju.businesslogic.financebl;

import java.sql.Date;
import java.util.ArrayList;

import edu.nju.businesslogicservice.financelogicservice.FinanceLogicService;
import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
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

public class financebl implements FinanceLogicService{
	/*financedataService
	
	public void saveOverDocPO(PayDocPO po);
	public void saveGatheringDocPO(GatheringDocPO po);
	public ArrayList<AccountPO> addAccountPO(String accountName)
	public ArrayList<AccountPO> deleteAccountPO(String accountName)
	public ArrayList<AccountPO> modifyAccountPO(String oldName,String newName)
	public ArrayList<AccountPO> checkAccountPO(String accountName)
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate);
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate);
	public double getTotalPayment();//生成总支出
	public double getTotalIncome();
	
	transformlogicservice
	public double getCourierBonus(int courierID)//用于计算每个快递员工资的提成
	public int getDriverTime(int DriverID)//用于计算每个司机的次数
	//得到每个中转单与装车单的列表，在条目选择运费时依次显示它们，并根据它们的运费属性显示运费，最后生成付款单
	//public ArrayList<TransferDoc_CarVO> getCarTransferList();
	//public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	//public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<TransferDocPO> getUnpaidCarTransferList();
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList();
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList();
	public void saveTransferDocPO(TransferDocPO po)
	public void saveYloadDocPO(YLoadDocPO po);
	public void saveZloadDocPO(ZLoadDocPO po);
	public ArrayList<SendDocPO> getSendDocPOsByID(String courier_ID);//生成付款单需要获得该快递员的寄件单列表，并且可以修改其状态
	infologicservice
	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public void saveInstitution(InstitutionPO po);
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void saveStaff(StaffPO po);
	
	*/
	
	//注意，数据层每次生成GatheringDoc的时候都要记得修改快递员的工资，快递员是可以提成的
	
	

	//账户管理使用的属性
	FinanceDataServiceImpl FinanceDataServiceImpl=new FinanceDataServiceImpl();
	ArrayList<AccountVO> companyAccountPOList;
	//审批单据需要用到的付款单和收款单的list
	ArrayList<PayDocPO> PayDocList;
	ArrayList<GatheringDocPO> GatheringDocList;
	
	@Override
	public double getTotalIncome() {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public double getTotalPayment() {
		// TODO Auto-generated method stub
		return 0;
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

//每次都是获取一系列的机构名称，填写完一部分的租金生成付款单后，在financebl的机构列表中删除这个已付款的机构
	//，只有当financebl中没有机构的时候才会去找别人要未付款的机构
	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList(){
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public ArrayList<TransferDoc_CarVO> getCarTransferList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	
//账户管理方法
	@Override
	public void addAccountPO(String accountName) {
		
		
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
	public AccountVO checkAccountPO(String accountName) {
		return null;
		// TODO Auto-generated method stub
		
	}

	
/*
	@Override
	public void deleteTransferDoc_CarVO(int TransferDoc_CarID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTransferDoc_TrainVO(int TransferDoc_TrainID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTransferDoc_PlaneVO(int TransferDoc_PlaneID) {
		// TODO Auto-generated method stub
		
	}
*/
	

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
	public ArrayList<TransferDocPO> getUnpaidCarTransferList() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void savePayDocPO(PayDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInstitutionList(ArrayList<InstitutionPO> InstitutionList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYLoadDocList(ArrayList<YLoadDocPO> YLoadDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setZLoadDocList(ArrayList<ZLoadDocPO> ZLoadDocList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStaffList(ArrayList<StaffPO> staffList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createGatheringDoc(String GatheringDocID, String courier_name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GatheringDocVO getGatheringDocVO(String GatheringDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSendDocList(ArrayList<SendDocPO> SendDocPOList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPayDoc(String payDocID, double money, String account,
			PayType type,String back) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PayDocVO getPayDocVO(String PayDocID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<PayDocPO> getPayDocList() {
		return PayDocList;
	}

	public void setPayDocList(ArrayList<PayDocPO> payDocList) {
		PayDocList = payDocList;
	}

	public ArrayList<GatheringDocPO> getGatheringDocList() {
		return GatheringDocList;
	}

	public void setGatheringDocList(ArrayList<GatheringDocPO> gatheringDocList) {
		GatheringDocList = gatheringDocList;
	}

}
