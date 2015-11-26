package edu.nju.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogic.transformbl.YLoadDoc;
import edu.nju.businesslogic.transformbl.ZLoadDoc;
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
	public double getTotalPayment();//������֧��
	public double getTotalIncome();
	
	transformlogicservice
	public double getCourierBonus(int courierID)//���ڼ���ÿ�����Ա���ʵ����
	public int getDriverTime(int DriverID)//���ڼ���ÿ��˾���Ĵ���
	//�õ�ÿ����ת����װ�������б�����Ŀѡ���˷�ʱ������ʾ���ǣ����������ǵ��˷�������ʾ�˷ѣ�������ɸ��
	//public ArrayList<TransferDoc_CarVO> getCarTransferList();
	//public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	//public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<TransferDocPO> getUnpaidCarTransferList();
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList();
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList();
	public void saveTransferDocPO(TransferDocPO po)
	public void saveYloadDocPO(YLoadDocPO po);
	public void saveZloadDocPO(ZLoadDocPO po);
	public ArrayList<SendDocPO> getSendDocPOsByID(String courier_ID);//���ɸ����Ҫ��øÿ��Ա�ļļ����б����ҿ����޸���״̬
	infologicservice
	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public void saveInstitution(InstitutionPO po);
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void saveStaff(StaffPO po);
	
	*/
	
	//ע�⣬���ݲ�ÿ������GatheringDoc��ʱ��Ҫ�ǵ��޸Ŀ��Ա�Ĺ��ʣ����Ա�ǿ�����ɵ�
	
	

	//�˻�����ʹ�õ�����
	String staffID;
	Collectionbl collectionbl=new Collectionbl();
	Institution institution=new Institution();
	TransferDoc transfer=new TransferDoc();
	YLoadDoc YLoad=new YLoadDoc();
	ZLoadDoc ZLoad=new ZLoadDoc();
	FinanceDataService financeDataService;
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
			answer.add(new GatheringDocVO(po.getID(),po.getDate(),po.getMoney(),po.getCourier_name(),po.getItemIDs()));
		}
		return answer;
	}

//ÿ�ζ��ǻ�ȡһϵ�еĻ������ƣ���д��һ���ֵ�������ɸ������financebl�Ļ����б���ɾ������Ѹ���Ļ���
	//��ֻ�е�financebl��û�л�����ʱ��Ż�ȥ�ұ���Ҫδ����Ļ���
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

	@Override
	public ArrayList<AccountVO> getAccount() {
		ArrayList<AccountVO> accountListVO=new ArrayList<AccountVO>();
		ArrayList<AccountPO> accountListPO=financeDataService.getAccount();
		for(AccountPO po:accountListPO){
			accountListVO.add(new AccountVO(po.getName(),po.getBalance()));
		}
		return accountListVO;
	}

	
//�˻�������
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
	public void createGatheringDoc(String GatheringDocID, String courier_name) {
		// TODO Auto-generated method stub
		//ϵͳֻ��֪�����Ա��˭�Ϳ������������տ����������Ϣ��Ҫ������ģ���ȡ
		//GatheringDocID,Date date,Double money, String courier_name,ArrayList<String> itemIDs)
		/*
		 public ArrayList<String> getSendDocsByID(String courier_ID);
public void savecSendDocCreateGatheringDoc(String SendDocID);
public double getCourierMoney(String courier_ID);
���еڶ���������Ҫ����ID��һ���������üļ����Ƿ������տ��bool������Ϊtrue

		 */
		/*
		 public ArrayList<String> getSendDocsByID(String courier_ID);
public void savecSendDocCreateGatheringDoc(String SendDocID);
public double getCourierMoney(String courier_ID);
���еڶ���������Ҫ����ID��һ���������üļ����Ƿ������տ��bool������Ϊtrue

		 */
		Date date=new Date();
		ArrayList
		 financeDataService.createGatheringDoc(GatheringDocID,date, money, courier_name, itemIDs);
	}

	@Override
	public GatheringDocVO getGatheringDocVO(String GatheringDocID) {
		GatheringDocPO po= financeDataService.getGatheringDocPO(GatheringDocID);
		return new GatheringDocVO(po.getID(),po.getDate(),po.getMoney(),po.getCourier_name(),po.getItemIDs());
	}

	@Override
	public void setSendDocList(ArrayList<SendDocPO> SendDocPOList) {
		for(SendDocPO po:SendDocPOList){
		collectionbl.saveSendDocPO(po);
		}
	}

	@Override
	public void createPayDoc(String payDocID, double money, String account,
			PayType type,String back) {
		Date date=new Date();
		financeDataService.createPayDoc(payDocID,date, money, account, type, back);
		
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
		 ��һ������ȡ���Ա����ְλ
		 �ڶ�������ȡ���Ա���Ĺ��ʲ��ԣ���ͨ��Ա��û������ʺͽ��𣬿��Ա�����ϵĻ����ϻ����ɵı�����˾�������� �Ļ����ϻ��ÿһ�ζ���Ǯ��
		 ���������������Ա���Ĺ���
		 */
		//StaffPO staff=institution.getStaff(staffID);
		Post position=institution.getPosition(staffID);
		if(position==Post.COURIER){
			return calculateCourierSalary(staffID);
		}else if(position==Post.Driver){
			return calculateDriverSalary(staffID);
		}else{
			return calculateNormalSalary(staffID);
		}
		return 0;
	}
	
	public double calculateCourierSalary(String staffID){
		double base=institution.getBase(staffID);
		double bonus=institution.getBonus(staffID);
		double commision=institution.getPercentage()*;
		return base+bonus+commision;
	}
	
	public double calculateDriverSalary(String staffID){
		double base=institution.getBase(staffID);
		double bonus=institution.getBonus(staffID);
		return base+bonus+institution.getDriverCommision()*;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resetRent() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<String> getAccountList() {
		return financeDataService.getAccountList();
	}
	@Override
	public void addMoney(String accountName, double money) {
		financeDataService.addMoney(accountName,money);
		
	}
	@Override
	public void minusMoney(String accountName, String money) {
		financeDataService.minusMoney(accountName,money);
		
	}

}
