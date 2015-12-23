package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import edu.nju.businesslogicservice.storagelogicservice.StorageModifyService;
import edu.nju.presentation.UiFactory;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class StorageModify extends JPanel{
	String currStorageID;
	String currPersonID;
	private JTextField textField;
	
//	public static void main(String[] args) {
//		StorageModify storageModify=new StorageModify("001000");
//		JFrame mainFrame = new JFrame();
//		mainFrame.getContentPane().add(storageModify);
//		mainFrame.setVisible(true);
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainFrame.setLocationRelativeTo(null);
//		mainFrame.setSize(500, 300);
//	}
	
	public StorageModify(String staffID){
		this();
		this.currPersonID=staffID;
		try {
			currStorageID=UiFactory.getInstitutionLogicService().getInstitutionID(currPersonID);
		} catch (RemoteException e) {
			System.out.println("根据人员id初始化机构id出错");
			e.printStackTrace();
		}
	}
	public StorageModify() {
		setOpaque(false);
		setSize(760,517);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 147, 110, 119, 0};
		gbl_panel.rowHeights = new int[]{32, 35, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("航运区");
		comboBox.addItem("货运区");
		comboBox.addItem("汽运区");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 5;
		gbc_button.gridy = 12;
		panel.add(button, gbc_button);
		
		JButton button_1 = new JButton("\u91CA\u653E\u673A\u52A8\u533A\u7A7A\u95F4");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageModifyService storageModifyService=UiFactory.getStorageModifyService();
				try {
					storageModifyService.storageRealease(currStorageID);
					JOptionPane.showMessageDialog(null, "机动区空间已释放");
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "网络连接失败，请检查网络连接后重启客户端");
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 13;
		panel.add(button_1, gbc_button_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageModifyService storageModifyService=UiFactory.getStorageModifyService();
				try {
					storageModifyService.storageModify((String)comboBox.getSelectedItem(),currPersonID,currStorageID,Integer.parseInt(textField.getText()));
					JOptionPane.showMessageDialog(null, "调整成功");
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "远程连接异常，请检查网络之后重启客户端");
					e1.printStackTrace();
				}
				
				
			}
		});
	}
	

}
