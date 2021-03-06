package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;

public class CarDataServiceImpl extends UnicastRemoteObject implements CarDataService{

	public CarDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<CarPO> findCar(String institutionName) throws RemoteException{
		ArrayList<CarPO> carList = new ArrayList<CarPO>();
		String sql = "SELECT 车辆代号,发动机号,车牌号,底盘号,车辆单位,购买时间,服役时间 FROM CAR WHERE 车辆单位='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				CarPO carPO=new CarPO(SQL.rs.getString("车辆代号"),SQL.rs.getString("发动机号"),SQL.rs.getString("车牌号"),SQL.rs.getString("底盘号"),SQL.rs.getString("车辆单位"),SQL.rs.getDate("购买时间"),SQL.rs.getInt("服役时间"));
				carList.add(carPO);
			}
		} catch (SQLException e) {
			System.out.println("查找车辆信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return carList;
	}

	@Override
	public void addCar(CarPO po) throws RemoteException{
		DateFormat df=DateFormat.getDateInstance();
		String sql = "INSERT INTO CAR VALUES('"+po.getCarID()+"','"+po.getEngineID()+"','"+po.getPlateID()+"','"+po.getUnderpanID()+"','"+po.getInstitutionName()+"','"+df.format(po.getBuyTime())+"','"+po.getYears()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void changeCar(CarPO po) throws RemoteException{
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE CAR SET 发动机号='"+po.getEngineID()+"',"+"车牌号='"+po.getPlateID()+"',底盘号='"+po.getUnderpanID()+"',"+"车辆单位='"+po.getInstitutionName()+"',"+"购买时间='"+df.format(po.getBuyTime())+"',"+"服役时间='"+po.getYears()+"' where 车辆代号='"
	+ po.getCarID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteCar(CarPO po) throws RemoteException{
		String sql ="DELETE FROM CAR WHERE 车辆代号='"+po.getCarID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public boolean isVaild(String id,String institutionName) throws RemoteException{
		boolean flag=false;
		String sql = "SELECT 车辆代号 FROM CAR WHERE 车辆单位='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("车辆代号");
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

}
