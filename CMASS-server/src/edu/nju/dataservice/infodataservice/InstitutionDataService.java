package edu.nju.dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public interface InstitutionDataService extends Remote{
	
	public ArrayList<StaffPO> getStaffList(String institutionId)throws RemoteException;
	public void addStaff(StaffPO po)throws RemoteException;
	public void changeStaff(StaffPO po)throws RemoteException;
	public void deleteStaff(StaffPO po)throws RemoteException;
	

	
	public ArrayList<InstitutionPO> findInstitution()throws RemoteException;
	public void addInstitution (InstitutionPO po)throws RemoteException;
	public void changeInstitution(InstitutionPO po)throws RemoteException;
	
	public InstitutionPO getInstitution(String id)throws RemoteException;
	public StaffPO getStaff(String id)throws RemoteException;


}
