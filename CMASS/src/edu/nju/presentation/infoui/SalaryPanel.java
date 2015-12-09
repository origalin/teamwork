package edu.nju.presentation.infoui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;
import javax.swing.JButton;

import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.DriverPO;
import edu.nju.po.SalaryPO;
import edu.nju.presentation.UiFactory;

public class SalaryPanel extends JPanel {
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_8 ;
	
	JPanel panel_4;
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	DriverLogicService driverLogicService=UiFactory.getDriverLogicService();

	/**
	 * Create the panel.
	 */
	public SalaryPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{474, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 122, 35, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u5DE5\u8D44\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		panel.add(label);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 159, 146, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5DE5\u53F7\u6216\u53F8\u673A\u7F16\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel_3.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panel_3.add(textField, gbc_textField);
		
		JButton button_2 = new JButton("\u70B9\u51FB\u67E5\u8BE2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		panel_3.add(button_2, gbc_button_2);
		
		 panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		add(panel_4, gbc_panel_4);
		
		
	
		
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{119, 81, 0, 81, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel_2.add(button, gbc_button);
		
		
		
		//点击确认
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().length()==10){
					DriverPO po = null;
					try {
						po = driverLogicService.getDriver(textField.getText());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					po.setMoney(Double.valueOf(textField_8.getText().toString()));
					try {
						driverLogicService.saveDriver(po);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					textField_8.setEditable(false);
		
				}else{
					SalaryPO po = null;
					try {
						po = institutionLogicService.getSalary(textField.getText());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					po.setBaseSalary(Double.valueOf(textField_1.getText()));
					po.setBonusSalary(Double.valueOf(textField_2.getText()));
					po.setPercentageSalary(Double.valueOf(textField_3.getText()));
					
					try {
						institutionLogicService.saveSalary(po);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
					
					
				}
			
		
				
			}
		});
		
		JButton button_1 = new JButton("\u53D6\u6D88\u4FDD\u5B58");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 0;
		panel_2.add(button_1, gbc_button_1);
		
		//点击取消
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_8.setEditable(false);
			}
		});
		
		
		
		
		
		
		
	
		
