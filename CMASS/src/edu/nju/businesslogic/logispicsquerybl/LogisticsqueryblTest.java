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
		logisticsquerybl.createPosition("1002500001", "南京市栖霞区营业厅");
		
	}

	@Test
	public void testHistoryQuery() {
		PositionVO positionVO=logisticsquerybl.historyQuery("1002500001");
		String string=positionVO.toString();
		assertEquals("历史轨迹查询与期望值不一致","1002500001 南京市栖霞区营业厅", string);
		
	}

	@Test
	public void testChangePosition() {
		logisticsquerybl.changePosition("1002500001", "南京市中转中心");
		PositionVO positionVO=logisticsquerybl.historyQuery("1002500001");
		assertEquals("历史轨迹修改失败","1002500001 南京市栖霞区营业厅,南京市中转中心",  positionVO.toString());
	}

	

}
