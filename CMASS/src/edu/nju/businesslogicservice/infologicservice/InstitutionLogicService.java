package edu.nju.businesslogicservice.infologicservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public interface InstitutionLogicService {
	
	
	public ArrayList<StaffVO> getStaffVOList(String institutionName)throws RemoteException;//获得staff的列表
	public ArrayList<InstitutionVO> getInstitutionVOList()throws RemoteException;//获得机构列表

	public void saveSalary (SalaryPO po)throws RemoteException;//保存薪资PO
	public SalaryPO getSalary(String staffID)throws RemoteException;
	
	public void saveStaff(StaffPO po)throws RemoteException;//保存员工信息
	public void saveInstitution (InstitutionPO po)throws RemoteException;//保存机构信息
	
	public void deleteInstitution(InstitutionPO po)throws RemoteException;
	public void deleteStaff(StaffPO po)throws RemoteException;
	
	//collection依赖我
	
	
	public ArrayList<String> getCourierID(String institutionID)throws RemoteException;//
	public String getTransferCenterID(String institutionID)throws RemoteException;//
	public ArrayList<String> getSubInstitutionID(String institutionID)throws RemoteException;//
	
	public String getName(String institutionId)throws RemoteException;//根据机构id返回name  
	public String getStaffName(String staffid)throws RemoteException;//根据人员ID返回人员姓名
	public String getInstitutionName(String staffid)throws RemoteException;//根据人员ID返回机构姓名
	public String getInstitutionID(String Staffid)throws RemoteException;//根据人员ID返回机构ID
	public String getCity(String institutionid)throws RemoteException;//根据机构id返回机构城市
	
	
	//financedata依赖我

	public ArrayList<InstitutionPO> getUnpaidInstitutionList()throws RemoteException;
	public ArrayList<StaffPO> getUnpaidStaffList()throws RemoteException;
	public void resetSalary()throws RemoteException; //把所有人的属性改为未付款
	public void saveSalary(String id)throws RemoteException;//根据员工id 设为已付款
	public void saveRent(String id)throws RemoteException;//根据机构id 设为已付款	
	public void resetRent()throws RemoteException;   //把所有机构设为未付租金
	Post getPosition(String staffID)throws RemoteException;//根据ID查找到这个人的职位
	double getBase(String staffID)throws RemoteException;//根据ID查找到这个人的基础工资
	double getBonus(String staffID)throws RemoteException;//根据ID查找到这个人的奖金
	double getPercentage(String staffID)throws RemoteException;//根据ID查找这个快递员的提成比例
	
	
}
