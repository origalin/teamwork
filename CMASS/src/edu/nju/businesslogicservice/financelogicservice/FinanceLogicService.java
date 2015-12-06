package edu.nju.businesslogicservice.financelogicservice;

import java.util.ArrayList;

import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
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

public interface FinanceLogicService {
	//�ṩ���������ݵĹ��ӿ�
	public ArrayList<PayDocPO> getunchekedPayDocList();
	public void savePayDocPO(PayDocPO po);
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList();
	public void saveGatheringDocPO(GatheringDocPO po);
	//�˻�������
	public void addAccountPO(String accountName);
	public void deleteAccountPO(String accountName);
	public void modifyAccountPO(String oldAccountName,String newAccountName);
	public AccountVO checkAccountPO(String accountName);
	
	//�鿴�ɱ��������
	public double getTotalIncome();//�õ�������
	public double getTotalPayment();//�õ���֧��
	//�鿴��Ӫ�������
	public ArrayList<PayDocVO> getPayDoc(String startTime,String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime);
	//�ɱ�������
	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public void setInstitutionList(ArrayList<InstitutionPO> InstitutionList);
	//�õ�ÿ����ת����װ�������б�����Ŀѡ���˷�ʱ������ʾ���ǣ����������ǵ��˷�������ʾ�˷ѣ�������ɸ��
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
	//���ʲ���
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void setStaffList(ArrayList<StaffPO> staffList);//ԭ��ͬdeleteInstitution
	public String getStaffSalaryName(String staffID);////���ʹ���Ҫ��ʾ��Ա������
	public double calculateSalary(String ID);
	public void createPayDoc(PayDocVO vo);
	public PayDocVO reviewPayDoc(String payDocID, double money,String payMen,String account, PayType type,String back);
	public PayDocVO getPayDocVO(String PayDocID);//֧��Ԥ���տ
	public void resetSalary();
	public void resetRent();
	//�����տ����
		public void createGatheringDoc(GatheringDocVO vo);//ʵ�ֵ�ʱ����Ҫ�ȵõ�SendDocPOList
		public GatheringDocVO reviewGatheringDoc(String GatheringDocID,String courier_ID,String account);
		public GatheringDocVO getGatheringDocVO(String GatheringDocID);//֧��Ԥ���տ
		public void setSendDocList(String courier_ID);//���ⲿ�ּļ�����Ϊ�Ѿ������տ
	//���ɸ���������տ���еĲ���,�˻����������ʾҲ���õ�
		public ArrayList<AccountVO> getAccountList();
		//�տ
		public void addMoney(String accountName,double money);
		//���
		public void minusMoney(String accountName,double money);
	
}

