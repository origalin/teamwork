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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import edu.nju.presentation.widget.SmallButton;
import javax.swing.JScrollPane;

public class CheckDialog extends JDialog{
	private final JPanel panel_1 = new JPanel();
	SmallButton confirmButton;
	ImageIcon imageIcon = new ImageIcon("images/dback.png");
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	public CheckDialog() {
		setSize(960,800);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setLocationRelativeTo(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		scrollPane.setViewportView(panel_2);
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		getContentPane().add(panel_1, gbc_panel_1);
		
		confirmButton = new SmallButton("\u786E\u8BA4");
		panel_1.add(confirmButton);
		panel_1.setOpaque(false);
		setAlwaysOnTop(true);
		//setModal(true);
		((JPanel)getContentPane()).setOpaque(false);
		JLabel back = new JLabel(imageIcon);
		back.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		setModal(true);
		
	}
	public void setDocPanel(Component p){
		scrollPane.setViewportView(p);
	}
	public void setText(String s) {
		JLabel text = new JLabel(s);
		panel_2.add(text);
		//scrollPane.setViewportView(text);
	}
	public SmallButton getConfirmButton() {
		return confirmButton;
	}
	public void setWarningMode(String s) {
		setTitle("提示！");
		
		setSize(300, 160);
		setLocationRelativeTo(null);
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		setText(s);
		setResizable(false);
		setVisible(true);
		//setModal(true);
	}
//	public void setNetMode() {
//		setTitle("提示！");
//		setText("网络连接错误！请检查网络连接并重启本软件");
//		setSize(300, 160);
//		setLocationRelativeTo(null);
//		getConfirmButton().addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO 自动生成的方法存根
//				dispose();
//			}
//		});
//		setVisible(true);
//		setModal(true);
//	}
	public void setCheckMode(JPanel panel) {
		setTitle("详情");
		setDocPanel(panel);
		
		
		getConfirmButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		setVisible(true);
		setModal(true);
	}
	public void setPreviewMode(JPanel panel) {
		setTitle("预览");
		setDocPanel(panel);
		
		SmallButton cancelButton = new SmallButton("\u53D6\u6D88");
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
		setVisible(true);
		setModal(true);
	}
}
