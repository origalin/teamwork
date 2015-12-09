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
import edu.nju.presentation.transformui.SendPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;

public class GuidePanel_Storage extends JPanel{
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
		
		JButton InWareHouseManagement = new JButton("\u5165\u5E93\u7BA1\u7406");
		InWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(new GridLayout(5, 1, 0, 0));
		add(InWareHouseManagement);
		
		JButton OutWareHouseManagement = new JButton("\u51FA\u5E93\u7BA1\u7406");
		OutWareHouseManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(OutWareHouseManagement);
		
		JButton StorageQuery = new JButton("\u5E93\u5B58\u76D8\u70B9");
		StorageQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(StorageQuery);
		
		JButton StorageInitialize = new JButton("\u5E93\u5B58\u4FE1\u606F\u521D\u59CB\u5316");
		StorageInitialize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(StorageInitialize);
		
		JButton StorageMidify = new JButton("\u5E93\u533A\u8C03\u6574");
		StorageMidify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(StorageMidify);
	}
}
