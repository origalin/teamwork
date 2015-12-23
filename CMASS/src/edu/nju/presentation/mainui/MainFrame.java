package edu.nju.presentation.mainui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Date;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.border.BevelBorder;

import edu.nju.tools.Time;

import java.awt.Color;
import java.awt.Font;

public class MainFrame extends JFrame{
	public GridBagConstraints functionConstraints;
	private JScrollPane scrollPane;
	JPanel panel_2;
	ImageIcon background = new ImageIcon("images/background.png");
	ImageIcon small = new ImageIcon("images/small.png");
	ImageIcon head = new ImageIcon("images/head.png");
	public MainFrame(){
		setSize(1000, 650);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{183, 580, 50, 43, 0};
		gridBagLayout.rowHeights = new int[]{38, 34, 472, 18, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
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
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{199, 0};
		gbl_panel.rowHeights = new int[]{0, 24, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblCmass = new JLabel("CMASS");
		lblCmass.setForeground(Color.WHITE);
		lblCmass.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCmass.setFont(new Font("黑体", Font.BOLD, 20));
		lblCmass.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblCmass = new GridBagConstraints();
		gbc_lblCmass.insets = new Insets(-5, 5, 0, 0);
		gbc_lblCmass.anchor = GridBagConstraints.WEST;
		gbc_lblCmass.gridx = 0;
		gbc_lblCmass.gridy = 0;
		panel.add(lblCmass, gbc_lblCmass);
		
		JLabel lblv = new JLabel("\u7269\u6D41\u7BA1\u7406\u7CFB\u7EDFV1.0");
		lblv.setForeground(Color.WHITE);
		lblv.setFont(new Font("黑体", Font.BOLD, 20));
		GridBagConstraints gbc_lblv = new GridBagConstraints();
		gbc_lblv.insets = new Insets(-20, 5, 5, 0);
		gbc_lblv.anchor = GridBagConstraints.WEST;
		gbc_lblv.gridx = 0;
		gbc_lblv.gridy = 1;
		panel.add(lblv, gbc_lblv);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(10, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{196, 17, 0, 445, 49, 100, 26, 10};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel(small);
		lblNewLabel.setSize(small.getIconWidth(), small.getIconHeight());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label = new JLabel("\u673A\u6784");
		label.setForeground(Color.GRAY);
		label.setFont(new Font("黑体", Font.PLAIN, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel lblNewLabel_1 = new JLabel(head);
		lblNewLabel_1.setSize(head.getIconWidth(), head.getIconHeight());
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("00251000000 \u5F20\u4E09\u4E09");
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{198, 0};
		gbl_panel_2.rowHeights = new int[]{48, 48, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setViewportBorder(null);
		scrollPane.setBorder(null);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(20, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(27, 29, 37));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 4;
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{652, 248, 72, 0};
		gbl_panel_3.rowHeights = new int[]{18, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_1 = new JLabel("Powered By Open-Source Software");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		panel_3.add(label_1, gbc_label_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 0;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JPanel content = (JPanel) getContentPane();
		content.setOpaque(false);
		
		JLabel backlabel = new JLabel(background);
		backlabel.setSize(background.getIconWidth(), background.getIconHeight());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(backlabel,new Integer(Integer.MIN_VALUE));
		
		Thread time = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while (true) {
					lblNewLabel_3.setText(Time.toSecondTime(new Date()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		time.start();
		
		
	}
	
	public void comeout() {
		this.setVisible(true);
	}
	public void setFunctionPanel(JPanel panel) {
		this.scrollPane.setViewportView(panel);
	}
	public void setGuidePanel(JPanel panel) {
		panel_2.removeAll();
		panel_2.add(panel);
	}
}