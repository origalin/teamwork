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
	
	public ArrayList<String> getDirverID(String institutionID);//
	public ArrayList<String> getDirverName(String institutionID);
	public ArrayList<String> getCourierID(String institutionID);//
	public ArrayList<String> getTransferCenterID(String institutionID);//
	public String getName(String id);//根据机构id返回name  
	public String getStaffName(String id);//根据人员ID返回人员姓名
	public String getInstitutionName(String id);//根据人员ID返回机构姓名
	public String getInstitutionID(String id);//根据人员ID返回机构ID
	public String getCity(String institutionid);//根据机构id返回机构城市
	
	
	//financedata依赖我

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
	public void resetSalary(); //把所有人的属性改为未付款
	public void saveSalary(String id);//根据员工id 设为已付款
	public void saveDriverSalary(String id);//根据司机id 设为已付款
	public void saveRent(String id);//根据机构id 设为已付款
	
	public void resetRent();   //把所有机构设为未付租金
	Post getPosition(String staffID);//根据ID查找到这个人的职位
	double getBase(String staffID);//根据ID查找到这个人的基础工资
	double getBonus(String staffID);//根据ID查找到这个人的奖金
	double getPercentage(String staffID);//根据ID查找这个快递员的提成比例
	double getDriverCommision(String driverID);//根据ID查找这个司机每次的钱数
}
