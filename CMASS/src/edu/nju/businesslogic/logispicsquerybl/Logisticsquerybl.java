package edu.nju.businesslogic.logispicsquerybl;

import java.util.ArrayList;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.po.PositionPO;
import edu.nju.vo.PositionVO;

public class Logisticsquerybl implements LogispicsQueryLogicService{

	ArrayList<PositionPO> list= new ArrayList<PositionPO>();
	@Override
	public PositionVO historyQuery(int SendDocID) {
		// �����ݲ��������������־û��ļ�
		return null;
	}
	
	public void changePosition(long ItemID,String pos){
		//���Լ����ݲ����������������ݲ��������Ϣ
	}
	
	public void createPosition(long Item,String pos){
		//���Լ����ݲ��������������¿�ݵ���ʷ�켣����
		
	}
	

}
