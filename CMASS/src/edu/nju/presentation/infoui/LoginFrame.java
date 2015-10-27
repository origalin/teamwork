package edu.nju.presentation.infoui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	JPanel pn1,pn2,pn3;
	JTextField account,password;
	JButton confirm,query;
	 public LoginFrame() {
		this.setTitle("��½");
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		account = new JTextField(20);
		account.setText("�˺�");
		account.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO �Զ����ɵķ������
				if(account.getText().equals(""))
					account.setText("�˺�");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO �Զ����ɵķ������
			}
		});
		account.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				if(account.getText().equals("�˺�"))
					account.setText("");
			}
		});
		password = new JTextField(20);
		password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO �Զ����ɵķ������
				if(password.getText().equals(""))
					password.setText("����");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO �Զ����ɵķ������
				
			}
		});
		password.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO �Զ����ɵķ������
				if(password.getText().equals("����"))
					password.setText("");
			}
		});
		password.setText("����");
		confirm = new JButton("ȷ��");
		query = new JButton("��ݲ�ѯ");
		this.setSize(350, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(3,1));
		pn1.add(account);
		pn2.add(password);
		pn3.add(confirm);
		pn3.add(query);
		this.add(pn1);
		this.add(pn2);
		this.add(pn3);
		this.setResizable(false);
		this.setVisible(true);
	}
}
