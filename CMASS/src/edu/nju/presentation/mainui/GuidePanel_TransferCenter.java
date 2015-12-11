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
import edu.nju.presentation.transformui.TransferDocPanel_Car;
import edu.nju.presentation.transformui.TransferDocPanel_Plane;
import edu.nju.presentation.transformui.TransferDocPanel_Train;
import edu.nju.presentation.transformui.ZArrivalDocPanel;
import edu.nju.presentation.transformui.ZLoadDocPanel;

public class GuidePanel_TransferCenter extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	ZArrivalDocPanel zArrivalDocPanel;
	ZLoadDocPanel zLoadDocPanel;
	TransferDocPanel_Car transferDocPanel_Car;
	TransferDocPanel_Train transferDocPanel_Train;
	TransferDocPanel_Plane transferDocPanel_Plane;
	public GuidePanel_TransferCenter(MainFrame frame,String staffID) {
		this.staffID = staffID;
		this.frame = frame;
		zArrivalDocPanel = new ZArrivalDocPanel(staffID);
		zLoadDocPanel = new ZLoadDocPanel(staffID);
		transferDocPanel_Car = new TransferDocPanel_Car(staffID);
		transferDocPanel_Plane = new TransferDocPanel_Plane(staffID);
		transferDocPanel_Train = new TransferDocPanel_Train(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{66, 64, 60, 60, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton collectButtom = new JButton("\u5230\u4EF6\u7BA1\u7406");
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
		
		JButton sendButtom = new JButton("\u88C5\u8F66\u7BA1\u7406");
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
		
		JButton button = new JButton("\u6C7D\u8FD0\u4E2D\u8F6C");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transFunc();
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		JButton button_1 = new JButton("\u94C1\u8DEF\u4E2D\u8F6C");
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transFunc1();
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 0;
		gbc_button_1.gridy = 3;
		add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("\u822A\u8FD0\u4E2D\u8F6C");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transFunc2();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.BOTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 0;
		gbc_button_2.gridy = 4;
		add(button_2, gbc_button_2);
	}
	void collectFunc(){
		frame.setFunctionPanel(zArrivalDocPanel);
	}
	void sendFunc() {
		frame.setFunctionPanel(zLoadDocPanel);
	}
	void transFunc() {
		frame.setFunctionPanel(transferDocPanel_Car);
	}
	void transFunc1() {
		frame.setFunctionPanel(transferDocPanel_Train);
	}
	void transFunc2() {
		frame.setFunctionPanel(transferDocPanel_Plane);
	}
}
