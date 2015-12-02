package edu.nju.businesslogic.financebl;

import java.util.ArrayList;

import edu.nju.po.PayDocPO;
import edu.nju.vo.PayDocVO;

public class MockFinancebl extends financebl{

	public ArrayList<PayDocPO> getunchekedPayDocList(){
		return null;//this.PayDocList;
	}
}
