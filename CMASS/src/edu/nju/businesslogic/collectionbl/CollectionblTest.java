package edu.nju.businesslogic.collectionbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.nju.vo.SendDocVO;

public class CollectionblTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateSendDocVO() {
		Collectionbl bl = new Collectionbl("0902102");
		double[] volume = {12.5,23.5,21.4};
		SendDocVO vo = bl.createSendDocVO("name", "address", "����", "unit", "123445432", "123445432", "name", "address", "�Ͼ�", "unit",	"123445432", "123445432", 1, 12.5, volume, "haha", 1, 0);
		assertEquals(100, vo.getSumPrice());
	}

}
