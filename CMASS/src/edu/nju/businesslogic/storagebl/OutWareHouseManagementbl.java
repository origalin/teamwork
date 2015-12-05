package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.businesslogic.transformbl.ZLoadDoc;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

public class OutWareHouseManagementbl implements OutWareHouseManagementService {

	OutWareHouseDocPO outWareHousePO;
	TransferDocPO tran;

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_ZloadDoc(String ZloadDocID, String currInstitution) {
		// 对运输模块有依赖，ZloadDoc getZloadDocPO(int ZloadDocID)
		//// 对自己数据层的依赖：ArrayList<RecordPO> getStorageItemList(int[]
		// SendDocIDList)
		// 对数据层依赖：获取该次出库单的编号

		return this.getOutWareHouseDocVO(ZloadDocID, currInstitution, false);
	}

	@Override
	public OutWareHouseDocVO getOutWareHouseDocVO_Transfer(String TransferDocID, String currInstitution) {

		// 对运输模块有依赖，TransferPO getTransferPO(int TransferID)
		// 对自己数据层的依赖：ArrayList<RecordPO> getStorageItemList(int[] SendDocIDList)
		// 对数据层依赖：获取该次出库单的编号

		

		return this.getOutWareHouseDocVO(TransferDocID, currInstitution, true);

	}

	public OutWareHouseDocVO getOutWareHouseDocVO(String sourceID, String currInstitution, boolean control) {
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		String[] itemsID;
		if (control == true) {
			TransferDoc transferDoc = null;
			try {
				transferDoc = new TransferDoc();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TransferDocPO transferDocPO = null;
			try {

				transferDocPO = transferDoc.geTransferDocPOByID(sourceID);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			if (transferDocPO == null) {
				JOptionPane.showMessageDialog(null, "未找到该中转单");
				return null;//失败直接返回null
			}

			itemsID = transferDocPO.getItemIDs();
		} else {
			ZLoadDoc zLoadDoc = new ZLoadDoc();
			ZLoadDocPO zLoadDocPO = null;
			try {
				zLoadDocPO = zLoadDoc.getZLoadDocPO(sourceID);
			} catch (RemoteException e) {
				JOptionPane.showMessageDialog(null, "远程获取装车单信息失败");
				e.printStackTrace();
			}

			if (zLoadDocPO == null){
				JOptionPane.showMessageDialog(null, "未找到该装车单");
				return null;//失败直接返回null
			}
			itemsID=zLoadDocPO.getItemIDs();
				
		}

		// 制造出outLineItems
		ArrayList<OutWareHouseDocLineItem> list = new ArrayList<OutWareHouseDocLineItem>();
		for (String temp : itemsID) {
			OutWareHouseDocLineItem lineItem = new OutWareHouseDocLineItem(temp, new Date());
			list.add(lineItem);
		}

		// 查询出现在的出库单ID
		String currOutWareID = "";
		try {
			currOutWareID = storageDataService.getCurrOutWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 以三个初始化过的属性去新建一个vo
		OutWareHouseDocVO outWareHouseDocVO = new OutWareHouseDocVO(list, currOutWareID, currInstitution,new Date());

		return outWareHouseDocVO;
	}

	@Override
	public void updateOutWareHouseDoc(OutWareHouseDocVO out) {
		// 对数据层依赖：void updateOutWareHouseDoc(OutWareHouseDocPO out)

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		try {
			storageDataService.updateOutWareHouseDoc(out.unpack());
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "更新出库单时与服务器连接异常");
			e.printStackTrace();
		}
		
		
		
	}

}
