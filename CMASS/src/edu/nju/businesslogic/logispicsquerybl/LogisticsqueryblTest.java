package edu.nju.businesslogic.logispicsquerybl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.nju.po.PositionPO;
import edu.nju.vo.PositionVO;

public class LogisticsqueryblTest {
	Logisticsquerybl logisticsquerybl;
	@Before
	public void setUp() throws Exception {
		logisticsquerybl=new Logisticsquerybl();
		logisticsquerybl.createPosition("1002500001", "�Ͼ�����ϼ��Ӫҵ��");
		
	}

	@Test
	public void testHistoryQuery() {
		PositionVO positionVO=logisticsquerybl.historyQuery("1002500001");
		String string=positionVO.toString();
		assertEquals("��ʷ�켣��ѯ������ֵ��һ��","1002500001 �Ͼ�����ϼ��Ӫҵ��", string);
		
	}

	@Test
	public void testChangePosition() {
		logisticsquerybl.changePosition("1002500001", "�Ͼ�����ת����");
		PositionVO positionVO=logisticsquerybl.historyQuery("1002500001");
		assertEquals("��ʷ�켣�޸�ʧ��","1002500001 �Ͼ�����ϼ��Ӫҵ��,�Ͼ�����ת����",  positionVO.toString());
	}

	

}
