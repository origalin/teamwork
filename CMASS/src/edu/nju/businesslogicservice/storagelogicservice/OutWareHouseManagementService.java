package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.vo.OutWareHouseDocVO;

public interface OutWareHouseManagementService {
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID);
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID);
	public void updateOutWareHouseDoc(OutWareHouseDocVO out);

}
