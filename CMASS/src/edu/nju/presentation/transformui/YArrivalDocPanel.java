package edu.nju.presentation.transformui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.table.TableColumnModel;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.transferbl.YArrivalDoc;
import edu.nju.businesslogic.transferbl.YDeliverDoc;
import edu.nju.businesslogic.transferbl.ZArrivalDoc;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.approveui.checkYArrivalDoc;
import edu.nju.presentation.approveui.checkZArrivalDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.YDeliverDocVO;
import edu.nju.vo.ZArrivalDocVO;

import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class YArrivalDocPanel extends JPanel{
	private JTextField zLoadDocIDField;
	private JTextField itemIDField;
	private JTable table;
	DefaultTableModel tableModel,DeliverModel;
	String institutionID, staffID;
	YArrivalDoc yArrivalDoc;
	YDeliverDoc yDeliverDoc;
	YArrivalDocVO vo;
	String[][] IDAndState;
	String[] courier;
	String[] courierName;
	private JTable table_1;
	public YArrivalDocPanel( String staffID) {
		this.staffID = staffID;
		try {
			yArrivalDoc = new YArrivalDoc(staffID);
			yDeliverDoc = new YDeliverDoc(staffID);
			courier = yArrivalDoc.getCouriers();
			courierName = new String[courier.length];
			for(int i = 0;i<courier.length;i++) {
				courierName[i] = yArrivalDoc.getcoutierName(courier[i]);
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{202, 295, 0, 0};
		gridBagLayout.rowHeights = new int[]{248, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		panel_11.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u8425\u4E1A\u5385\u5230\u8FBE\u5355");
		panel.add(label);

		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355\u53F7");
		panel_6.add(label_10);
		
		JPanel panel_2 = new JPanel();
		panel_2.getLayout();
		panel_11.add(panel_2);
		
		zLoadDocIDField = new JTextField();
		panel_2.add(zLoadDocIDField);
		zLoadDocIDField.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		
		JPanel panel_3 = new JPanel();
		panel_11.add(panel_3);
		

		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{45, 126, 30, 71, 0};
		gbl_panel_1.rowHeights = new int[]{170, 24, 27, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
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
				"\u8FD0\u5355\u53F7", "\u72B6\u6001"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableModel = (DefaultTableModel) table.getModel();
		panel_14.add(table);
		
		JLabel label_2 = new JLabel("\u8FD0\u5355\u53F7");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		itemIDField = new JTextField();
		itemIDField.setColumns(15);
		GridBagConstraints gbc_itemIDField = new GridBagConstraints();
		gbc_itemIDField.anchor = GridBagConstraints.NORTHWEST;
		gbc_itemIDField.insets = new Insets(0, 0, 5, 5);
		gbc_itemIDField.gridx = 1;
		gbc_itemIDField.gridy = 1;
		panel_1.add(itemIDField, gbc_itemIDField);
		
		JLabel label_3 = new JLabel("\u72B6\u6001");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"\u635F\u574F", "\u4E22\u5931"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.anchor = GridBagConstraints.NORTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				tableModel.addRow(new Object[] {itemIDField.getText(),comboBox.getSelectedItem()});
				itemIDField.setText("");
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_addButton.anchor = GridBagConstraints.NORTH;
		gbc_addButton.gridx = 3;
		gbc_addButton.gridy = 2;
		panel_1.add(addButton, gbc_addButton);
		
		JButton creatButton = new JButton("\u751F\u6210\u5230\u8FBE\u5355");
		creatButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (intializable()) {
					createZArrivalDoc();
				}
				
			}
		});
		GridBagConstraints gbc_creatButton = new GridBagConstraints();
		gbc_creatButton.anchor = GridBagConstraints.EAST;
		gbc_creatButton.gridwidth = 2;
		gbc_creatButton.insets = new Insets(0, 0, 5, 5);
		gbc_creatButton.gridx = 0;
		gbc_creatButton.gridy = 1;
		add(creatButton, gbc_creatButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5FEB\u9012\u5355\u53F7", "\u5730\u5740", "\u5FEB\u9012\u5458"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JComboBox<String> courierBox = new JComboBox<String>();
		courierBox.setModel(new DefaultComboBoxModel<String>(courierName));
		TableColumnModel tcm = table_1.getColumnModel();
		tcm.getColumn(2).setCellEditor(new DefaultCellEditor(courierBox));
		DeliverModel = (DefaultTableModel) table_1.getModel();
	
		
		
		JButton confirmButton = new JButton("\u786E\u8BA4\u5206\u914D");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveYArrivalDoc();
				createYDeliverDoc();
				saveDoc();
			}
		});
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.insets = new Insets(0, 0, 0, 5);
		gbc_confirmButton.anchor = GridBagConstraints.EAST;
		gbc_confirmButton.gridx = 1;
		gbc_confirmButton.gridy = 4;
		add(confirmButton, gbc_confirmButton);
		
		setOpaque(false);
		panel.setOpaque(false);
		panel.setOpaque(false);
		panel_11.setOpaque(false);
		panel_12.setOpaque(false);
		panel_13.setOpaque(false);
		panel_14.setOpaque(false);
		panel_2.setOpaque(false);
		panel_3.setOpaque(false);
		panel_6.setOpaque(false);
		panel_8.setOpaque(false);

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

	private boolean intializable() {
		if (zLoadDocIDField.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	private void createZArrivalDoc() {
			IDAndState = new String[tableModel.getRowCount()][2];
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				IDAndState[i][0] = (String) tableModel.getValueAt(i, 0);
				IDAndState[i][0] = (String) tableModel.getValueAt(i, 1);
			}
				try {
					vo = yArrivalDoc.createYArrivalDocVO(zLoadDocIDField.getText(), IDAndState);
					CheckDialog cDialog = new CheckDialog();
					cDialog.setPreviewMode(new checkYArrivalDoc(vo));
					cDialog.getConfirmButton().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							intializeYDeliver();
						}
					});
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					warning("net");
				} catch (DatabaseNULLException e1) {
					// TODO Auto-generated catch block
					warning("null");
					e1.printStackTrace();
				}
			
			
	}
	private void  saveYArrivalDoc() {
		try {
			yArrivalDoc.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
	}
	private void intializeYDeliver() {
		String[][] itStrings = vo.getItemAndState();
		String[] docs  = new String[itStrings.length];
		for(int i = 0;i<itStrings.length;i++) {
			docs[i] = itStrings[i][0];
		}
		for(String str : docs) {
			try {
				DeliverModel.addRow(new Object[]{str,yArrivalDoc.getAddressByID(str),""});
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				warning("net");
			} catch (DatabaseNULLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void createYDeliverDoc() {
		String[][] table = new String[DeliverModel.getRowCount()][2];
		for(int i = 0;i<DeliverModel.getRowCount();i++) {
			table[i][0] = (String) DeliverModel.getValueAt(i, 0);
			String name = (String) DeliverModel.getValueAt(i, 2);
			for(int j = 0;j<courier.length;j++) {
				if(courierName[j].equals(name)) {
					table[i][1] = courier[j];
					break;
				}
			}
			
		}
		try {
			yDeliverDoc.createYDeliverDoc(table);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}
		
	}
	private void saveDoc() {
		try {
			yDeliverDoc.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
		JOptionPane.showMessageDialog(this, "保存成功");
	}
}
