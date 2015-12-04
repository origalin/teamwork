package edu.nju.businesslogic.storagebl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.nju.businesslogic.transferbl.MockTransferDoc;
import edu.nju.po.TransferDocPO;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

public class OutWareHouseManagementblTest {
	OutWareHouseManagementbl ou;
	@Before
	public void setUp() throws Exception {
		ou=new OutWareHouseManagementbl();
	}
	@Test
	public void testGetOutWareHouseDocVO_ZloadDoc() {
		
	}

	@Test
	public void testGetOutWareHouseDocVO_Transfer() {
		MockTransferDoc mockTransferDoc = new MockTransferDoc();
		ou.tran=mockTransferDoc.getTransferDocPO("0250201511160000008");
		
		OutWareHouseDocVO outWareHouseDocVO=ou.getOutWareHouseDocVO_Transfer("0250201511160000008");
	
		ArrayList<OutWareHouseDocLineItem> arrayList = null;
		arrayList.add(new OutWareHouseDocLineItem("0231212212","航运","南京"));
		
		OutWareHouseDocVO expected=new OutWareHouseDocVO(arrayList,"");
		
		assertEquals("出库管理错误",expected.toString(),outWareHouseDocVO.toString() );
		
	}

	@Test
	public void testUpdateOutWareHouseDoc() {
		fail("Not yet implemented");
	}

}
