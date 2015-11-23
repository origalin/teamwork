package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.DriverPO;

public class DriverDataServiceImpl implements DriverDataService{

	@Override
	public ArrayList<DriverPO> findDriver() {
		ArrayList<DriverPO> DriverList = new ArrayList<DriverPO>();
		String sql = "SELECT 收款单号,日期,钱,快递员,寄件单编号列表 FROM GatheringDocPOList WHERE 是否被审批='false';";
		SQL.databaseQuery(sql);
//		ArrayList<String> GatheringDocno = new ArrayList<String>();
//		ArrayList<Date> date = new ArrayList<Date>();
//		ArrayList<Double> money = new ArrayList<Double>();
//		ArrayList<String> courier = new ArrayList<String>();
//		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
//		try {
//			while (SQL.rs.next()) {
//				GatheringDocno.add(SQL.rs.getString("收款单号"));
//				date.add(SQL.rs.getDate("日期"));
//				money.add(SQL.rs.getDouble("钱"));
//				courier.add(SQL.rs.getString("快递员"));
//				// 接下来我们把寄件单列表从String转为ArryaList
//				String temp = SQL.rs.getString("寄件单编号列表");
//				String[] split = temp.split(",");
//				ArrayList<String> numberList = new ArrayList<String>();
//				for (String temp1 : split) {
//					numberList.add(temp1);
//				}
//				sendDocnoList.add(numberList);
//
//			}
//		} catch (SQLException e) {
//			System.out.println("收款单查询错误");
//			e.printStackTrace();
//		}
//		for (int i = 0; i < GatheringDocno.size(); i++) {
//			GatheringDocPO temp = new GatheringDocPO(GatheringDocno.get(i),
//					date.get(i), money.get(i), courier.get(i),
//					sendDocnoList.get(i));
//			uncheckedGatheringDocList.add(temp);
//		}
//		SQL.closeDatabase();
		return DriverList;

	}

	@Override
	public void addDriver(DriverPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeDriver(DriverPO po) {
		// TODO Auto-generated method stub
		
	}



}
