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
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.YDeliverDocVO;

import java.awt.FlowLayout;
public class checkYArrivalDoc extends JPanel{
	private MyTextField date;
	private MyTextField transferID;
	private MyTextField startPlace;
	private MyTable table;
	private MyTextField YArrivalID;
	public checkYArrivalDoc(YArrivalDocVO vo) {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 13, 123, 51, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 85, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel label_3 = new JLabel("\u8425\u4E1A\u5385\u5230\u8FBE\u5355");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u8425\u4E1A\u5385\u5230\u8FBE\u5355\u7F16\u53F7");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.fill = GridBagConstraints.VERTICAL;
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		
		YArrivalID = new MyTextField();
		panel_2.add(YArrivalID);
		YArrivalID.setEditable(false);
		YArrivalID.setColumns(10);
		
		JLabel label = new JLabel("\u5230\u8FBE\u65E5\u671F");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		
		date = new MyTextField();
		panel_1.add(date);
		date.setEditable(false);
		date.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355\u7F16\u53F7");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		transferID = new MyTextField();
		transferID.setEditable(false);
		GridBagConstraints gbc_transferID = new GridBagConstraints();
		gbc_transferID.insets = new Insets(0, 0, 5, 5);
		gbc_transferID.fill = GridBagConstraints.HORIZONTAL;
		gbc_transferID.gridx = 4;
		gbc_transferID.gridy = 2;
		add(transferID, gbc_transferID);
		transferID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u53D1\u5730");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		startPlace = new MyTextField();
		panel_3.add(startPlace);
		startPlace.setEditable(false);
		startPlace.setColumns(15);
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		String[][]itemAndState=vo.getItemAndState();
		Object[][]tableInfo=new Object[itemAndState.length][2];
		for(int i=0;i<tableInfo.length;i++){
			Object[]oneLine={itemAndState[i][0],itemAndState[i][1]};
			tableInfo[i]=oneLine;
		}
		table = new MyTable();
		table.setFont(new Font("SimSun", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u5BC4\u4EF6\u5355\u53F7", "\u72B6\u6001"
			}
		));
		YArrivalID.setText(vo.getID());
		transferID.setText(vo.getTransferDocID());
		date.setText(vo.getDate());
		startPlace.setText(vo.getFrom());
	}

}
