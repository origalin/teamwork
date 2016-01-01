package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class MyTable extends JTable{
	public MyTable() {
		// TODO Auto-generated constructor stub
		
		init();
		
		
	}
	
	public MyTable(Object[][] arg0, Object[] arg1){
		
		super(arg0, arg1);
		init();
//		setBackground(new Color(234, 234, 234));
	}
	private void init() {
		setRowHeight(30);
		setGridColor(Color.LIGHT_GRAY);
		setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
		setShowVerticalLines(false);
		setOpaque(false);
		getTableHeader().setOpaque(false);
		getTableHeader().setBackground(new Color(240, 240, 240));
//		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer(){
//            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)  
//            {
//                JComponent comp = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//                comp.setBackground(Color.lightGray);
//                comp.setBorder(BorderFactory.createRaisedBevelBorder());               
//                return comp;
//            }
//        };
//        setHeaderRenderer(cellRenderer);
		
	}
}
