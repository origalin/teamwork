package edu.nju.data.InfoDataServiceImpl;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.DriverPO;

public class DriverDataServiceImpl implements DriverDataService{

	@Override
	public ArrayList<DriverPO> findDriver(String InstitutionName) {
		ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
		String sql = "SELECT ˾�����,˾������,�Ա�,��������,���֤��,��ϵ��ʽ,������λ,��ʻ֤��ʼ����,��ʻ֤ʧЧ���� FROM DRIVER WHERE ������λ='"+InstitutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				DriverPO driverPO=new DriverPO(SQL.rs.getString("˾�����"),SQL.rs.getString("˾������"),SQL.rs.getString("�Ա�"),SQL.rs.getDate("��������"),SQL.rs.getString("���֤��"),SQL.rs.getString("��ϵ��ʽ"),SQL.rs.getString("������λ"),SQL.rs.getDate("��ʻ֤��ʼ����"),SQL.rs.getDate("��ʻ֤ʧЧ����"));
				driverList.add(driverPO);
			}
		} catch (SQLException e) {
			System.out.println("����˾����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return driverList;
	}

	@Override
	public void changeDriver(DriverPO po) {
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE DRIVER SET ˾������='"+po.getName()+"',"+"�Ա�='"+po.getSex()+"',��������='"+df.format(po.getBirthday())+"',"+"���֤��='"+po.getIdentity()+"',"+"��ϵ��ʽ='"+po.getTel()+"',"+"������λ='"+po.getInstitution()+"',"+"��ʻ֤��ʼ����='"+df.format(po.getBeginLimit())+"',"+"��ʻ֤ʧЧ����='"+df.format(po.getEndLimit())+"' where ˾�����='"
	+ po.getDriverID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteDriver(DriverPO po) {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM DRIVER WHERE ˾�����='"+po.getDriverID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void addDriver(DriverPO po) {
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "INSERT INTO DRIVER VALUES('"+po.getDriverID()+"','"+po.getName()+"','"+po.getSex()+"','"+df.format(po.getBirthday())+"','"+po.getIdentity()+"','"+po.getTel()+"','"+po.getInstitution()+"','"+df.format(po.getBeginLimit())+"','"+df.format(po.getEndLimit())+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}


}
