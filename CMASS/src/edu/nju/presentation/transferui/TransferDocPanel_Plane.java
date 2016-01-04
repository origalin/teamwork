package edu.nju.presentation.transferui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.Savepoint;

import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.WarningManager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.transferbl.TransferDoc;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.presentation.approveui.CheckTransferDoc_Car;
import edu.nju.presentation.approveui.CheckTransferDoc_Plane;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class TransferDocPanel_Plane extends JPanel {
	private MyTextField carNumField;
	private MyTextField watcherField;
	private MyTextField targetField;
	private MyTextField itemIDField;
	private MyTextField boxField;
	private TransferDoc transferDoc;
	private String city, carNum, watcher, box;
	private String[] itemIDs;
	private int itemIDNum;
	private TransferDoc_PlaneVO vo;
	DefaultTableModel tableModel;
	private String institutionID, staffID;
	private String container;
	private MyTable table;

	public TransferDocPanel_Plane(String staffID) {
		this.staffID = staffID;
		try {
			transferDoc = new TransferDoc(staffID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 342, 309, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 248, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { -273, 0 };
		gbl_panel_11.rowHeights = new int[] { 42, 42, 42, 0, 0, 0, 0, 0 };
		gbl_panel_11.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_11.add(panel_6, gbc_panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);

		JLabel label_10 = new JLabel("\u5230\u8FBE\u5730  ");
		panel_6.add(label_10);

		targetField = new MyTextField();
		panel_6.add(targetField);
		targetField.setColumns(20);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_11.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);

		JLabel label_11 = new JLabel("\u822A\u73ED\u53F7  ");
		panel_8.add(label_11);

		carNumField = new MyTextField();
		panel_8.add(carNumField);
		carNumField.setColumns(5);

		JLabel lblNewLabel_1 = new JLabel("\u8D27\u67DC\u53F7");
		panel_8.add(lblNewLabel_1);

		boxField = new MyTextField();
		panel_8.add(boxField);
		boxField.setColumns(5);

		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);

		watcherField = new MyTextField();
		panel_8.add(watcherField);
		watcherField.setColumns(5);

		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 6;
		panel_11.add(panel_12, gbc_panel_12);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 168, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 170, 24, 27, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		MyScrollPane scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);

		table = new MyTable();
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u5FEB\u4EF6\u5355\u53F7" }));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("\u65B0\u589E\u5355\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);

		itemIDField = new MyTextField();
		itemIDField.setColumns(25);
		GridBagConstraints gbc_itemIDField = new GridBagConstraints();
		gbc_itemIDField.anchor = GridBagConstraints.NORTH;
		gbc_itemIDField.insets = new Insets(0, 0, 5, 5);
		gbc_itemIDField.gridx = 1;
		gbc_itemIDField.gridy = 1;
		panel_1.add(itemIDField, gbc_itemIDField);
		tableModel = (DefaultTableModel) table.getModel();

		setOpaque(false);
		panel_1.setOpaque(false);
		panel_11.setOpaque(false);
		panel_12.setOpaque(false);
		panel_6.setOpaque(false);
		panel_8.setOpaque(false);
		scrollPane.setOpaque(false);
		
				SmallButton addButton = new SmallButton("\u6DFB\u52A0");
				addButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						try {
							transferDoc.checkHas(itemIDField.getText());
							tableModel.addRow(new Object[] { itemIDField.getText() });
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
				gbc_addButton.insets = new Insets(0, 0, 5, 0);
				gbc_addButton.anchor = GridBagConstraints.NORTH;
				gbc_addButton.gridx = 2;
				gbc_addButton.gridy = 1;
				panel_1.add(addButton, gbc_addButton);
				
						SmallButton createButton = new SmallButton("\u751F\u6210\u7A7A\u8FD0\u4E2D\u8F6C\u5355");
						GridBagConstraints gbc_createButton = new GridBagConstraints();
						gbc_createButton.anchor = GridBagConstraints.EAST;
						gbc_createButton.gridwidth = 2;
						gbc_createButton.gridx = 1;
						gbc_createButton.gridy = 2;
						panel_1.add(createButton, gbc_createButton);
						createButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								createTransferDoc();
							}
						});
		scrollPane.getViewport().setOpaque(false);
	}

	private void createTransferDoc() {
		intialize();
		if (creatable()) {
			try {
				vo = transferDoc.createTransferDocVO_Plane(city, carNum, watcher, container, itemIDs);
				CheckDialog cDialog = new CheckDialog();
				cDialog.setPreviewMode(new CheckTransferDoc_Plane(vo));
				cDialog.getConfirmButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						saveDoc();
						clean();
					}
				});
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				warning("net");
			}

		} else {
			warning("lost");
		}

	}

	private boolean creatable() {
		if (city.equals("") || carNum.equals("") || watcher.equals("") || box.equals("") || container.equals("")
				|| itemIDNum < 1) {
			return false;
		} else {
			return true;
		}
	}

	private void intialize() {
		this.city = targetField.getText();
		this.carNum = carNumField.getText();
		this.watcher = watcherField.getText();
		this.box = boxField.getText();
		this.container = boxField.getText();
		this.itemIDs = new String[tableModel.getRowCount()];
		itemIDNum = 0;
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			this.itemIDs[i] = (String) tableModel.getValueAt(i, 0);
			itemIDNum++;
		}
	}

	private void saveDoc() {
		try {
			transferDoc.confirmsave_Plane();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
	}

	private void warning(String type) {

		switch (type) {
		case "net":
			WarningManager.warning("�����쳣���������ͻ��ˣ�");
			break;	
		case "lost":
			WarningManager.warning("������Ϣ������");
			break;
		case "null":
			WarningManager.warning("�Ҳ�������");
			break;

		default:
			break;
		}
	}
	private void clean() {
		int i = tableModel.getRowCount();
		for(;i>0;i--) {
			tableModel.removeRow(i-1);
		}
	}
}