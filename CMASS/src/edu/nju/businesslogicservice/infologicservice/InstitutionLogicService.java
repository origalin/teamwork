package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	public int getSalary(int id);//获得人员的工资
	public ArrayList<StaffVO> getStaffVO();//获得staff的列表
	public ArrayList<InstitutionVO> getInstitutionVOList();//获得机构列表

	
	
	public void saveSalary (StaffPO po);//保存薪资PO
	public void saveStaff(StaffPO po);//保存员工信息
	public void saveInstitution (InstitutionPO po);//保存机构信息
	//collection依赖我
	
	public String[][] getCouriers();//返回登陆机构的所有人员名单，第一个是ID 第二个是名字
	public String[][] getBusinessHalls(String id);//根据中转中心ID列出下属机构
	public String[][] getDrivers(String id);     //根据机构id列出所有司机姓名
	public String[][] getTransfers(String id);//根据营业厅ID列出上属机构
	public String getCityAndName(String id);//根据机构id返回city+name  
	public String getStaffName(String id);//根据人员ID返回人员姓名
	public String getInstitutionName(String id);//根据人员ID返回机构姓名
	public String getInstitutionID(String id);//根据人员ID返回机构ID
	
	
	//financedata依赖我

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
	
	
	public void resetSalary();

	public void resetRent();
	
	Post getPosition(String staffID);//根据ID查找到这个人的职位
	double getBase(String staffID);//根据ID查找到这个人的基础工资
	double getBonus(String staffID);//根据ID查找到这个人的奖金
	double getPercentage(String staffID);//根据ID查找这个快递员的提成比例
	double getDriverCommision(String driverID);//根据ID查找这个司机每次的钱数



}
