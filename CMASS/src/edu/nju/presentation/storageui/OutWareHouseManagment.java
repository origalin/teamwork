package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.OutWareHouseManagementbl;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.presentation.UiFactory;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OutWareHouseManagment extends JPanel{
	private OutWareHouseManagementService outWareHouseManagement;
	private String currInstitution;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private OutWareHouseDocVO outWareHouseDocVO;
	String[] columnNames={"快递编号","出库日期","装运形式","目的地"};
	public OutWareHouseManagment() {
		
		
//		String[][] data={
//				{"10003665","20151031","航运","北京"},
//				{"10003666","20151031","航运","北京"},
//				{"10003667","20151031","航运","北京"},
//				{"10003668","20151031","航运","北京"},
//				{"10003669","20151031","航运","北京"},
//				{"10003670","20151031","航运","北京"},
//				{"10003671","20151031","航运","北京"},
//				{"10003672","20151031","航运","北京"},
//		};
		
		setBorder(new TitledBorder(null, "\u51FA\u5E93\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{114, 223, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 171, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("中转单编号");
		comboBox.addItem("装车单编号");
		scrollPane.setViewportView(comboBox);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		
//		table = new JTable(data,columnNames);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();

				outWareHouseManagement = UiFactory.getOutWareHouseManagementService();//与逻辑层建立联系以便调用
				if (selectedItem.equals("中转单编号"))
					outWareHouseDocVO = outWareHouseManagement.getOutWareHouseDocVO_Transfer(textField.getText(), currInstitution);
				else if (selectedItem.equals("装车单编号"))
					outWareHouseDocVO = outWareHouseManagement.getOutWareHouseDocVO_ZloadDoc(textField.getText(), currInstitution);
				
				textField_1.setText(outWareHouseDocVO.getID());
				// 该行以上没有问题
				ArrayList<OutWareHouseDocLineItem> list = outWareHouseDocVO.getLineItemList();

				String[][] data1 = new String[list.size()][4];
				int i = 0;
				for (OutWareHouseDocLineItem temp : list) {
					data1[i][0] = temp.getSendDocID();// 快递编号
					data1[i][1] = temp.getOutDate().toString();// 入库日期
					data1[i][2] = temp.getTransformPattern();// 目的地
					
					i++;
				}

				table = new JTable(data1, columnNames);
				scrollPane.setViewportView(table);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		JButton btnNewButton = new JButton("\u751F\u6210\u51FA\u5E93\u5355");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		add(btnNewButton, gbc_btnNewButton);
	}
}
