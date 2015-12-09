package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.storageui.InWareHouseManagment;
import edu.nju.presentation.storageui.OutWareHouseManagment;
import edu.nju.presentation.storageui.StorageInitialize;
import edu.nju.presentation.storageui.StorageModify;
import edu.nju.presentation.storageui.StorageQuery;
import edu.nju.presentation.transformui.SendPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class GuidePanel_Storage extends JPanel{
	InWareHouseManagment inWareHousePanel=new InWareHouseManagment();
	OutWareHouseManagment outWareHousePanel=new OutWareHouseManagment();
	StorageInitialize storageInitializePanel=new StorageInitialize();
	StorageQuery storageQueryPanel=new StorageQuery();
	StorageModify storageModifyPanel=new StorageModify();
	String institutionID;
	String staffID;
	MainFrame frame;
	CollertionPanel collertionPanel;
	SendPanel sendPanel;
	public GuidePanel_Storage(MainFrame frame,String staffID) {
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
		
		JButton OutWareHouseManagement = new JButton("\u51FA\u5E93\u7BA1\u7406");
		OutWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setFunctionPanel(outWareHousePanel);
			}
		});
		
		JButton InWareHouseManagement = new JButton("\u5165\u5E93\u7BA1\u7406");
		InWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		JButton StorageInitialize = new JButton("\u5E93\u5B58\u4FE1\u606F\u521D\u59CB\u5316");
		StorageInitialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setFunctionPanel(storageInitializePanel);
			}
		});
		
		JButton StorageQuery = new JButton("ø‚¥Ê≈Ãµ„");
		StorageQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JButton StorageMidify = new JButton("\u5E93\u533A\u8C03\u6574");
		StorageMidify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setFunctionPanel(storageModifyPanel);
			}
		});
		GridBagConstraints gbc_StorageMidify = new GridBagConstraints();
		gbc_StorageMidify.insets = new Insets(0, 0, 5, 0);
		gbc_StorageMidify.fill = GridBagConstraints.BOTH;
		gbc_StorageMidify.gridx = 0;
		gbc_StorageMidify.gridy = 4;
		add(StorageMidify, gbc_StorageMidify);
	}
}
