package edu.nju.businesslogic.transformbl;

import edu.nju.po.TranceferDoc_CarPO;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.TransferDoc_CarVO;

public class MockTransferDoc extends TransferDoc{
	String[] ids = {"0231212212","1232321232","2321233212","1233221234"};
	public TransferDocPO getTransferDocPO(String ID) {
		return new TranceferDoc_CarPO(ID, System.currentTimeMillis(), 12321, 23122, "北京", "南京", 3333.3, ids);
	}
}
