package edu.nju.presentation.transformui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogic.transferbl.ZLoadDoc;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.presentation.approveui.CheckZLoadDoc;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.approveui.checkYLoadDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.YLoadDocVO;
import edu.nju.vo.ZLoadDocVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class ZLoadDocPanel extends JPanel{
	private JTextField carIDField;
	private JTextField watcherField;
	private JTextField itemIDField;
	private JTable table;
	String institutionID,staffID;
	ZLoadDoc zLoadDoc;
	String[] subBusinessHall;
	String[] drivers;
	String[][] driverNameAndIDs;
	private DefaultTableModel tableModel;
	String carID,watcher,driver,target;
	String[] itemIDs;
	ZLoadDocVO vo;
	private JComboBox<String> targetBox;
	private JComboBox<String> driverBox;
	public ZLoadDocPanel(String staffID) {
		this.staffID = staffID;
		try {
			zLoadDoc = new ZLoadDoc(staffID);
			subBusinessHall = zLoadDoc.getSubBusinessHall();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{290, 168, 0};
		gridBagLayout.rowHeights = new int[]{0, 17, 248, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355");
		panel.add(label);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridwidth = 2;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u8F66\u8F86\u4EE3\u53F7");
		panel_8.add(label_11);
		
		carIDField = new JTextField();
		panel_8.add(carIDField);
		carIDField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5230\u8FBE\u5730");
		panel_8.add(label_2);
		
		
		targetBox = new JComboBox<String>();
		targetBox.setModel(new DefaultComboBoxModel<>(subBusinessHall));
		panel_8.add(targetBox);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);
		
		watcherField = new JTextField();
		panel_8.add(watcherField);
		watcherField.setColumns(10);
		
		JLabel label_12 = new JLabel("\u53F8\u673A");
		panel_8.add(label_12);
		
		try {
			driverNameAndIDs = zLoadDoc.getDrivers();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}
		drivers = new String[driverNameAndIDs.length];
		for(int i = 0;i<driverNameAndIDs.length;i++) {
			drivers[i] = driverNameAndIDs[i][1];
		}
		driverBox = new JComboBox<String>();
		driverBox.setModel(new DefaultComboBoxModel<String>(drivers));
		panel_8.add(driverBox);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{168, 0};
		gbl_panel_1.rowHeights = new int[]{170, 24, 27, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_13 = new JPanel();
		scrollPane.setColumnHeaderView(panel_13);
		
		JLabel label_1 = new JLabel("\u8FD0\u5355\u53F7");
		panel_13.add(label_1);
		
		JPanel panel_14 = new JPanel();
		scrollPane.setViewportView(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8FD0\u5355\u53F7"
			}
		));
		tableModel = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		panel_14.add(table);
		
		itemIDField = new JTextField();
		itemIDField.setColumns(30);
		GridBagConstraints gbc_itemIDField = new GridBagConstraints();
		gbc_itemIDField.anchor = GridBagConstraints.NORTH;
		gbc_itemIDField.insets = new Insets(0, 0, 5, 0);
		gbc_itemIDField.gridx = 0;
		gbc_itemIDField.gridy = 1;
		panel_1.add(itemIDField, gbc_itemIDField);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					zLoadDoc.checkHas(itemIDField.getText());
					tableModel.addRow(new Object[] {itemIDField.getText()});
					itemIDField.setText("");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					warning("net");
				} catch (DatabaseNULLException e1) {
					// TODO Auto-generated catch block
					warning("null");
				}
				
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.NORTH;
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 2;
		panel_1.add(addButton, gbc_addButton);
		
		JButton createButton = new JButton("\u751F\u6210\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createZLoadDoc();
			}
		});
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.gridx = 1;
		gbc_createButton.gridy = 3;
		add(createButton, gbc_createButton);
		
		panel.setOpaque(false);
		setOpaque(false);
		panel_1.setOpaque(false);
		panel_13.setOpaque(false);
		panel_14.setOpaque(false);
		panel_8.setOpaque(false);
	}
	private void createZLoadDoc() {
		if(creatable()) {
			try {
				vo = zLoadDoc.createZLoadDocVO(carID,target ,watcher, driver,itemIDs);
				CheckDialog cDialog = new CheckDialog();
				cDialog.setPreviewMode(new CheckZLoadDoc(vo));
				cDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						saveDoc();
					}
				});
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				warning("net");
			}
		}else {
			warning("lost");
		}
	}
	private boolean creatable() {
		intialize();
		if(driver.equals("")||target.equals("")||carID.equals("")||watcher.equals("")||itemIDs==null) {
			return false;
		}else {
			return true;
		}
	}
	private void  intialize() {
		carID = carIDField.getText();
		watcher = watcherField.getText();
		target = (String) targetBox.getSelectedItem();
		driver = driverNameAndIDs[driverBox.getSelectedIndex()][0];
		if(tableModel.getRowCount()>0) {
			itemIDs = new String[tableModel.getRowCount()];
			for(int i = 0;i<tableModel.getRowCount();i++) {
				itemIDs[i] = (String) tableModel.getValueAt(i, 0);
			}
		}
	}
	private void warning(String type) {
		
		switch (type) {
		case "net":
			JOptionPane.showMessageDialog(this, "网络异常，请重启客户端！");
			break;	
		case "lost":
			JOptionPane.showMessageDialog(this, "请检查信息完整性");
			break;
		case "null":
			JOptionPane.showMessageDialog(this, "找不到单据");
			break;

		default:
			break;
		}
	}
	private void saveDoc() {
		try {
			zLoadDoc.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
	}
}
