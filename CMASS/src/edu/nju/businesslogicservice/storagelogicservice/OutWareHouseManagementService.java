package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.vo.OutWareHouseDocVO;

public interface OutWareHouseManagementService {
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID,String currInstitution);
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID,String currInstitution);
	public void updateOutWareHouseDoc(OutWareHouseDocVO out);

}
