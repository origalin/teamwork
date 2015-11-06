package edu.nju.businesslogicservice.storagelogicservice;

import java.util.ArrayList;

import edu.nju.po.RecordPO;
import edu.nju.vo.InWareHouseDocVO;
//建议单据预览面板不提供任何的监听
import edu.nju.vo.OutWareHouseDocVO;
public interface StorageLogicService {
	//库存盘点：
	//获取仓库的航运区的库存记录列表
	public ArrayList<RecordPO> getInWareHouseDocVO_Fly=new ArrayList<RecordPO>();
	//获取仓库的货运区的库存记录列表
	public ArrayList<RecordPO> getInWareHouseDocVO_Train=new ArrayList<RecordPO>();
	//获取仓库的汽运区的库存记录列表
	public ArrayList<RecordPO> getInWareHouseDocVO_Car=new ArrayList<RecordPO>();	
	
	//入库管理：
	//根据中转单编号去查找每个快递的具体信息，返回入库单VO,在调用这个方法的过程中，返回VO前已经实现了对单据文件的更新
	public InWareHouseDocVO getInWareHouseDocVO_Transfer(int TransferDocID);
	
	//根据营业厅装车单编号，返回入库单VO；在调用这个方法的过程中，返回VO前已经实现了对单据文件的更新
	public InWareHouseDocVO getInWareHouseDocVO_YloadDoc(int YloadDocID);	
	
	
	//出库管理：
	//根据中转单编号去遍历它上面的所有快递编号对应的库存记录，生成中转单VO，在调用这个方法的过程中，返回VO前已经实现了对单据文件的更新
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(int TransferDocID);
	//根据中转中心装车单编号去遍历它上面的所有快递编号对应的库存记录，生成中转单VO，在调用这个方法的过程中，返回VO前已经实现了对单据文件的更新
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(int ZloadDocID);
	//根据出库单编号，更新出库单文件
	public void updateOutWareHouseDoc(int OutWareHouseDocID);
	
	//库存初始化：
	//清空仓库的库存记录
	public void clear();	
	//新增库存记录
	public void addNewStorageItem();
	
	//库存预警
	//设置报警阀值
	public void setAlarm(double p);
	//设置划分出多少百分比的机动区给报警区
	public void setPercent(double p);

}
