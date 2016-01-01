package edu.nju.presentation.transformui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.SmallButton;
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
import edu.nju.businesslogic.transferbl.YLoadDoc;
import edu.nju.businesslogic.transferbl.ZArrivalDoc;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.Doc;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.approveui.checkZArrivalDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.ZArrivalDocVO;

import edu.nju.presentation.widget.MyComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class ZArrivalDocPanel extends JPanel {
	private MyTextField transferDocIDField;
	private MyTextField itemIDField;
	private MyTable table;
	MyComboBox docTypeBox;
	String institutionID, staffID;
	ZArrivalDoc zArrivalDoc;
	ZArrivalDocVO vo;
	DefaultTableModel tableModel;
	String[][] str;
	TransferDoc transferDoc;
	YLoadDoc yLoadDoc;
	int docType = -1;//0-中转单1-装车单

	public ZArrivalDocPanel( String staffID) {
		this.staffID = staffID;
		try {
			zArrivalDoc = new ZArrivalDoc( staffID);
			transferDoc = new TransferDoc(staffID);
			yLoadDoc = new YLoadDoc(staffID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 183, 295, 30, 0 };
		gridBagLayout.rowHeights = new int[] { 248, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 178, 0 };
		gbl_panel_11.rowHeights = new int[] { 42, 42, 0, 42, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
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
		
		
		docTypeBox = new MyComboBox();
		docTypeBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u4E2D\u8F6C\u5355\u7F16\u53F7", "\u8425\u4E1A\u5385\u88C5\u8F66\u5355\u7F16\u53F7" }));
		panel_6.add(docTypeBox);
		docTypeBox.setOpaque(false);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_11.add(panel_2, gbc_panel_2);

		transferDocIDField = new MyTextField();
		panel_2.add(transferDocIDField);
		transferDocIDField.setColumns(20);

		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 3;
		panel_11.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 45, 208, 43, 71, 0 };
		gbl_panel_1.rowHeights = new int[] { 170, 24, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		MyScrollPane scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);

		JPanel panel_14 = new JPanel();
		
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table = new MyTable();
		table.setRowHeight(30);
		table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8FD0\u5355\u53F7", "\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		table.getColumnModel().getColumn(1).setPreferredWidth(48);
		scrollPane.setViewportView(table);
		tableModel = (DefaultTableModel) table.getModel();

		JLabel label_2 = new JLabel("\u65B0\u589E\u5355\u53F7");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);

		itemIDField = new MyTextField();
		itemIDField.setColumns(15);
		GridBagConstraints gbc_itemIDField = new GridBagConstraints();
		gbc_itemIDField.fill = GridBagConstraints.HORIZONTAL;
		gbc_itemIDField.anchor = GridBagConstraints.NORTH;
		gbc_itemIDField.insets = new Insets(0, 0, 0, 5);
		gbc_itemIDField.gridx = 1;
		gbc_itemIDField.gridy = 1;
		panel_1.add(itemIDField, gbc_itemIDField);

		JLabel label_3 = new JLabel("\u72B6\u6001");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 2;
		gbc_label_3.gridy = 1;
		panel_1.add(label_3, gbc_label_3);

		MyComboBox comboBox = new MyComboBox();
		comboBox.setOpaque(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "\u635F\u574F", "\u4E22\u5931" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);

		SmallButton createButton = new SmallButton("\u751F\u6210\u5230\u8FBE\u5355");
		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				createZArrivalDoc();
			}
		});
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.insets = new Insets(0, 0, 0, 5);
		gbc_createButton.anchor = GridBagConstraints.EAST;
		gbc_createButton.gridx = 2;
		gbc_createButton.gridy = 1;
		add(createButton, gbc_createButton);

		
		
		setOpaque(false);
		panel_11.setOpaque(false);
		panel_14.setOpaque(false);
		panel_2.setOpaque(false);
		panel_1.setOpaque(false);
		panel_6.setOpaque(false);
		panel_8.setOpaque(false);
		
		scrollPane.setOpaque(false);
		
				SmallButton addButton = new SmallButton("\u6DFB\u52A0");
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
				gbc_addButton.gridx = 4;
				gbc_addButton.gridy = 1;
				panel_1.add(addButton, gbc_addButton);
		scrollPane.getViewport().setOpaque(false);
	}

	private void intializeWithFromDoc() {
		
			Doc po ;
			switch ((String)docTypeBox.getSelectedItem()) {
			case "中转单编号":
				docType = 0;
				
				break;
			case "营业厅装车单编号":
				docType = 1;
				
				break;
			default:
				break;
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

	private boolean intializable() {
		if (transferDocIDField.getText().equals("")) {
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
		if (intializable()) {
			intializeWithFromDoc();
			str = new String[tableModel.getRowCount()][2];
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				str[i][0] = (String) tableModel.getValueAt(i, 0);
				str[i][1] = (String) tableModel.getValueAt(i, 1);
				
				
				
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
						clean();
					}
				});
			} catch (RemoteException e) {
				// TODO: handle exception
				warning("net");
			} catch (DatabaseNULLException e1) {
				// TODO Auto-generated catch block
				warning("null");
				e1.printStackTrace();
			}
			
//			CheckDialog cDialog = new CheckDialog();
//			cDialog.getDocPanel().add(new checkZArrivalDoc(vo));
//			cDialog.getConfirmButton().addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					saveDoc();
//				}
//			});
		}else {
			warning("lost");
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
	private void clean() {
		int i = tableModel.getRowCount();
		for(;i>0;i--) {
			tableModel.removeRow(i-1);
		}
	}
}
