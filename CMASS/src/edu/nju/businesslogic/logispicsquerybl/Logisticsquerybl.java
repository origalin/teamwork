package edu.nju.businesslogic.logispicsquerybl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;
import edu.nju.vo.PositionVO;

public class Logisticsquerybl implements LogispicsQueryLogicService{
	LogisticsDataService logisticsDataService;
	ArrayList<PositionPO> list;
	
	public Logisticsquerybl() {
		super();
		list= new ArrayList<PositionPO>();
		try {
			this.logisticsDataService = logisticsDataService=(LogisticsDataService)Naming.lookup("rmi://127.0.0.1:6600/LogisticsDataService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}

	@Override
	public PositionVO historyQuery(String SendDocID) {
		// �����ݲ��������������־û��ļ�\
		PositionVO vo=null;
		try {
			
			PositionPO po=logisticsDataService.positionQuery(SendDocID);
			vo=new PositionVO(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("�߼����ݲ�ѯʧ��");
			e.printStackTrace();
		}
		return vo;
	}
	
	public void changePosition(String ItemID,String pos){
		//���Լ����ݲ����������������ݲ��������Ϣ
		try {
			logisticsDataService.changePosition(ItemID,pos);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("�߼�����ʷ�켣�޸�ʧ��");
			e.printStackTrace();
		}
	}
	
	public void createPosition(String string,String pos){
		//���Լ����ݲ��������������¿�ݵ���ʷ�켣����
		try {
			logisticsDataService.createPosition(string,pos);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("�߼�����ʷ�켣��¼����ʧ��");
			e.printStackTrace();
		}
	}
	

}
