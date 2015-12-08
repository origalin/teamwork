package edu.nju.presentation.collectionui;

import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JFrame;

import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.CourierMoneyPO;
import edu.nju.po.OverDocPO;

public class MainTest {
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setSize(1280, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(new CollertionPanel());
		
		
		CollectionDataService collectionDataService = DataFactory.getCollectionDataService();
		TransferDataService transferDataService = null;
		try {
			transferDataService = new TransferDataServiceImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//System.out.println(collectionDataService.getSendDocPOByID("2002512345").getrAddress());
//			CourierMoneyPO po = collectionDataService.getCourierMoneyPO("00252123315");
//			po.appendMoney("00252123315", "12123132", 12);
//			collectionDataService.saveCourierMoneyPO(po);
			System.out.println(transferDataService.getunPaidTransferDocPO().size());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
