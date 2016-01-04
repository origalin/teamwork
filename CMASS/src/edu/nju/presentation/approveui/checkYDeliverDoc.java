package edu.nju.presentation.approveui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.vo.YDeliverDocVO;

import java.awt.FlowLayout;
public class checkYDeliverDoc extends JPanel{
	private MyTextField date;
	private MyTextField courier;
	private JLabel label_1;
	private JLabel label_2;
	private MyTextField YDeliverID;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private MyScrollPane scrollPane;
	private MyTable table;
	public checkYDeliverDoc(YDeliverDocVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 3, 11, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		label_1 = new JLabel("\u8425\u4E1A\u5385\u6D3E\u4EF6\u5355");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label_1);
		
		label_2 = new JLabel("\u8425\u4E1A\u5385\u6D3E\u4EF6\u5355\u7F16\u53F7");
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 1;
		add(label_2, gbc_label_2);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		YDeliverID = new MyTextField();
		panel_1.add(YDeliverID);
		YDeliverID.setEditable(false);
		YDeliverID.setColumns(15);
		
		JLabel label = new JLabel("\u5FEB\u9012\u5458");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 4;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		courier = new MyTextField();
		panel_2.add(courier);
		courier.setEditable(false);
		courier.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5230\u8FBE\u65E5\u671F");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		
		date = new MyTextField();
		panel_3.add(date);
		date.setEditable(false);
		date.setColumns(15);
		
		scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		table = new MyTable();
		String[]itemIDs=vo.getItemIDs();
		Object[][]tableInfo=new Object[itemIDs.length][1];
		for(int i=0;i<itemIDs.length;i++){
			Object[]oneLine={itemIDs[i]};
			tableInfo[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u5FEB\u9012\u5355\u53F7"
			}
		));
		scrollPane.setViewportView(table);
		YDeliverID.setText(vo.getID());
		date.setText(vo.getDate());
		courier.setText(vo.getCourier());
	}

}
