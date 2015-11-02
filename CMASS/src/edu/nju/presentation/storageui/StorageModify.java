package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StorageModify extends JPanel{
	private JTextField textField;
	public StorageModify() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 119, 0};
		gbl_panel.rowHeights = new int[]{32, 35, 28, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("\u5212\u5206\u673A\u52A8\u533A\u767E\u5206\u6BD4");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 2;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton button = new JButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 11;
		gbc_button.gridy = 2;
		panel_1.add(button, gbc_button);
		
		JButton button_1 = new JButton("\u8C03\u6574\u9884\u8B66\u9608\u503C");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 11;
		gbc_button_1.gridy = 3;
		panel_1.add(button_1, gbc_button_1);
	}
	

}
