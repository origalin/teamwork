package edu.nju.presentation.approveui;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
public class checkMainUI extends JPanel{
	public checkMainUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 119, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6536\u6B3E\u5355", "\u5165\u5E93\u5355", "\u4E2D\u8F6C\u5355", "\u51FA\u5E93\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355", "\u8425\u4E1A\u5385\u88C5\u8F66\u5355", "\u6536\u4EF6\u5355", "\u4ED8\u6B3E\u5355", "\u8425\u4E1A\u5385\u5230\u8FBE\u5355", "\u6D3E\u4EF6\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 6;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
	}

}
