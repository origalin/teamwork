
package edu.nju.presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;




import edu.nju.po.InstitutionPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

public class freightMoneyPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTable table;
	MyScrollPane scrollPane;
	public freightMoneyPanel() {
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
				"", "\u5355\u636E\u7C7B\u578B", "\u5355\u636E\u7F16\u53F7", "\u8FD0\u8D39"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
	public MyTable initializeTable(ArrayList<TransferDocPO> transferDoc,	ArrayList<YLoadDocPO> YLoadDoc,ArrayList<ZLoadDocPO>ZLoadDoc)
	{
		MyTable table = new MyTable();
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setOpaque(false);
		Object[][]tableInfo=new Object[transferDoc.size()+YLoadDoc.size()+ZLoadDoc.size()][];
		for(int i=0;i<transferDoc.size();i++){
			Object[]oneLine={false,"TransferDoc",transferDoc.get(i).getID(),transferDoc.get(i).getPrice()};
			tableInfo[i]=oneLine;
		}
		for(int i=0;i<YLoadDoc.size();i++){
			Object[]oneLine={false,"YLoadDoc",YLoadDoc.get(i).getID(),YLoadDoc.get(i).getPrice()};
			tableInfo[i+transferDoc.size()]=oneLine;
		}
		for(int i=0;i<ZLoadDoc.size();i++){
			Object[]oneLine={false,"ZLoadDoc",ZLoadDoc.get(i).getID(),ZLoadDoc.get(i).getPrice()};
			tableInfo[i+transferDoc.size()+YLoadDoc.size()]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"", "\u5355\u636E\u7C7B\u578B", "\u5355\u636E\u7F16\u53F7", "\u8FD0\u8D39"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class
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
