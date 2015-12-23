package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.storageui.InWareHouseManagment;
import edu.nju.presentation.storageui.OutWareHouseManagment;
import edu.nju.presentation.storageui.StorageInitialize;
import edu.nju.presentation.storageui.StorageModify;
import edu.nju.presentation.storageui.StorageQuery;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.widget.BigButton;

import java.awt.CardLayout;
import javax.swing.JLabel;

public class GuidePanel_Storage extends JPanel{
	ArrayList<BigButton> buttons;
	InWareHouseManagment inWareHousePanel;
//	=new InWareHouseManagment();
	OutWareHouseManagment outWareHousePanel;
//	=new OutWareHouseManagment();
	StorageInitialize storageInitializePanel;
//	=new StorageInitialize();
	StorageQuery storageQueryPanel;
//	=new StorageQuery();
	StorageModify storageModifyPanel;
//	=new StorageModify();
	String institutionID;
	String staffID;
	MainFrame frame;
	CollertionPanel collertionPanel;
	SendPanel sendPanel;
	public GuidePanel_Storage(MainFrame frame,String staffID) {
		setOpaque(false);
		inWareHousePanel=new InWareHouseManagment(staffID);
		outWareHousePanel=new OutWareHouseManagment(staffID);
		storageInitializePanel=new StorageInitialize(staffID);
		storageModifyPanel=new StorageModify(staffID);
		storageQueryPanel=new StorageQuery(staffID);
		this.staffID = staffID;
		this.frame = frame;
		collertionPanel = new CollertionPanel(staffID);
		sendPanel = new SendPanel(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.columnWidths = new int[]{5};
		gridBagLayout.rowHeights = new int[]{60, 60, 60, 60, 60, 0, 0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		BigButton OutWareHouseManagement = new BigButton("\u51FA\u5E93\u7BA1\u7406");
		OutWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				OutWareHouseManagement.setPressed();
				frame.setFunctionPanel(outWareHousePanel);
			}
		});
		
		BigButton InWareHouseManagement = new BigButton("\u5165\u5E93\u7BA1\u7406");
		InWareHouseManagement.setPressed();
		InWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				InWareHouseManagement.setPressed();
					frame.setFunctionPanel(inWareHousePanel);
				
			}
		});
		GridBagConstraints gbc_InWareHouseManagement = new GridBagConstraints();
		gbc_InWareHouseManagement.fill = GridBagConstraints.BOTH;
		gbc_InWareHouseManagement.insets = new Insets(0, 0, 5, 0);
		gbc_InWareHouseManagement.gridx = 0;
		gbc_InWareHouseManagement.gridy = 0;
		add(InWareHouseManagement, gbc_InWareHouseManagement);
		GridBagConstraints gbc_OutWareHouseManagement = new GridBagConstraints();
		gbc_OutWareHouseManagement.fill = GridBagConstraints.BOTH;
		gbc_OutWareHouseManagement.insets = new Insets(0, 0, 5, 0);
		gbc_OutWareHouseManagement.gridx = 0;
		gbc_OutWareHouseManagement.gridy = 1;
		add(OutWareHouseManagement, gbc_OutWareHouseManagement);
		
		BigButton StorageInitialize = new BigButton("\u5E93\u5B58\u4FE1\u606F\u521D\u59CB\u5316");
		StorageInitialize.setText("\u521D\u59CB\u5316");
		StorageInitialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				StorageInitialize.setPressed();
				frame.setFunctionPanel(storageInitializePanel);
			}
		});
		
		BigButton StorageQuery = new BigButton("ø‚¥Ê≈Ãµ„");
		StorageQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				StorageQuery.setPressed();
				frame.setFunctionPanel(storageQueryPanel);
			}
		});
		GridBagConstraints gbc_StorageQuery = new GridBagConstraints();
		gbc_StorageQuery.fill = GridBagConstraints.BOTH;
		gbc_StorageQuery.insets = new Insets(0, 0, 5, 0);
		gbc_StorageQuery.gridx = 0;
		gbc_StorageQuery.gridy = 2;
		add(StorageQuery, gbc_StorageQuery);
		GridBagConstraints gbc_StorageInitialize = new GridBagConstraints();
		gbc_StorageInitialize.fill = GridBagConstraints.BOTH;
		gbc_StorageInitialize.insets = new Insets(0, 0, 5, 0);
		gbc_StorageInitialize.gridx = 0;
		gbc_StorageInitialize.gridy = 3;
		add(StorageInitialize, gbc_StorageInitialize);
		
		BigButton StorageMidify = new BigButton("\u5E93\u533A\u8C03\u6574");
		StorageMidify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				StorageMidify.setPressed();
				frame.setFunctionPanel(storageModifyPanel);
				
			}
		});
		GridBagConstraints gbc_StorageMidify = new GridBagConstraints();
		gbc_StorageMidify.insets = new Insets(0, 0, 5, 0);
		gbc_StorageMidify.fill = GridBagConstraints.BOTH;
		gbc_StorageMidify.gridx = 0;
		gbc_StorageMidify.gridy = 4;
		add(StorageMidify, gbc_StorageMidify);
		buttons=new ArrayList<BigButton>();
		buttons.add(StorageMidify);
		buttons.add(StorageQuery);
		buttons.add(StorageInitialize);
		buttons.add(InWareHouseManagement);
		buttons.add(OutWareHouseManagement);
	}
	
	void clean() {
		for(BigButton bt:buttons) {
			bt.setNormal();
		}
	}
}
