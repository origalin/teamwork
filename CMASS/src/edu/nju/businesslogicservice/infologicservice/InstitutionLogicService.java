package edu.nju.businesslogicservice.infologicservice;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	public int getSalary(int id);//获得人员的工资
	public ArrayList<StaffVO> getStaffVO();//获得staff的列表
	public ArrayList<InstitutionVO> getInstitutionVOList();//获得机构列表
	public double  getDistance(String city1,String city2);//获得城市间的距离
	
	
	public void saveSalary (StaffPO po);//保存薪资PO
	public void saveStaff(StaffPO po);//保存员工信息
	public void saveInstitution (InstitutionPO po);//保存机构信息
	public void saveDistance(String city,String city2,double distance);//保存距离信息
	//collection依赖我
	public double getDistance(String city);//构造时调用两个参数的方法
	public String[][] getCouriers();//返回登陆机构的所有人员名单，第一个是ID 第二个是名字
	public String[][] getBusinessHalls(String id);//根据中转中心ID列出下属机构
	public String[][] getDrivers();
	public String[][] getTransfers(String id);//根据营业厅ID列出上属机构

	//financedata依赖我

	public ArrayList<InstitutionPO> getUnpaidInstitutionList();
	public ArrayList<StaffPO> getUnpaidStaffList();
}
