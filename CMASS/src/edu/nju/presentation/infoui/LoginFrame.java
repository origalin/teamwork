package edu.nju.presentation.infoui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.Post;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.financeui.accountManagement;
import edu.nju.presentation.financeui.checkCostIncomDocPO;
import edu.nju.presentation.financeui.checkManageStateDoc;
import edu.nju.presentation.financeui.costManagement;
import edu.nju.presentation.logispicqueryui.QueryFrame;
import edu.nju.presentation.mainui.GuidePanel_BusinessHall;
import edu.nju.presentation.mainui.GuidePanel_Courier;
import edu.nju.presentation.mainui.GuidePanel_Finance;
import edu.nju.presentation.mainui.GuidePanel_Manager;
import edu.nju.presentation.mainui.GuidePanel_Storage;
import edu.nju.presentation.mainui.GuidePanel_System;
import edu.nju.presentation.mainui.GuidePanel_TransferCenter;
import edu.nju.presentation.mainui.MainFrame;
import edu.nju.presentation.storageui.InWareHouseManagment;
import edu.nju.presentation.storageui.OutWareHouseManagment;
import edu.nju.presentation.storageui.StorageQuery;
import edu.nju.presentation.systemui.OperationPanel;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.transformui.YLoadDocPanel;
import edu.nju.presentation.transformui.ZArrivalDocPanel;
import edu.nju.presentation.widget.SmallButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {
	JTextField account;
	JPasswordField password;
	JButton confirm, query;
	MainFrame mainFrame;
	QueryFrame queryFrame;
	InstitutionLogicService institution;
	ImageIcon background = new ImageIcon("images/loginbackground.png");
	public LoginFrame() {
		
		JLabel backlabel = new JLabel(background);
		backlabel.setSize(background.getIconWidth(), background.getIconHeight());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(backlabel,new Integer(Integer.MIN_VALUE));
		
		Image image = Toolkit.getDefaultToolkit().getImage(   
	               "images/icon.png"); 
  
        // 设置标题栏的图标为face.gif  
        this.setIconImage(image);
		this.setTitle("登陆");
		this.setSize(450, 210);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		((JPanel)getContentPane()).setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 44, 273, 42, 0};
		gridBagLayout.rowHeights = new int[]{20, 40, 40, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		JLabel label = new JLabel("\u5DE5\u53F7");
		label.setFont(new Font("黑体", Font.PLAIN, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		account = new JTextField(20);
		GridBagConstraints gbc_account = new GridBagConstraints();
		gbc_account.anchor = GridBagConstraints.WEST;
		gbc_account.insets = new Insets(0, 0, 5, 5);
		gbc_account.gridx = 2;
		gbc_account.gridy = 1;
		getContentPane().add(account, gbc_account);
		JLabel label_1 = new JLabel("密码");
		label_1.setFont(new Font("黑体", Font.PLAIN, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 2;
		getContentPane().add(label_1, gbc_label_1);
		password = new JPasswordField(20);
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.anchor = GridBagConstraints.WEST;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridx = 2;
		gbc_password.gridy = 2;
		getContentPane().add(password, gbc_password);
		confirm = new SmallButton("确认");
		GridBagConstraints gbc_confirm = new GridBagConstraints();
		gbc_confirm.anchor = GridBagConstraints.SOUTHEAST;
		gbc_confirm.insets = new Insets(0, 30, 0, -60);
		gbc_confirm.gridx = 1;
		gbc_confirm.gridy = 3;
		getContentPane().add(confirm, gbc_confirm);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				loginAction(account.getText(),
						String.valueOf(password.getPassword()));
			}
		});
		getRootPane().setDefaultButton(confirm);
		query = new SmallButton("快递查询");
		GridBagConstraints gbc_query = new GridBagConstraints();
		gbc_query.anchor = GridBagConstraints.SOUTHWEST;
		gbc_query.insets = new Insets(0, 90, 0, -25);
		gbc_query.gridx = 2;
		gbc_query.gridy = 3;
		getContentPane().add(query, gbc_query);
		query.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				queryFrame = new QueryFrame();
				setVisible(false);
				queryFrame.comeout();
			}
		});
		this.setResizable(false);
		institution = UiFactory.getInstitutionLogicService();
		this.setVisible(true);
	}

	private void loginAction(String account, String password) {// 还要完善
		SystemLogicService systemLogicService = UiFactory
				.getSystemLogicService();
		String institutionstr = null;
		String namestr = null;
		String str[] = null;
		try {
			try {
				str = systemLogicService.getPasswordAndPower(account);
			} catch (DatabaseNULLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"用户名不存在");
			}
			institutionstr = institution.getInstitutionID(account)+" "+institution.getInstitutionName(account);
			namestr = account+" "+institution.getStaffName(account);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		
		if(!str[0].equals(password)){
			
			
			JOptionPane.showMessageDialog(null,"密码错误");
		}else{
			mainFrame = new MainFrame();
			mainFrame.setInstitution(institutionstr);
			mainFrame.setName(namestr);
			mainFrame.comeout();
		switch (str[1]) {
		case "总经理":
			mainFrame.setFunctionPanel(new InstitutionPanel());
			mainFrame.setGuidePanel(new GuidePanel_Manager(mainFrame, account));
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
			mainFrame.setFunctionPanel(new YLoadDocPanel(account));
			mainFrame.setGuidePanel(new GuidePanel_BusinessHall(mainFrame, account));
			break;
		case "快递员":
			mainFrame.setFunctionPanel(new CollertionPanel(account));
			mainFrame.setGuidePanel(new GuidePanel_Courier(mainFrame, account));
			break;
		case "管理员":
			try {
				mainFrame.setFunctionPanel(new OperationPanel());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainFrame.setGuidePanel(new GuidePanel_System(mainFrame, account));
			
			break;

		default:
			break;
		}
		}
		this.setVisible(false);
	}
}
