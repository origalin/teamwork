package edu.nju.businesslogic.financebl;

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
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime)
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) 
	public ArrayList<PayDocVO> getPayDoc//�޲ε���Ϊ��������֧������Ҫ������ǰ�����и��������
	public ArrayList<GatheringDocVO> getGatheringDoc//�޲ε���Ϊ������������
	
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
	ArrayList<AccountVO> companyAccountPOList;
	//����������Ҫ�õ��ĸ�����տ��list
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

//ÿ�ζ��ǻ�ȡһϵ�еĻ������ƣ���д��һ���ֵ�������ɸ������financebl�Ļ����б���ɾ������Ѹ���Ļ���
	//��ֻ�е�financebl��û�л�����ʱ��Ż�ȥ�ұ���Ҫδ����Ļ���
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

	
//�˻�������
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
	public void saveOverDocPO(PayDocPO po) {
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
