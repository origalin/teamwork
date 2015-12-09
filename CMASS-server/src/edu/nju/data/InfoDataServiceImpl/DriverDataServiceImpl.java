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
		String sql = "SELECT ˾�����,˾������,�Ա�,��������,���֤��,��ϵ��ʽ,������λ,��ʻ֤��ʼ����,��ʻ֤ʧЧ����,����,�Ƿ񸶿� FROM DRIVER WHERE ������λ='"+InstitutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			boolean flag=true;
			if(SQL.rs.getInt("�Ƿ񸶿�")==0){
				flag=false;
			}
				DriverPO driverPO=new DriverPO(SQL.rs.getString("˾�����"),SQL.rs.getString("˾������"),SQL.rs.getString("�Ա�"),SQL.rs.getDate("��������"),SQL.rs.getString("���֤��"),SQL.rs.getString("��ϵ��ʽ"),SQL.rs.getString("������λ"),SQL.rs.getDate("��ʻ֤��ʼ����"),SQL.rs.getDate("��ʻ֤ʧЧ����"),SQL.rs.getDouble("����"),flag);
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
	public void changeDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE DRIVER SET ˾������='"+po.getName()+"',"+" �Ա�='"+po.getSex()+"',��������='"+df.format(po.getBirthday())+"',"+"���֤��='"+po.getIdentity()+"',"+"��ϵ��ʽ='"+po.getTel()+"',"+"������λ='"+po.getInstitution()+"',"+"��ʻ֤��ʼ����='"+df.format(po.getBeginLimit())+"',"+"��ʻ֤ʧЧ����='"+df.format(po.getEndLimit())+"' where ˾�����='"
	+ po.getDriverID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteDriver(DriverPO po) throws RemoteException{
		// TODO Auto-generated method stub
		String sql ="DELETE FROM DRIVER WHERE ˾�����='"+po.getDriverID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		System.out.println("ɾ���ɹ�");
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
		String sql = "SELECT ˾����� FROM DRIVER WHERE ������λ='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("˾�����");
				if(ID.equals(id)){
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("�жϴ���");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return flag;
	}

	@Override
	public DriverPO getDriver(String id) throws RemoteException {
		// TODO Auto-generated method stub
		DriverPO driverPO = null;
		String sql = "SELECT ˾�����,˾������,�Ա�,��������,���֤��,��ϵ��ʽ,������λ,��ʻ֤��ʼ����,��ʻ֤ʧЧ����,����,�Ƿ񸶿� FROM DRIVER WHERE ˾�����='"+id+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
			boolean flag=true;
			if(SQL.rs.getInt("�Ƿ񸶿�")==0){
				flag=false;
			}
		driverPO=new DriverPO(SQL.rs.getString("˾�����"),SQL.rs.getString("˾������"),SQL.rs.getString("�Ա�"),SQL.rs.getDate("��������"),SQL.rs.getString("���֤��"),SQL.rs.getString("��ϵ��ʽ"),SQL.rs.getString("������λ"),SQL.rs.getDate("��ʻ֤��ʼ����"),SQL.rs.getDate("��ʻ֤ʧЧ����"),SQL.rs.getDouble("����"),flag);
			}
		} catch (SQLException e) {
			System.out.println("����˾����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return driverPO;
	}

	@Override
	public void saveMoney(Double money,String id) throws RemoteException {
		
		String sql = "UPDATE DRIVER SET ����='"+money+"' where ˾�����='"
	+id+ "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
	}
}
