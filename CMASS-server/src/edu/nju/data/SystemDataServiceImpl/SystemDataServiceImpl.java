package edu.nju.data.SystemDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.systemdataservice.SystemDataService;
import edu.nju.po.AccountPO;
import edu.nju.po.DriverPO;
import edu.nju.po.OperationPO;

public class SystemDataServiceImpl extends UnicastRemoteObject implements SystemDataService {

	protected SystemDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<OperationPO> findOperationLog(Date beginTime, Date endTime) throws RemoteException{

		DateFormat df=DateFormat.getDateTimeInstance();
		ArrayList<OperationPO> operationList=new ArrayList<OperationPO>();
		String sql = "SELECT 操作时间,工号,操作人,操作描述 FROM OPERATION WHERE 操作时间 BETWEEN '"+df.format(beginTime)+"' AND '"+df.format(endTime)+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				OperationPO operationPO=new OperationPO(SQL.rs.getTimestamp("操作时间"),SQL.rs.getString("工号"),SQL.rs.getString("操作人"),SQL.rs.getString("操作描述"));
				operationList.add(operationPO);
			}
		} catch (SQLException e) {
			System.out.println("查找操作信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return operationList;
	}

	@Override
	public void saveOperationLog(OperationPO po) throws RemoteException{
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateTimeInstance();
		String sql = "INSERT INTO OPERATION VALUES('"+df.format(po.getDate())+"','"+po.getStaffID()+"','"+po.getStaffName()+"','"+po.getDescribration()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}




}
