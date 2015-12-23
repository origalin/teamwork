package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import edu.nju.businesslogicservice.storagelogicservice.StorageInitializeService;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.po.RecordPO;
import edu.nju.presentation.UiFactory;
import edu.nju.tools.Time;

import java.awt.event.ActionListener;
import java.awt.font.TextLayout;
import java.rmi.RemoteException;
import java.util.Date;
import java.awt.event.ActionEvent;

public class StorageInitialize extends JPanel{
	private String currStorageID;
	private String currPersonID;
	private JTextField textSendDoc_ID;
	private JTextField textDestination;
	private JTextField textDistrict;
	private JTextField textShelf;
	private JLabel lblNewLabel_4;
	private JTextField textRow;
	private JLabel lblNewLabel_5;
	private JTextField textPosition;
	private JButton btnNewButton;
	private JLabel lblNewLabel_6;
	private JTextField textInWareDate;
	private JButton button;
	public StorageInitialize(String staffID){
		this();
		this.currPersonID=staffID;
		try {
			currStorageID=UiFactory.getInstitutionLogicService().getInstitutionID(currPersonID);
		} catch (RemoteException e) {
			System.out.println("根据人员id初始化机构id出错");
			e.printStackTrace();
		}
	}
	public StorageInitialize() {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 291, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u5FEB\u9012\u7F16\u53F7");
		
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textSendDoc_ID = new JTextField();
		GridBagConstraints gbc_textSendDoc_ID = new GridBagConstraints();
		gbc_textSendDoc_ID.gridwidth = 2;
		gbc_textSendDoc_ID.insets = new Insets(0, 0, 5, 5);
		gbc_textSendDoc_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSendDoc_ID.gridx = 3;
		gbc_textSendDoc_ID.gridy = 1;
		add(textSendDoc_ID, gbc_textSendDoc_ID);
		textSendDoc_ID.setColumns(10);
		
		lblNewLabel_6 = new JLabel("\u5165\u5E93\u65E5\u671F");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textInWareDate = new JTextField();
		GridBagConstraints gbc_textInWareDate = new GridBagConstraints();
		gbc_textInWareDate.gridwidth = 2;
		gbc_textInWareDate.insets = new Insets(0, 0, 5, 5);
		gbc_textInWareDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textInWareDate.gridx = 3;
		gbc_textInWareDate.gridy = 2;
		add(textInWareDate, gbc_textInWareDate);
		textInWareDate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u76EE\u7684\u5730");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textDestination = new JTextField();
		GridBagConstraints gbc_textDestination = new GridBagConstraints();
		gbc_textDestination.gridwidth = 2;
		gbc_textDestination.insets = new Insets(0, 0, 5, 5);
		gbc_textDestination.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDestination.gridx = 3;
		gbc_textDestination.gridy = 3;
		add(textDestination, gbc_textDestination);
		textDestination.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u533A");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textDistrict = new JTextField();
		GridBagConstraints gbc_textDistrict = new GridBagConstraints();
		gbc_textDistrict.gridwidth = 2;
		gbc_textDistrict.insets = new Insets(0, 0, 5, 5);
		gbc_textDistrict.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDistrict.gridx = 3;
		gbc_textDistrict.gridy = 4;
		add(textDistrict, gbc_textDistrict);
		textDistrict.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\u6392\u53F7");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textRow = new JTextField();
		GridBagConstraints gbc_textRow = new GridBagConstraints();
		gbc_textRow.gridwidth = 2;
		gbc_textRow.insets = new Insets(0, 0, 5, 5);
		gbc_textRow.fill = GridBagConstraints.HORIZONTAL;
		gbc_textRow.gridx = 3;
		gbc_textRow.gridy = 5;
		add(textRow, gbc_textRow);
		textRow.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u67B6\u53F7");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textShelf = new JTextField();
		GridBagConstraints gbc_textShelf = new GridBagConstraints();
		gbc_textShelf.gridwidth = 2;
		gbc_textShelf.insets = new Insets(0, 0, 5, 5);
		gbc_textShelf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textShelf.gridx = 3;
		gbc_textShelf.gridy = 6;
		add(textShelf, gbc_textShelf);
		textShelf.setColumns(10);
		
		lblNewLabel_5 = new JLabel("\u4F4D\u53F7");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textPosition = new JTextField();
		GridBagConstraints gbc_textPosition = new GridBagConstraints();
		gbc_textPosition.gridwidth = 2;
		gbc_textPosition.insets = new Insets(0, 0, 5, 5);
		gbc_textPosition.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPosition.gridx = 3;
		gbc_textPosition.gridy = 7;
		add(textPosition, gbc_textPosition);
		textPosition.setColumns(10);
		
		button = new JButton("\u6E05\u96F6");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 8;
		add(button, gbc_button);
		
		btnNewButton = new JButton("\u65B0\u5EFA\u5E93\u5B58\u8BB0\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecordPO lineItem=new RecordPO(textSendDoc_ID.getText(),Time.stringToDate(textInWareDate.getText()), textDestination.getText(),
						textDistrict.getText(), textPosition.getText(), currStorageID);
				StorageInitializeService storageInitialize=UiFactory.getStorageInitialize();
				try {
					storageInitialize.addNewStorageItem(lineItem);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 9;
		add(btnNewButton, gbc_btnNewButton);
	}

}
