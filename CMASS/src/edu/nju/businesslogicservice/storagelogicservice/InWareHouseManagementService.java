package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.vo.InWareHouseDocVO;

public interface InWareHouseManagementService {
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID) ;
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID) ;
	public void updateInWareHouseDoc(InWareHouseDocVO out);

}
