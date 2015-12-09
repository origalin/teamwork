package edu.nju.presentation.infoui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.logispicqueryui.QueryFrame;
import edu.nju.presentation.mainui.GuidePanel_Courier;
import edu.nju.presentation.mainui.MainFrame;
import edu.nju.presentation.transformui.SendPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	JPanel pn1,pn2,pn3;
	JTextField account;
	JPasswordField password;
	JButton confirm,query;
	MainFrame mainFrame;
	QueryFrame queryFrame;
	 public LoginFrame() {
		this.setTitle("登陆");
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		this.setSize(350, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(3,1));
		GridBagLayout gbl_pn1 = new GridBagLayout();
		gbl_pn1.columnWidths = new int[]{94, 24, 126, 0};
		gbl_pn1.rowHeights = new int[]{53, 0};
		gbl_pn1.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pn1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pn1.setLayout(gbl_pn1);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		JLabel label = new JLabel("\u5DE5\u53F7");
		pn1.add(label, gbc);
		GridBagLayout gbl_pn2 = new GridBagLayout();
		gbl_pn2.columnWidths = new int[]{94, 24, 126, 0};
		gbl_pn2.rowHeights = new int[]{57, 0};
		gbl_pn2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pn2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pn2.setLayout(gbl_pn2);
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.anchor = GridBagConstraints.WEST;
		gbc_1.insets = new Insets(0, 0, 0, 5);
		gbc_1.gridx = 1;
		gbc_1.gridy = 0;
		JLabel label_1 = new JLabel("密码");
		pn2.add(label_1, gbc_1);
		password = new JPasswordField(20);
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.anchor = GridBagConstraints.WEST;
		gbc_password.gridx = 2;
		gbc_password.gridy = 0;
		pn2.add(password, gbc_password);
		GridBagLayout gbl_pn3 = new GridBagLayout();
		gbl_pn3.columnWidths = new int[]{86, 57, 0, 81, 0};
		gbl_pn3.rowHeights = new int[]{55, 0};
		gbl_pn3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pn3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pn3.setLayout(gbl_pn3);
		query = new JButton("快递查询");
		query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				queryFrame = new QueryFrame();
				setVisible(false);
				queryFrame.comeout();
			}
		});
		confirm = new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				loginAction(account.getText(),new String(password.getPassword()));
			}
		});
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.anchor = GridBagConstraints.WEST;
		gbc_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_confirm.gridx = 1;
		gbc_confirm.gridy = 0;
		pn3.add(confirm, gbc_confirm);
		GridBagConstraints gbc_query = new GridBagConstraints();
		gbc_query.anchor = GridBagConstraints.EAST;
		gbc_query.gridx = 3;
		gbc_query.gridy = 0;
		pn3.add(query, gbc_query);
		getContentPane().add(pn1);
		account = new JTextField(20);
		GridBagConstraints gbc_account = new GridBagConstraints();
		gbc_account.anchor = GridBagConstraints.WEST;
		gbc_account.gridx = 2;
		gbc_account.gridy = 0;
		pn1.add(account, gbc_account);
		getContentPane().add(pn2);
		getContentPane().add(pn3);
		this.setResizable(false);
		this.setVisible(true);
	}
	 private void loginAction(String account, String password){//还要完善
		 SystemLogicService systemLogicService=UiFactory.getSystemLogicService();
		 try {
			systemLogicService.getPasswordAndPower(account);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 mainFrame = new MainFrame();
		 
		 mainFrame.comeout();
		 mainFrame.setFunctionPanel(new CollertionPanel("10010101010"));
		 mainFrame.setGuidePanel(new GuidePanel_Courier(mainFrame, "1010101010"));
		 
		 this.setVisible(false);
	 }
}
