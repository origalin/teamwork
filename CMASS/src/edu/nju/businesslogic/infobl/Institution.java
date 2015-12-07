package edu.nju.businesslogic.infobl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public class Institution implements InstitutionLogicService{

	@Override
	public ArrayList<String> getCourierID(String institutionID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTransferCenterID(String institutionID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getSubInstitutionID(String institutionID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStaffName(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstitutionName(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstitutionID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCity(String institutionid) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InstitutionPO> getUnpaidInstitutionList()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<StaffPO> getUnpaidStaffList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetSalary() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSalary(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveRent(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetRent() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Post getPosition(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getBase(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBonus(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPercentage(String staffID) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}




}
