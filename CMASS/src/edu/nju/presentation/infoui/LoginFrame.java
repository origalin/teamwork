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
import edu.nju.po.Post;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.financeui.accountManagement;
import edu.nju.presentation.financeui.checkCostIncomDocPO;
import edu.nju.presentation.financeui.checkManageStateDoc;
import edu.nju.presentation.financeui.costManagement;
import edu.nju.presentation.logispicqueryui.QueryFrame;
import edu.nju.presentation.mainui.GuidePanel_BusinessHall;
import edu.nju.presentation.mainui.GuidePanel_Courier;
import edu.nju.presentation.mainui.GuidePanel_Finance;
import edu.nju.presentation.mainui.GuidePanel_Storage;
import edu.nju.presentation.mainui.GuidePanel_TransferCenter;
import edu.nju.presentation.mainui.MainFrame;
import edu.nju.presentation.storageui.InWareHouseManagment;
import edu.nju.presentation.storageui.OutWareHouseManagment;
import edu.nju.presentation.storageui.StorageQuery;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.transformui.ZArrivalDocPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	JPanel pn1, pn2, pn3;
	JTextField account;
	JPasswordField password;
	JButton confirm, query;
	MainFrame mainFrame;
	QueryFrame queryFrame;

	public LoginFrame() {
		this.setTitle("登陆");
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		this.setSize(450, 222);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new GridLayout(3, 1));
		GridBagLayout gbl_pn1 = new GridBagLayout();
		gbl_pn1.columnWidths = new int[] { 94, 24, 126, 0 };
		gbl_pn1.rowHeights = new int[] { 53, 0 };
		gbl_pn1.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pn1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pn1.setLayout(gbl_pn1);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 0, 5);
		gbc.gridx = 1;
		gbc.gridy = 0;
		JLabel label = new JLabel("\u5DE5\u53F7");
		pn1.add(label, gbc);
		GridBagLayout gbl_pn2 = new GridBagLayout();
		gbl_pn2.columnWidths = new int[] { 94, 24, 126, 0 };
		gbl_pn2.rowHeights = new int[] { 57, 0 };
		gbl_pn2.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pn2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
		gbl_pn3.columnWidths = new int[] { 19, 57, 0, 81, 0, 0 };
		gbl_pn3.rowHeights = new int[] { 55, 0 };
		gbl_pn3.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_pn3.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
				loginAction(account.getText(),
						String.valueOf(password.getPassword()));
			}
		});
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.anchor = GridBagConstraints.WEST;
		gbc_confirm.insets = new Insets(0, 0, 0, 5);
		gbc_confirm.gridx = 1;
		gbc_confirm.gridy = 0;
		pn3.add(confirm, gbc_confirm);
		GridBagConstraints gbc_query = new GridBagConstraints();
		gbc_query.insets = new Insets(0, 0, 0, 5);
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

	private void loginAction(String account, String password) {// 还要完善
		SystemLogicService systemLogicService = UiFactory
				.getSystemLogicService();
		
		String str[] = null;
		try {
			str = systemLogicService.getPasswordAndPower(account);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		if(!str[0].equals(password)){
			
			
			JOptionPane.showMessageDialog(null,"密码错误");
		}else{
			mainFrame = new MainFrame();

			mainFrame.comeout();
		switch (str[1]) {
		case "总经理":
			
			break;
		case "高级财务":
			/*
			 * accountManagement accountManagement;
	checkCostIncomDocPO checkCostIncomDocPO;
	checkManageStateDoc checkManageStateDoc;
	costManagement costManagement;
			 */
			mainFrame.setFunctionPanel(new accountManagement(account));
			mainFrame.setGuidePanel(new GuidePanel_Finance(mainFrame, account));
			break;
		case "会计":

			break;
		case "中转中心业务员":
			mainFrame.setFunctionPanel(new ZArrivalDocPanel(account));
			mainFrame.setGuidePanel(new GuidePanel_TransferCenter(mainFrame, account));
			break;
		case "仓库管理人员":
			mainFrame.setFunctionPanel(new InWareHouseManagment(account));
			
			mainFrame.setGuidePanel(new GuidePanel_Storage(mainFrame, account));
			break;
		case "营业厅业务员":
			mainFrame.setFunctionPanel(new SendPanel(account));
			mainFrame.setGuidePanel(new GuidePanel_BusinessHall(mainFrame, account));
			break;
		case "快递员":
			mainFrame.setFunctionPanel(new CollertionPanel(account));
			mainFrame.setGuidePanel(new GuidePanel_Courier(mainFrame, account));
			break;

		default:
			break;
		}
		}
		this.setVisible(false);
	}
}
