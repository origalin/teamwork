package edu.nju.businesslogicservice.transformlogicservice;

import java.util.ArrayList;

import edu.nju.po.DeliverDocPO;
import edu.nju.po.OverDocPO;
import edu.nju.vo.OverDocVO;

public interface OverDocService {
	public void saveOverDocPO(OverDocPO po);//保存收件单持久化对象
	public int getOverDocSequence();//获取收件单基准序列号
	public void changeOverDocSequence(int sequence);//改变基准序列号
	public OverDocVO createOverDocDocVO();//创建收件单VO
	public OverDocVO findOverDocVO(int ID);//获取收件单VO
	public ArrayList<OverDocPO> getUncheckedOverDocPOs();

}
