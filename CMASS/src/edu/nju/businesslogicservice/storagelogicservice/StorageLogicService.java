package edu.nju.businesslogicservice.storagelogicservice;

import java.util.ArrayList;

import edu.nju.po.RecordPO;
import edu.nju.vo.InWareHouseDocVO;
//���鵥��Ԥ����岻�ṩ�κεļ���
import edu.nju.vo.OutWareHouseDocVO;
public interface StorageLogicService {
	//����̵㣺
	//��ȡ�ֿ�ĺ������Ŀ���¼�б�
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly=new ArrayList<RecordPO>();
	//��ȡ�ֿ�Ļ������Ŀ���¼�б�
	public ArrayList<RecordPO> getInWareHouseDocVO_Train=new ArrayList<RecordPO>();
	//��ȡ�ֿ���������Ŀ���¼�б�
	public ArrayList<RecordPO> getInWareHouseDocVO_Car=new ArrayList<RecordPO>();	
	
	//������
	//������ת�����ȥ����ÿ����ݵľ�����Ϣ��������ⵥVO,�ڵ�����������Ĺ����У�����VOǰ�Ѿ�ʵ���˶Ե����ļ��ĸ���
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID);
	
	
	public void updateInWareHouseDoc(InWareHouseDocVO in);
	//����Ӫҵ��װ������ţ�������ⵥVO���ڵ�����������Ĺ����У�����VOǰ�Ѿ�ʵ���˶Ե����ļ��ĸ���
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID);	
	
	
	//�������
	//������ת�����ȥ��������������п�ݱ�Ŷ�Ӧ�Ŀ���¼��������ת��VO���ڵ�����������Ĺ����У�����VOǰ�Ѿ�ʵ���˶Ե����ļ��ĸ���
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID);
	//������ת����װ�������ȥ��������������п�ݱ�Ŷ�Ӧ�Ŀ���¼��������ת��VO���ڵ�����������Ĺ����У�����VOǰ�Ѿ�ʵ���˶Ե����ļ��ĸ���
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID);
	//���ݳ��ⵥ��ţ����³��ⵥ�ļ�
	public void updateOutWareHouseDoc(OutWareHouseDocVO out);
	
	//����ʼ����
	//��ղֿ�Ŀ���¼
	public void clear();	
	//��������¼
	public void addNewStorageItem(RecordPO recordPO);
	
	//���Ԥ��
	//���ñ�����ֵ
	public void setAlarm(double p);
	//���û��ֳ����ٰٷֱȵĻ�������������
	public void setPercent(double p);

	
	public void updateStorage(ArrayList<RecordPO> aList);
}
