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

	public static void main(String[] args) throws RemoteException {
		FinanceDataServiceImpl financeDataServiceImpl = new FinanceDataServiceImpl();
		financeDataServiceImpl.minusMoney("linqing",50);
	}

	public FinanceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public static void main(String[] args) throws RemoteException,
	 * ParseException { FinanceDataServiceImpl temp = new
	 * FinanceDataServiceImpl(); System.out.println(temp.getTotalIncome()); }
	 */
	// 提供给审批单据的供接口
	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() throws RemoteException {
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
		String sql = "SELECT 付款单号,日期,钱,付款人,付款账号,付款类型,备注 FROM PayDocPOList WHERE 是否被审批='false';";
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
				payDocno.add(SQL.rs.getString("付款单号"));
				date.add(SQL.rs.getDate("日期"));
				money.add(SQL.rs.getDouble("钱"));
				payer.add(SQL.rs.getString("付款人"));
				account.add(SQL.rs.getString("付款账号"));
				back.add(SQL.rs.getString("备注"));
				// PayType是一个enum,所以我们先把string转成对应的payType再进行添加
				String temp = SQL.rs.getString("付款类型");
				if (temp.equals("租金")) {
					payType.add(PayType.RENT);
				} else if (temp.equals("运费")) {
					payType.add(PayType.FREIGHT);
				} else {
					payType.add(PayType.SALARY);
				}

				// isChecked.add(SQL.rs.getString("是否被审批"));
			}
		} catch (SQLException e) {
			System.out.println("付款单查询错误");
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
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList()
			throws RemoteException {
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表,收款账号 FROM GatheringDocPOList WHERE 是否被审批='false';";
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		ArrayList<String> account = new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("收款单号"));
				date.add(SQL.rs.getDate("日期"));
				money.add(SQL.rs.getDouble("钱"));
				courier.add(SQL.rs.getString("快递员"));
				account.add(SQL.rs.getString("收款账号"));
				// 接下来我们把寄件单列表从String转为ArryaList
				String temp = SQL.rs.getString("寄件单编号列表");
				String[] split = temp.split(",");
				ArrayList<String> numberList = new ArrayList<String>();
				for (String temp1 : split) {
					numberList.add(temp1);
				}
				sendDocnoList.add(numberList);

			}
		} catch (SQLException e) {
			System.out.println("收款单查询错误");
			e.printStackTrace();
		}
		for (int i = 0; i < GatheringDocno.size(); i++) {
			GatheringDocPO temp = new GatheringDocPO(GatheringDocno.get(i),
					date.get(i), money.get(i), courier.get(i),
					sendDocnoList.get(i), account.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public void savePayDocPO(PayDocPO po) throws RemoteException {
		String PayDocID = po.getID();
		String sql = "UPDATE PayDocPOList SET 是否被审批='true'where 付款单号="
				+ PayDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) throws RemoteException {
		String GatheringDocID = po.getID();
		String sql = "UPDATE GatheringDocPOList SET 是否被审批='true'where 收款单号="
				+ GatheringDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void addAccountPO(String accountName) throws RemoteException {
		String sql = "INSERT INTO account VALUES('" + accountName + "',0);";

		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteAccountPO(String accountName) throws RemoteException {
		String sql = "DELETE FROM account WHERE 账户名称 ='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName)
			throws RemoteException {
		String sql = "UPDATE account SET 账户名称='" + newAccountName
				+ "'WHERE 账户名称='" + oldAccountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public AccountPO checkAccountPO(String accountName) throws RemoteException {
		String sql = "SELECT 账户名称,账户余额 FROM account WHERE 账户名称='" + accountName
				+ "';";
		SQL.databaseQuery(sql);
		try {
			if (SQL.rs.next()) {
				AccountPO temp = new AccountPO(SQL.rs.getString("账户名称"),
						SQL.rs.getDouble("账户余额"));
				SQL.closeDatabase();
				return temp;
			}
		} catch (SQLException e) {
			System.out.println("账户查询错误");
			e.printStackTrace();
			SQL.closeDatabase();
		}

		return null;

	}

	@Override
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate)
			throws RemoteException {
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
		String sql = "SELECT 付款单号,日期,钱,付款人,付款账号,付款类型,备注 FROM PayDocPOList WHERE 日期  BETWEEN '"
				+ Time.toDaysTime(startDate)
				+ "' AND '"
				+ Time.toDaysTime(endDate) + "';";
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
				payDocno.add(SQL.rs.getString("付款单号"));
				date.add(SQL.rs.getDate("日期"));
				money.add(SQL.rs.getDouble("钱"));
				payer.add(SQL.rs.getString("付款人"));
				account.add(SQL.rs.getString("付款账号"));
				back.add(SQL.rs.getString("备注"));
				// PayType是一个enum,所以我们先把string转成对应的payType再进行添加
				String temp = SQL.rs.getString("付款类型");
				if (temp.equals("租金")) {
					payType.add(PayType.RENT);
				} else if (temp.equals("运费")) {
					payType.add(PayType.FREIGHT);
				} else {
					payType.add(PayType.SALARY);
				}

				// isChecked.add(SQL.rs.getString("是否被审批"));
			}
		} catch (SQLException e) {
			System.out.println("付款单查询错误");
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
			Date endDate) throws RemoteException {
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表,收款账号 FROM GatheringDocPOList WHERE 日期  BETWEEN '"
				+ Time.toDaysTime(startDate)
				+ "' AND '"
				+ Time.toDaysTime(endDate) + "';";
		// SELECT prod_name, prod_price FROM Products WHERE prod_price BETWEEN 5
		// AND 10;
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		ArrayList<String> account = new ArrayList<String>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("收款单号"));
				date.add(SQL.rs.getDate("日期"));
				money.add(SQL.rs.getDouble("钱"));
				courier.add(SQL.rs.getString("快递员"));
				account.add(SQL.rs.getString("收款账号"));
				// 接下来我们把寄件单列表从String转为ArryaList
				String temp = SQL.rs.getString("寄件单编号列表");
				String[] split = temp.split(",");
				ArrayList<String> numberList = new ArrayList<String>();
				for (String temp1 : split) {
					numberList.add(temp1);
				}
				sendDocnoList.add(numberList);

			}
		} catch (SQLException e) {
			System.out.println("收款单查询错误");
			e.printStackTrace();
		}
		for (int i = 0; i < GatheringDocno.size(); i++) {
			GatheringDocPO temp = new GatheringDocPO(GatheringDocno.get(i),
					date.get(i), money.get(i), courier.get(i),
					sendDocnoList.get(i), account.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public double getTotalPayment() throws RemoteException {
		double totalPayment = 0;
		String sql = "SELECT 钱 FROM PayDocPOList;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				totalPayment += SQL.rs.getDouble("钱");
			}
		} catch (SQLException e) {
			System.out.println("总支出数据查询出错");
			e.printStackTrace();
		}
		return totalPayment;
	}

	@Override
	public double getTotalIncome() throws RemoteException {
		double totalIncome = 0;
		String sql = "SELECT 钱 FROM GatheringDocPOList;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				totalIncome += SQL.rs.getDouble("钱");
			}
		} catch (SQLException e) {
			System.out.println("总收入数据查询出错");
			e.printStackTrace();
		}
		return totalIncome;
	}

	// 生成付款单
	@Override
	public void createPayDoc(String payDocID, Date date, double money,
			String payMen, String account, PayType type, String back)
			throws RemoteException {

		String payType;
		if (type.equals(PayType.RENT)) {
			payType = "租金";
		} else if (type.equals(PayType.FREIGHT)) {
			payType = "运费";
		} else {
			payType = "工资";
		}
		String sql = "INSERT INTO PayDocPOList VALUES('" + payDocID + "','"
				+ Time.toDaysTime(date) + "','" + money + "','" + payMen
				+ "','" + account + "','" + payType + "','" + back
				+ "','false');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) throws RemoteException {

		String sql = "SELECT 付款单号,日期,钱,付款人,付款账号,付款类型,备注 FROM PayDocPOList WHERE 付款单号='"
				+ PayDocID + "';";
		SQL.databaseQuery(sql);
		try {
			if (SQL.rs.next()) {
				String temp = SQL.rs.getString("付款类型");
				PayType payType;
				if (temp.equals("租金")) {
					payType = PayType.RENT;
				} else if (temp.equals("运费")) {
					payType = PayType.FREIGHT;
				} else {
					payType = PayType.SALARY;
				}
				PayDocPO PO = new PayDocPO(SQL.rs.getString("付款单号"),
						SQL.rs.getDate("日期"), SQL.rs.getDouble("钱"),
						SQL.rs.getString("付款人"), SQL.rs.getString("付款账号"),
						payType, SQL.rs.getString("备注"));
				return PO;
			}
		} catch (SQLException e) {
			System.out.println("付款单预览出错");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	// 生成收款单
	@Override
	public void createGatheringDoc(String GatheringDocID, Date date,
			Double money, String courier_ID, ArrayList<String> itemIDs,
			String account) throws RemoteException {
		DateFormat df1 = DateFormat.getDateInstance();// 日期格式，精确到日
		String items = "";
		for (String temp : itemIDs) {
			items += temp + ",";
		}
		items = items.substring(0, items.length() - 1);// 删除最后一个逗号
		String sql = "INSERT INTO GatheringDocPOList VALUES('" + GatheringDocID
				+ "','" + Time.toDaysTime(date) + "','" + money + "','"
				+ courier_ID + "','" + items + "','" + account + "','false');";
		System.out.println(sql);
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID)
			throws RemoteException {
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表,收款账号 FROM GatheringDocPOList WHERE 收款单号='"
				+ GatheringDocID + "';";
		SQL.databaseQuery(sql);
		try {
			if (SQL.rs.next()) {
				String temp = SQL.rs.getString("寄件单编号列表");
				String[] split = temp.split(",");
				ArrayList<String> numberList = new ArrayList<String>();
				for (String temp1 : split) {
					numberList.add(temp1);
				}
				GatheringDocPO PO = new GatheringDocPO(
						SQL.rs.getString("收款单号"), SQL.rs.getDate("日期"),
						SQL.rs.getDouble("钱"), SQL.rs.getString("快递员"),
						numberList, SQL.rs.getString("收款账号"));
				return PO;
			}
		} catch (SQLException e) {
			System.out.println("付款单预览出错");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	// tools
	public static boolean betweenDate(String startDate, String endDate,
			String testDate) {
		String[] startDateSplit = startDate.split("-");
		String[] endDateSplit = endDate.split("-");
		String[] testDateSplit = testDate.split("-");
		for (int i = 0; i <= 2; i++) {
			int start = Integer.parseInt(startDateSplit[i]);
			System.out.println(start);
			int end = Integer.parseInt(endDateSplit[i]);
			System.out.println(end);
			int test = Integer.parseInt(testDateSplit[i]);
			System.out.println(test);
			if (start > test || end < test) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<AccountPO> getAccountList() throws RemoteException {
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
		String sql = "SELECT 账户名称,账户余额 FROM account;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String accountName = SQL.rs.getString("账户名称");
				double accountBalance = SQL.rs.getDouble("账户余额");
				accountList.add(new AccountPO(accountName, accountBalance));
			}
			return accountList;
		} catch (SQLException e) {
			System.out.println("账户查询错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	@Override
	public void addMoney(String accountName, double money)
			throws RemoteException {
		double currentMoney = 0;
		String s = "SELECT 账户余额 FROM account WHERE 账户名称='" + accountName + "';";
		SQL.databaseQuery(s);
		try {
			if (SQL.rs.next()) {
				double temp = SQL.rs.getDouble("账户余额");
				SQL.closeDatabase();
				currentMoney = temp;
			}
		} catch (SQLException e) {
			System.out.println("账户查询错误");
			e.printStackTrace();
			SQL.closeDatabase();
		}

		currentMoney += money;

		String sql = "UPDATE account SET 账户余额='" + currentMoney
				+ "'WHERE 账户名称='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void minusMoney(String accountName, double money)
			throws RemoteException {
		double temp = -money;
		this.addMoney(accountName, temp);

	}

	@Override
	public double getCourierMoney(String staffID,Date date) throws RemoteException{
		ArrayList<Double> courierMoneyList=new ArrayList<Double>();
		String sql = "SELECT 钱 FROM GatheringDocPOList WHERE 日期  BETWEEN '"
				+ Time.toFirstDayTime(date)
				+ "' AND '"
				+ Time.toDaysTime(date) + "' AND 快递员='"+staffID+"';";
		SQL.databaseQuery(sql);
		double money = 0;
		try {
			while (SQL.rs.next()) {
				money+=SQL.rs.getDouble("钱");
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("付款单查询错误");
			return 0;
		}
		
		return money;
	}

}
