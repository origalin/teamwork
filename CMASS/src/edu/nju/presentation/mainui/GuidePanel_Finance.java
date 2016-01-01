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
import edu.nju.presentation.financeui.accountManagement;
import edu.nju.presentation.financeui.checkCostIncomDocPO;
import edu.nju.presentation.financeui.checkManageStateDoc;
import edu.nju.presentation.financeui.costManagement;
import edu.nju.presentation.transferui.SendPanel;
import edu.nju.presentation.widget.BigButton;

public class GuidePanel_Finance extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	accountManagement accountManagement;
	checkCostIncomDocPO checkCostIncomDocPO;
	checkManageStateDoc checkManageStateDoc;
	costManagement costManagement;
	ArrayList<BigButton> buttons=new ArrayList<BigButton>();
	public GuidePanel_Finance(MainFrame frame,String staffID) {
		setOpaque(false);
		this.staffID = staffID;
		this.frame = frame;
		accountManagement=new accountManagement(staffID);
		checkCostIncomDocPO=new checkCostIncomDocPO(staffID);
		checkManageStateDoc=new checkManageStateDoc(staffID);
		costManagement=new costManagement(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{60, 60, 60, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		BigButton collectButtom = new BigButton("\u8D26\u6237\u7BA1\u7406");
		collectButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
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
		
		BigButton sendButtom = new BigButton("\u67E5\u770B\u6210\u672C\u6536\u76CA\u8868");
		sendButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		
		BigButton btnNewButton_1 = new BigButton("\u67E5\u770B\u7ECF\u8425\u60C5\u51B5\u8868");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clean();
				btnNewButton_1.setPressed();
				stateFunc();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		BigButton btnNewButton = new BigButton("\u6210\u672C\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clean();
				btnNewButton.setPressed();
				costFunc();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
		buttons.add(collectButtom);
		buttons.add(btnNewButton);
		buttons.add(btnNewButton_1);
		buttons.add(sendButtom);
		collectButtom.setPressed();
		
	}
	void collectFunc(){	
		frame.setFunctionPanel(accountManagement);
	}
	void sendFunc() {
		frame.setFunctionPanel(checkCostIncomDocPO);
	}
	void stateFunc(){
		frame.setFunctionPanel(checkManageStateDoc);
	}
	void costFunc(){
		frame.setFunctionPanel(costManagement);
	}
	void clean() {
		for(BigButton bt:buttons) {
			bt.setNormal();
		}
	}
}
