package edu.nju.businesslogic.logispicsquerybl;

import java.rmi.Naming;

import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		try{
    		//����Զ�̶���ע��RMI·����ӿڱ��������������һ��
    		LogisticsDataService personService=(LogisticsDataService)Naming.lookup("rmi://127.0.0.1:6600/LogisticsDataService");
    		System.out.println(personService.positionQuery("0025010010"));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
	}

}
