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

	public SystemDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<OperationPO> findOperationLog(Date beginTime, Date endTime) throws RemoteException{

		DateFormat df=DateFormat.getDateTimeInstance();
		ArrayList<OperationPO> operationList=new ArrayList<OperationPO>();
		String sql = "SELECT ����ʱ��,����,������,�������� FROM OPERATION WHERE ����ʱ�� BETWEEN '"+df.format(beginTime)+"' AND '"+df.format(endTime)+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				OperationPO operationPO=new OperationPO(SQL.rs.getTimestamp("����ʱ��"),SQL.rs.getString("����"),SQL.rs.getString("������"),SQL.rs.getString("��������"));
				operationList.add(operationPO);
			}
		} catch (SQLException e) {
			System.out.println("���Ҳ�����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return operationList;
	}

	@Override
	public void saveOperationLog(OperationPO po) throws RemoteException{
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateTimeInstance();
		String sql = "INSERT INTO OPERATION (����ʱ��,����,������,��������) VALUES('"+df.format(po.getDate())+"','"+po.getStaffID()+"','"+po.getStaffName()+"','"+po.getDescribration()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public String[] getPasswordAndPower(String id) throws RemoteException {
		// TODO Auto-generated method stub
		String result[]={"",""};
		String sql = "SELECT password,power FROM PASSWORD WHERE id='"+id+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				result[0]=SQL.rs.getString("password");
			result[1]=SQL.rs.getString("power");
			}
		} catch (SQLException e) {
			System.out.println("���Ҳ�����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return result;
	}

	@Override
	public void changePasswordAndPower(String[] str) throws RemoteException {
		// TODO Auto-generated method stub
		String sql = "UPDATE PASSWORD SET password='"+str[1]+"',"+"power='"+str[2]+"' where id='"
	+str[0]+ "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
		
	}








}
