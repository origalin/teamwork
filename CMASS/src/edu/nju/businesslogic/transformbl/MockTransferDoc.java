package edu.nju.businesslogic.transformbl;

import edu.nju.po.TransferDocPO;

public class MockTransferDoc extends TransferDoc{
	
	public MockTransferDoc() {
		super();
	}
	public MockTransferDoc(String institutionID, String staffID) {
		super(institutionID, staffID);
		// TODO Auto-generated constructor stub
	}
	String[] ids = {"0231212212","1232321232","2321233212","1233221234"};
	public TransferDocPO getTransferDocPO(String ID) {
		return null;//new TranceferDoc_CarPO(ID, System.currentTimeMillis(), 12321, "23122", "北京", "南京", 3333.3, ids);
	}
}
