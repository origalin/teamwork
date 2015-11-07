package edu.nju.presentation.infoui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CarAddDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CarAddDialog dialog = new CarAddDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CarAddDialog() {
		setBounds(100, 100, 413, 389);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel label = new JLabel("\u65B0\u589E/\u4FEE\u6539\u8F66\u8F86\u4FE1\u606F");
				panel.add(label);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.WEST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{75, 0, 0, 155, 133, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				JLabel label = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 1;
				panel.add(label, gbc_label);
			}
			{
				textField = new JTextField();
				textField.setColumns(10);
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.gridx = 3;
				gbc_textField.gridy = 1;
				panel.add(textField, gbc_textField);
			}
			{
				JLabel label = new JLabel("\u8F66\u724C\u53F7");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 3;
				panel.add(label, gbc_label);
			}
			{
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.gridx = 3;
				gbc_textField_1.gridy = 3;
				panel.add(textField_1, gbc_textField_1);
			}
			{
				JLabel label = new JLabel("\u5BF9\u5E94\u53F8\u673A");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 5;
				panel.add(label, gbc_label);
			}
			{
				JComboBox comboBox = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.gridx = 3;
				gbc_comboBox.gridy = 5;
				panel.add(comboBox, gbc_comboBox);
			}
			{
				JLabel label = new JLabel("\u670D\u5F79\u65F6\u95F4");
				GridBagConstraints gbc_label = new GridBagConstraints();
				gbc_label.anchor = GridBagConstraints.EAST;
				gbc_label.insets = new Insets(0, 0, 5, 5);
				gbc_label.gridx = 1;
				gbc_label.gridy = 7;
				panel.add(label, gbc_label);
			}
			{
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.gridx = 3;
				gbc_textField_2.gridy = 7;
				panel.add(textField_2, gbc_textField_2);
			}
			{
				JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.gridwidth = 2;
				gbc_button.insets = new Insets(0, 0, 0, 5);
				gbc_button.gridx = 1;
				gbc_button.gridy = 9;
				panel.add(button, gbc_button);
			}
			{
				JButton button = new JButton("\u53D6\u6D88\u4FDD\u5B58");
				GridBagConstraints gbc_button = new GridBagConstraints();
				gbc_button.anchor = GridBagConstraints.EAST;
				gbc_button.insets = new Insets(0, 0, 0, 5);
				gbc_button.gridx = 3;
				gbc_button.gridy = 9;
				panel.add(button, gbc_button);
			}
		}
	}

}
