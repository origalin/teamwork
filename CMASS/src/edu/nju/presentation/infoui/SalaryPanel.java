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

import javax.swing.JOptionPane;





import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.DriverPO;
import edu.nju.po.SalaryPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.WarningManager;

import java.awt.Dimension;

public class SalaryPanel extends JPanel {
	private MyTextField textField_1;
	private MyTextField textField_2;
	private MyTextField textField_3;
	private MyTextField textField;
	private MyTextField textField_8 ;
	
	JPanel panel_4;
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	DriverLogicService driverLogicService=UiFactory.getDriverLogicService();

	/**
	 * Create the panel.
	 */
	public SalaryPanel() {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{474, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 122, 35, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 62, 159, 333, 54, 63, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5DE5\u53F7\u6216\u53F8\u673A\u7F16\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 1;
		panel_3.add(label_1, gbc_label_1);
		
		textField = new MyTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_3.add(textField, gbc_textField);
		
		SmallButton button_2 = new SmallButton("\u70B9\u51FB\u67E5\u8BE2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.WEST;
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 1;
		panel_3.add(button_2, gbc_button_2);
		
		 panel_4 = new JPanel();
		 panel_4.setOpaque(false);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 2;
		add(panel_4, gbc_panel_4);
		
		
	
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 132, 81, 169, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{23, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		SmallButton button = new SmallButton("\u786E\u8BA4\u4FEE\u6539");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 0;
		panel_2.add(button, gbc_button);
		
		
		
		//���ȷ��
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().length()==10){
				try {
					driverLogicService.saveMoney(Double.valueOf(textField_8.getText()), textField.getText().toString());
				} catch (NumberFormatException e1) {
						System.out.println("����double");
						WarningManager.warning("����нˮ��Ϣ��ʽ��������");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
					textField_8.setEditable(false);	
				}else{
					SalaryPO po = null;
					try {
						try {
							po = institutionLogicService.getSalary(textField.getText());
						} catch (DatabaseNULLException e1) {
							// TODO Auto-generated catch block
						
							WarningManager.warning("���ܲ��ҵ�����Ϣ������");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try{
					po.setBaseSalary(Double.valueOf(textField_1.getText()));
					po.setBonusSalary(Double.valueOf(textField_2.getText()));
					po.setPercentageSalary(Double.valueOf(textField_3.getText()));
					}catch(NumberFormatException e1){
						System.out.println("����double");
						WarningManager.warning("���������Ϣ��ʽ����");
					}
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
		
		SmallButton button_1 = new SmallButton("\u53D6\u6D88\u4FDD\u5B58");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 0;
		panel_2.add(button_1, gbc_button_1);
		
		//���ȡ��
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().toString().length()==10){
					textField_8.setEditable(false);
				}else{
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				}
			}
		});

					
					
					
					
					
			
					
			
					
					
					
					
					
					
					
	
					
					//�����ѯ
		button_2.addActionListener(new ActionListener() {
						
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().toString().length()==10){
								
					panel_4.removeAll();
					GridBagLayout gbl_panel_4 = new GridBagLayout();
					gbl_panel_4.columnWidths = new int[]{403, 0};
					gbl_panel_4.rowHeights = new int[]{};
					gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
					gbl_panel_4.rowWeights = new double[]{};
					panel_4.setLayout(gbl_panel_4);
								
								
								
								
								
								
//								˾������
								JPanel panel_5 = new JPanel();
								panel_5.setOpaque(false);
								GridBagConstraints gbc_panel_5 = new GridBagConstraints();
								gbc_panel_5.anchor = GridBagConstraints.NORTHWEST;
								gbc_panel_5.insets = new Insets(0, 0, 5, 0);
								gbc_panel_5.fill = GridBagConstraints.BOTH;
								gbc_panel_5.gridx = 0;
								gbc_panel_5.gridy = 0;
								
									GridBagLayout gbl_panel_5 = new GridBagLayout();
									gbl_panel_5.columnWidths = new int[]{89, 127, 59, 0, 0, 141, 0, 0};
									gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0};
									gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
									gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
									panel_5.setLayout(gbl_panel_5);
									
									JLabel label_8 = new JLabel("\u5F53\u524D\u85AA\u6C34\u7B56\u7565  \u8BA1\u6B21");
									GridBagConstraints gbc_label_8 = new GridBagConstraints();
									gbc_label_8.anchor = GridBagConstraints.EAST;
									gbc_label_8.insets = new Insets(0, 0, 5, 5);
									gbc_label_8.gridx = 1;
									gbc_label_8.gridy = 2;
									panel_5.add(label_8, gbc_label_8);
									
									
									textField_8 = new MyTextField();
									textField_8.setMinimumSize(new Dimension(0, 19));
									try {
										textField_8.setText(String.valueOf(driverLogicService.getDriverCommision(textField.getText())));
									} catch (RemoteException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (DatabaseNULLException e1) {
										// TODO Auto-generated catch block
									
										WarningManager.warning("���ܲ��ҵ�����Ϣ������");
										e1.printStackTrace();
									}
									GridBagConstraints gbc_textField_8 = new GridBagConstraints();
									gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
									gbc_textField_8.insets = new Insets(0, 0, 5, 5);
									gbc_textField_8.gridx = 2;
									gbc_textField_8.gridy = 2;
									panel_5.add(textField_8, gbc_textField_8);
									textField_8.setColumns(10);
									textField_8.setEditable(false);
									
									
									SmallButton button_8 = new SmallButton("\u70B9\u51FB\u4FEE\u6539");
									GridBagConstraints gbc_button_8 = new GridBagConstraints();
									gbc_button_8.anchor = GridBagConstraints.WEST;
									gbc_button_8.insets = new Insets(0, 0, 5, 5);
									gbc_button_8.gridx = 5;
									gbc_button_8.gridy = 2;
									panel_5.add(button_8, gbc_button_8);
									
									//�޸Ĳ���
									button_8.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											textField_8.setEditable(true);
											
										}
									});
									GridBagConstraints gbc_panel_51 = new GridBagConstraints();
									gbc_panel_51.fill = GridBagConstraints.HORIZONTAL;
									panel_4.add(panel_5, gbc_panel_51);
					updateUI();
				}else{
					
					
					
					
					//�����˽���
					JPanel panel_1 = new JPanel();
					panel_1.setOpaque(false);
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.anchor = GridBagConstraints.NORTH;
					gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
				
					GridBagLayout gbl_panel_1 = new GridBagLayout();
					gbl_panel_1.columnWidths = new int[]{84, 94, 45, 359, 22, 27, 142, 0, 0};
					gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
					gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
					panel_1.setLayout(gbl_panel_1);
					
					JLabel label_2 = new JLabel("\u5F53\u524D\u85AA\u6C34\u7B56\u7565");
					GridBagConstraints gbc_label_2 = new GridBagConstraints();
					gbc_label_2.anchor = GridBagConstraints.EAST;
					gbc_label_2.insets = new Insets(0, 0, 5, 5);
					gbc_label_2.gridx = 1;
					gbc_label_2.gridy = 1;
					panel_1.add(label_2, gbc_label_2);
					
					JLabel label_3 = new JLabel("\u57FA\u7840\r\n");
					GridBagConstraints gbc_label_3 = new GridBagConstraints();
					gbc_label_3.insets = new Insets(0, 0, 5, 5);
					gbc_label_3.anchor = GridBagConstraints.EAST;
					gbc_label_3.gridx = 2;
					gbc_label_3.gridy = 1;
					panel_1.add(label_3, gbc_label_3);
					
					textField_1 = new MyTextField();
			
						try {
							textField_1.setText(String.valueOf(institutionLogicService.getBase(textField.getText())));
						} catch (DatabaseNULLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							WarningManager.warning("���ܲ��ҵ�����Ϣ������");
						}
					 catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_1 = new GridBagConstraints();
					gbc_textField_1.insets = new Insets(0, 0, 5, 5);
					gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_1.gridx = 3;
					gbc_textField_1.gridy = 1;
					panel_1.add(textField_1, gbc_textField_1);
					textField_1.setColumns(10);
					textField_1.setEditable(false);
					
					
					SmallButton button_3 = new SmallButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_3 = new GridBagConstraints();
					gbc_button_3.anchor = GridBagConstraints.WEST;
					gbc_button_3.insets = new Insets(0, 0, 5, 5);
					gbc_button_3.gridx = 6;
					gbc_button_3.gridy = 1;
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
					gbc_label_4.gridy = 2;
					panel_1.add(label_4, gbc_label_4);
					
					textField_2 = new MyTextField();
					try {
						try {
							textField_2.setText(String.valueOf(institutionLogicService.getBonus(textField.getText())));
						} catch (DatabaseNULLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_2 = new GridBagConstraints();
					gbc_textField_2.insets = new Insets(0, 0, 5, 5);
					gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_2.gridx = 3;
					gbc_textField_2.gridy = 2;
					panel_1.add(textField_2, gbc_textField_2);
					textField_2.setColumns(10);
					textField_2.setEditable(false);
					
					SmallButton button_4 = new SmallButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_4 = new GridBagConstraints();
					gbc_button_4.anchor = GridBagConstraints.WEST;
					gbc_button_4.insets = new Insets(0, 0, 5, 5);
					gbc_button_4.gridx = 6;
					gbc_button_4.gridy = 2;
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
					gbc_label_5.gridy = 3;
					panel_1.add(label_5, gbc_label_5);
					
					textField_3 = new MyTextField();
					try {
						try {
							textField_3.setText(String.valueOf(institutionLogicService.getPercentage(textField.getText())));
						} catch (DatabaseNULLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					GridBagConstraints gbc_textField_3 = new GridBagConstraints();
					gbc_textField_3.insets = new Insets(0, 0, 5, 5);
					gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
					gbc_textField_3.gridx = 3;
					gbc_textField_3.gridy = 3;
					panel_1.add(textField_3, gbc_textField_3);
					textField_3.setColumns(10);
					textField_3.setEditable(false);
					
					SmallButton button_5 = new SmallButton("\u70B9\u51FB\u4FEE\u6539");
					GridBagConstraints gbc_button_5 = new GridBagConstraints();
					gbc_button_5.anchor = GridBagConstraints.WEST;
					gbc_button_5.insets = new Insets(0, 0, 5, 5);
					gbc_button_5.gridx = 6;
					gbc_button_5.gridy = 3;
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
