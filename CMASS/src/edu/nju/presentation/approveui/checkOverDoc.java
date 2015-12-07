package edu.nju.presentation.approveui;
import javax.swing.*;

import edu.nju.vo.OverDocVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;
public class checkOverDoc extends JPanel{
	private JTextField Date;
	private JTextField Courier;
	private JTextField OverDocID;
	private JTable table;
	private JScrollPane scrollPane;
	public checkOverDoc(OverDocVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 167, 146, 105, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u6536\u4EF6\u5355");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_4 = new JLabel("\u6536\u4EF6\u5355\u7F16\u53F7");
		label_4.setFont(new Font("ºÚÌå", Font.BOLD, 12));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		OverDocID = new JTextField();
		OverDocID.setEditable(false);
		GridBagConstraints gbc_OverDocID = new GridBagConstraints();
		gbc_OverDocID.insets = new Insets(0, 0, 5, 5);
		gbc_OverDocID.fill = GridBagConstraints.HORIZONTAL;
		gbc_OverDocID.gridx = 2;
		gbc_OverDocID.gridy = 1;
		add(OverDocID, gbc_OverDocID);
		OverDocID.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6536\u4EF6\u65E5\u671F");
		label_1.setFont(new Font("ºÚÌå", Font.BOLD, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		Date = new JTextField();
		Date.setEditable(false);
		GridBagConstraints gbc_Date = new GridBagConstraints();
		gbc_Date.insets = new Insets(0, 0, 5, 0);
		gbc_Date.fill = GridBagConstraints.HORIZONTAL;
		gbc_Date.gridx = 4;
		gbc_Date.gridy = 1;
		add(Date, gbc_Date);
		Date.setColumns(10);
		
		JLabel label1 = new JLabel("\u5FEB\u9012\u5458");
		label1.setFont(new Font("ºÚÌå", Font.BOLD, 12));
		GridBagConstraints gbc_label1 = new GridBagConstraints();
		gbc_label1.insets = new Insets(0, 0, 5, 5);
		gbc_label1.gridx = 1;
		gbc_label1.gridy = 2;
		add(label1, gbc_label1);
		
		Courier = new JTextField();
		Courier.setEditable(false);
		GridBagConstraints gbc_Courier = new GridBagConstraints();
		gbc_Courier.insets = new Insets(0, 0, 5, 5);
		gbc_Courier.fill = GridBagConstraints.HORIZONTAL;
		gbc_Courier.gridx = 2;
		gbc_Courier.gridy = 2;
		add(Courier, gbc_Courier);
		Courier.setColumns(10);
		
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		
		Object[][] tableInfo=new Object[vo.getReceiver().length][2];
		String[]Receiver=vo.getReceiver();
		String[] ItemIDs=vo.getItemID();
		for(int i=0;i<vo.getReceiver().length;i++){
			Object[] oneLine={Receiver[i],ItemIDs[i]};
			tableInfo[i]=oneLine;
		}
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u6536\u4EF6\u4EBA", "\u6536\u4EF6\u7F16\u53F7"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		OverDocID.setText(vo.getID());
		Date.setText(vo.getDate());
		Courier.setText(vo.getCourier());
	}
	

}
