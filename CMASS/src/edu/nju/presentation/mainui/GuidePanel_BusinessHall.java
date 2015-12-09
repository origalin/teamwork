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
import edu.nju.presentation.financeui.createGatheringDocPO;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.transformui.YArrivalDocPanel;
import edu.nju.presentation.transformui.YLoadDocPanel;
import edu.nju.presentation.transformui.ZArrivalDocPanel;
import edu.nju.presentation.transformui.ZLoadDocPanel;

public class GuidePanel_BusinessHall extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	createGatheringDocPO createGatheringDocPO;
	YArrivalDocPanel yArrivalDocPanel;
	YLoadDocPanel yLoadDocPanel;
	public GuidePanel_BusinessHall(MainFrame frame,String staffID) {
		this.staffID = staffID;
		this.frame = frame;
		createGatheringDocPO=new createGatheringDocPO(staffID);
		yArrivalDocPanel = new YArrivalDocPanel(staffID);
		yLoadDocPanel = new YLoadDocPanel(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{66, 64, 66, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton collectButtom = new JButton("\u88C5\u8F66\u7BA1\u7406");
		collectButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				collectFunc();
			}
		});
		GridBagConstraints gbc_collectButtom = new GridBagConstraints();
		gbc_collectButtom.fill = GridBagConstraints.BOTH;
		gbc_collectButtom.insets = new Insets(0, 0, 5, 0);
		gbc_collectButtom.gridx = 0;
		gbc_collectButtom.gridy = 0;
		add(collectButtom, gbc_collectButtom);
		
		JButton sendButtom = new JButton("\u5230\u4EF6\u7BA1\u7406");
		sendButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendFunc();
			}
		});
		GridBagConstraints gbc_sendButtom = new GridBagConstraints();
		gbc_sendButtom.fill = GridBagConstraints.BOTH;
		gbc_sendButtom.insets = new Insets(0, 0, 5, 0);
		gbc_sendButtom.gridx = 0;
		gbc_sendButtom.gridy = 1;
		add(sendButtom, gbc_sendButtom);
		
		JButton btnNewButton = new JButton("\u65B0\u5EFA\u6536\u6B3E\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createGatheringDocfunc();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
	}
	void collectFunc(){
		frame.setFunctionPanel(yLoadDocPanel);
	}
	void sendFunc() {
		frame.setFunctionPanel(yArrivalDocPanel);
	}
	void createGatheringDocfunc(){
		frame.setFunctionPanel(createGatheringDocPO);
	}
}