		//点击查询
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().length()==10){
					
					
					
					
					
					
					
					
					//司机界面
					JPanel panel_5 = new JPanel();
					GridBagConstraints gbc_panel_5 = new GridBagConstraints();
					gbc_panel_5.insets = new Insets(0, 0, 5, 0);
					gbc_panel_5.fill = GridBagConstraints.BOTH;
					gbc_panel_5.gridx = 0;
					gbc_panel_5.gridy = 2;
				
					GridBagLayout gbl_panel_5 = new GridBagLayout();
					gbl_panel_5.columnWidths = new int[]{84, 0, 0, 144, 75, 0, 0};
					gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0};
					gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_5.setLayout(gbl_panel_5);
					
					JLabel label_8 = new JLabel("\u5F53\u524D\u85AA\u6C34\u7B56\u7565 计次");
					GridBagConstraints gbc_label_8 = new GridBagConstraints();
					gbc_label_8.anchor = GridBagConstraints.EAST;
					gbc_label_8.insets = new Insets(0, 0, 5, 5);
					gbc_label_8.gridx = 1;
					gbc_label_8.gridy = 0;
					panel_5.add(label_8, gbc_label_8);
					
					
					textField_8 = new JTextField();
					try {
						textField_8.setText(String.valueOf(driverLogicService.getDriverCommision(textField.getText())));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_8 = new GridBagConstraints();
					gbc_textField_8.insets = new Insets(0, 0, 5, 5);
					gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_8.gridx = 3;
					gbc_textField_8.gridy = 0;
					panel_5.add(textField_8, gbc_textField_8);
					textField_8.setColumns(10);
					textField_8.setEditable(false);
					
					
					JButton button_8 = new JButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_8 = new GridBagConstraints();
					gbc_button_8.insets = new Insets(0, 0, 5, 5);
					gbc_button_8.gridx = 4;
					gbc_button_8.gridy = 0;
					panel_5.add(button_8, gbc_button_8);
					
					//修改策略
					button_8.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							textField_8.setEditable(true);
							
						}
					});
					
					
					
					
					
			
					
					panel_4.removeAll();
					panel_4.add(panel_5, gbc_panel_5);
					updateUI();
				}else{
					
					
					
					
					//其他人界面
					JPanel panel_1 = new JPanel();
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.insets = new Insets(0, 0, 5, 0);
					gbc_panel_1.fill = GridBagConstraints.BOTH;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 2;
				
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[]{84, 0, 0, 144, 75, 0, 0};
					gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
					gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_1.setLayout(gbl_panel_1);
					
					JLabel label_2 = new JLabel("\u5F53\u524D\u85AA\u6C34\u7B56\u7565");
					GridBagConstraints gbc_label_2 = new GridBagConstraints();
					gbc_label_2.anchor = GridBagConstraints.EAST;
					gbc_label_2.insets = new Insets(0, 0, 5, 5);
					gbc_label_2.gridx = 1;
					gbc_label_2.gridy = 0;
					panel_1.add(label_2, gbc_label_2);
					
					JLabel label_3 = new JLabel("\u57FA\u7840\r\n");
					GridBagConstraints gbc_label_3 = new GridBagConstraints();
					gbc_label_3.insets = new Insets(0, 0, 5, 5);
					gbc_label_3.anchor = GridBagConstraints.EAST;
					gbc_label_3.gridx = 2;
					gbc_label_3.gridy = 0;
					panel_1.add(label_3, gbc_label_3);
					
					textField_1 = new JTextField();
					try {
						textField_1.setText(String.valueOf(institutionLogicService.getBase(textField.getText())));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_1 = new GridBagConstraints();
					gbc_textField_1.insets = new Insets(0, 0, 5, 5);
					gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_1.gridx = 3;
					gbc_textField_1.gridy = 0;
					panel_1.add(textField_1, gbc_textField_1);
					textField_1.setColumns(10);
					textField_1.setEditable(false);
					
					
					JButton button_3 = new JButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_3 = new GridBagConstraints();
					gbc_button_3.insets = new Insets(0, 0, 5, 5);
					gbc_button_3.gridx = 4;
					gbc_button_3.gridy = 0;
					panel_1.add(button_3, gbc_button_3);
					
					button_3.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							textField_1.setEditable(true);
							
						}
					});
					
					JLabel label_4 = new JLabel("\u63D0\u6210");
					GridBagConstraints gbc_label_4 = new GridBagConstraints();
					gbc_label_4.insets = new Insets(0, 0, 5, 5);
					gbc_label_4.anchor = GridBagConstraints.EAST;
					gbc_label_4.gridx = 2;
					gbc_label_4.gridy = 1;
					panel_1.add(label_4, gbc_label_4);
					
					textField_2 = new JTextField();
					try {
						textField_1.setText(String.valueOf(institutionLogicService.getBonus(textField.getText())));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_2 = new GridBagConstraints();
					gbc_textField_2.insets = new Insets(0, 0, 5, 5);
					gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_2.gridx = 3;
					gbc_textField_2.gridy = 1;
					panel_1.add(textField_2, gbc_textField_2);
					textField_2.setColumns(10);
					textField_2.setEditable(false);
					
					JButton button_4 = new JButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_4 = new GridBagConstraints();
					gbc_button_4.insets = new Insets(0, 0, 5, 5);
					gbc_button_4.gridx = 4;
					gbc_button_4.gridy = 1;
					panel_1.add(button_4, gbc_button_4);
					button_4.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							textField_2.setEditable(true);
						}
					});
					
					
					JLabel label_5 = new JLabel("\u5956\u91D1");
					GridBagConstraints gbc_label_5 = new GridBagConstraints();
					gbc_label_5.insets = new Insets(0, 0, 5, 5);
					gbc_label_5.anchor = GridBagConstraints.EAST;
					gbc_label_5.gridx = 2;
					gbc_label_5.gridy = 2;
					panel_1.add(label_5, gbc_label_5);
					
					textField_3 = new JTextField();
					try {
						textField_1.setText(String.valueOf(institutionLogicService.getPercentage(textField.getText())));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_3 = new GridBagConstraints();
					gbc_textField_3.insets = new Insets(0, 0, 5, 5);
					gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_3.gridx = 3;
					gbc_textField_3.gridy = 2;
					panel_1.add(textField_3, gbc_textField_3);
					textField_3.setColumns(10);
					textField_3.setEditable(false);
					
					JButton button_5 = new JButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_5 = new GridBagConstraints();
					gbc_button_5.insets = new Insets(0, 0, 5, 5);
					gbc_button_5.gridx = 4;
					gbc_button_5.gridy = 2;
					panel_1.add(button_5, gbc_button_5);
					
					button_5.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							textField_3.setEditable(true);	
						}
					});
					
					
					
					
					
					
						panel_4.removeAll();
						
						panel_4.add(panel_1, gbc_panel_1);
						updateUI();
				}
			
			}
		});

	}

}
