package edu.nju.businesslogic.approvebl;



import java.util.ArrayList;

import edu.nju.businesslogic.financebl.MockFinancebl;
import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;

public class approveblTest {
	public void test(){
		
		PayDocPO payDoc1=new PayDocPO("11123456", 20151116, 5000, "Michael Jackson", "6228480010200900214", PayType.RENT,"南京市中转中心0250租金");
		PayDocPO payDoc2=new PayDocPO("11839475",20151225,100,"Michael Jordan","9558800200136624752",PayType.FREIGHT,"车辆代号为为0025000010，从南京运往上海的运费");
		ArrayList<PayDocPO> payDocList = new ArrayList<PayDocPO>();
		payDocList.add(payDoc1);
		payDocList.add(payDoc2);
		
		financebl b=new MockFinancebl();
		b.setPayDocList(payDocList);
		
		approvebl a=new approvebl();
		a.getunchekedPayDocList();
		a.setPayDocList(a.unchekedPayDocList);
		
		ArrayList<PayDocPO> listRefreshed=b.getPayDocList();
		ArrayList<PayDocPO> list=a.unchekedPayDocList;
		for(int i=0;i<list.size();i++){
			if(list.get(i).isChecked()!=listRefreshed.get(i).isChecked()){
				System.out.println("The method setPayDocList failed!!!");
			}
		}
		
	}
}
