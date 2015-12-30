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
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;






import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogicservice.infologicservice.DistanceLogicService;
import edu.nju.po.DistancePO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;

public class DistancePanel extends JPanel {
	private MyTextField txtkm;
	DefaultComboBoxModel<String> model;
	DistanceLogicService distanceLogicService=UiFactory.getDistanceLogicService();
	/**
	 * Create the panel.
	 */
	public DistancePanel() {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{55, 196, 90, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 89, 51, 84, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel("\u9009\u62E9\u57CE\u5E02");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
	
		MyComboBox comboBox = new MyComboBox();
	initComboBox(comboBox);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);
		
		JLabel label_2 = new JLabel("\u2190\u2192");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		MyComboBox comboBox_1 = new MyComboBox();
	initComboBox(comboBox_1);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 1;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		SmallButton button_2 = new SmallButton("\u70B9\u51FB\u67E5\u8BE2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 7;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
		//查询
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double distance = 0;
				try {
					distance = distanceLogicService.getDistance((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem());
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
					e1.printStackTrace();
				}
				txtkm.setText(String.valueOf(distance));
				txtkm.setEditable(false);
		
			}
		});

		
		SmallButton btnNewButton = new SmallButton("\u65B0\u589E\u57CE\u5E02\r\n");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		
		//新增
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				DistanceAdd dialog = new DistanceAdd();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				
				//TODO 动态修改ComboBox
			}
		});
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u8DDD\u79BB\r\n");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panel_1.add(label_3, gbc_label_3);
		
		txtkm = new MyTextField();
		txtkm.setText("100/km");
		GridBagConstraints gbc_txtkm = new GridBagConstraints();
		gbc_txtkm.gridwidth = 3;
		gbc_txtkm.insets = new Insets(0, 0, 0, 5);
		gbc_txtkm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtkm.gridx = 3;
		gbc_txtkm.gridy = 3;
		panel_1.add(txtkm, gbc_txtkm);
		txtkm.setColumns(10);
	
		
		SmallButton button_3 = new SmallButton("\u70B9\u51FB\u4FEE\u6539");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridwidth = 2;
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 7;
		gbc_button_3.gridy = 3;
		panel_1.add(button_3, gbc_button_3);
		//修改
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtkm.setEditable(true);
		
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{97, 108, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		SmallButton button = new SmallButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		panel_2.add(button, gbc_button);
		//queren
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			try{
				DistancePO po=new DistancePO((String)comboBox.getSelectedItem(),(String)comboBox_1.getSelectedItem(),Double.valueOf(txtkm.getText()));
				distanceLogicService.changeDistance(po);
			}catch(NumberFormatException e1){
				System.out.println("不是double");
				JOptionPane.showMessageDialog(null, "输入距离信息格式错误");  
			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
					e1.printStackTrace();
				}
				txtkm.setEditable(false);
				
			}
		});
	
		
		SmallButton button_1 = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 1;
		panel_2.add(button_1, gbc_button_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double distance = 0;
				try {
					distance = distanceLogicService.getDistance((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem());
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
					e1.printStackTrace();
				}
				txtkm.setText(String.valueOf(distance));
				txtkm.setEditable(false);
		
			}
		});

	}

	void initComboBox(MyComboBox comboBox){
		ArrayList<String> cityList=new ArrayList<String>();
		try {
			cityList = distanceLogicService.getCityList();
		} catch (RemoteException e) {
		
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "网络连接错误，请检查");
		}
		model=(DefaultComboBoxModel<String>) comboBox.getModel();
		for(String city:cityList){
				model.addElement(city);
		}
	
	}
	
}
