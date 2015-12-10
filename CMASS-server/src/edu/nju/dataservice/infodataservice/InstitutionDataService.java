package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;

public interface InstitutionDataService extends Remote{
	
	public ArrayList<StaffPO> getStaffList(String institutionId)throws RemoteException;
	public void addStaff(StaffPO po)throws RemoteException;
	public void changeStaff(StaffPO po)throws RemoteException;
	public void deleteStaff(StaffPO po)throws RemoteException;
	

	
	public ArrayList<InstitutionPO> findInstitution()throws RemoteException;
	public void addInstitution (InstitutionPO po)throws RemoteException;
	public void changeInstitution(InstitutionPO po)throws RemoteException;
	public void deleteInstitution(InstitutionPO po)throws RemoteException;
	
	public InstitutionPO getInstitution(String id)throws RemoteException;
	public StaffPO getStaff(String id)throws RemoteException;
	
	
	public ArrayList<SalaryPO> getSalaryPOs()throws RemoteException;
	
	public SalaryPO getSalaryPO(String staffID)throws RemoteException;
	public void changeSalary(SalaryPO po)throws RemoteException;
	
	public boolean isStaffVaild(StaffPO po)throws RemoteException;
	public boolean isInstitutionVaild(InstitutionPO po)throws RemoteException;
	
}
