package edu.nju.presentation.financeui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;
import edu.nju.presentation.widget.MyTable;

public class salaryPanel extends JPanel{
	financebl bl;
	private MyTable table;
	private JScrollPane scrollPane;
	public salaryPanel() {
		setOpaque(false);
		try {
			bl=new financebl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{266, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
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
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
				{Boolean.FALSE, null, null, null},
			},
			new String[] {
				"", "\u5DE5\u53F7", "\u59D3\u540D", "\u5DE5\u8D44"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		
	}
	public MyTable initializeTable(ArrayList<StaffPO> staffList){
		MyTable table = new MyTable();
		scrollPane.setViewportView(table);
		Object[][]tableInfo=new Object[staffList.size()][];
		for(int i=0;i<staffList.size();i++){
			String staffID=staffList.get(i).getStaffID();
			Object[]oneLine={false,staffID,bl.getStaffSalaryName(staffID),bl.calculateSalary(staffID)};
			tableInfo[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"", "\u5DE5\u53F7", "\u59D3\u540D", "\u5DE5\u8D44"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, String.class, String.class, String.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
		});
		this.table=table;
		return table;
		
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(MyTable table) {
		this.table = table;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
