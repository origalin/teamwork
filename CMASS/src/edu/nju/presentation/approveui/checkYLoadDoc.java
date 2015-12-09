package edu.nju.presentation.approveui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;

import edu.nju.vo.YLoadDocVO;

import java.awt.Font;
import java.awt.FlowLayout;
public class checkYLoadDoc extends JPanel{
	private JTextField date;
	private JTextField BusinessHallID;
	private JTextField carTransportID;
	private JTextField car_ID;
	private JTextField endPlace;
	private JTextField Driver;
	private JTextField money;
	private JLabel label_6;
	private JLabel label_7;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JTextField YLoadID;
	private JPanel panel_8;
	private JScrollPane scrollPane;
	private JTable table;
	public checkYLoadDoc(YLoadDocVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 122, 76, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 39, 113, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		label_6 = new JLabel("\u8425\u4E1A\u5385\u88C5\u8F66\u5355");
		label_6.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label_6);
		
		label_7 = new JLabel("\u8425\u4E1A\u5385\u88C5\u8F66\u5355\u7F16\u53F7");
		label_7.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.anchor = GridBagConstraints.WEST;
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 1;
		gbc_label_7.gridy = 1;
		add(label_7, gbc_label_7);
		
		panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 1;
		add(panel_7, gbc_panel_7);
		
		YLoadID = new JTextField();
		YLoadID.setEditable(false);
		panel_7.add(YLoadID);
		YLoadID.setColumns(15);
		
		JLabel label_4 = new JLabel("\u53F8\u673A");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 3;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 4;
		gbc_panel_8.gridy = 1;
		add(panel_8, gbc_panel_8);
		
		Driver = new JTextField();
		panel_8.add(Driver);
		Driver.setEditable(false);
		Driver.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u88C5\u8F66\u65E5\u671F");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		date = new JTextField();
		panel_1.add(date);
		date.setEditable(false);
		date.setColumns(15);
		
		JLabel label = new JLabel("\u8425\u4E1A\u5385\u7F16\u53F7");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		panel_3 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_3.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 4;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		
		BusinessHallID = new JTextField();
		panel_3.add(BusinessHallID);
		BusinessHallID.setEditable(false);
		BusinessHallID.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 3;
		add(panel_2, gbc_panel_2);
		
		carTransportID = new JTextField();
		panel_2.add(carTransportID);
		carTransportID.setEditable(false);
		carTransportID.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_4.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 3;
		add(panel_4, gbc_panel_4);
		
		car_ID = new JTextField();
		panel_4.add(car_ID);
		car_ID.setEditable(false);
		car_ID.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5230\u8FBE\u5730");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 4;
		add(label_3, gbc_label_3);
		
		panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 4;
		add(panel_5, gbc_panel_5);
		
		endPlace = new JTextField();
		panel_5.add(endPlace);
		endPlace.setEditable(false);
		endPlace.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8FD0\u8D39");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 4;
		add(label_5, gbc_label_5);
		
		panel_6 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_6.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 4;
		gbc_panel_6.gridy = 4;
		add(panel_6, gbc_panel_6);
		
		money = new JTextField();
		panel_6.add(money);
		money.setEditable(false);
		money.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
		
		
		String[]itemID=vo.getItemIDs();
		Object[][]tableInfo=new Object[itemID.length][1];
		for(int i=0;i<itemID.length;i++){
			Object[]oneLine={itemID[i]};
			tableInfo[i]=oneLine;
		}
		table = new JTable();
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u5FEB\u4EF6\u5355\u53F7"
			}
		));
		scrollPane.setViewportView(table);
		YLoadID.setText(vo.getID());
		date.setText(vo.getDate());
		carTransportID.setText(vo.getTranceID());
		endPlace.setText(vo.getTargetBusinessHall());
		Driver.setText(vo.getDriver());
		BusinessHallID.setText(vo.getBusinessHallID());
		car_ID.setText(vo.getCarID());
		money.setText(vo.getPrice());
	}

}
