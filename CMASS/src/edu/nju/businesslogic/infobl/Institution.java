package edu.nju.businesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public class Institution implements InstitutionLogicService{
	InstitutionDataService institutionDataService;
public Institution() {
		// TODO Auto-generated constructor stub
		
		super();
		this.institutionDataService=DataFactory.getInstitutionDataService();
	}
	@Override
	public ArrayList<StaffVO> getStaffVOList(String institutionName)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InstitutionVO> getInstitutionVOList()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveSalary(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveInstitution(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInstitution(InstitutionPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> getCourierID(String institutionID)
			throws RemoteException {
		ArrayList<String> courierList=new ArrayList<String>();
		ArrayList<StaffPO>staffPOs=institutionDataService.getStaffList(institutionID);
		for(StaffPO po:staffPOs){
			courierList.add(po.getStaffID());
		}
		return courierList;
	}

	@Override
	public String getTransferCenterID(String institutionID)
			throws RemoteException {
		
		return institutionDataService.getInstitution(institutionID).getParentInstitution();
	}

	@Override
	public ArrayList<String> getSubInstitutionID(String institutionID)
			throws RemoteException {
		ArrayList<String>subInstitutionList=new ArrayList<String>();
		ArrayList<InstitutionPO>institutionPOs=new ArrayList<InstitutionPO>();
		institutionPOs=institutionDataService.findInstitution();
		for(InstitutionPO po:institutionPOs){
			if(po.getParentInstitution().equals(institutionID)){
				subInstitutionList.add(po.getId());
			}
		}
		return subInstitutionList;
	}

	@Override
	public String getName(String id) throws RemoteException {
		return institutionDataService.getInstitution(id).getName();
	}

	@Override
	public String getStaffName(String id) throws RemoteException {
	
		return institutionDataService.getStaff(id).getName();
	}

	@Override
	public String getInstitutionName(String id) throws RemoteException {

		String institution=institutionDataService.getStaff(id).getInstitutation();
		return institutionDataService.getInstitution(institution).getName();
	}

	@Override
	public String getInstitutionID(String id) throws RemoteException {
	
		return institutionDataService.getStaff(id).getInstitutation();
	}

	@Override
	public String getCity(String institutionid) throws RemoteException {
		
		return institutionDataService.getInstitution(institutionid).getCity();
	}

	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList()
			throws RemoteException {
		ArrayList<InstitutionPO>unPaidInstitutionList=new ArrayList<InstitutionPO>();
		ArrayList<InstitutionPO>institutionPOs=institutionDataService.findInstitution();
		
		for(InstitutionPO po:institutionPOs){
			if(!po.isPaid()){
				unPaidInstitutionList.add(po);
			}
		}
		return unPaidInstitutionList;
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() throws RemoteException {
		ArrayList<StaffPO>unPaidStaffList=new ArrayList<StaffPO>();
	
		ArrayList<SalaryPO>salaryList=institutionDataService.getSalaryPOs();
		for(SalaryPO po:salaryList){
		
					if(!po.isPaid()){
						unPaidStaffList.add(institutionDataService.getStaff(po.getId()));
			}
		}
		return unPaidStaffList;
	}

	@Override
	public void resetSalary() throws RemoteException {
	
		
		ArrayList<SalaryPO>salaryList=institutionDataService.getSalaryPOs();
		for(SalaryPO po:salaryList){
			po.setPaid(false);
			institutionDataService.changeSalary(po);
			}
		}
		
		


	@Override
	public void saveSalary(String id) throws RemoteException {
		
		ArrayList<SalaryPO>salaryList=institutionDataService.getSalaryPOs();
		for(SalaryPO po:salaryList){
			po.setPaid(true);
			institutionDataService.changeSalary(po);
			}
		}
		
	

	@Override
	public void saveRent(String id) throws RemoteException {
		ArrayList<InstitutionPO> institutionPOs=institutionDataService.findInstitution();
		for(InstitutionPO po:institutionPOs){
			po.setPaid(true);
			institutionDataService.changeInstitution(po);
		}
		
	}

	@Override
	public void resetRent() throws RemoteException {
		ArrayList<InstitutionPO> institutionPOs=institutionDataService.findInstitution();
		for(InstitutionPO po:institutionPOs){
			po.setPaid(false);
			institutionDataService.changeInstitution(po);
		}
		
	}

	@Override
	public Post getPosition(String staffID) throws RemoteException {
	
		return institutionDataService.getStaff(staffID).getPost();
	}

	@Override
	public double getBase(String staffID) throws RemoteException {
		return institutionDataService.getSalaryPO(staffID).getBaseSalary();
	}

	@Override
	public double getBonus(String staffID) throws RemoteException {
		return institutionDataService.getSalaryPO(staffID).getBonusSalary();
	}

	@Override
	public double getPercentage(String staffID) throws RemoteException {
		return institutionDataService.getSalaryPO(staffID).getPercentageSalary();
	}



}
