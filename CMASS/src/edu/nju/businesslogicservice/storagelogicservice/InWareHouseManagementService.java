package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.vo.InWareHouseDocVO;

public interface InWareHouseManagementService {
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(String TransferDocID) ;
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(String YloadDocID) ;
	public void updateInWareHouseDoc(InWareHouseDocVO out);

}
