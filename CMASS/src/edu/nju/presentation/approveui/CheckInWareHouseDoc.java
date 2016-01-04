package edu.nju.presentation.approveui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.vo.InWareHouseDocVO;

public class CheckInWareHouseDoc extends JPanel{
	private MyTextField InWareHouseDocID;
	private MyTable table;
	private MyScrollPane scrollPane;
	private String[] columnNames={"快递编号","入库日期","目的地","区号","排号","架号","位号"};
	public CheckInWareHouseDoc(InWareHouseDocVO vo) {
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5165\u5E93\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 114, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 130, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u5165\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		InWareHouseDocID = new MyTextField();
		InWareHouseDocID.setEditable(false);
		GridBagConstraints gbc_InWareHouseDocID = new GridBagConstraints();
		gbc_InWareHouseDocID.fill = GridBagConstraints.HORIZONTAL;
		gbc_InWareHouseDocID.insets = new Insets(0, 0, 5, 5);
		gbc_InWareHouseDocID.gridx = 1;
		gbc_InWareHouseDocID.gridy = 1;
		add(InWareHouseDocID, gbc_InWareHouseDocID);
		InWareHouseDocID.setColumns(10);
		
		scrollPane = new MyScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		InWareHouseDocID.setText(vo.getID());
		scrollPane.setViewportView(initializeTable(vo.getList()));
		
	}
	
	public JTable initializeTable(ArrayList<InWareHouseDocLineItem> list){
		MyTable table=new MyTable();
		Object[][] array=new Object[list.size()][];
		for(int i=0;i<list.size();i++){
			InWareHouseDocLineItem item=list.get(i);
			String location=item.getLocation();
			Object[] oneLine={item.getSendDocID(),item.getDate(),item.getDestination(),item.getDistrict(),location.substring(0, 2),location.substring(2, 4),location.substring(4,6)};
			array[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
				array,
				columnNames
			));
		return table;
		
	}
}
