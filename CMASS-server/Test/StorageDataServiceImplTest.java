package edu.nju.data.StorageDataServiceImpl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.nju.po.OutRecord;
import edu.nju.po.OutWareHouseDocPO;

public class StorageDataServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStorageDataServiceImpl() {
		
		
		
	}

	

	@Test
	public void testGetStorageItems() {
		String storageID="001000";
		int ctrl=0;
		
		assertNotNull("getStorageItems ß∞‹", getStorageItems(storageID,ctrl));
	}

	
	@Test
	public void testGetStorageItemList() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOutWareHouseDocID() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOutWareHouseDoc() {
		ArrayList<OutRecord> outRecords=new ArrayList<OutRecord>();
		outRecords.add(new OutRecord("0025010010", "±±æ©", ""))
		OutWareHouseDocPO outWareHouseDocPO=new OutWareHouseDocPO("09000010", new Date(), "∫Ω‘À","001000", outRecords);
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateInWareHouseDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWareHouse() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddNewStorageItem() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPercent() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAlarm() {
		fail("Not yet implemented");
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPercent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOutWarehouseDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInWarehouseDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrInWare_ID() {
		fail("Not yet implemented");
	}

	@Test
	public void testMarkPositionOccupied() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValidLocation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveInWareHouseDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCurrOutWare_ID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOutWareHouseDoc() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOutWareHouseDoc_unchecked() {
		fail("Not yet implemented");
	}

}
