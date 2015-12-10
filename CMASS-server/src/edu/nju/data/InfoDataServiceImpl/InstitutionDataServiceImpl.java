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
	}

	@Override
	public ArrayList<StaffPO> getStaffList(String institutionId)
			throws RemoteException {

		ArrayList<StaffPO> staffList = new ArrayList<StaffPO>();
		String sql = "SELECT 工号,姓名,性别,身份证号,联系电话,所属机构,职位 FROM STAFF WHERE 所属机构='"
				+ institutionId + "';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				StaffPO po = new StaffPO(SQL.rs.getString("工号"),
						SQL.rs.getString("姓名"), SQL.rs.getString("性别"),
						SQL.rs.getString("身份证号"), SQL.rs.getString("联系电话"),
						SQL.rs.getString("所属机构"), Post.valueOf(SQL.rs
								.getString("职位")));
				staffList.add(po);
			}
		} catch (SQLException e) {
			System.out.println("查找车辆信息错误");
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
		
		String sql1 = "INSERT INTO PASSWORD('id','power') VALUES('"+po.getStaffID()+"','"+po.getPost().toString()+"');";
		SQL.databaseUpdate(sql1);
		SQL.closeDatabase();
		
		String sql2 = "INSERT INTO SALARY  VALUES('"+po.getStaffID()+"','"+5000+"','"+0+"','"+0+"','"+0+"');";
		SQL.databaseUpdate(sql2);
		SQL.closeDatabase();
		
		
	}

	@Override
	public void changeStaff(StaffPO po) throws RemoteException {
		String sql = "UPDATE STAFF SET 姓名='"+po.getName()+"',"+"性别='"+po.getSex()+"',身份证号='"+po.getIdenity()+"',"+"联系电话='"+po.getTel()+"',"+"所属机构='"+po.getInstitutation()+"',"+"职位='"+String.valueOf(po.getPost())+"' where 工号='"
	+ po.getStaffID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteStaff(StaffPO po) throws RemoteException {
		String sql ="DELETE FROM STAFF WHERE 工号='"+po.getStaffID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public ArrayList<InstitutionPO> findInstitution() throws RemoteException {

		InstitutionPO po = null;
		ArrayList<InstitutionPO>institutionList=new ArrayList<InstitutionPO>();
		String sql = "SELECT 机构编号,机构类型,机构名称,所在城市,上级机构,租金,是否付款 FROM INSTITUTION;";
		SQL.databaseQuery(sql);
		boolean flag = true;
		try {
			while (SQL.rs.next()) {

				if (SQL.rs.getInt("是否付款") == 0) {
					flag = false;
				}
				po =new InstitutionPO(SQL.rs.getString("机构编号"),
						Institutation.valueOf(SQL.rs.getString("机构类型")),
						SQL.rs.getString("机构名称"), SQL.rs.getString("所在城市"),
						SQL.rs.getString("上级机构"), SQL.rs.getDouble("租金"), flag);
				institutionList.add(po);
			}
		} catch (SQLException e) {
			System.out.println("查找信息错误");
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
		String sql = "UPDATE INSTITUTION SET 机构类型='"+po.getType().toString()+"',"+"机构名称='"+po.getName()+"',所在城市='"+po.getCity()+"',"+"上级机构='"+po.getParentInstitution()+"',"+"租金='"+po.getRent()+"',"+"是否付款='"+flag+"' where 机构编号='"
	+ po.getId() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();

	}

	@Override
	public InstitutionPO getInstitution(String id) throws RemoteException {

		InstitutionPO po = null;
		String sql = "SELECT 机构编号,机构类型,机构名称,所在城市,上级机构,租金,是否付款 FROM INSTITUTION WHERE 机构编号='"
				+ id + "';";
		SQL.databaseQuery(sql);
		boolean flag = true;
		try {
			while (SQL.rs.next()) {

				if (SQL.rs.getInt("是否付款") == 0) {
					flag = false;
				}
				po =new InstitutionPO(SQL.rs.getString("机构编号"),
						Institutation.valueOf(SQL.rs.getString("机构类型")),
						SQL.rs.getString("机构名称"), SQL.rs.getString("所在城市"),
						SQL.rs.getString("上级机构"), SQL.rs.getDouble("租金"), flag);
			}
		} catch (SQLException e) {
			System.out.println("查找信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

	@Override
	public StaffPO getStaff(String id) throws RemoteException {
		StaffPO po = null;
		String sql = "SELECT 工号,姓名,性别,身份证号,联系电话,所属机构,职位 FROM STAFF WHERE 工号='"
				+ id + "';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				po = new StaffPO(SQL.rs.getString("工号"),
						SQL.rs.getString("姓名"), SQL.rs.getString("性别"),
						SQL.rs.getString("身份证号"), SQL.rs.getString("联系电话"),
						SQL.rs.getString("所属机构"), Post.valueOf(SQL.rs
								.getString("职位")));
			}
		} catch (SQLException e) {
			System.out.println("查找信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

	@Override
	public ArrayList<SalaryPO> getSalaryPOs() throws RemoteException {
		SalaryPO po = null;
		ArrayList<SalaryPO> salaryPOs=new ArrayList<SalaryPO>();
		String sql = "SELECT 工号,基础工资,提成,奖金,是否付款 FROM SALARY ;";
		SQL.databaseQuery(sql);
		
		try {
			while (SQL.rs.next()) {
				boolean flag=true;
				if(SQL.rs.getInt("是否付款")==0){
					flag=false;
				}
				po = new SalaryPO(SQL.rs.getString("工号"),SQL.rs.getDouble("基础工资"),SQL.rs.getDouble("提成"),SQL.rs.getDouble("奖金"),flag);
		salaryPOs.add(po);
			}
		} catch (SQLException e) {
			System.out.println("查找信息错误");
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
		String sql = "UPDATE SALARY SET 基础工资='"+po.getBaseSalary()+"',"+"提成='"+po.getBonusSalary()+"',奖金='"+po.getPercentageSalary()+"',"+"是否付款='"+flag+"' where 工号='"
				+ po.getId() + "';";
					SQL.databaseUpdate(sql);
					SQL.closeDatabase();
		
	}
	@Override
	public SalaryPO getSalaryPO(String staffID) throws RemoteException {
		SalaryPO po = null;
		String sql = "SELECT 工号,基础工资,提成,奖金,是否付款 FROM SALARY WHERE 工号='"
				+ staffID + "';";
		SQL.databaseQuery(sql);
		
		try {
			while (SQL.rs.next()) {
				boolean flag=true;
				if(SQL.rs.getInt("是否付款")==0){
					flag=false;
				}
				po = new SalaryPO(SQL.rs.getString("工号"),SQL.rs.getDouble("基础工资"),SQL.rs.getDouble("提成"),SQL.rs.getDouble("奖金"),flag);
			}
		} catch (SQLException e) {
			System.out.println("查找信息错误");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return po;
	}

	@Override
	public boolean isStaffVaild(StaffPO po) throws RemoteException {
		boolean flag=false;
		String sql = "SELECT 工号 FROM STAFF ;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("工号");
				if(ID.equals(po.getStaffID())){
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
	public boolean isInstitutionVaild(InstitutionPO po) throws RemoteException {
		boolean flag=false;
		String sql = "SELECT 机构编号 FROM INSTITUTION ;";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("机构编号");
				if(ID.equals(po.getId())){
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
	public void deleteInstitution(InstitutionPO po) throws RemoteException {
			String sql ="DELETE FROM INSTITUTION WHERE 机构编号='"+po.getId()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
		
		for(StaffPO staffPO:getStaffList(po.getId())){
			deleteStaff(staffPO);
		}
		
	}

}
