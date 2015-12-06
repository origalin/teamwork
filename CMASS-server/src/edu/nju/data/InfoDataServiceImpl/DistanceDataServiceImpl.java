package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.po.DistancePO;

public class DistanceDataServiceImpl extends UnicastRemoteObject implements DistanceDataService{

	public DistanceDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public double getDistance(String city1, String city2) throws RemoteException{
		// TODO Auto-generated method stub
		double distance=0;
		String sql = "SELECT city1,city2,distance FROM DISTANCE WHERE city1= '"+city1+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			if(SQL.rs.getString("city2").equals(city2)){
				distance=SQL.rs.getDouble("distance");
			}
			}
		} catch (SQLException e) {
			System.out.println("ªÒ»°æ‡¿Î¥ÌŒÛ");
			e.printStackTrace();
		}
		if(distance==0){
			String sql1 = "SELECT city1,city2,distance FROM DISTANCE WHERE city1= '"+city2+"';";
			SQL.databaseQuery(sql1);
			try {
				while (SQL.rs.next()) {
				if(SQL.rs.getString("city2").equals(city1)){
					distance=SQL.rs.getDouble("distance");
				}
				}
			} catch (SQLException e) {
				System.out.println("ªÒ»°æ‡¿Î¥ÌŒÛ");
				e.printStackTrace();
			} 	
		}
		SQL.closeDatabase();
		return distance;
	}


	@Override
	public void changeDistance(DistancePO po) throws RemoteException{
		// TODO Auto-generated method stub
		int id=0;
		String sql = "SELECT id,city1,city2 FROM DISTANCE WHERE city1= '"+po.getCity1()+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			if(SQL.rs.getString("city2").equals(po.getCity2())){
			id=SQL.rs.getInt("id");
			}
			}
		} catch (SQLException e) {
			System.out.println("ªÒ»°æ‡¿Î¥ÌŒÛ");
			e.printStackTrace();
		}
		if(id==0){
			String sql1 = "SELECT id,city1,city2,distance FROM DISTANCE WHERE city1= '"+po.getCity2()+"';";
			SQL.databaseQuery(sql1);
			try {
				while (SQL.rs.next()) {
				if(SQL.rs.getString("city2").equals(po.getCity1())){
				id=SQL.rs.getInt("id");
				}
				}
			} catch (SQLException e) {
				System.out.println("ªÒ»°æ‡¿Î¥ÌŒÛ");
				e.printStackTrace();
			} 	
		}
	po.setId(id);
		String sql2 = "UPDATE DISTANCE SET distance='"+po.getDistance()+"' WHERE id= '"+po.getId()+"';";
		SQL.databaseUpdate(sql2);
		SQL.closeDatabase();
	}

	@Override
	public void addDistance(DistancePO po) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO DISTANCE (city1,city2,distance)VALUES('"+po.getCity1()+"','"+po.getCity2()+"','"+po.getDistance()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}
	
	

}
