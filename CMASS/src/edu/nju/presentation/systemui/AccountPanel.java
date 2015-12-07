package edu.nju.presentation.systemui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.ComboBoxUI;

import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.presentation.UiFactory;

public class AccountPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	SystemLogicService systemLogicService=UiFactory.getSystemLogicService();
	/**
	 * Create the panel.
	 */
	public AccountPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{67, 130, 0, 115, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{518, 0};
		gbl_panel.rowHeights = new int[]{136, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("\u8D26\u6237\u5BC6\u7801\u6743\u9650\u7BA1\u7406");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{93, 0, 160, 146, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 26, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5DE5\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton button_2 = new JButton("\u70B9\u51FB\u67E5\u8BE2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
	
		JLabel label_3 = new JLabel("\u5F53\u524D\u5BC6\u7801");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 2;
		panel_1.add(label_3, gbc_label_3);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton button_3 = new JButton("\u70B9\u51FB\u4FEE\u6539");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 2;
		panel_1.add(button_3, gbc_button_3);
		
		JLabel label_2 = new JLabel("\u5F53\u524D\u6743\u9650");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		panel_1.add(label_2, gbc_label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u603B\u7ECF\u7406", "\u9AD8\u7EA7\u8D22\u52A1", "\u4F1A\u8BA1", "\u8425\u4E1A\u5385", "\u4E2D\u8F6C\u4E2D\u5FC3"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		panel_1.add(comboBox, gbc_comboBox);
		
		JButton button_4 = new JButton("\u70B9\u51FB\u4FEE\u6539");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 3;
		panel_1.add(button_4, gbc_button_4);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		panel_2.add(button);
		
		
		
		JButton button_1 = new JButton("\u53D6\u6D88\u4FDD\u5B58");
		panel_2.add(button_1);
		
		//查询
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str[] = null;
				try {
					str=systemLogicService.getPasswordAndPower(textField.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_1.setText(str[0]);
				comboBox.setSelectedItem(str[1]);
				textField_1.setEditable(false);
				comboBox.setEnabled(false);
			}
		});
		
		//修改password
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textField_1.setEditable(true);
			}
		});
		//修改power
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				comboBox.setEnabled(true);
			}
		});
		
		//确认
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str[]={textField.getText(),textField_1.getText(),(String)comboBox.getSelectedItem()};
				try {
					systemLogicService.changePasswordAndPower(str);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_1.setEditable(false);
				comboBox.setEnabled(false);
				
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str[] = null;
				try {
					str=systemLogicService.getPasswordAndPower(textField.getText());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_1.setText(str[0]);
				comboBox.setSelectedItem(str[1]);
				textField_1.setEditable(false);
				comboBox.setEnabled(false);
			
			}
		});
	}

}
