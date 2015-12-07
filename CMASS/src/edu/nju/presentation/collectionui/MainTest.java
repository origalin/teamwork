package edu.nju.presentation.collectionui;

import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JFrame;

import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.OverDocPO;

public class MainTest {
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setSize(1280, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(new CollertionPanel());
		
		
		CollectionDataService collectionDataService = DataFactory.getCollectionDataService();
		try {
			System.out.println(collectionDataService.getSendDocPOByID("2002512345").getrAddress());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		TransferDataService transferDataService = DataFactory.getTransferDataService();
//		String[] aStrings = {"122","12","231","213","123","123"};
//		String[] bStrings = {"122","12","231","213","123","123"};
//		try {
//			OverDocPO po = new OverDocPO("134", aStrings, bStrings, new Date(), "12123");
//			transferDataService.saveOverDocPO(po);
//			
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
 catch (DatabaseNULLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
