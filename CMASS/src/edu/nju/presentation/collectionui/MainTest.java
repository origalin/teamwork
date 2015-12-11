package edu.nju.presentation.collectionui;

import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.JFrame;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.data.collectionDataServiceImpl.CollectionDataServiceImpl;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataFactory.DataFactory;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.CourierMoneyPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.presentation.transformui.SendPanel;

public class MainTest {
	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setSize(1280, 800);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		frame.getContentPane().add(new SendPanel("00251001100"));
//		frame.setVisible(true);
		try {
			TransferDataServiceImpl transferDataServiceImpl = new TransferDataServiceImpl();
			CollectionDataService collectionDataService = new CollectionDataServiceImpl();
			System.out.println(transferDataServiceImpl.getAllYArrivalDoc().size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
