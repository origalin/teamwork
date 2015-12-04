package edu.nju.presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import edu.nju.po.InstitutionPO;
import edu.nju.vo.AccountVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

public class rentMoneyPanel extends JPanel{
	private JTable table;
	private JScrollPane scrollPane;
	public rentMoneyPanel() {
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
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
	}
	public JTable initializeTable(ArrayList<InstitutionPO> institutionList){
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		Object[][] tableInfo=new Object[institutionList.size()][3];
		for(int i=0;i<institutionList.size();i++){
			Object[] oneLine={null,institutionList.get(i).getName(),institutionList.get(i).getRent()};
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
		return null;
	}
	

}
