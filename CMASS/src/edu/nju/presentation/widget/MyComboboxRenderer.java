package edu.nju.presentation.widget;

import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class MyComboboxRenderer extends BasicComboBoxRenderer{
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		// TODO Auto-generated method stub
		if (isSelected) {
            setBackground(new Color(96, 174, 219));
            setForeground(list.getSelectionForeground());
        }
        else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        setFont(list.getFont());

        if (value instanceof Icon) {
            setIcon((Icon)value);
        }
        else {
            setText((value == null) ? "" : value.toString());
        }
        return this;
	}
	
}
