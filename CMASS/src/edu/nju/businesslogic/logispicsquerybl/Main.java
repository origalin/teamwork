package edu.nju.businesslogic.logispicsquerybl;

import java.rmi.Naming;
import java.sql.Blob;

import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;

public class Main {

	
	public static void main(String[] args) {
		try{
    		//调用远程对象，注意RMI路径与接口必须与服务器配置一致
			Logisticsquerybl lbl=new Logisticsquerybl();
    		lbl.createPosition("2036030037", "北京市朝阳区营业厅");
    		lbl.changePosition("2036030037", "北京市中转中心");
    		System.out.println(lbl.historyQuery("2036030037"));
    		//System.out.println(po.toString());
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
	}

}
