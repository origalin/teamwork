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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.transformbl.ZArrivalDoc;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.approveui.checkZArrivalDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.ZArrivalDocVO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ZArrivalDocPanel extends JPanel {
	private JTextField transferDocIDField;
	private JTextField itemIDField;
	private JTable table;
	JComboBox docTypeBox;
	String institutionID, staffID;
	ZArrivalDoc zArrivalDoc;
	ZArrivalDocVO vo;
	DefaultTableModel tableModel;
	String[][] str;
	int docType = -1;//0-中转单1-装车单

	public ZArrivalDocPanel( String staffID) {
		this.staffID = staffID;
		try {
			zArrivalDoc = new ZArrivalDoc( staffID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 183, 295, 0 };
		gridBagLayout.rowHeights = new int[] { 248, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 178, 0 };
		gbl_panel_11.rowHeights = new int[] { 42, 42, 42, 0, 42, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_11.add(panel, gbc_panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		JLabel label = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355");
		panel.add(label);

		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 1;
		panel_11.add(panel_6, gbc_panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);

		docTypeBox = new JComboBox();
		docTypeBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u4E2D\u8F6C\u5355\u7F16\u53F7", "\u8425\u4E1A\u5385\u88C5\u8F66\u5355\u7F16\u53F7" }));
		panel_6.add(docTypeBox);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		panel_11.add(panel_2, gbc_panel_2);

		transferDocIDField = new JTextField();
		panel_2.add(transferDocIDField);
		transferDocIDField.setColumns(20);

		JButton confirmButton = new JButton("\u786E\u8BA4");
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				intializeWithFromDoc();
			}
		});
		GridBagConstraints gbc_confirmButton = new GridBagConstraints();
		gbc_confirmButton.anchor = GridBagConstraints.EAST;
		gbc_confirmButton.insets = new Insets(0, 0, 5, 0);
		gbc_confirmButton.gridx = 0;
		gbc_confirmButton.gridy = 3;
		panel_11.add(confirmButton, gbc_confirmButton);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 4;
		panel_11.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 45, 126, 30, 71 };
		gbl_panel_1.rowHeights = new int[] { 170, 24, 27, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 4;
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
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "\u8FD0\u5355\u53F7", "\u72B6\u6001" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		panel_14.add(table);
		tableModel = (DefaultTableModel) table.getModel();

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
		gbc_itemIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemIDField.anchor = GridBagConstraints.NORTH;
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

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u635F\u574F", "\u4E22\u5931" }));
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
				tableModel.addRow(new Object[] { itemIDField.getText(), comboBox.getSelectedItem() });
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_addButton.anchor = GridBagConstraints.NORTH;
		gbc_addButton.gridx = 3;
		gbc_addButton.gridy = 2;
		panel_1.add(addButton, gbc_addButton);

		JButton createButton = new JButton("\u751F\u6210\u5230\u8FBE\u5355");
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				createZArrivalDoc();
			}
		});
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.anchor = GridBagConstraints.EAST;
		gbc_createButton.gridx = 1;
		gbc_createButton.gridy = 1;
		add(createButton, gbc_createButton);

	}

	private void intializeWithFromDoc() {
		if (intializable()) {
			switch ((String)docTypeBox.getSelectedItem()) {
			case "中转单":
				docType = 0;
				break;
			case "营业厅装车单":
				docType = 1;
				break;
			default:
				break;
			}
				
		} else {
			warning("lost");
		}

	}

	private void warning(String type) {
		CheckDialog warningDialog = new CheckDialog();
		switch (type) {
		case "net":
			warningDialog.setNetMode();
			break;	
		case "lost":
			warningDialog.setLostMode();
			break;

		default:
			break;
		}
	}

	private boolean intializable() {
		if (transferDocIDField.getText().equals("")||docType==-1) {
			return false;
		} else {
			return true;
		}
	}

	private boolean creatable() {
		if (tableModel.getRowCount() == 0) {
			return false;
		} else {
			return true;
		}
	}

	private void createZArrivalDoc() {
		if (creatable()&&intializable()) {
			intializeWithFromDoc();
			str = new String[tableModel.getRowCount()][2];
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				str[i][0] = (String) tableModel.getValueAt(i, 0);
				str[i][0] = (String) tableModel.getValueAt(i, 1);
				
				
				
			}
			try {
				if(docType==0) {
					vo = zArrivalDoc.createZArrivalDocVO_TransferDoc(transferDocIDField.getText(), str);
				}else {
					vo = zArrivalDoc.createZArrivalDocVO_YLoadDoc(transferDocIDField.getText(), str);
				}
				CheckDialog cDialog = new CheckDialog();
				cDialog.setPreviewMode(new checkZArrivalDoc(vo));
				cDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						saveDoc();
					}
				});
			} catch (Exception e) {
				// TODO: handle exception
				warning("net");
			}
			
			CheckDialog cDialog = new CheckDialog();
			cDialog.getDocPanel().add(new checkZArrivalDoc(vo));
			cDialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					saveDoc();
				}
			});
		}
	}
	private void saveDoc() {
		try {
			zArrivalDoc.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
	}
}
