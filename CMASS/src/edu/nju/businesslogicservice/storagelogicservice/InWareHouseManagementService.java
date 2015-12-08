package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.exception.DatabaseNULLException;
import edu.nju.vo.InWareHouseDocVO;

public interface InWareHouseManagementService {
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID,String currInstitutionID) throws DatabaseNULLException ;
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID,String currInstitution) throws DatabaseNULLException ;
	public void updateInWareHouseDoc(InWareHouseDocVO out);
	

}
