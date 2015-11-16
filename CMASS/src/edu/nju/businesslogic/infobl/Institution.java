package edu.nju.businesslogic.infobl;

import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.InstitutionPO;
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
	public double getDistance(String city1, String city2) {
		// TODO Auto-generated method stub
		return 0;
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
	public void saveDistance(String city, String city2, double distance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getDistance(String city) {
		// TODO Auto-generated method stub
		return 0;
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

}
