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
		JFrame frame = new JFrame();
		frame.setSize(1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new CollertionPanel("00251001100"));
		frame.setVisible(true);
	}
}
