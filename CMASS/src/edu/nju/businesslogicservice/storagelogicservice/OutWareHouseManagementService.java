package edu.nju.businesslogicservice.storagelogicservice;

import java.rmi.RemoteException;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.vo.OutWareHouseDocVO;

public interface OutWareHouseManagementService {
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID,String currInstitution) throws DatabaseNULLException, RemoteException;
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID,String currInstitution) throws DatabaseNULLException, RemoteException;
	public void updateOutWareHouseDoc(OutWareHouseDocVO out,String currPersonID);

}
