package edu.nju.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogic.transferbl.ZLoadDoc;
import edu.nju.businesslogicservice.financelogicservice.FinanceLogicService;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.Post;
import edu.nju.po.SendDocPO;
import edu.nju.po.StaffPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.tools.Time;
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
	String staffID;
	Collectionbl collectionbl=new Collectionbl();
	Institution institution=new Institution();
	TransferDoc transfer=new TransferDoc();
	YLoadDoc YLoad=new YLoadDoc();
	ZLoadDoc ZLoad=new ZLoadDoc();
	FinanceDataService financeDataService;
	Driver driver=new Driver();
	public financebl(){
		try {
			this.financeDataService = financeDataService=(FinanceDataService)Naming.lookup("rmi://127.0.0.1:6600/FinanceDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		};
		
	}
	public financebl(String staffID) {
		this.staffID=staffID;
//		list= new ArrayList<PositionPO>();
		try {
			this.financeDataService = financeDataService=(FinanceDataService)Naming.lookup("rmi://127.0.0.1:6600/FinanceDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
	@Override
	public double getTotalIncome() {
		return financeDataService.getTotalIncome();
		
	}

	@Override
	public double getTotalPayment() {
		return financeDataService.getTotalPayment();
	}

	@Override
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime) {
		ArrayList<PayDocVO>answer=new ArrayList<PayDocVO>();
		Date startDate=Time.stringToDate(startTime);
		Date endDate=Time.stringToDate(endTime);
		ArrayList <PayDocPO> payDocList= financeDataService.getPayDoc(startDate, endDate);
		for(PayDocPO po:payDocList){
			answer.add(new PayDocVO(po.getID(),po.getDate(),po.getMoney(),po.getPayer(),po.getAccount(),po.getType(),po.getBack()));
		}
		return answer;
	}

	@Override
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) {
		ArrayList<GatheringDocVO>answer=new ArrayList<GatheringDocVO>();
		Date startDate=Time.stringToDate(startTime);
		Date endDate=Time.stringToDate(endTime);
		ArrayList <GatheringDocPO> GatheringDocList= financeDataService.getGatheringDoc(startDate, endDate);
		for(GatheringDocPO po:GatheringDocList){
			answer.add(new GatheringDocVO(po.getID(),po.getDate(),po.getMoney(),po.getCourier_name(),po.getItemIDs(), po.getAccount()));
		}
		return answer;
	}

//每次都是获取一系列的机构名称，填写完一部分的租金生成付款单后，在financebl的机构列表中删除这个已付款的机构
	//，只有当financebl中没有机构的时候才会去找别人要未付款的机构
	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList(){
		return institution.getUnpaidInstitutionList();
	}

	@Override
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList() {
		
		return YLoad.getUnPaidYLoadDocPOs();
	}

	@Override
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList() {
		
		return ZLoad.getUnPaidZLoadDocPOs();
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() {
		return institution.getUnpaidStaffList();
	}
	
//账户管理方法
	@Override
	public void addAccountPO(String accountName) {
		financeDataService.addAccountPO(accountName);
		
	}

	@Override
	public void deleteAccountPO(String accountName) {
		financeDataService.deleteAccountPO(accountName);
		
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName) {
		financeDataService.modifyAccountPO(oldAccountName, newAccountName);
	}

	@Override
	public AccountVO checkAccountPO(String accountName) {
		AccountPO accountPO=financeDataService.checkAccountPO(accountName);
		return new AccountVO(accountPO.getName(),accountPO.getBalance());
	}

	

	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		return financeDataService.getunchekedPayDocList();
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		return financeDataService.getunchekedGatheringDocList();
	}

	@Override
	public ArrayList<TransferDocPO> getUnpaidCarTransferList() {
		return transfer.getUnPaidTransferDocPOs();
	}

	

	@Override
	public void savePayDocPO(PayDocPO po) {
		financeDataService.savePayDocPO(po);
	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		financeDataService.saveGatheringDocPO(po);
	}

	@Override
	public void setInstitutionList(ArrayList<InstitutionPO> InstitutionList) {
		
		for(InstitutionPO po:InstitutionList){
			institution.saveInstitution(po);
		}
	}

	@Override
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) {
		for(TransferDocPO po:TransferDocList){
			transfer.saveTransferDocPO(po);
		}
	}

	@Override
	public void setYLoadDocList(ArrayList<YLoadDocPO> YLoadDocList) {
		for(YLoadDocPO po:YLoadDocList){
			YLoad.saveYloadDocPO(po);
		}
	}

	@Override
	public void setZLoadDocList(ArrayList<ZLoadDocPO> ZLoadDocList) {
		for(ZLoadDocPO po:ZLoadDocList){
			ZLoad.saveZloadDocPO(po);
		}
	}

	@Override
	public void setStaffList(ArrayList<StaffPO> staffList) {
		for(StaffPO po:staffList){
			institution.saveStaff(po);
		}
		
	}

	@Override
	public void createGatheringDoc(String GatheringDocID, String courier_ID,String account) {
		//系统只用知道快递员是谁就可以生成他的收款单，其他的信息需要从其他模块获取
		//GatheringDocID,Date date,Double money, String courier_name,ArrayList<String> itemIDs,String account)
		/*
		 public ArrayList<String> getSendDocsByID(String courier_ID);
public void savecSendDocCreateGatheringDoc(String SendDocID);
public double getCourierMoney(String courier_ID);
其中第二个方法需要根据ID把一个用来检查该寄件单是否生成收款单的bool变量置为true

		 */
		/*
		 public ArrayList<String> getSendDocsByID(String courier_ID);
public void savecSendDocCreateGatheringDoc(String SendDocID);
public double getCourierMoney(String courier_ID);
其中第二个方法需要根据ID把一个用来检查该寄件单是否生成收款单的bool变量置为true

		 */
		double money=collectionbl.getCourierMoney(courier_ID);
		ArrayList<String> SendDoclist=collectionbl.getSendDocsByID(courier_ID);
		 financeDataService.createGatheringDoc(GatheringDocID,new Date(), money, courier_ID,SendDoclist,account);
	}

	@Override
	public GatheringDocVO getGatheringDocVO(String GatheringDocID) {
		GatheringDocPO po= financeDataService.getGatheringDocPO(GatheringDocID);
		return new GatheringDocVO(po.getID(),po.getDate(),po.getMoney(),po.getCourier_name(),po.getItemIDs(),po.getAccount());
	}

	@Override
	public void setSendDocList(ArrayList<SendDocPO> SendDocPOList) {
		for(SendDocPO po:SendDocPOList){
		collectionbl.saveSendDocPO(po);
		}
	}

	@Override
	public void createPayDoc(String payDocID, double money,String payMen, String account,
			PayType type,String back) {
		Date date=new Date();
		financeDataService.createPayDoc(payDocID,date, money,payMen, account, type, back);
		
	}

	@Override
	public PayDocVO getPayDocVO(String PayDocID) {
		PayDocPO po= financeDataService.getPayDocPO(PayDocID);
		return new PayDocVO(po.getID(),po.getDate(),po.getMoney(),po.getPayer(),po.getAccount(),po.getType(),po.getBack());
	}

	@Override
	public String getStaffSalaryName(String staffID) {
		return institution.getStaffName(staffID);
	}
	@Override
	public double calculateSalary(String staffID) {
		
		// TODO Auto-generated method stub
		/*
		 第一步：获取这个员工的职位
		 第二步：获取这个员工的工资策略（普通人员获得基础工资和奖金，快递员在以上的基础上获得提成的比例，司机在以上 的基础上获得每一次多少钱）
		 第三步：计算这个员工的工资
		 */
		//StaffPO staff=institution.getStaff(staffID);
		//10位说明是司机
		if(staffID.length()==10){
			return calculateDriverSalary(staffID);
		}
		//11位说明是普通员工
		Post position=institution.getPosition(staffID);
		if(position==Post.COURIER){
			return calculateCourierSalary(staffID);
		}else{
			return calculateNormalSalary(staffID);
		}
	}
	
	public double calculateCourierSalary(String staffID){
		double base=institution.getBase(staffID);
		double bonus=institution.getBonus(staffID);
		double commision=institution.getPercentage(staffID);
		double totalMoney=collectionbl.getCourierMoney(staffID);
		return base+bonus+commision*totalMoney;
	}
	
	public double calculateDriverSalary(String DriverID){
		double oneTimeMoney=institution.getDriverCommision(DriverID);
		int time=YLoad.getDriverTime(DriverID)+ZLoad.getDriverTime(DriverID);
		return oneTimeMoney*time;
	}
	
	public double calculateNormalSalary(String staffID){
		double base=institution.getBase(staffID);
		double bonus=institution.getBonus(staffID);
		return base+bonus;
	}
	
	
	public String getStaffName(){
		return institution.getStaffName(staffID);
	}
	@Override
	public void resetSalary() {
		institution.resetSalary();
	}
	@Override
	public void resetRent() {
		institution.resetRent();
		
	}
	@Override
	public ArrayList<AccountVO> getAccountList() {
		ArrayList<AccountPO> POList= financeDataService.getAccountList();
		ArrayList<AccountVO> VOList=new ArrayList<AccountVO>();
		for(AccountPO po:POList){
			VOList.add(new AccountVO(po.getName(),po.getBalance()));
		}
		return VOList;	
	}
	@Override
	public void addMoney(String accountName, double money) {
		financeDataService.addMoney(accountName,money);
		
	}
	@Override
	public void minusMoney(String accountName, double money) {
		financeDataService.minusMoney(accountName,money);
		
	}

}
