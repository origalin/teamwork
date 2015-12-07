package edu.nju.data.FinanceDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import edu.nju.tools.Time;

public class FinanceDataServiceImpl extends UnicastRemoteObject implements
		FinanceDataService {
	
	public static void main(String[]args) throws RemoteException{
		FinanceDataServiceImpl financeDataServiceImpl=new FinanceDataServiceImpl();
		System.out.println(financeDataServiceImpl.getTotalIncome());
	}
	public FinanceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	public static void main(String[] args) throws RemoteException, ParseException {		 
		FinanceDataServiceImpl temp = new FinanceDataServiceImpl();
		System.out.println(temp.getTotalIncome());
	}
*/
	// �ṩ���������ݵĹ��ӿ�
	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() throws RemoteException{
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
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
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() throws RemoteException{
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б�,�տ��˺� FROM GatheringDocPOList WHERE �Ƿ�����='false';";
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		ArrayList<String> account=new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("�տ��"));
				date.add(SQL.rs.getDate("����"));
				money.add(SQL.rs.getDouble("Ǯ"));
				courier.add(SQL.rs.getString("���Ա"));
				account.add(SQL.rs.getString("�տ��˺�"));
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
					sendDocnoList.get(i),account.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public void savePayDocPO(PayDocPO po) throws RemoteException{
		String PayDocID = po.getID();
		String sql = "UPDATE PayDocPOList SET �Ƿ�����='true'where �����="
				+ PayDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) throws RemoteException{
		String GatheringDocID = po.getID();
		String sql = "UPDATE GatheringDocPOList SET �Ƿ�����='true'where �տ��="
				+ GatheringDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void addAccountPO(String accountName) throws RemoteException{
		String sql = "INSERT INTO account VALUES('" + accountName + "',0);";

		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteAccountPO(String accountName) throws RemoteException{
		String sql = "DELETE FROM account WHERE �˻����� ='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName)throws RemoteException {
		String sql = "UPDATE account SET �˻�����='" + newAccountName
				+ "'WHERE �˻�����='" + oldAccountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public AccountPO checkAccountPO(String accountName)throws RemoteException {
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
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate)throws RemoteException {
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
		String sql = "SELECT �����,����,Ǯ,������,�����˺�,��������,��ע FROM PayDocPOList WHERE ����  BETWEEN '"+Time.toDaysTime(startDate)+"' AND '"+Time.toDaysTime(endDate)+"';";
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
	public ArrayList<GatheringDocPO> getGatheringDoc(Date startDate,
			Date endDate) throws RemoteException{
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б�,�տ��˺� FROM GatheringDocPOList WHERE ����  BETWEEN '"+Time.toDaysTime(startDate)+"' AND '"+Time.toDaysTime(endDate)+"';";
		//SELECT prod_name, prod_price FROM Products WHERE prod_price BETWEEN 5 AND 10;
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		ArrayList<String> account=new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("�տ��"));
				date.add(SQL.rs.getDate("����"));
				money.add(SQL.rs.getDouble("Ǯ"));
				courier.add(SQL.rs.getString("���Ա"));
				account.add(SQL.rs.getString("�տ��˺�"));
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
					sendDocnoList.get(i),account.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public double getTotalPayment() throws RemoteException{
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
	public double getTotalIncome() throws RemoteException{
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
	public void createPayDoc(String payDocID,Date date, double money,String payMen, String account,
			PayType type, String back) throws RemoteException{

		String payType;
		if (type.equals(PayType.RENT)) {
			payType = "���";
		} else if (type.equals(PayType.FREIGHT)) {
			payType = "�˷�";
		} else {
			payType = "����";
		}
		String sql = "INSERT INTO PayDocPOList VALUES('" + payDocID + "','"
				+Time.toDaysTime(date)+ "','" + money + "','" + payMen+"','"+account
				+ "','" + payType + "','" + back + "','false');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) throws RemoteException{

		String sql = "SELECT �����,����,Ǯ,������,�����˺�,��������,��ע FROM PayDocPOList WHERE �����='"
				+ PayDocID + "';";
		SQL.databaseQuery(sql);
		try {
			if(SQL.rs.next()){
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
			}
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
			String courier_ID, ArrayList<String> itemIDs,String account)throws RemoteException {
		DateFormat df1 = DateFormat.getDateInstance();//���ڸ�ʽ����ȷ����
		String items = "";
		for (String temp : itemIDs) {
			items += temp + ",";
		}
		items = items.substring(0,items.length() - 1);// ɾ�����һ������
		String sql = "INSERT INTO GatheringDocPOList VALUES('" + GatheringDocID
				+ "','" +Time.toDaysTime(date)+ "','" + money + "','"
				+ courier_ID + "','" + items + "','"+account+"','false');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID)throws RemoteException {
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б�,�տ��˺� FROM GatheringDocPOList WHERE �տ��='"
				+ GatheringDocID + "';";
		SQL.databaseQuery(sql);
		try {
			if(SQL.rs.next()){
			String temp = SQL.rs.getString("�ļ�������б�");
			String[] split = temp.split(",");
			ArrayList<String> numberList = new ArrayList<String>();
			for (String temp1 : split) {
				numberList.add(temp1);
			}
			GatheringDocPO PO = new GatheringDocPO(SQL.rs.getString("�տ��"),
					SQL.rs.getDate("����"), SQL.rs.getDouble("Ǯ"),
					SQL.rs.getString("���Ա"), numberList,SQL.rs.getString("�տ��˺�"));
			return PO;
			}
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
	public ArrayList<AccountPO> getAccountList() throws RemoteException{
		ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();
		String sql = "SELECT �˻�����,�˻���� FROM account;";
		SQL.databaseQuery(sql);
		try {
			while(SQL.rs.next()){
			String accountName = SQL.rs.getString("�˻�����");	
			double accountBalance=SQL.rs.getDouble("�˻����");
			accountList.add(new AccountPO(accountName,accountBalance));
			}
			return accountList;
		} catch (SQLException e) {
			System.out.println("�˻���ѯ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public void addMoney(String accountName, double money) throws RemoteException{
		double currentMoney=0;
		String s= "SELECT �˻���� FROM account WHERE �˻�����='" + accountName
				+ "';";
		SQL.databaseQuery(s);
		try {
			if(SQL.rs.next()){
			double temp = SQL.rs.getDouble("�˻����");
			SQL.closeDatabase();
			currentMoney=temp;
			}
		} catch (SQLException e) {
			System.out.println("�˻���ѯ����");
			e.printStackTrace();
			SQL.closeDatabase();
		}
		
		currentMoney+=money;
		
		
		String sql = "UPDATE account SET �˻����='"+currentMoney
				+ "'WHERE �˻�����='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
	}

	@Override
	public void minusMoney(String accountName, double money) throws RemoteException{
		double temp=-money;
		this.addMoney(accountName,temp);
		
	}

}
