package edu.nju.businesslogic.financebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogic.transferbl.ZLoadDoc;
import edu.nju.businesslogicservice.financelogicservice.FinanceLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.Post;
import edu.nju.po.SalaryPO;
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

public class financebl implements FinanceLogicService {
	/*
	 * financedataService
	 * 
	 * public void saveOverDocPO(PayDocPO po); public void
	 * saveGatheringDocPO(GatheringDocPO po); public ArrayList<AccountPO>
	 * addAccountPO(String accountName) public ArrayList<AccountPO>
	 * deleteAccountPO(String accountName) public ArrayList<AccountPO>
	 * modifyAccountPO(String oldName,String newName) public
	 * ArrayList<AccountPO> checkAccountPO(String accountName) public
	 * ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate); public
	 * ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate);
	 * public double getTotalPayment();//������֧�� public double getTotalIncome();
	 * 
	 * transformlogicservice public double getCourierBonus(int
	 * courierID)//���ڼ���ÿ�����Ա���ʵ���� public int getDriverTime(int
	 * DriverID)//���ڼ���ÿ��˾���Ĵ���
	 * //�õ�ÿ����ת����װ�������б�����Ŀѡ���˷�ʱ������ʾ���ǣ����������ǵ��˷�������ʾ�˷ѣ�������ɸ�� //public
	 * ArrayList<TransferDoc_CarVO> getCarTransferList(); //public
	 * ArrayList<TransferDoc_TrainVO> getTrainTransferList(); //public
	 * ArrayList<TransferDoc_PlaneVO> getPlaneTransferList(); public
	 * ArrayList<TransferDocPO> getUnpaidCarTransferList(); public
	 * ArrayList<YLoadDocPO> getUnpaidYLoadDocList(); public
	 * ArrayList<ZLoadDocPO> getUnpaidZLoadDocList(); public void
	 * saveTransferDocPO(TransferDocPO po) public void saveYloadDocPO(YLoadDocPO
	 * po); public void saveZloadDocPO(ZLoadDocPO po); public
	 * ArrayList<SendDocPO> getSendDocPOsByID(String
	 * courier_ID);//���ɸ����Ҫ��øÿ��Ա�ļļ����б����ҿ����޸���״̬ infologicservice public
	 * ArrayList<InstitutionPO> getUnpaidInstitutionList(); public void
	 * saveInstitution(InstitutionPO po); public ArrayList<StaffPO>
	 * getUnpaidStaffList(); public void saveStaff(StaffPO po);
	 */

	// ע�⣬���ݲ�ÿ������GatheringDoc��ʱ��Ҫ�ǵ��޸Ŀ��Ա�Ĺ��ʣ����Ա�ǿ�����ɵ�

	// �˻�����ʹ�õ�����
	financebl bl;
	String staffID;
	Collectionbl collectionbl;
	Institution institution = new Institution();

	TransferDoc transfer;// new TransferDoc();

	YLoadDoc YLoad = new YLoadDoc();
	ZLoadDoc ZLoad = new ZLoadDoc();
	FinanceDataService financeDataService;
	Driver driver = new Driver();
/*
	public static void main(String[] args) {
		financebl bl;
		try {
			bl = new financebl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			bl = null;
			e1.printStackTrace();
		}
		try {

			System.out.println(bl.financeDataService.getTotalIncome());
		} catch (RemoteException e) {
			System.out.println("���Ӵ���");
			e.printStackTrace();
		}
	}
*/
	public financebl() throws RemoteException {
		collectionbl = new Collectionbl();
		this.transfer=new TransferDoc();
		this.financeDataService = DataFactory.getFinanceDataService();

	}

	public financebl(String staffID) throws RemoteException {
		collectionbl = new Collectionbl();
		this.transfer=new TransferDoc();
		this.financeDataService = DataFactory.getFinanceDataService();
		this.staffID = staffID;

	}

	@Override
	public double getTotalIncome() {
		try {
			return financeDataService.getTotalIncome();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return 0;
		}

	}

