package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JButton;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.button.BigButton;
import edu.nju.presentation.collectionui.CollertionPanel;

import edu.nju.presentation.financeui.createGatheringDocPO;
import edu.nju.presentation.infoui.CarPanel;
import edu.nju.presentation.infoui.DriverPanel;
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
	CarPanel carPanel;
	DriverPanel driverPanel;
	ArrayList<BigButton> buttons = new ArrayList<>();
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	public GuidePanel_BusinessHall(MainFrame frame,String staffID) {
		this.staffID = staffID;
		this.frame = frame;
		createGatheringDocPO=new createGatheringDocPO(staffID);
		yArrivalDocPanel = new YArrivalDocPanel(staffID);
		yLoadDocPanel = new YLoadDocPanel(staffID);
		
			try {
				carPanel=new CarPanel(institutionLogicService.getInstitutionName(staffID));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				driverPanel=new DriverPanel(institutionLogicService.getInstitutionName(staffID));
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{60, 60, 60, 60, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		BigButton collectButtom = new BigButton("\u88C5\u8F66\u7BA1\u7406");
		collectButtom.setPressed();
		collectButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				clean();
				collectButtom.setPressed();
				collectFunc();
			}
		});
		GridBagConstraints gbc_collectButtom = new GridBagConstraints();
		gbc_collectButtom.fill = GridBagConstraints.BOTH;
		gbc_collectButtom.insets = new Insets(0, 0, 0, 0);
		gbc_collectButtom.gridx = 0;
		gbc_collectButtom.gridy = 0;
		add(collectButtom, gbc_collectButtom);
		
		BigButton sendButtom = new BigButton("\u5230\u4EF6\u7BA1\u7406");
		sendButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				clean();
				sendButtom.setPressed();
				sendFunc();
			}
		});
		GridBagConstraints gbc_sendButtom = new GridBagConstraints();
		gbc_sendButtom.fill = GridBagConstraints.BOTH;
		gbc_sendButtom.insets = new Insets(0, 0, 0, 0);
		gbc_sendButtom.gridx = 0;
		gbc_sendButtom.gridy = 1;
		add(sendButtom, gbc_sendButtom);

		BigButton carButton = new BigButton("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(carButton, gbc_btnNewButton);
		
		carButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clean();
				carButton.setPressed();
			carFunc();
				
			}
		});
		
		BigButton button = new BigButton("\u53F8\u673A\u4FE1\u606F\u7BA1\u7406");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 0, 0);
		gbc_button.gridx = 0;
		gbc_button.gridy = 3;
		add(button, gbc_button);
		
		BigButton btnNewButton = new BigButton("\u65B0\u5EFA\u6536\u6B3E\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
				btnNewButton.setPressed();
				createGatheringDocfunc();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 4;
		add(btnNewButton, gbc_btnNewButton_1);
		
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clean();
				button.setPressed();
				driverFunc();
				
			}
		});
		setOpaque(false);
		buttons.add(button);
		buttons.add(collectButtom);
		buttons.add(sendButtom);
		buttons.add(carButton);
		buttons.add(btnNewButton);
		
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

	void carFunc(){
		frame.setFunctionPanel(carPanel);
	}
	void driverFunc(){
		frame.setFunctionPanel(driverPanel);

	}
	void clean() {
		for(BigButton bt:buttons) {
			bt.setNormal();
		}
	}
}
