package edu.nju.presentation.infoui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.logispicqueryui.QueryFrame;
import edu.nju.presentation.mainui.MainFrame;
import edu.nju.presentation.transformui.SendPanel;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	JPanel pn1,pn2,pn3;
	JTextField account;
	JPasswordField password;
	JButton confirm,query;
	MainFrame mainFrame;
	QueryFrame queryFrame;
	 public LoginFrame() {
		this.setTitle("��½");
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		account = new JTextField(20);
		password = new JPasswordField(20);
		confirm = new JButton("ȷ��");
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				loginAction(account.getText(),new String(password.getPassword()));
			}
		});
		query = new JButton("��ݲ�ѯ");
		query.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				queryFrame = new QueryFrame();
				setVisible(false);
				queryFrame.comeout();
			}
		});
		this.setSize(350, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		pn1.add(new JLabel("�ʺ�"));
		pn1.add(account);
		pn2.add(new JLabel("����"));
		pn2.add(password);
		pn3.add(confirm);
		pn3.add(query);
		this.add(pn1);
		this.add(pn2);
		this.add(pn3);
		this.setResizable(false);
		this.setVisible(true);
	}
	 private void loginAction(String account, String password){//��Ҫ����
		 mainFrame = new MainFrame();
		 
		 mainFrame.comeout();
		 mainFrame.changeFunctionPanel(new CollertionPanel(" "," "));
		 this.setVisible(false);
	 }
}
