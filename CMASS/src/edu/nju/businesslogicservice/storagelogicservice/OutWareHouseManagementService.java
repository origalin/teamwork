package edu.nju.businesslogicservice.storagelogicservice;

import edu.nju.vo.OutWareHouseDocVO;

public interface OutWareHouseManagementService {
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID);
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID);
	public void updateOutWareHouseDoc(OutWareHouseDocVO out);

}
