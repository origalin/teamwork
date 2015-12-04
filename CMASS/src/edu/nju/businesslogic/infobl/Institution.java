package edu.nju.businesslogic.infobl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public class Institution implements InstitutionLogicService{

	@Override
	public int getSalary(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<StaffVO> getStaffVO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InstitutionVO> getInstitutionVOList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSalary(StaffPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStaff(StaffPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveInstitution(InstitutionPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getDirverID(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDirverName(String driverID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getCourierID(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferCenterID(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getSubInstitutionID(String institutionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStaffName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstitutionName(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstitutionID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCity(String institutionid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetSalary() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSalary(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDriverSalary(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRent(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetRent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post getPosition(String staffID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBase(String staffID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBonus(String staffID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPercentage(String staffID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDriverCommision(String driverID) {
		// TODO Auto-generated method stub
		return 0;
	}



}
