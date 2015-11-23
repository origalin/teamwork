package edu.nju.presentation.transformui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.transformbl.TransferDoc;
import edu.nju.presentation.approveui.CheckTransferDoc_Car;
import edu.nju.presentation.approveui.CheckTransferDoc_Plane;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;

@SuppressWarnings("serial")
public class TransferDocPanel_Plane extends JPanel{
	private JTextField carNumField;
	private JTextField watcherField;
	private JTextField targetField;
	private JTextField itemIDField;
	private JTable table;
	private JTextField boxField;
	private TransferDoc transferDoc;
	private String city,carNum,watcher,box;
	private String[] itemIDs;
	private int itemIDNum;
	private TransferDoc_PlaneVO vo;
	DefaultTableModel tableModel;
	private String institutionID, staffID;
	private String container;
	public TransferDocPanel_Plane(String staffID) {
		this.staffID = staffID;
		transferDoc = new TransferDoc( staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{418, 168, 0};
		gridBagLayout.rowHeights = new int[]{248, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{413, 0};
		gbl_panel_11.rowHeights = new int[]{42, 42, 42, 42, 0, 0, 0, 0, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				
				JLabel label = new JLabel("\u7A7A\u8FD0\u4E2D\u8F6C\u5355");
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
				
				JLabel label_10 = new JLabel("\u5230\u8FBE\u5730  ");
				panel_6.add(label_10);
				
				targetField = new JTextField();
				panel_6.add(targetField);
				targetField.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 2;
		panel_11.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u822A\u73ED\u53F7  ");
		panel_8.add(label_11);
		
		carNumField = new JTextField();
		panel_8.add(carNumField);
		carNumField.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u67DC\u53F7");
		panel_8.add(lblNewLabel_1);
		
		boxField = new JTextField();
		panel_8.add(boxField);
		boxField.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		panel_8.add(lblNewLabel);
		
		watcherField = new JTextField();
		panel_8.add(watcherField);
		watcherField.setColumns(5);
		

		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 7;
		panel_11.add(panel_12, gbc_panel_12);
		
		JButton createButton = new JButton("\u751F\u6210\u7A7A\u8FD0\u4E2D\u8F6C\u5355");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createTransferDoc();
			}
		});
		panel_12.add(createButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
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
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		panel_14.add(table);
		
		itemIDField = new JTextField();
		itemIDField.setColumns(15);
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
				tableModel.addRow(new Object[] {itemIDField.getText()});
			}
		});
		GridBagConstraints gbc_addButton = new GridBagConstraints();
		gbc_addButton.anchor = GridBagConstraints.NORTH;
		gbc_addButton.gridx = 0;
		gbc_addButton.gridy = 2;
		panel_1.add(addButton, gbc_addButton);
		

	}
	private void createTransferDoc() {
		intialize();
		if (creatable()) {
			vo = transferDoc.createTransferDocVO_Plane(city, carNum,  watcher, container, itemIDs);
			CheckDialog dialog = new CheckDialog();
			dialog.getDocPanel().add(new CheckTransferDoc_Plane(vo));
			dialog.getConfirmButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}

	}

	private boolean creatable() {
		if(city.equals("")||carNum.equals("")||watcher.equals("")||box.equals("")||container.equals("")||itemIDNum<1){
			return false;
		}else {
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
		for(int i = 0;i<tableModel.getRowCount();i++) {
			this.itemIDs[i] = (String) tableModel.getValueAt(i,0);
			itemIDNum++;
		}
	}
}
