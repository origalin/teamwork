package edu.nju.presentation.mainui;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CheckDialog extends JDialog{
	private final JPanel panel_1 = new JPanel();
	JButton confirmButton;
	JPanel docPanel;
	public CheckDialog() {
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		
		docPanel = new JPanel();
		GridBagConstraints gbc_docPanel = new GridBagConstraints();
		gbc_docPanel.insets = new Insets(0, 0, 5, 0);
		gbc_docPanel.fill = GridBagConstraints.BOTH;
		gbc_docPanel.gridx = 0;
		gbc_docPanel.gridy = 0;
		getContentPane().add(docPanel, gbc_docPanel);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		
		confirmButton = new JButton("\u786E\u8BA4");
		panel_1.add(confirmButton);
		
		
	}
	public JPanel getDocPanel(){
		return docPanel;
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}
	public void setLostMode() {
		setTitle("提示！");
		getDocPanel().add(new JLabel("请检查输入信息完整性"));
		setSize(300, 100);
		setVisible(true);
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
	}
	public void setNetMode() {
		setTitle("提示！");
		getDocPanel().add(new JLabel("网络连接错误！请检查网络连接并重启本软件"));
		setSize(300, 100);
		setVisible(true);
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
	}
	public void setCheckMode(JPanel panel) {
		setTitle("详情");
		getDocPanel().add(panel);
		setSize(600,900);
		setVisible(true);
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
	}
	public void setPreviewMode(JPanel panel) {
		setTitle("预览");
		getDocPanel().add(panel);
		setSize(600,900);
		setVisible(true);
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		panel_1.add(cancelButton);
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
	}
}
