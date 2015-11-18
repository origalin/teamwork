package edu.nju.presentation.mainui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;

public class MainFrame extends JFrame{
	public GridBagConstraints functionConstraints;
	private JScrollPane scrollPane;
	JScrollPane scrollPane_1;
	public MainFrame(){
		setSize(833, 600);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 580, 50, 43, 0};
		gridBagLayout.rowHeights = new int[]{38, 0, 469, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		functionConstraints = new GridBagConstraints();
		functionConstraints.gridheight = 2;
		functionConstraints.gridwidth = 2;
		functionConstraints.insets = new Insets(0, 0, 5, 0);
		functionConstraints.fill = GridBagConstraints.BOTH;
		functionConstraints.gridx = 1;
		functionConstraints.gridy = 1;
		
		
		JLabel lblCmass = new JLabel("CMASS\u7CFB\u7EDF");
		lblCmass.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCmass);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{135, 0};
		gbl_panel_2.rowHeights = new int[]{48, 48, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_2.add(panel_1, gbc_panel_1);
		
		JLabel label_1 = new JLabel("\u529F\u80FD\u5BFC\u822A");
		panel_1.add(label_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(null);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);
		
		JLabel label = new JLabel("\u674E\u96F7");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
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
	public void setFunctionPanel(JPanel panel) {
		this.scrollPane.setViewportView(panel);
	}
	public void setGuidePanel(JPanel panel) {
		this.scrollPane_1.setViewportView(panel);
	}
}