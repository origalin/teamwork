package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.infoui.DistancePanel;
import edu.nju.presentation.infoui.InstitutionPanel;
import edu.nju.presentation.infoui.SalaryPanel;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.widget.BigButton;

public class GuidePanel_Manager extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	CollertionPanel collertionPanel;
	SendPanel sendPanel;
	InstitutionPanel institutionPanel;
	DistancePanel distancePanel;
	SalaryPanel salaryPanel;
	checkMainUI checkMainUI;
	ArrayList<BigButton> bigButtons=new ArrayList<BigButton>();
	public GuidePanel_Manager(MainFrame frame,String staffID) {
		setOpaque(false);
		this.staffID = staffID;
		this.frame = frame;
		institutionPanel=new InstitutionPanel();
		checkMainUI=new checkMainUI(staffID);
		collertionPanel = new CollertionPanel(staffID);
		sendPanel = new SendPanel(staffID);
		salaryPanel=new SalaryPanel();
		distancePanel=new DistancePanel();
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{66, 64, 66, 86, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		BigButton institutionButton = new BigButton("\u4EBA\u5458\u673A\u6784\u7BA1\u7406\r\n");
		institutionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
			institutionFunc();
			clean();
			institutionButton.setPressed();
			}
		});
		GridBagConstraints gbc_collectButtom = new GridBagConstraints();
		gbc_collectButtom.fill = GridBagConstraints.BOTH;
		gbc_collectButtom.insets = new Insets(0, 0, 5, 0);
		gbc_collectButtom.gridx = 0;
		gbc_collectButtom.gridy = 0;
		add(institutionButton, gbc_collectButtom);
		
		BigButton salaryButton = new BigButton("\u85AA\u6C34\u7B56\u7565\u8BBE\u7F6E");
		salaryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				salaryFunc();
				clean();
				salaryButton.setPressed();
			}
		});
		GridBagConstraints gbc_sendButtom = new GridBagConstraints();
		gbc_sendButtom.fill = GridBagConstraints.BOTH;
		gbc_sendButtom.insets = new Insets(0, 0, 5, 0);
		gbc_sendButtom.gridx = 0;
		gbc_sendButtom.gridy = 1;
		add(salaryButton, gbc_sendButtom);
		
		BigButton distanceButton = new BigButton("\u57CE\u5E02\u8DDD\u79BB\u8BBE\u7F6E");
		GridBagConstraints gbc_checkButton = new GridBagConstraints();
		gbc_checkButton.fill = GridBagConstraints.BOTH;
		gbc_checkButton.insets = new Insets(0, 0, 5, 0);
		gbc_checkButton.gridx = 0;
		gbc_checkButton.gridy = 2;
		add(distanceButton, gbc_checkButton);
		
		distanceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				distanceFunc();
				clean();
				distanceButton.setPressed();
			}
		});
		
		BigButton checkButton = new BigButton("\u5BA1\u6279\u5355\u636E");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clean();
				checkButton.setPressed();
				checkMainUIFunc();
			}
		});
		GridBagConstraints aButton = new GridBagConstraints();
		aButton.fill = GridBagConstraints.BOTH;
		aButton.gridx = 0;
		aButton.gridy = 3;
		add(checkButton, aButton);
		distanceButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				distanceFunc();
				clean();
				distanceButton.setPressed();
			}
		});
		
		bigButtons.add(checkButton);
		bigButtons.add(distanceButton);
		bigButtons.add(salaryButton);
		bigButtons.add(institutionButton);
		
		
		
	}
void institutionFunc(){
	frame.setFunctionPanel(institutionPanel);
}
void salaryFunc(){
	frame.setFunctionPanel(salaryPanel);
}
void distanceFunc(){
	frame.setFunctionPanel(distancePanel);
}
void checkMainUIFunc(){
	frame.setFunctionPanel(checkMainUI);
}

void clean() {
	for(BigButton bt:bigButtons) {
		bt.setNormal();
	}
}
}
