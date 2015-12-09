package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;

import javax.swing.JButton;

import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.systemui.AccountPanel;
import edu.nju.presentation.systemui.OperationPanel;
import edu.nju.presentation.transformui.SendPanel;

public class GuidePanel_System extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	CollertionPanel collertionPanel;
	SendPanel sendPanel;
	OperationPanel operationPanel;
	AccountPanel accountPanel;
	
	public GuidePanel_System(MainFrame frame,String staffID) {
		this.staffID = staffID;
		this.frame = frame;
		collertionPanel = new CollertionPanel(staffID);
		sendPanel = new SendPanel(staffID);
		try {
			operationPanel=new OperationPanel();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		accountPanel=new AccountPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{66, 64, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton operationButtom = new JButton("\u64CD\u4F5C\u65E5\u5FD7\u67E5\u8BE2");
		operationButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				operationFunc();
			}
		});
		GridBagConstraints gbc_collectButtom = new GridBagConstraints();
		gbc_collectButtom.fill = GridBagConstraints.BOTH;
		gbc_collectButtom.insets = new Insets(0, 0, 5, 0);
		gbc_collectButtom.gridx = 0;
		gbc_collectButtom.gridy = 0;
		add(operationButtom, gbc_collectButtom);
		
		JButton accountButtom = new JButton("\u5BC6\u7801\u6743\u9650\u7BA1\u7406");
		accountButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				accountFunc();
			}
		});
		GridBagConstraints gbc_sendButtom = new GridBagConstraints();
		gbc_sendButtom.fill = GridBagConstraints.BOTH;
		gbc_sendButtom.insets = new Insets(0, 0, 5, 0);
		gbc_sendButtom.gridx = 0;
		gbc_sendButtom.gridy = 1;
		add(accountButtom, gbc_sendButtom);
	}
	void collectFunc(){
		frame.setFunctionPanel(collertionPanel);
	}
	void sendFunc() {
		frame.setFunctionPanel(sendPanel);
	}
	void operationFunc(){
		frame.setFunctionPanel(operationPanel);
	}
	void accountFunc(){
		frame.setFunctionPanel(accountPanel);
	}
}
