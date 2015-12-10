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
		setBorder(new TitledBorder(null, "\u5E93\u533A\u8C03\u6574", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 147, 0, 119, 0};
		gbl_panel.rowHeights = new int[]{32, 35, 28, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("航运区");
		comboBox.addItem("货运区");
		comboBox.addItem("汽运区");
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StorageModifyService storageModifyService=UiFactory.getStorageModifyService();
				try {
					storageModifyService.storageModify((String)comboBox.getSelectedItem(),currStorageID);
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "远程连接异常，请检查网络之后重新进行操作");
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "调整成功");
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 11;
		gbc_button.gridy = 2;
		panel_1.add(button, gbc_button);
	}
	

}
