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
		this.setTitle("登陆");
		pn1 = new JPanel();
		pn2 = new JPanel();
		pn3 = new JPanel();
		account = new JTextField(20);
		account.setText("账号");
		account.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(account.getText().equals(""))
					account.setText("账号");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
			}
		});
		account.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(account.getText().equals("账号"))
					account.setText("");
			}
		});
		password = new JTextField(20);
		password.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				if(password.getText().equals(""))
					password.setText("密码");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		password.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if(password.getText().equals("密码"))
					password.setText("");
			}
		});
		password.setText("密码");
		confirm = new JButton("确认");
		query = new JButton("快递查询");
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
