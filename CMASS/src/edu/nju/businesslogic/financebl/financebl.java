package edu.nju.businesslogic.financebl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.financelogicservice.FinanceLogicService;
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

public class financebl implements FinanceLogicService{
	/*financedataService
	public ArrayList<AccountPO> getAccountPO()//�õ�PO��ԭ����Ϊ�˿��Զ��˻���ɾ�Ĳ�
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime)
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) 
	public ArrayList<PayDocVO> getPayDoc//�޲ε���Ϊ��������֧������Ҫ������ǰ�����и��������
	public ArrayList<GatheringDocVO> getGatheringDoc//�޲ε���Ϊ������������
	
	transformlogicservice
	public double getCourierBonus(int courierID)//���ڼ���ÿ�����Ա���ʵ����
	public int getDriverTime(int DriverID)//���ڼ���ÿ��˾���Ĵ���
	//�õ�ÿ����ת����װ�������б�����Ŀѡ���˷�ʱ������ʾ���ǣ����������ǵ��˷�������ʾ�˷ѣ�������ɸ��
	public ArrayList<TransferDoc_CarVO> getCarTransferList();
	public ArrayList<TransferDoc_TrainVO> getTrainTransferList();
	public ArrayList<TransferDoc_PlaneVO> getPlaneTransferList();
	public ArrayList<YLoadDocVO> getYLoadDocList();
	public ArrayList<ZLoadDocVO> getZLoadDocList();
	
	infologicservice
	public ArrayList<String> getInstitutionList();//�������л���������
	public ArrayList<StaffVO> getStaffList();//��������Ա�����������ڽ��й��ʵļ���
	
	
	*/
	
	//ע�⣬���ݲ�ÿ������GatheringDoc��ʱ��Ҫ�ǵ��޸Ŀ��Ա�Ĺ��ʣ����Ա�ǿ�����ɵ�
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

}
