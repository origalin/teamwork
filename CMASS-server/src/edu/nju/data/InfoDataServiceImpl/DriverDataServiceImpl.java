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
		String sql = "SELECT 司机编号,司机姓名,性别,出生日期,身份证号,联系方式,车辆单位,行驶证初始日期,行驶证失效日期 FROM DRIVER WHERE 车辆单位='"+InstitutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				DriverPO driverPO=new DriverPO(SQL.rs.getString("司机编号"),SQL.rs.getString("司机姓名"),SQL.rs.getString("性别"),SQL.rs.getDate("出生日期"),SQL.rs.getString("身份证号"),SQL.rs.getString("联系方式"),SQL.rs.getString("车辆单位"),SQL.rs.getDate("行驶证初始日期"),SQL.rs.getDate("行驶证失效日期"));
				driverList.add(driverPO);
			}
		} catch (SQLException e) {
			System.out.println("查找司机信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return driverList;
	}

	@Override
	public void changeDriver(DriverPO po) {
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE DRIVER SET 司机姓名='"+po.getName()+"',"+"性别='"+po.getSex()+"',出生日期='"+df.format(po.getBirthday())+"',"+"身份证号='"+po.getIdentity()+"',"+"联系方式='"+po.getTel()+"',"+"车辆单位='"+po.getInstitution()+"',"+"行驶证初始日期='"+df.format(po.getBeginLimit())+"',"+"行驶证失效日期='"+df.format(po.getEndLimit())+"' where 司机编号='"
	+ po.getDriverID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteDriver(DriverPO po) {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM DRIVER WHERE 司机编号='"+po.getDriverID()+"';" ;
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
