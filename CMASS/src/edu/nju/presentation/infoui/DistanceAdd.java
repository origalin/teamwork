package edu.nju.presentation.infoui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import edu.nju.businesslogic.infobl.Distance;
import edu.nju.businesslogicservice.infologicservice.DistanceLogicService;
import edu.nju.po.DistancePO;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class DistanceAdd extends JDialog {
	DistanceLogicService distanceLogicService=new Distance();
	private final JPanel contentPanel = new JPanel();
	private MyTextField textField;
	private SmallButton button;
	private SmallButton button_1;
	private JScrollPane scrollPane;
	private MyTable table;
	private SmallButton button_2;
	private JLabel label_1;
	DefaultTableModel model;


	/**
	 * Create the dialog.
	 */
	public DistanceAdd() {
	
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{69, 87, 60, 122, 63, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel label = new JLabel("\u65B0\u589E\u57CE\u5E02");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.WEST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 1;
			gbc_label.gridy = 0;
			contentPanel.add(label, gbc_label);
		}
		{
			textField = new MyTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			button_2 = new SmallButton("\u70B9\u51FB\u65B0\u589E");
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.insets = new Insets(0, 0, 5, 5);
			gbc_button_2.gridx = 3;
			gbc_button_2.gridy = 0;
			contentPanel.add(button_2, gbc_button_2);
			button_2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(textField.getText().equals("")){
						JOptionPane.showMessageDialog(null,"信息填写不完整，请检查");
					}else{
							add(textField.getText(),table);
					}
				
				}
			});
		}
		{
			label_1 = new JLabel("\u8F93\u5165\u4E0E\u5176\u4ED6\u57CE\u5E02\u7684\u8DDD\u79BB");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.WEST;
			gbc_label_1.gridwidth = 3;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 1;
			gbc_label_1.gridy = 1;
			contentPanel.add(label_1, gbc_label_1);
		}
		{
			scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.gridheight = 3;
			gbc_scrollPane.gridwidth = 3;
			gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridx = 1;
			gbc_scrollPane.gridy = 2;
			contentPanel.add(scrollPane, gbc_scrollPane);
			{
				table = new MyTable();
				table.setPreferredScrollableViewportSize(new Dimension(50, 100));
				table.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null, null},
					},
					new String[] {
						"\u57CE\u5E021", "\u57CE\u5E022", "\u8DDD\u79BB"
					}
				));
				scrollPane.setViewportView(table);
			}
		}
		{
			button = new SmallButton("\u786E\u8BA4");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")){
					JOptionPane.showMessageDialog(null,"信息填写不完整，请检查");
				}else{
					
					
					if(check(table)){
						table.setEnabled(false);
						for (int i = 0; i < table.getRowCount(); i++) {
							DistancePO po=new DistancePO((String) table.getValueAt(i, 0),
									(String) table.getValueAt(i, 1),Double.valueOf((String)table
									.getValueAt(i, 2)));
							try {
								distanceLogicService.addDistance(po);
							} catch (RemoteException e1) {
							
								e1.printStackTrace();
								JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
							}		
						}		
						dispose();
						//TODO 这里如何动态将comboBox内容修改
						
						
						
					}
					
				}
					
					
				}
			});
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.gridwidth = 2;
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 1;
			gbc_button.gridy = 5;
			contentPanel.add(button, gbc_button);
		}
		{
			button_1 = new SmallButton("\u53D6\u6D88");
			button_1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				dispose();
				}
			});
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.insets = new Insets(0, 0, 5, 5);
			gbc_button_1.gridx = 3;
			gbc_button_1.gridy = 5;
			contentPanel.add(button_1, gbc_button_1);
		}	
	}
	void add(String str,MyTable table){
		
		model=(DefaultTableModel)table.getModel();
		int row=model.getRowCount();
		for(int i=0;i<row;i++){
				model.removeRow(0);
		}
	

		ArrayList<String> citys= null;
		try {
		citys=distanceLogicService.getCityList();
		} catch (RemoteException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
		}
		for (String city : citys) {
			model.addRow(new Object[] { textField.getText(),city,"0"});
		}
	}
	
	boolean check(MyTable table2){
		for (int row = 0; row < table2.getRowCount();row++) {
				if((String.valueOf(table2.getValueAt(row, 2))).equals("0")){
					JOptionPane.showMessageDialog(null,"信息不完整，请检查");
					return false;
				}
			}
		return true;
}
	
}
