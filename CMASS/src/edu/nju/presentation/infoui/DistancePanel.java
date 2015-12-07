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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JTextField;

import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogicservice.infologicservice.DistanceLogicService;
import edu.nju.po.DistancePO;
import edu.nju.presentation.UiFactory;

public class DistancePanel extends JPanel {
	private JTextField txtkm;
	DistanceLogicService distanceBl=UiFactory.getDistanceLogicService();
	/**
	 * Create the panel.
	 */
	public DistancePanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{124, 196, 90, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u57CE\u5E02\u8BBE\u7F6E");
		label.setFont(new Font("����", Font.PLAIN, 25));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC", "\u4E0A\u6D77", "\u5E7F\u5DDE", "\u6DF1\u5733", "\u5357\u4EAC"}));
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
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u5317\u4EAC", "\u4E0A\u6D77", "\u5E7F\u5DDE", "\u6DF1\u5733", "\u5357\u4EAC"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 1;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		JButton button_2 = new JButton("\u70B9\u51FB\u67E5\u8BE2");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 7;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
		//��ѯ
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double distance = 0;
				try {
					distance = distanceBl.getDistance((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtkm.setText(String.valueOf(distance));
				txtkm.setEditable(false);
		
			}
		});

		
		JButton btnNewButton = new JButton("\u65B0\u589E\u57CE\u5E02\r\n");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 8;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		
		//����
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DistanceAdd dialog = new DistanceAdd();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u8DDD\u79BB\r\n");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		panel_1.add(label_3, gbc_label_3);
		
		txtkm = new JTextField();
		txtkm.setText("100/km");
		GridBagConstraints gbc_txtkm = new GridBagConstraints();
		gbc_txtkm.gridwidth = 3;
		gbc_txtkm.insets = new Insets(0, 0, 0, 5);
		gbc_txtkm.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtkm.gridx = 3;
		gbc_txtkm.gridy = 3;
		panel_1.add(txtkm, gbc_txtkm);
		txtkm.setColumns(10);
	
		
		JButton button_3 = new JButton("\u70B9\u51FB\u4FEE\u6539");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridwidth = 2;
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 7;
		gbc_button_3.gridy = 3;
		panel_1.add(button_3, gbc_button_3);
		//�޸�
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtkm.setEditable(true);
		
			}
		});
		
		JPanel panel_2 = new JPanel();
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
		
		JButton button = new JButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		panel_2.add(button, gbc_button);
		//queren
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DistancePO po=new DistancePO((String)comboBox.getSelectedItem(),(String)comboBox_1.getSelectedItem(),Double.valueOf(txtkm.getText()));
				try {
					distanceBl.changeDistance(po);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtkm.setEditable(false);
				
			}
		});
	
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 1;
		panel_2.add(button_1, gbc_button_1);
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double distance = 0;
				try {
					distance = distanceBl.getDistance((String)comboBox.getSelectedItem(), (String)comboBox_1.getSelectedItem());
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtkm.setText(String.valueOf(distance));
				txtkm.setEditable(false);
		
			}
		});

	}

}
