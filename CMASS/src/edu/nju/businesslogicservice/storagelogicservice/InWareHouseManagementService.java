package edu.nju.businesslogicservice.storagelogicservice;

import java.rmi.RemoteException;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.vo.InWareHouseDocVO;

public interface InWareHouseManagementService {
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID,String currInstitutionID) throws DatabaseNULLException ;
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID,String currInstitution) throws DatabaseNULLException, RemoteException ;
	public void updateInWareHouseDoc(InWareHouseDocVO out);
	

}