	@Override
	public double getTotalPayment() {
		try {
			return financeDataService.getTotalPayment();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public ArrayList<PayDocVO> getPayDoc(String startTime, String endTime) {
		try {
			ArrayList<PayDocVO> answer = new ArrayList<PayDocVO>();
			Date startDate = Time.stringToDate(startTime);
			Date endDate = Time.stringToDate(endTime);
			ArrayList<PayDocPO> payDocList = financeDataService.getPayDoc(
					startDate, endDate);
			for (PayDocPO po : payDocList) {
				answer.add(new PayDocVO(po.getID(), po.getDate(),
						po.getMoney(), po.getPayer(), po.getAccount(), po
								.getType(), po.getBack()));
			}
			return answer;
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<GatheringDocVO> getGatheringDoc(String startTime,
			String endTime) {
		try {
			ArrayList<GatheringDocVO> answer = new ArrayList<GatheringDocVO>();
			Date startDate = Time.stringToDate(startTime);
			Date endDate = Time.stringToDate(endTime);
			ArrayList<GatheringDocPO> GatheringDocList = financeDataService
					.getGatheringDoc(startDate, endDate);
			for (GatheringDocPO po : GatheringDocList) {
				answer.add(new GatheringDocVO(po.getID(), po.getDate(), po
						.getMoney(), po.getCourier_ID(), po.getItemIDs(), po
						.getAccount()));
			}
			return answer;
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	// ÿ�ζ��ǻ�ȡһϵ�еĻ������ƣ���д��һ���ֵ�������ɸ������financebl�Ļ����б���ɾ������Ѹ���Ļ���
	// ��ֻ�е�financebl��û�л�����ʱ��Ż�ȥ�ұ���Ҫδ����Ļ���
	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList() {

		try {
			return institution.getUnpaidInstitutionList();
		} catch (RemoteException e) {
			System.out.println("������ȡʧ��");
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ArrayList<YLoadDocPO> getUnpaidYLoadDocList() {

		try {
			return YLoad.getUnPaidYLoadDocPOs();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<ZLoadDocPO> getUnpaidZLoadDocList() {

		try {
			return ZLoad.getUnPaidZLoadDocPOs();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() {
		try {
			return institution.getUnpaidStaffList();
		} catch (RemoteException e) {
			System.out.println("��Ա��ȡʧ��");
			e.printStackTrace();
			return null;
		}
	}

	// �˻�������
	@Override
	public void addAccountPO(String accountName) {
		try {
			financeDataService.addAccountPO(accountName);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAccountPO(String accountName) {
		try {
			financeDataService.deleteAccountPO(accountName);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}

	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName) {
		try {
			financeDataService.modifyAccountPO(oldAccountName, newAccountName);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}
	}

	@Override
	public AccountVO checkAccountPO(String accountName) {
		try {
			AccountPO accountPO = financeDataService
					.checkAccountPO(accountName);
			return new AccountVO(accountPO.getName(), accountPO.getBalance());
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		try {
			return financeDataService.getunchekedPayDocList();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		try {
			return financeDataService.getunchekedGatheringDocList();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<TransferDocPO> getUnpaidCarTransferList() {
		try {
			if(transfer==null){
				System.out.println("����������");
			}
			return transfer.getUnPaidTransferDocPOs();
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void savePayDocPO(PayDocPO po) {
		try {
			financeDataService.savePayDocPO(po);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}
	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		try {
			financeDataService.saveGatheringDocPO(po);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}
	}

	@Override
	public void setInstitutionList(ArrayList<InstitutionPO> InstitutionList)  {

		for (InstitutionPO po : InstitutionList) {
			try {
				institution.saveRent(po.getId());
			} catch (RemoteException e) {
				System.out.println("�����Э������");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setTransferDocList(ArrayList<TransferDocPO> TransferDocList) {
		for (TransferDocPO po : TransferDocList) {
			try {
				transfer.saveTransferDocPO(po);
			} catch (RemoteException e) {
				System.out.println("�������ݲ��ѯʧ��");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setYLoadDocList(ArrayList<YLoadDocPO> YLoadDocList) {
		for (YLoadDocPO po : YLoadDocList) {
			try {
				YLoad.saveYloadDocPO(po);
			} catch (RemoteException e) {
				System.out.println("�������ݲ��ѯʧ��");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setZLoadDocList(ArrayList<ZLoadDocPO> ZLoadDocList) {
		for (ZLoadDocPO po : ZLoadDocList) {
			try {
				ZLoad.saveZloadDocPO(po);
			} catch (RemoteException e) {
				System.out.println("�������ݲ��ѯʧ��");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setStaffList(ArrayList<StaffPO> staffList) {
		for (StaffPO po : staffList) {
			try {
				institution.saveStaff(po);
			} catch (RemoteException e) {
				System.out.println("�����Э������");
				e.printStackTrace();
			}
		}

	}

	@Override
	public GatheringDocVO reviewGatheringDoc(
			String courier_ID, String account) {
		// double money=collectionbl.getCourierMoney(courier_ID);
		ArrayList<String> SendDoclist;
		try {
			SendDoclist = collectionbl.getSendDocsByID(courier_ID);
			
			if(SendDoclist.size()==0){
				System.out.println("û���ɼ�");
			}else{
				System.out.println(SendDoclist.size());
			}
			
			double money = 0;
			for (String itemID : SendDoclist) {
				SendDocPO po;
				po = collectionbl.getSendDocPOByID(itemID);
				money += po.getSumPrice();
			}
			String  GatheringDocID=financeDataService.getNewGatheringDocID()+"";
			return new GatheringDocVO(GatheringDocID, new Date(), money,
					courier_ID, SendDoclist, account);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		} catch (DatabaseNULLException e) {
		    JOptionPane.showMessageDialog(null, "�ÿ��ԱĿǰû���µ��ɼ�", "����",JOptionPane.PLAIN_MESSAGE);  
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void createGatheringDoc(GatheringDocVO vo) {
		// ϵͳֻ��֪�����Ա��˭�Ϳ������������տ����������Ϣ��Ҫ������ģ���ȡ
		// GatheringDocID,Date date,Double money, String
		// courier_name,ArrayList<String> itemIDs,String account)
		/*
		 * public ArrayList<String> getSendDocsByID(String courier_ID); public
		 * void savecSendDocCreateGatheringDoc(String SendDocID); public double
		 * getCourierMoney(String courier_ID);
		 * ���еڶ���������Ҫ����ID��һ���������üļ����Ƿ������տ��bool������Ϊtrue
		 */
		/*
		 * public ArrayList<String> getSendDocsByID(String courier_ID); public
		 * void savecSendDocCreateGatheringDoc(String SendDocID); public double
		 * getCourierMoney(String courier_ID);
		 * ���еڶ���������Ҫ����ID��һ���������üļ����Ƿ������տ��bool������Ϊtrue
		 */
		try {
			financeDataService.createGatheringDoc(vo.getDate(),
					vo.getMoney(), vo.getCourier_ID(), vo.getItemIDs(),
					vo.getAccount());
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}
	}

	@Override
	public GatheringDocVO getGatheringDocVO(String GatheringDocID) {
		GatheringDocPO po;
		try {
			po = financeDataService.getGatheringDocPO(GatheringDocID);
			return new GatheringDocVO(po.getID(), po.getDate(), po.getMoney(),
					po.getCourier_ID(), po.getItemIDs(), po.getAccount());
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setSendDocList(String courier_ID) {
		try {
			collectionbl.saveSendDocCreateGatheringDoc(courier_ID);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}
	}

	@Override
	public PayDocVO reviewPayDoc(double money, String payMen,
			String account, PayType type, String back) {
		String payDocID;
		try {
			payDocID = financeDataService.getNewPayDocID()+"";
			return new PayDocVO(payDocID, new Date(), money, payMen, account, type,
					back);
		} catch (RemoteException e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void createPayDoc(PayDocVO vo) {
		try {
			financeDataService.createPayDoc(vo.getDate(),
					vo.getMoney(), vo.getPayer(), vo.getAccount(),
					vo.getType(), vo.getBack());
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}

	}

	@Override
	public PayDocVO getPayDocVO(String PayDocID) {
		PayDocPO po;
		try {
			po = financeDataService.getPayDocPO(PayDocID);
			return new PayDocVO(po.getID(), po.getDate(), po.getMoney(),
					po.getPayer(), po.getAccount(), po.getType(), po.getBack());
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getStaffSalaryName(String staffID) {
		try {
			return institution.getStaffName(staffID);
		} catch (RemoteException e) {
			System.out.println("institution Э������");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public double calculateSalary(String staffID) {

		// TODO Auto-generated method stub
		/*
		 * ��һ������ȡ���Ա����ְλ �ڶ�������ȡ���Ա���Ĺ��ʲ��ԣ���ͨ��Ա��û������ʺͽ��𣬿��Ա�����ϵĻ����ϻ����ɵı�����˾��������
		 * �Ļ����ϻ��ÿһ�ζ���Ǯ�� ���������������Ա���Ĺ���
		 */
		// StaffPO staff=institution.getStaff(staffID);
		// 10λ˵����˾��
		if (staffID.length() == 10) {
			try {
				return calculateDriverSalary(staffID);
			} catch (RemoteException e) {
				e.printStackTrace();
				return 0;
			}
		}
		// 11λ˵������ͨԱ��
		Post position = null;
		try {
			position = institution.getPosition(staffID);
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
		}
		if (position == Post.���Ա) {
			return calculateCourierSalary(staffID);
		} else {
			return calculateNormalSalary(staffID);
		}
	}

	public double calculateCourierSalary(String staffID) {
		try {
			double base = institution.getBase(staffID);
			double bonus = institution.getBonus(staffID);
			double commision = institution.getPercentage(staffID);
			double totalMoney;
			totalMoney = bl.getCourierMoney(staffID);
			return base + bonus + commision * totalMoney;
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return 0;
		}

	}

	private double getCourierMoney(String staffID) throws RemoteException {
		return financeDataService.getCourierMoney(staffID,new Date());
		
	}

	public double calculateDriverSalary(String DriverID) throws RemoteException {
		double oneTimeMoney = driver.getDriverCommision(DriverID);
		int time;
		try {
			time = YLoad.getDriverTime(DriverID)
					+ ZLoad.getDriverTime(DriverID);
			return oneTimeMoney * time;
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
			return 0;
		}

	}

	public double calculateNormalSalary(String staffID) {
		try {
			double base = institution.getBase(staffID);
			double bonus = institution.getBonus(staffID);
			return base + bonus;
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
			return 0;
		}
	}

	public String getStaffName() {
		try {
			return institution.getStaffName(staffID);
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void resetSalary() {
		try {
			institution.resetSalary();
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
		}
	}

	@Override
	public void resetRent() {
		try {
			institution.resetRent();
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<AccountVO> getAccountList() {
		try {
			ArrayList<AccountPO> POList = financeDataService.getAccountList();
			ArrayList<AccountVO> VOList = new ArrayList<AccountVO>();
			for (AccountPO po : POList) {
				VOList.add(new AccountVO(po.getName(), po.getBalance()));
			}
			return VOList;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addMoney(String accountName, double money) {
		try {
			financeDataService.addMoney(accountName, money);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}

	}

	@Override
	public void minusMoney(String accountName, double money) {
		try {
			financeDataService.minusMoney(accountName, money);
		} catch (RemoteException e) {
			System.out.println("�������ݲ��ѯʧ��");
			e.printStackTrace();
		}

	}

	@Override
	public SalaryPO getSalaryPO(String staffID)  {
		SalaryPO po=null;
		try {
			po = institution.getSalary(staffID);
		} catch (RemoteException e) {
			System.out.println("�����Э������");		
			e.printStackTrace();
		}
		return po;
	}

	@Override
	public void saveSalaryPO(SalaryPO po) {
		try {
			institution.saveSalary(po);
		} catch (RemoteException e) {
			System.out.println("�����Э������");
			e.printStackTrace();
		}
		
	}

}
