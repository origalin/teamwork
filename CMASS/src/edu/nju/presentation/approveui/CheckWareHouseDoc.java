package edu.nju.presentation.approveui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;



import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

public class CheckWareHouseDoc extends JPanel{
	private MyTextField OutWareHouseID;
	private MyTextField Date;
	private MyTextField type;
	private String[] columnNames={"快递编号","目的地"};
	public CheckWareHouseDoc(OutWareHouseDocVO vo) {
		setOpaque(false);
		
		setBorder(new TitledBorder(null, "\u51FA\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 62, 218, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u51FA\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		OutWareHouseID = new MyTextField();
		OutWareHouseID.setEditable(false);
		GridBagConstraints gbc_OutWareHouseID = new GridBagConstraints();
		gbc_OutWareHouseID.insets = new Insets(0, 0, 5, 5);
		gbc_OutWareHouseID.fill = GridBagConstraints.HORIZONTAL;
		gbc_OutWareHouseID.gridx = 1;
		gbc_OutWareHouseID.gridy = 0;
		add(OutWareHouseID, gbc_OutWareHouseID);
		OutWareHouseID.setColumns(10);
		
		JLabel label_1 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		Date = new MyTextField();
		Date.setEditable(false);
		GridBagConstraints gbc_Date = new GridBagConstraints();
		gbc_Date.insets = new Insets(0, 0, 5, 5);
		gbc_Date.fill = GridBagConstraints.HORIZONTAL;
		gbc_Date.gridx = 1;
		gbc_Date.gridy = 1;
		add(Date, gbc_Date);
		Date.setColumns(10);
		
		JLabel label_2 = new JLabel("\u88C5\u8FD0\u5F62\u5F0F");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		type = new MyTextField();
		type.setEditable(false);
		GridBagConstraints gbc_type = new GridBagConstraints();
		gbc_type.insets = new Insets(0, 0, 5, 5);
		gbc_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_type.gridx = 1;
		gbc_type.gridy = 2;
		add(type, gbc_type);
		type.setColumns(10);
		
		MyScrollPane scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		scrollPane.setViewportView(initializeTable(vo.getList()));
		OutWareHouseID.setText(vo.getID());
		Date.setText(toDaysTime(vo.getDate()));
		type.setText(vo.getTransferPattern());
	}
	
	
	public MyTable initializeTable(ArrayList<OutWareHouseDocLineItem> arrayList){
		MyTable table=new MyTable();
		Object[][] array=new Object[arrayList.size()][];
		for(int i=0;i<arrayList.size();i++){
			Object[] oneLine={arrayList.get(i).getSendDocID(),arrayList.get(i).getDestination()};
			array[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
				array,
				columnNames
			));
		return table;
		
	}
	
	
	public static String toDaysTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");	
		String result = sdm.format(date);
		return result;
		
	}

}
