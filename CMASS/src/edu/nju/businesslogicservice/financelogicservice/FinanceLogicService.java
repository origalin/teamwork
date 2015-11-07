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
	//�˻�������
	public ArrayList<AccountPO> getAccountPO();//����Ҫ�õ�accountPO���ݲ������
	//�鿴�ɱ��������
	public double getTotalIncome();//�õ�������
	public double getTotalPayment();//�õ���֧��
	//�鿴��Ӫ�������
	public ArrayList<PayDocVO> getPayDoc(String startTime,String endTime);
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,String endTime);
	//�ɱ�������
	public ArrayList<InstitutionVO> getInstitutionList();//�õ����л����б�������Ա�ֶ���д����������������ɸ��
	//�õ�ÿ����ת����װ�������б�����Ŀѡ���˷�ʱ������ʾ���ǣ����������ǵ��˷�������ʾ�˷ѣ�������ɸ��
	public ArrayList<TransferDoc_CarVO> getCarTransferList();
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<YLoadDocVO> getYLoadDocList();
	public ArrayList<ZLoadDocVO> getZLoadDocList();
	//���ʲ���
	public ArrayList<showStaffSalaryVO> getShowStaffSalaryList();
	public ArrayList<AccountVO> getAccount();
	
}
