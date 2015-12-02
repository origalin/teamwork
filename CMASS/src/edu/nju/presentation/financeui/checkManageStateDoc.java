package edu.nju.presentation.financeui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class checkManageStateDoc extends JPanel{
	public static void main(String[]args){
		JFrame frame=new JFrame();
		checkManageStateDoc ui=new checkManageStateDoc();
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	ArrayList<PayDocVO> PayDocVOList=new ArrayList<PayDocVO>();
	ArrayList<GatheringDocVO> GatheringDocVOList=new ArrayList<GatheringDocVO>();
	financebl bl=new financebl();
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	public checkManageStateDoc() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 34, 58, 92, 0, 80, 0};
		gridBagLayout.rowHeights = new int[]{43, -10, 0, 12, 117, 129, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u7ECF\u8425\u60C5\u51B5\u8868");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("\u8D77\u59CB\u65F6\u95F4");
		label_2.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EC8\u6B62\u65F6\u95F4");
		label_3.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 4;
		gbc_label_3.gridy = 2;
		add(label_3, gbc_label_3);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton checkButton = new JButton("\u67E5\u8BE2");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startDate=textField.getText().trim();
				String endDate=textField_1.getText().trim();
				PayDocVOList=bl.getPayDoc(startDate, endDate);
				GatheringDocVOList=bl.getGatheringDoc(startDate, endDate);
			}
		});
		GridBagConstraints gbc_checkButton = new GridBagConstraints();
		gbc_checkButton.insets = new Insets(0, 0, 5, 5);
		gbc_checkButton.gridx = 3;
		gbc_checkButton.gridy = 3;
		add(checkButton, gbc_checkButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u5165\u6B3E\u5355"
			}
		));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 3;
		gbc_scrollPane_1.gridy = 5;
		add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"\u6536\u6B3E\u5355"
			}
		));
	}
	
	public JTable initializeTable(ArrayList)

}
