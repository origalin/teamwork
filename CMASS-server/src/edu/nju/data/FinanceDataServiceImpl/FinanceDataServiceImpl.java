package edu.nju.data.FinanceDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
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
		String sql = "create table account;";
//		String sql = "INSERT INTO account (账户名称,账户余额) VALUES('张健',5000);";
		System.out.println(SQL.databaseUpdate(sql));
	}

	// 提供给审批单据的供接口
	@Override
	public ArrayList<PayDocPO> getunchekedPayDocList() {
		ArrayList<PayDocPO> uncheckedPayDocList = new ArrayList<PayDocPO>();
		// String
		// sql="SELECT 付款单号,日期,钱,付款人,付款账号,付款类型,备注,是否被审批 FROM PayDocPOList WHERE 是否被审批=no";
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
	public ArrayList<GatheringDocPO> getunchekedGatheringDocList() {
		ArrayList<GatheringDocPO> uncheckedGatheringDocList = new ArrayList<GatheringDocPO>();
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表 FROM GatheringDocPOList WHERE 是否被审批='false';";
		SQL.databaseQuery(sql);
		ArrayList<String> GatheringDocno = new ArrayList<String>();
		ArrayList<Date> date = new ArrayList<Date>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<String> courier = new ArrayList<String>();
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		try {
			while (SQL.rs.next()) {
				GatheringDocno.add(SQL.rs.getString("收款单号"));
				date.add(SQL.rs.getDate("日期"));
				money.add(SQL.rs.getDouble("钱"));
				courier.add(SQL.rs.getString("快递员"));
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
					sendDocnoList.get(i));
			uncheckedGatheringDocList.add(temp);
		}
		SQL.closeDatabase();
		return uncheckedGatheringDocList;
	}

	@Override
	public void savePayDocPO(PayDocPO po) {
		String PayDocID = po.getID();
		String sql = "UPDATE PayDocPOList SET 是否被审批='true'where 付款单号="
				+ PayDocID + ";";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public void saveGatheringDocPO(GatheringDocPO po) {
		String GatheringDocID = po.getID();
		String sql = "UPDATE GatheringDocPOList SET 是否被审批='true'where 收款单号="
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
		// TODO Auto-generated method stub
		String sql = "DELETE FROM account WHERE 账户名称 ='" + accountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void modifyAccountPO(String oldAccountName, String newAccountName) {
		// TODO Auto-generated method stub
		String sql = "UPDATE account SET 账户名称='" + newAccountName
				+ "'WHERE 账户名称='" + oldAccountName + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public AccountPO checkAccountPO(String accountName) {
		// TODO Auto-generated method stub
		String sql = "SELECT 账户名称,账户余额 FROM account WHERE 账户名称='" + accountName
				+ "';";
		SQL.databaseQuery(sql);
		try {
			AccountPO temp = new AccountPO(SQL.rs.getString("账户名称"),
					SQL.rs.getDouble("账户余额"));
			return temp;
		} catch (SQLException e) {
			System.out.println("账户查询错误");
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public ArrayList<PayDocPO> getPayDoc(Date startDate, Date endDate) {
		// TODO Auto-generated method stub

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
		String sql = "SELECT 钱 FROM PayDocListPOList;";
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
	public double getTotalIncome() {
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
	public void createPayDoc(String payDocID, double money, String account,
			PayType type, String back) {
		String payType;
		if (type.equals(PayType.RENT)) {
			payType = "租金";
		} else if (type.equals(PayType.FREIGHT)) {
			payType = "运费";
		} else {
			payType = "工资";
		}
		String sql = "INSERT INTO PayDocPOList VALUES('" + payDocID + "','"
				+ getCurrentDate().toString() + "'," + money + ",'" + account
				+ "','" + payType + "','" + back + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public PayDocPO getPayDocPO(String PayDocID) {

		String sql = "SELECT 付款单号,日期,钱,付款人,付款账号,付款类型,备注 FROM PayDocPOList WHERE 付款单号='"
				+ PayDocID + "';";
		SQL.databaseQuery(sql);
		try {
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
					SQL.rs.getString("付款人"), SQL.rs.getString("付款账号"), payType,
					SQL.rs.getString("备注"));
			return PO;
		} catch (SQLException e) {
			System.out.println("付款单预览出错");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	// 生成收款单
	@Override
	public void createGatheringDoc(String GatheringDocID, Double money,
			String courier_name, ArrayList<String> itemIDs) {
		// TODO Auto-generated method stub
		String items = "";
		for (String temp : itemIDs) {
			items += temp + ",";
		}
		items = items.substring(0, itemIDs.size() - 1);// 删除最后一个逗号
		String sql = "INSERT INTO GatheringDocPOList VALUES('" + GatheringDocID
				+ "','" + getCurrentDate().toString() + "'," + money + ",'"
				+ courier_name + "','" + items + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public GatheringDocPO getGatheringDocPO(String GatheringDocID) {
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表 FROM GatheringDocPOList WHERE 收款单号='"
				+ GatheringDocID + "';";
		SQL.databaseQuery(sql);
		try {
			String temp = SQL.rs.getString("寄件单编号列表");
			String[] split = temp.split(",");
			ArrayList<String> numberList = new ArrayList<String>();
			for (String temp1 : split) {
				numberList.add(temp1);
			}
			GatheringDocPO PO = new GatheringDocPO(SQL.rs.getString("收款单号"),
					SQL.rs.getDate("日期"), SQL.rs.getDouble("钱"),
					SQL.rs.getString("快递员"), numberList);
			return PO;
		} catch (SQLException e) {
			System.out.println("付款单预览出错");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return null;
	}

	public Date getCurrentDate() {
		return null;
	}

}
