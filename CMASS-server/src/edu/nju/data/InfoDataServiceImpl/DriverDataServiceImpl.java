package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.DriverPO;

public class DriverDataServiceImpl implements DriverDataService{

	@Override
	public ArrayList<DriverPO> findDriver(String InstitutionName) {
		ArrayList<DriverPO> DriverList = new ArrayList<DriverPO>();
		String sql = "SELECT ˾�����,˾������,��������,���֤��,��ϵ��ʽ,������λ,�Ա�,��ʻ֤���� FROM DRIVER WHERE ������λ="+InstitutionName+";";
		SQL.databaseQuery(sql);
		ArrayList<String> ID = new ArrayList<String>();
		ArrayList<String> name= new ArrayList<String>();
		ArrayList<Date> birthday = new ArrayList<Date>();
		ArrayList<String> identity = new ArrayList<String>();
		ArrayList<String> tel = new ArrayList<String>();
		ArrayList<String> institutionName = new ArrayList<String>();
		ArrayList<String> sex = new ArrayList<String>();
		ArrayList<String> limit = new ArrayList<String>();
		
		ArrayList<ArrayList<String>> sendDocnoList = new ArrayList<ArrayList<String>>();
		try {
			while (SQL.rs.next()) {
				ID.add(SQL.rs.getString("˾�����"));
				name.add(SQL.rs.getString("˾������"));
				birthday.add(SQL.rs.getDate("��������"));
				identity.add(SQL.rs.getString("���֤��"));
				identity.add(SQL.rs.getString("��ϵ��ʽ"));
				identity.add(SQL.rs.getString("������λ"));
				identity.add(SQL.rs.getString("�Ա�"));
				identity.add(SQL.rs.getString("��ʻ֤����"));
			}
		} catch (SQLException e) {
			System.out.println("����˾����Ϣ����");
			e.printStackTrace();
		}

		for (int i = 0; i < ID.size(); i++) {
			DriverPO temp = new DriverPO(ID.get(i) , name.get(i) , birthday.get(i),identity.get(i),	tel.get(i),sex.get(i),limit.get(i));
			       DriverList.add(temp);
		}
		SQL.closeDatabase();
		return DriverList;
	}

	@Override
	public void addDriver(DriverPO po) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DriverList VALUES("+po.getDriverID()+","+po.getName()+","+po.getBirthday()+","+po.getIdentity()+","+po.getPhone_numer()+","+po.getSex()+","+po.getLimit()+")";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void changeDriver(DriverPO po) {
		// TODO Auto-generated method stub
//		String GatheringDocID = po.getID();
//		String sql = "UPDATE GatheringDocPOList SET �Ƿ�����='true'where �տ��="
//				+ GatheringDocID + ";";
//		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
	}



}
