package edu.nju.presentation.financeui;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
public class createGatheringDocPO extends JPanel{
	
	
		private JTextField textField_2;
		private JTextField textField_4;
		 
		public createGatheringDocPO() {
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{233, 109, 0, 113, 65, 62, 0, 48, 0};
			gridBagLayout.rowHeights = new int[]{42, 0, 19, 118, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel label_2 = new JLabel("\u6536\u6B3E\u5355");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 0;
			add(label_2, gbc_label_2);
			
			JLabel label_4 = new JLabel("\u6536\u6B3E\u5355\u7F16\u53F7");
			label_4.setFont(new Font("ºÚÌå", Font.BOLD, 12));
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.anchor = GridBagConstraints.EAST;
			gbc_label_4.gridx = 0;
			gbc_label_4.gridy = 1;
			add(label_4, gbc_label_4);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 5);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 1;
			add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
			
			JLabel label = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7");
			label.setFont(new Font("ºÚÌå", Font.BOLD, 12));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 3;
			gbc_label.gridy = 1;
			add(label, gbc_label);
			
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 5);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 4;
			gbc_textField_4.gridy = 1;
			add(textField_4, gbc_textField_4);
			textField_4.setColumns(10);
			
			JButton btnNewButton = new JButton("\u786E\u5B9A");
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 3;
			add(btnNewButton, gbc_btnNewButton);
		}

	
}
