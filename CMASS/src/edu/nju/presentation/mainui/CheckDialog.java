package edu.nju.presentation.mainui;

import javax.swing.JDialog;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CheckDialog extends JDialog{
	private final JPanel panel_1 = new JPanel();
	JButton confirmButton;
	JPanel docPanel;
	public CheckDialog() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		
		docPanel = new JPanel();
		GridBagConstraints gbc_docPanel = new GridBagConstraints();
		gbc_docPanel.insets = new Insets(0, 0, 5, 0);
		gbc_docPanel.fill = GridBagConstraints.BOTH;
		gbc_docPanel.gridx = 0;
		gbc_docPanel.gridy = 0;
		getContentPane().add(docPanel, gbc_docPanel);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		
		confirmButton = new JButton("\u786E\u8BA4");
		panel_1.add(confirmButton);
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		panel_1.add(cancelButton);
	}
	public JPanel getDocPanel(){
		return docPanel;
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}

}
