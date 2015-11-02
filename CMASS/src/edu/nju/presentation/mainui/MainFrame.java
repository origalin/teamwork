package edu.nju.presentation.mainui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

public class MainFrame extends JFrame{
	public MainFrame(){
		setSize(833, 600);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 580, 50, 43, 0};
		gridBagLayout.rowHeights = new int[]{38, 0, 469, 20, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		JLabel lblCmass = new JLabel("CMASS\u7CFB\u7EDF");
		lblCmass.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCmass);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(10, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1);
		
		JLabel label_1 = new JLabel("\u529F\u80FD\u5BFC\u822A");
		panel_1.add(label_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JLabel label = new JLabel("\u674E\u96F7");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		getContentPane().add(panel_3, gbc_panel_3);
		
		JLabel label_2 = new JLabel("\u4FDD\u6301\u4E2D\u3002\u3002\u3002");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label_2);
	}
	public void comeout() {
		this.setVisible(true);
	}
}