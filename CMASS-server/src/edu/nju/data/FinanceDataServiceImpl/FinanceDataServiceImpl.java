package edu.nju.data.FinanceDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.PositionPO;

public class FinanceDataServiceImpl extends UnicastRemoteObject implements
		FinanceDataService {
	protected FinanceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		FinanceDataServiceImpl temp = new FinanceDataServiceImpl();
		/*
		 * �õ�δ����������Գɹ�
		ArrayList<PayDocPO> payDocList=temp.getunchekedPayDocList();
		for(PayDocPO po:payDocList){
			System.out.println(po.getID());
			System.out.println(po.getDate());
			System.out.println(po.getMoney());
			System.out.println(po.getPayer());
			System.out.println(po.getAccount());
			System.out.println(po.getType());
			System.out.println(po.getBack());
		}
		*/
		/*
		 * �õ�δ�����տ���Գɹ�
		ArrayList<GatheringDocPO> GatheringDocList=temp.getunchekedGatheringDocList();
		for(GatheringDocPO po:GatheringDocList){
			System.out.println(po.getID());
			System.out.println(po.getDate());
			System.out.println(po.getMoney());
			System.out.println(po.getCourier_name());
			System.out.println(po.getItemIDs());
		}
		*/
		/*
		 ���Գɹ����ø��Ϊ������
		PayDocPO po=new PayDocPO("11000002",new Date(),5000,"Michael Jackson","6228480010200900000",PayType.RENT,"...");
		temp.savePayDocPO(po);
		*/
		//temp.addAccountPO("������");
		//temp.deleteAccountPO("������");
		/*
		public void modifyAccountPO(String oldAccountName,String newAccountName);
		public AccountPO checkAccountPO(String accountName);
		public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate);
		public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,Date endDate); 
		public double getTotalPayment();//������֧��
		public double getTotalIncome();//�޲ε���Ϊ������������
		//���ɸ��
		public void createPayDoc(String payDocID,Date date, double money,	String account, PayType type,String back);
		public PayDocPO getPayDocPO(String PayDocID);//֧��Ԥ��
		//�����տ
		public void createGatheringDoc(String GatheringDocID,Date date,Double money, String courier_name,ArrayList<String> itemIDs);
		public GatheringDocPO getGatheringDocPO(String GatheringDocID);//֧��Ԥ��
		*/
		//temp.modifyAccountPO("dingeryu","lizhimu");
		/*
		AccountPO account=temp.checkAccountPO("linqing");
		System.out.println(account.getName());
		System.out.println(account.getBalance());
		*/
		/*
		System.out.println(temp.getTotalPayment());
		*/
		temp.createPayDoc("11000004", new Date(), 400,"1412" , PayType.RENT,"�½�");
	}

	// �ṩ���������ݵĹ��ӿ�
	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
		// String
		// sql="SELECT �����,����,Ǯ,������,�����˺�,��������,��ע,�Ƿ����� FROM PayDocPOList WHERE �Ƿ�����=no";
		String sql = "SELECT �����,����,Ǯ,������,�����˺�,��������,��ע FROM PayDocPOList WHERE �Ƿ�����='false';";
		SQL.databaseQuery(sql);
		ArrayList<String> payDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> payer = new ArrayList<String>();
		ArrayList<String> account = new ArrayList<String>();
		ArrayList<PayType> payType = new ArrayList<PayType>();
		ArrayList<String> back = new ArrayList<String>();
		// ArrayList<String> isChecked=new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				payDocno.add(SQL.rs.getString("�����"));
				date.add(SQL.rs.getDate("����"));
				money.add(SQL.rs.getDouble("Ǯ"));
				payer.add(SQL.rs.getString("������"));
				account.add(SQL.rs.getString("�����˺�"));
				back.add(SQL.rs.getString("��ע"));
				// PayType��һ��enum,���������Ȱ�stringת�ɶ�Ӧ��payType�ٽ������
				String temp = SQL.rs.getString("��������");
				if (temp.equals("���")) {
					payType.add(PayType.RENT);
				} else if (temp.equals("�˷�")) {
					payType.add(PayType.FREIGHT);
				} else {
					payType.add(PayType.SALARY);
				}

				// isChecked.add(SQL.rs.getString("�Ƿ�����"));
			}
		} catch (SQLException e) {
			System.out.println("�����ѯ����");
			e.printStackTrace();
		}
		for (int i = 0; i < payDocno.size(); i++) {
			PayDocPO temp = new PayDocPO(payDocno.get(i), date.get(i),
					money.get(i), payer.get(i), account.get(i), payType.get(i),
					back.get(i));
			uncheckedPayDocList.add(temp);
		}

		SQL.closeDatabase();
		return uncheckedPayDocList;
	}

	@Override
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б� FROM GatheringDocPOList WHERE �Ƿ�����='false';";
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("�տ��"));
				date.add(SQL.rs.getDate("����"));
				money.add(SQL.rs.getDouble("Ǯ"));
				courier.add(SQL.rs.getString("���Ա"));
				// ���������ǰѼļ����б��StringתΪArryaList
				String temp = SQL.rs.getString("�ļ�������б�");
				String[] split = temp.split(",");
				ArrayList<String> numberList = new ArrayList<String>();
				for (String temp1 : split) {
					numberList.add(temp1);
				}
				sendDocnoList.add(numberList);

			}
		} catch (SQLException e) {
			System.out.println("�տ��ѯ����");
			e.printStackTrace();
		}
		for (int i = 0; i < GatheringDocno.size(); i++) {
			GatheringDocPO temp = new GatheringDocPO(GatheringDocno.get(i),
					date.get(i), money.get(i), courier.get(i),
					sendDocnoList.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public void savePayDocPO(PayDocPO po) {
		String PayDocID = po.getID();
		String sql = "UPDATE PayDocPOList SET �Ƿ�����='true'where �����="
				+ PayDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		String GatheringDocID = po.getID();
		String sql = "UPDATE GatheringDocPOList SET �Ƿ�����='true'where �տ��="
				+ GatheringDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void addAccountPO(String accountName) {
		String sql = "INSERT INTO account VALUES('" + accountName + "',0);";

		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteAccountPO(String accountName) {
		String sql = "DELETE FROM account WHERE �˻����� ='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName) {
		String sql = "UPDATE account SET �˻�����='" + newAccountName
				+ "'WHERE �˻�����='" + oldAccountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public AccountPO checkAccountPO(String accountName) {
		String sql = "SELECT �˻�����,�˻���� FROM account WHERE �˻�����='" + accountName
				+ "';";
		SQL.databaseQuery(sql);
		try {
			if(SQL.rs.next()){
			AccountPO temp = new AccountPO(SQL.rs.getString("�˻�����"),
					SQL.rs.getDouble("�˻����"));
			SQL.closeDatabase();
			return temp;
			}
		} catch (SQLException e) {
			System.out.println("�˻���ѯ����");
			e.printStackTrace();
			SQL.closeDatabase();
		}
		
		return null;

	}

	@Override
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		//select * from tb where riqi between '2009-01-22 00:00:00' and '2009-01-22 23:59:59'  
		return null;
	}

	@Override
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,
			Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalPayment() {
		double totalPayment = 0;
		String sql = "SELECT Ǯ FROM PayDocPOList;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				totalPayment += SQL.rs.getDouble("Ǯ");
			}
		} catch (SQLException e) {
			System.out.println("��֧�����ݲ�ѯ����");
			e.printStackTrace();
		}
		return totalPayment;
	}

	@Override
	public double getTotalIncome() {
		double totalIncome = 0;
		String sql = "SELECT Ǯ FROM GatheringDocPOList;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				totalIncome += SQL.rs.getDouble("Ǯ");
			}
		} catch (SQLException e) {
			System.out.println("���������ݲ�ѯ����");
			e.printStackTrace();
		}
		return totalIncome;
	}

	// ���ɸ��
	@Override
	public void createPayDoc(String payDocID,Date date, double money, String account,
			PayType type, String back) {
		String payType;
	    DateFormat df1 = DateFormat.getDateInstance();//���ڸ�ʽ����ȷ����
		if (type.equals(PayType.RENT)) {
			payType = "���";
		} else if (type.equals(PayType.FREIGHT)) {
			payType = "�˷�";
		} else {
			payType = "����";
		}
		String sql = "INSERT INTO PayDocPOList VALUES('" + payDocID + "','"
				+df1.format(date)+ "'," + money + ",'" + account
				+ "','" + payType + "','" + back + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) {

		String sql = "SELECT �����,����,Ǯ,������,�����˺�,��������,��ע FROM PayDocPOList WHERE �����='"
				+ PayDocID + "';";
		SQL.databaseQuery(sql);
		try {
			String temp = SQL.rs.getString("��������");
			PayType payType;
			if (temp.equals("���")) {
				payType = PayType.RENT;
			} else if (temp.equals("�˷�")) {
				payType = PayType.FREIGHT;
			} else {
				payType = PayType.SALARY;
			}
			PayDocPO PO = new PayDocPO(SQL.rs.getString("�����"),
					SQL.rs.getDate("����"), SQL.rs.getDouble("Ǯ"),
					SQL.rs.getString("������"), SQL.rs.getString("�����˺�"), payType,
					SQL.rs.getString("��ע"));
			return PO;
		} catch (SQLException e) {
			System.out.println("���Ԥ������");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	// �����տ
	@Override
	public void createGatheringDoc(String GatheringDocID,Date date, Double money,
			String courier_name, ArrayList<String> itemIDs) {
		DateFormat df1 = DateFormat.getDateInstance();//���ڸ�ʽ����ȷ����
		String items = "";
		for (String temp : itemIDs) {
			items += temp + ",";
		}
		items = items.substring(0, itemIDs.size() - 1);// ɾ�����һ������
		String sql = "INSERT INTO GatheringDocPOList VALUES('" + GatheringDocID
				+ "','" +df1.format(date) + "'," + money + ",'"
				+ courier_name + "','" + items + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID) {
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б� FROM GatheringDocPOList WHERE �տ��='"
				+ GatheringDocID + "';";
		SQL.databaseQuery(sql);
		try {
			String temp = SQL.rs.getString("�ļ�������б�");
			String[] split = temp.split(",");
			ArrayList<String> numberList = new ArrayList<String>();
			for (String temp1 : split) {
				numberList.add(temp1);
			}
			GatheringDocPO PO = new GatheringDocPO(SQL.rs.getString("�տ��"),
					SQL.rs.getDate("����"), SQL.rs.getDouble("Ǯ"),
					SQL.rs.getString("���Ա"), numberList);
			return PO;
		} catch (SQLException e) {
			System.out.println("���Ԥ������");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}
	
	//tools
	public static boolean betweenDate(String startDate,String endDate,String testDate){
		String[] startDateSplit=startDate.split("-");
		String[] endDateSplit=endDate.split("-");
		String[] testDateSplit=testDate.split("-");
		for(int i=0;i<=2;i++){
			int start=Integer.parseInt(startDateSplit[i]);
			System.out.println(start);
			int end=Integer.parseInt(endDateSplit[i]);
			System.out.println(end);
			int test=Integer.parseInt(testDateSplit[i]);
			System.out.println(test);
			if(start>test||end<test){
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<String> getAccountList() {
		ArrayList<String> accountNameList=new ArrayList<String>();
		String sql = "SELECT �˻�����FROM account;";
		SQL.databaseQuery(sql);
		try {
			while(SQL.rs.next()){
			String accountName = SQL.rs.getString("�˻�����");	
			accountNameList.add(accountName);
			}
			return accountNameList;
		} catch (SQLException e) {
			System.out.println("�˻���ѯ����");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addMoney(String accountName, double money) {
		String sql = "UPDATE account SET �˻����='"
				+ "'WHERE �˻�����='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
	}

	@Override
	public void minusMoney(String accountName, String money) {
		// TODO Auto-generated method stub
		
	}

}
