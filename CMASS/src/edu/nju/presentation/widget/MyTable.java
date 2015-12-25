package edu.nju.presentation.widget;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable{
	public MyTable() {
		// TODO Auto-generated constructor stub
		setRowHeight(30);
		setGridColor(Color.LIGHT_GRAY);
		
		
		
	}
	
	public MyTable(Object[][] arg0, Object[] arg1){
		
		super(arg0, arg1);
		setRowHeight(30);
		setGridColor(Color.LIGHT_GRAY);
//		setBackground(new Color(234, 234, 234));
	}
}
