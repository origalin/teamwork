package edu.nju.tools;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;






import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.presentation.infoui.CarPanel;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;

public class MyDialog extends JDialog{
	public static MyTextField textField;
	static String str="";
	public static SmallButton btnNewButton;
	ImageIcon imageIcon = new ImageIcon("images/dback.png");
	public MyDialog() {
	
		JLabel back = new JLabel(imageIcon);
		back.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		((JPanel)getContentPane()).setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{49, 0, 65, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{43, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u5173\u952E\u5B57");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		getContentPane().add(label, gbc_label);
		setVisible(false);
		textField = new MyTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		setBounds(500, 300, 350, 200);
	 btnNewButton = new SmallButton("\u786E\u8BA4");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
	
		
		SmallButton button = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 3;
		getContentPane().add(button, gbc_button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	

	

	}}
