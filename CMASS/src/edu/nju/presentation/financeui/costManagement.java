package edu.nju.presentation.financeui;
import javax.swing.*;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.InstitutionPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.approveui.checkMainUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class costManagement extends JPanel{
	public static void main(String args[]){
		JFrame frame=new JFrame();
		costManagement ui=new costManagement();
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(700,400);
		frame.setVisible(true);
	}
	private financebl bl=new financebl();
	private JTextField textField_2;
	private JPanel thisPanel=this;
	private JPanel panel;
	private JComboBox comboBox;
	public costManagement() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 13, 68, 389, 0, 0, 0, 73, 44, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_3 = new JLabel("\u6210\u672C\u7BA1\u7406");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		add(label_3, gbc_label_3);
		
		JButton button = new JButton("\u83B7\u53D6\u5217\u8868");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String payAccount=textField_2.getText().trim();
				if(payAccount.equals("")){
					JOptionPane.showMessageDialog(thisPanel,"尚未输入账户","错误",JOptionPane.ERROR_MESSAGE);
				}else{
					String type=(String) comboBox.getSelectedItem();
					switch(type){
					case "租金":
						panel=new rentMoneyPanel();
						addPanel(panel);
						updateUI();
						ArrayList<InstitutionPO> institutionList=bl.getUnpaidInstitutionList();
						((rentMoneyPanel) panel).initializeTable(institutionList);
						
						break;
					case"运费":
						panel=new freightMoneyPanel();
						addPanel(panel);
						updateUI();
						ArrayList<TransferDocPO> transferDoc=bl.getUnpaidCarTransferList();
						ArrayList<YLoadDocPO> YLoadDoc=bl.getUnpaidYLoadDocList();
						ArrayList<ZLoadDocPO>ZLoadDoc=bl.getUnpaidZLoadDocList();
						break;
					case "工资":
						panel=new salaryPanel();
						addPanel(panel);
						updateUI();
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		add(button, gbc_button);
		
		JButton button_1 = new JButton("\u65B0\u5EFA\u4ED8\u6B3E\u5355");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		JLabel label = new JLabel("\u6761\u76EE");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u79DF\u91D1", "\u5DE5\u8D44", "\u8FD0\u8D39"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JLabel label_2 = new JLabel("\u4ED8\u6B3E\u8D26\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 6;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 8;
		gbc_textField_2.gridy = 2;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		/*
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		*/
	}
	public void addPanel(JPanel panel){
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 4;
		thisPanel.add(panel, gbc_panel);
	}

}
