package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.DriverPO;

public class DriverDataServiceImpl extends UnicastRemoteObject implements DriverDataService{

	public DriverDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<DriverPO> findDriver(String InstitutionName) throws RemoteException {
		ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
		String sql = "SELECT 司机编号,司机姓名,性别,出生日期,身份证号,联系方式,车辆单位,行驶证初始日期,行驶证失效日期,工资,是否付款 FROM DRIVER WHERE 车辆单位='"+InstitutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			boolean flag=true;
			if(SQL.rs.getInt("是否付款")==0){
				flag=false;
			}
				DriverPO driverPO=new DriverPO(SQL.rs.getString("司机编号"),SQL.rs.getString("司机姓名"),SQL.rs.getString("性别"),SQL.rs.getDate("出生日期"),SQL.rs.getString("身份证号"),SQL.rs.getString("联系方式"),SQL.rs.getString("车辆单位"),SQL.rs.getDate("行驶证初始日期"),SQL.rs.getDate("行驶证失效日期"),SQL.rs.getDouble("工资"),flag);
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
	public void changeDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE DRIVER SET 司机姓名='"+po.getName()+"',"+" 性别='"+po.getSex()+"',出生日期='"+df.format(po.getBirthday())+"',"+"身份证号='"+po.getIdentity()+"',"+"联系方式='"+po.getTel()+"',"+"车辆单位='"+po.getInstitution()+"',"+"行驶证初始日期='"+df.format(po.getBeginLimit())+"',"+"行驶证失效日期='"+df.format(po.getEndLimit())+"' where 司机编号='"
	+ po.getDriverID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		String sql ="DELETE FROM DRIVER WHERE 司机编号='"+po.getDriverID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("删除成功");
	}

	@Override
	public void addDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "INSERT INTO DRIVER VALUES('"+po.getDriverID()+"','"+po.getName()+"','"+po.getSex()+"','"+df.format(po.getBirthday())+"','"+po.getIdentity()+"','"+po.getTel()+"','"+po.getInstitution()+"','"+df.format(po.getBeginLimit())+"','"+df.format(po.getEndLimit())+"','"+10+"','"+0+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}
	
	@Override
	public boolean isVaild(String id,String institutionName) throws RemoteException{
		boolean flag=false;
		String sql = "SELECT 司机编号 FROM DRIVER WHERE 车辆单位='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("司机编号");
				if(ID.equals(id)){
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("判断错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return flag;
	}

	@Override
	public DriverPO getDriver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DriverPO driverPO = null;
		String sql = "SELECT 司机编号,司机姓名,性别,出生日期,身份证号,联系方式,车辆单位,行驶证初始日期,行驶证失效日期,工资,是否付款 FROM DRIVER WHERE 司机编号='"+id+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			boolean flag=true;
			if(SQL.rs.getInt("是否付款")==0){
				flag=false;
			}
		driverPO=new DriverPO(SQL.rs.getString("司机编号"),SQL.rs.getString("司机姓名"),SQL.rs.getString("性别"),SQL.rs.getDate("出生日期"),SQL.rs.getString("身份证号"),SQL.rs.getString("联系方式"),SQL.rs.getString("车辆单位"),SQL.rs.getDate("行驶证初始日期"),SQL.rs.getDate("行驶证失效日期"),SQL.rs.getDouble("工资"),flag);
			}
		} catch (SQLException e) {
			System.out.println("查找司机信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return driverPO;
	}

	@Override
	public void saveMoney(Double money,String id) throws RemoteException {
		
		String sql = "UPDATE DRIVER SET 工资='"+money+"' where 司机编号='"
	+id+ "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
	}
}
