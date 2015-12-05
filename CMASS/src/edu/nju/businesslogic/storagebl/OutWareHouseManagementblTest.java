package edu.nju.businesslogic.storagebl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
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
		MockTransferDoc mockTransferDoc = null;
		try {
			mockTransferDoc = new MockTransferDoc();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ou.tran=mockTransferDoc.getTransferDocPO("0250201511160000008");
		
		OutWareHouseDocVO outWareHouseDocVO=ou.getOutWareHouseDocVO_Transfer("0250201511160000008", null);
	
		ArrayList<OutWareHouseDocLineItem> arrayList = null;
		arrayList.add(new OutWareHouseDocLineItem("0231212212","����","�Ͼ�"));
		
		OutWareHouseDocVO expected=new OutWareHouseDocVO(arrayList,"");
		
		assertEquals("����������",expected.toString(),outWareHouseDocVO.toString() );
		
	}

	@Test
	public void testUpdateOutWareHouseDoc() {
		fail("Not yet implemented");
	}

}

