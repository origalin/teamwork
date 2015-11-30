package edu.nju.presentation.transformui;

import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.transformbl.YLoadDoc;
import edu.nju.presentation.approveui.checkYLoadDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.YLoadDocVO;

import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class YLoadDocPanel extends JPanel{
	private JTextField carIDField;
	private JTextField watcherField;
	private JTextField itemIDField;
	private JTable table;
	protected DefaultTableModel tableModel;
	String carID,watcher,institutionID,staffID;
	String driver;
	String[] itemIDs;
	YLoadDoc yLoadDoc;
	YLoadDocVO vo;
	private JComboBox driverBox;
	String[][] driverNameAndIDs;
	String[] drivers;

	public YLoadDocPanel(String staffID) {
		this.staffID = staffID;
		yLoadDoc = new YLoadDoc(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{144, 334, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 248, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u8425\u4E1A\u5385\u88C5\u8F66\u5355");
		panel.add(label);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.HORIZONTAL;
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
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);
		
		watcherField = new JTextField();
		panel_8.add(watcherField);
		watcherField.setColumns(10);
		
		JLabel label_12 = new JLabel("\u53F8\u673A");
		panel_8.add(label_12);
		
		driverNameAndIDs = yLoadDoc.getDrivers();
		drivers = new String[driverNameAndIDs.length];
		for(int i = 0;i<driverNameAndIDs.length;i++) {
			drivers[i] = driverNameAndIDs[i][1];
		}
		driverBox = new JComboBox();
		driverBox.setModel(new DefaultComboBoxModel<String>(drivers));
		panel_8.add(driverBox);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.gridheight = 3;
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
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				tableModel.addRow(new Object[] {itemIDField.getText()});
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
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
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
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
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.NORTH;
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 2;
		panel_1.add(addButton, gbc_addButton);
		
		JButton createButton = new JButton("\u751F\u6210\u8425\u4E1A\u5385\u88C5\u8F66\u5355");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createYLoadDoc();
			}
		});
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.gridwidth = 2;
		gbc_createButton.anchor = GridBagConstraints.EAST;
		gbc_createButton.gridx = 0;
		gbc_createButton.gridy = 5;
		add(createButton, gbc_createButton);
		

	}
	private void createYLoadDoc() {
		if(creatable()) {
			vo = yLoadDoc.createYLoadDocVO(carID,"上级", watcher, driver,itemIDs);
			CheckDialog cDialog = new CheckDialog();
			cDialog.getDocPanel().add(new checkYLoadDoc(vo));
			cDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					saveDoc();
				}
			});
		}else {
			warnning();
		}
	}
	private boolean creatable() {
		intialize();
		if(driver.equals("")||carID.equals("")||watcher.equals("")||itemIDs==null) {
			return false;
		}else {
			return true;
		}
	}
	private void  intialize() {
		carID = carIDField.getText();
		watcher = watcherField.getText();
		driver = driverNameAndIDs[driverBox.getSelectedIndex()][0];
		if(tableModel.getRowCount()>0) {
			itemIDs = new String[tableModel.getRowCount()];
			for(int i = 0;i<tableModel.getRowCount();i++) {
				itemIDs[i] = (String) tableModel.getValueAt(i, 0);
			}
		}
	}
	private void warnning() {
		
	}
	private void saveDoc() {
		yLoadDoc.confirmSave();
	}
}
