package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.po.Institutation;
import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;

public class InstitutionDataServiceImpl extends UnicastRemoteObject implements
		InstitutionDataService {

	public InstitutionDataServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<StaffPO> getStaffList(String institutionId)
			throws RemoteException {

		ArrayList<StaffPO> staffList = new ArrayList<StaffPO>();
		String sql = "SELECT ����,����,�Ա�,���֤��,��ϵ�绰,��������,ְλ FROM STAFF WHERE ��������='"
				+ institutionId + "';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				StaffPO po = new StaffPO(SQL.rs.getString("����"),
						SQL.rs.getString("����"), SQL.rs.getString("�Ա�"),
						SQL.rs.getString("���֤��"), SQL.rs.getString("��ϵ�绰"),
						SQL.rs.getString("��������"), Post.valueOf(SQL.rs
								.getString("ְλ")));
				staffList.add(po);
			}
		} catch (SQLException e) {
			System.out.println("���ҳ�����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return staffList;
	}

	@Override
	public void addStaff(StaffPO po) throws RemoteException {
	
		String sql = "INSERT INTO STAFF VALUES('"+po.getStaffID()+"','"+po.getName()+"','"+po.getSex()+"','"+po.getIdenity()+"','"+po.getTel()+"','"+po.getInstitutation()+"','"+po.getPost().toString()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void changeStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<InstitutionPO> findInstitution() throws RemoteException {

		InstitutionPO po = null;
		ArrayList<InstitutionPO>institutionList=new ArrayList<InstitutionPO>();
		String sql = "SELECT �������,��������,��������,���ڳ���,�ϼ�����,���,�Ƿ񸶿� FROM INSTITUTION;";
		SQL.databaseQuery(sql);
		boolean flag = true;
		try {
			while (SQL.rs.next()) {

				if (SQL.rs.getInt("�Ƿ񸶿�") == 0) {
					flag = false;
				}
				po =new InstitutionPO(SQL.rs.getString("�������"),
						Institutation.valueOf(SQL.rs.getString("��������")),
						SQL.rs.getString("��������"), SQL.rs.getString("���ڳ���"),
						SQL.rs.getString("�ϼ�����"), SQL.rs.getDouble("���"), flag);
				institutionList.add(po);
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return institutionList;
	}

	@Override
	public void addInstitution(InstitutionPO po) throws RemoteException {
	int flag=0;
		if (po.isPaid()) {
			flag =1;
		}
		String sql = "INSERT INTO INSTITUTION VALUES('"+po.getId()+"','"+po.getType().toString()+"','"+po.getName()+"','"+po.getCity()+"','"+po.getParentInstitution()+"','"+po.getRent()+"','"+flag+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void changeInstitution(InstitutionPO po) throws RemoteException {
		int flag=0;
		if (po.isPaid()) {
			flag =1;
		}
		String sql = "UPDATE INSTITUTION SET ��������='"+po.getType().toString()+"',"+"��������='"+po.getName()+"',���ڳ���='"+po.getCity()+"',"+"�ϼ�����='"+po.getParentInstitution()+"',"+"���='"+po.getRent()+"',"+"�Ƿ񸶿�='"+flag+"' where �������='"
	+ po.getId() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public InstitutionPO getInstitution(String id) throws RemoteException {

		InstitutionPO po = null;
		String sql = "SELECT �������,��������,��������,���ڳ���,�ϼ�����,���,�Ƿ񸶿� FROM INSTITUTION WHERE �������='"
				+ id + "';";
		SQL.databaseQuery(sql);
		boolean flag = true;
		try {
			while (SQL.rs.next()) {

				if (SQL.rs.getInt("�Ƿ񸶿�") == 0) {
					flag = false;
				}
				po =new InstitutionPO(SQL.rs.getString("�������"),
						Institutation.valueOf(SQL.rs.getString("��������")),
						SQL.rs.getString("��������"), SQL.rs.getString("���ڳ���"),
						SQL.rs.getString("�ϼ�����"), SQL.rs.getDouble("���"), flag);
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

	@Override
	public StaffPO getStaff(String id) throws RemoteException {
		StaffPO po = null;
		String sql = "SELECT ����,����,�Ա�,���֤��,��ϵ�绰,��������,ְλ FROM STAFF WHERE ����='"
				+ id + "';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				po = new StaffPO(SQL.rs.getString("����"),
						SQL.rs.getString("����"), SQL.rs.getString("�Ա�"),
						SQL.rs.getString("���֤��"), SQL.rs.getString("��ϵ�绰"),
						SQL.rs.getString("��������"), Post.valueOf(SQL.rs
								.getString("ְλ")));
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

	@Override
	public ArrayList<SalaryPO> getSalaryPOs() throws RemoteException {
		SalaryPO po = null;
		ArrayList<SalaryPO> salaryPOs=new ArrayList<SalaryPO>();
		String sql = "SELECT ����,��������,���,����,�Ƿ񸶿� FROM SALARY ;";
		SQL.databaseQuery(sql);
		
		try {
			while (SQL.rs.next()) {
				boolean flag=true;
				if(SQL.rs.getInt("�Ƿ񸶿�")==0){
					flag=false;
				}
				po = new SalaryPO(SQL.rs.getString("����"),SQL.rs.getDouble("��������"),SQL.rs.getDouble("���"),SQL.rs.getDouble("����"),flag);
		salaryPOs.add(po);
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return salaryPOs;
	}

	

	@Override
	public void changeSalary(SalaryPO po) throws RemoteException {
		int flag=0;
		if(po.isPaid()){
			flag=1;
		}
		String sql = "UPDATE SALARY SET ��������='"+po.getBaseSalary()+"',"+"���='"+po.getBonusSalary()+"',����='"+po.getPercentageSalary()+"',"+"�Ƿ񸶿�='"+flag+"' where ����='"
				+ po.getId() + "';";
					SQL.databaseUpdate(sql);
					SQL.closeDatabase();
		
	}
	@Override
	public SalaryPO getSalaryPO(String staffID) throws RemoteException {
		SalaryPO po = null;
		String sql = "SELECT ����,��������,���,����,�Ƿ񸶿� FROM SALARY WHERE ����='"
				+ staffID + "';";
		SQL.databaseQuery(sql);
		
		try {
			while (SQL.rs.next()) {
				boolean flag=true;
				if(SQL.rs.getInt("�Ƿ񸶿�")==0){
					flag=false;
				}
				po = new SalaryPO(SQL.rs.getString("����"),SQL.rs.getDouble("��������"),SQL.rs.getDouble("���"),SQL.rs.getDouble("����"),flag);
			}
		} catch (SQLException e) {
			System.out.println("������Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

}
