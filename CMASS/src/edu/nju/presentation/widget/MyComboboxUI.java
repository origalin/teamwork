package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;



public class MyComboboxUI extends BasicComboBoxUI{

	@Override
	protected JButton createArrowButton() {
		JButton button = new MicroButton();
//		button.setUI(new MyButtonUI());
//		button.setSize(20, 20);
//		button.setOpaque(true);
//		button.setMargin(new Insets(0, 0, 0, 0));// …Ë÷√±ﬂæ‡
//		button.setBackground(new Color(234, 234, 234));
//		button.setBorderPainted(false);
//		button.setContentAreaFilled(false);
		return button;
	}
	
	
	@Override
	public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
		
		Color t = g.getColor();
        if ( comboBox.isEnabled() )
            g.setColor(new Color(96, 174, 219));
        else
            g.setColor(new Color(234, 234, 234));
        g.fillRect(bounds.x,bounds.y,bounds.width,bounds.height);
        g.setColor(t);
		
	}
	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		// TODO Auto-generated method stub
		 ListCellRenderer renderer = comboBox.getRenderer();
	        Component c;

	        if ( hasFocus && !isPopupVisible(comboBox) ) {
	            c = renderer.getListCellRendererComponent( listBox,
	                                                       comboBox.getSelectedItem(),
	                                                       -1,
	                                                       true,
	                                                       false );
	        }
	        else {
	            c = renderer.getListCellRendererComponent( listBox,
	                                                       comboBox.getSelectedItem(),
	                                                       -1,
	                                                       false,
	                                                       false );
	            c.setBackground(UIManager.getColor("ComboBox.background"));
	        }
	        c.setFont(comboBox.getFont());
	        if ( hasFocus && !isPopupVisible(comboBox) ) {
	        	 c.setForeground(new Color(234, 234, 234));
	                c.setBackground(new Color(96, 174, 219));
	        }
	        else {
	            if ( comboBox.isEnabled() ) {
	                c.setForeground(comboBox.getForeground());
	                c.setBackground(comboBox.getBackground());
	            }
	            else {
	                c.setForeground(new Color(234, 234, 234));
	                c.setBackground(new Color(96, 174, 219));
	            }
	        }

	        // Fix for 4238829: should lay out the JPanel.
	        boolean shouldValidate = false;
	        if (c instanceof JPanel)  {
	            shouldValidate = true;
	        }

	        int x = bounds.x, y = bounds.y, w = bounds.width, h = bounds.height;
	        if (padding != null) {
	            x = bounds.x + padding.left;
	            y = bounds.y + padding.top;
	            w = bounds.width - (padding.left + padding.right);
	            h = bounds.height - (padding.top + padding.bottom);
	        }

	        currentValuePane.paintComponent(g,c,comboBox,x,y,w,h,shouldValidate);
	}
}
