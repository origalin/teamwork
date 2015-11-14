package edu.nju.businesslogic.financebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.financelogicservice.FinanceLogicService;
import edu.nju.po.AccountPO;
import edu.nju.po.PayType;
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

public class financebl implements FinanceLogicService{
	/*financedataService
	public ArrayList<AccountPO> getAccountPO()//得到PO的原因是为了可以对账户增删改查
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime)
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) 
	public ArrayList<PayDocVO> getPayDoc//无参的是为了生成总支出，需要截至当前的所有付款单来计算
	public ArrayList<GatheringDocVO> getGatheringDoc//无参的是为了生成总收入
	
	transformlogicservice
	public double getCourierBonus(int courierID)//用于计算每个快递员工资的提成
	public int getDriverTime(int DriverID)//用于计算每个司机的次数
	//得到每个中转单与装车单的列表，在条目选择运费时依次显示它们，并根据它们的运费属性显示运费，最后生成付款单
	public ArrayList<TransferDoc_CarVO> getCarTransferList();
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<YLoadDocVO> getYLoadDocList();
	public ArrayList<ZLoadDocVO> getZLoadDocList();
	
	infologicservice
	public ArrayList<String> getInstitutionList();//返回所有机构的名称
	public ArrayList<StaffVO> getStaffList();//返回所有员工的链表，用于进行工资的计算
	
	
	*/
	
	//注意，数据层每次生成GatheringDoc的时候都要记得修改快递员的工资，快递员是可以提成的
	@Override
	public ArrayList<AccountPO> getAccountPO() {
		// TODO Auto-generated method stub
		return null;
	}

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


	@Override
	public ArrayList<InstitutionVO> getInstitutionList() {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public ArrayList<YLoadDocVO> getYLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ZLoadDocVO> getZLoadDocList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<showStaffSalaryVO> getShowStaffSalaryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountVO> getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPayDoc(int payDocID, long date, double money, String payer,
			int account, PayType type, String back) {
		// TODO Auto-generated method stub
		
	}

}
