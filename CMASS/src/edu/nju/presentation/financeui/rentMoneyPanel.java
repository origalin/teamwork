package edu.nju.presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import edu.nju.po.InstitutionPO;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.vo.AccountVO;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

public class rentMoneyPanel extends JPanel{
	private MyTable table;
	private MyScrollPane scrollPane;
	public rentMoneyPanel() {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new MyScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		table = new MyTable();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
				{Boolean.FALSE, null, null},
			},
			new String[] {
				"", "\u673A\u6784", "\u79DF\u91D1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
	public MyTable initializeTable(ArrayList<InstitutionPO> institutionList){
		MyTable table = new MyTable();
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);
		Object[][] tableInfo=new Object[institutionList.size()][3];
		for(int i=0;i<institutionList.size();i++){
			Object[] oneLine={false,institutionList.get(i).getName(),institutionList.get(i).getRent()};
			tableInfo[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"", "\u673A\u6784", "\u79DF\u91D1"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setPreferredScrollableViewportSize(new Dimension(200,200));
		this.table=table;
		return table;
	}
	public MyTable getTable() {
		return table;
	}
	public void setTable(MyTable table) {
		this.table = table;
	}
	public MyScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(MyScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public void chooseAll(){
		for (int i=0; i<table.getRowCount(); i++)
        {
            table.setValueAt(true, i, 0);
        }
	
	}
	

}
