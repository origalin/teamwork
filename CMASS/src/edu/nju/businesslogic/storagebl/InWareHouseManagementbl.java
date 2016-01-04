package edu.nju.businesslogic.storagebl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.data.StorageDataServiceImpl.StorageLocation;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.exception.NoSpace;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OperationPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.tools.WarningManager;
import edu.nju.vo.InWareHouseDocVO;

/**
 * @author ��
 *
 */
public class InWareHouseManagementbl implements InWareHouseManagementService {

    /* 
	 * 	 * @see edu.nju.businesslogicservice.storagelogicservice.
	 * InWareHouseManagementService#getInWareHouseDocVO_Transfer
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public final InWareHouseDocVO getInWareHouseDocVO_Transfer
	(final String TransferDocID, final String currInstitutionID)
			throws DatabaseNULLException {
		// ������ģ����������TransferDocPO getTransferPO(int TransferID)
		// ���ݵ���ȷ���ؿ컹�Ǿ���
		// �����ݲ���������ȡ�ô���ⵥ�ı�� ��öԲֿ������

		StorageDataService storageDataService
		= DataFactory.getStorageImpl();
		TransferDoc transferDoc = null;
		try {
			transferDoc = new TransferDoc();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		TransferDocPO transferDocPO = null;
		try {
			transferDocPO 
			= transferDoc.geTransferDocPOByID(TransferDocID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// System.out.println(transferDocPO);
		// StorageDataService storageDataService
		//= DataFactory.getStorageImpl();
		// storageDataService.
		if (transferDocPO == null) {
			JOptionPane.showMessageDialog(null, "δ�ҵ�����ת��");
			return null;
		}

		String[] itemsID = transferDocPO.getItemIDs();
		StorageLocation storageLocation = null;
		ArrayList<InWareHouseDocLineItem> list 
		= new ArrayList<InWareHouseDocLineItem>();
		for (String temp : itemsID) {
			String district = "";
			if (temp.charAt(0) == '0') {
				district = "������";
			} else if (temp.charAt(0) == '1') {
				district = "������";
			} else {
				district = "������";
			}

			try {
				storageLocation =
						storageDataService.getValidLocation(currInstitutionID, district);
				System.out.println
				("currInstitution=" + currInstitutionID + ";district:" + district);
			} catch (RemoteException e) {
				System.out.println("��ȡ��Чλ�ó���");
				e.printStackTrace();
			} catch (NoSpace e) {
				WarningManager.warning("���澯������е���");
				e.printStackTrace();
			}

			InWareHouseDocLineItem lineItem 
			= new InWareHouseDocLineItem(temp, new Date(), district,
					storageLocation.getLocation());
			list.add(lineItem);
		}

		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO 
		= new InWareHouseDocVO(currInWareID, currInstitutionID, list);

		return inWareHouseDocVO;
	}

	/* (non-Javadoc)
	 * @see edu.nju.businesslogicservice.
	 * storagelogicservice.InWareHouseManagementService#getInWareHouseDocVO_YloadDoc
	 * (java.lang.String, java.lang.String)
	 */
	@Override
	public final InWareHouseDocVO getInWareHouseDocVO_YloadDoc
	(final String YloadDocID, final String currInstitutionID) throws DatabaseNULLException, RemoteException {
		StorageDataService storageDataService = DataFactory.getStorageImpl();
		YLoadDoc yLoadDoc  = new YLoadDoc();

		YLoadDocPO yLoadDocPO = null;
		try {
			yLoadDocPO = yLoadDoc.getYloadDocPOByID(YloadDocID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// StorageDataService storageDataService = DataFactory.getStorageImpl();
		// storageDataService.
		if (yLoadDocPO == null) {
			JOptionPane.showMessageDialog(null, "δ�ҵ���װ����");
			return null;
		}
		String[] itemsID = yLoadDocPO.getItemIDs();
		StorageLocation storageLocation = null;
		ArrayList<InWareHouseDocLineItem> list 
		= new ArrayList<InWareHouseDocLineItem>();
		for (String temp : itemsID) {
			String district = "";
			if (temp.charAt(0) == '0') {
				district = "������";
			} else if (temp.charAt(0) == '1') {
				district = "������";
			} else {
				district = "������";
			}

			try {
				storageLocation 
				= storageDataService.getValidLocation(currInstitutionID, district);
				// System.out.println("currInstitution="+currInstitutionID+";district:"+district);
			} catch (RemoteException e) {
				System.out.println("��ȡ��Чλ�ó���");
				e.printStackTrace();
			} catch (NoSpace e) {
				WarningManager.warning("���澯������е���");
				e.printStackTrace();
			}

			InWareHouseDocLineItem lineItem 
			= new InWareHouseDocLineItem(temp, new Date(), district,
					storageLocation.getLocation());
			list.add(lineItem);
		}

		String currInWareID = "";
		try {
			currInWareID = storageDataService.getCurrInWare_ID();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		InWareHouseDocVO inWareHouseDocVO 
		= new InWareHouseDocVO(currInWareID, currInstitutionID, list);

		return inWareHouseDocVO;

	}

	/* (non-Javadoc)
	 * @see edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService#updateInWareHouseDoc(edu.nju.vo.InWareHouseDocVO, java.lang.String)
	 */
	@Override
	public final void updateInWareHouseDoc
	(final InWareHouseDocVO in,final String currPersonID) {
		// �����ݲ�������void updateInWareHouseDoc(InWareHouseDocPO out)

		StorageDataService storageDataService = DataFactory.getStorageImpl();
		try {
			System.out.println("�߼����VO in:" + in);
			
			InstitutionLogicService institutionLogicService=new Institution();
			String staffName=institutionLogicService.getStaffName(currPersonID);
			OperationPO operationPO=new OperationPO(new Date(), currPersonID, staffName, "�½���"+in.getID()+"��ⵥ");
			SystemBl systemBl=new SystemBl();
			systemBl.saveOperation(operationPO);
			
			storageDataService.updateInWareHouseDoc(in.unpack());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param ItemID
	 * @return
	 */
	public final String getAddressDatail(final String ItemID) {
		return null;
	}

	/**
	 * @param in
	 * @throws RemoteException
	 */
	public final void saveInWareHouseDoc(final InWareHouseDocPO in) 
			throws RemoteException{
		StorageDataService storageDataService
		=DataFactory.getStorageImpl();
		storageDataService.saveInWareHouseDoc(in);
	}

}
