package edu.nju.businesslogicservice.logispicsquerylogicservice;

import edu.nju.vo.HistoryVO;
import edu.nju.vo.PositionVO;

public interface LogispicsQueryLogicService {
	//����һ���ļ�����Ų�ѯ�ÿ����ʷ������Ϣ
	//��������û��ά���������һ���࣬��ʷ�켣��Ϣ�������
	public PositionVO historyQuery(String SendDocID);
	
	public void changePosition(String ItemID,String pos);
	public void createPosition(String string,String pos,String destination);

	

}
