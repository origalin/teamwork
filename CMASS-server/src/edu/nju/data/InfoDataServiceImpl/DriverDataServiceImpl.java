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
		String sql = "SELECT �տ��,����,Ǯ,���Ա,�ļ�������б� FROM GatheringDocPOList WHERE �Ƿ�����='false';";
		SQL.databaseQuery(sql);
//		ArrayList<String> GatheringDocno = new ArrayList<String>();
//		ArrayList<Date> date = new ArrayList<Date>();
//		ArrayList<Double> money = new ArrayList<Double>();
//		ArrayList<String> courier = new ArrayList<String>();
//		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
//		try {
//			while (SQL.rs.next()) {
//				GatheringDocno.add(SQL.rs.getString("�տ��"));
//				date.add(SQL.rs.getDate("����"));
//				money.add(SQL.rs.getDouble("Ǯ"));
//				courier.add(SQL.rs.getString("���Ա"));
//				// ���������ǰѼļ����б��StringתΪArryaList
//				String temp = SQL.rs.getString("�ļ�������б�");
//				String[] split = temp.split(",");
//				ArrayList<String> numberList = new ArrayList<String>();
//				for (String temp1 : split) {
//					numberList.add(temp1);
//				}
//				sendDocnoList.add(numberList);
//
//			}
//		} catch (SQLException e) {
//			System.out.println("�տ��ѯ����");
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
