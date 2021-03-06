package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogic.storagebl.OutWareHouseManagementbl;
import edu.nju.businesslogicservice.storagelogicservice.OutWareHouseManagementService;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.InWareHouseDocLineItem;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.Time;
import edu.nju.tools.WarningManager;
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class OutWareHouseManagment extends JPanel {
	private OutWareHouseManagementService outWareHouseManagement;
	private String currPersonID;
	private String currInstitution;
	private MyTextField textField;
	private JTable table;
	private TableModel model;
	private MyTextField textField_1;
	private OutWareHouseDocVO outWareHouseDocVO;
	String[] columnNames = { "快递编号", "目的地" };
	private MyTextField textField_2;

	public OutWareHouseManagment(String staffID) {
		this();

		this.currPersonID = staffID;
		try {
			currInstitution = UiFactory.getInstitutionLogicService().getInstitutionID(currPersonID);
		} catch (RemoteException e) {
			System.out.println("根据人员id初始化机构id出错");
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// OutWareHouseManagment outWareHouseManagment=new
	// OutWareHouseManagment("001000");
	// JFrame mainFrame = new JFrame();
	// mainFrame.getContentPane().add(outWareHouseManagment);
	// mainFrame.setVisible(true);
	// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// mainFrame.setLocationRelativeTo(null);
	// mainFrame.setSize(500, 300);
	// }
	public OutWareHouseManagment() {
		setOpaque(false);

		// String[][] data={
		// {"10003665","20151031","航运","北京"},
		// {"10003666","20151031","航运","北京"},
		// {"10003667","20151031","航运","北京"},
		// {"10003668","20151031","航运","北京"},
		// {"10003669","20151031","航运","北京"},
		// {"10003670","20151031","航运","北京"},
		// {"10003671","20151031","航运","北京"},
		// {"10003672","20151031","航运","北京"},
		// };

		String data[][] = new String[0][0];
		table = new MyTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u5FEB\u9012\u7F16\u53F7", "\u76EE\u7684\u5730" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(201);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 85, 153, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 171, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		MyComboBox comboBox = new MyComboBox();
		panel.add(comboBox);
		comboBox.addItem("中转单编号");
		comboBox.addItem("装车单编号");

		textField = new MyTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		MyComboBox comboBox_1 = new MyComboBox();
		comboBox_1.addItem("航运");
		comboBox_1.addItem("汽运");
		comboBox_1.addItem("货运");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 0;
		add(comboBox_1, gbc_comboBox_1);

		MyScrollPane scrollPane_1 = new MyScrollPane();
		scrollPane_1.getViewport().setOpaque(false);

		SmallButton button = new SmallButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (textField.getText().equals(""))
					WarningManager.warning( "请输入中转单号或装车单号");
				else {
					boolean normal = true;
					String selectedItem = (String) comboBox.getSelectedItem();

					outWareHouseManagement = UiFactory.getOutWareHouseManagementService();// 与逻辑层建立联系以便调用

					if (selectedItem.equals("中转单编号"))
						try {
							outWareHouseDocVO = outWareHouseManagement
									.getOutWareHouseDocVO_Transfer(textField.getText(), currInstitution);
						} catch (RemoteException e1) {
							System.out.println("远程连接异常，请检查网络环境后重启客户端");
							e1.printStackTrace();
							normal = false;
						} catch (DatabaseNULLException e1) {
							WarningManager.warning( "请输入合法有效的中转单号");
							e1.printStackTrace();
							normal = false;
						}
					else if (selectedItem.equals("装车单编号"))
						try {
							outWareHouseDocVO = outWareHouseManagement
									.getOutWareHouseDocVO_ZloadDoc(textField.getText(), currInstitution);
						} catch (RemoteException e1) {
							System.out.println("远程连接异常，请检查网络环境后重启客户端");
							e1.printStackTrace();
							normal = false;
						} catch (DatabaseNULLException e1) {
							WarningManager.warning( "请输入合法有效的装车单号");
							e1.printStackTrace();
							normal = false;
						}
					if (normal) {
						outWareHouseDocVO.setTransferPattern((String) comboBox_1.getSelectedItem());// 设置装运形式
						outWareHouseDocVO.setStorageID(currInstitution);
						textField_1.setText(outWareHouseDocVO.getID());// 设置当前出库单编号
						textField_2.setText(Time.toDaysTime(outWareHouseDocVO.getDate()));
						// 以下对vo进行解析在界面上显示出来
						ArrayList<OutWareHouseDocLineItem> list = outWareHouseDocVO.getLineItemList();

						String[][] data1 = new String[list.size()][4];
						int i = 0;
						for (OutWareHouseDocLineItem temp : list) {
							data1[i][0] = temp.getSendDocID();// 快递编号

							i++;
						}

						table = new MyTable(data1, columnNames);
						scrollPane_1.setViewportView(table);
					}
				}

			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 4;
		gbc_button.gridy = 0;
		add(button, gbc_button);

		JLabel lblNewLabel = new JLabel("\u51FA\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

		textField_1 = new MyTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField_2 = new MyTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 1;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		scrollPane_1.setOpaque(false);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		add(scrollPane_1, gbc_scrollPane_1);

		// table = new JTable(data,columnNames);
		scrollPane_1.setViewportView(table);

		SmallButton btnNewButton = new SmallButton("\u751F\u6210\u51FA\u5E93\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = true;
				int rowNum = table.getRowCount();
				int columnNum = table.getColumnCount();
				model = (table.getModel());
				for (int i = 0, j = 1; i < rowNum; i++) {
					String object = (String) model.getValueAt(i, j);
					if (object == null || object.equals(""))
						check = false;
				}
				String selectedItem = (String) comboBox.getSelectedItem();

				model = (table.getModel());
				ArrayList<OutWareHouseDocLineItem> lines = outWareHouseDocVO.getLineItemList();
				int i = 0, j = 1;
				for (OutWareHouseDocLineItem temp : lines)

				{
					String object = (String) model.getValueAt(i, j);
					temp.setDestination(object);
					i++;
				}
				// 根据table的model更新vo的信息

				for (OutWareHouseDocLineItem temp : lines) {
					if (temp.getDestination() == null)
						WarningManager.warning( "请输入完整的信息");
				}
				// check是否有某行目的地没有填写
				if (check) {
					outWareHouseDocVO.setLineItemList(lines);
					outWareHouseManagement = UiFactory.getOutWareHouseManagementService();
					outWareHouseManagement.updateOutWareHouseDoc(outWareHouseDocVO, currPersonID);
					// 根据新的vo去更新调用逻辑层更新数据层
					WarningManager.warning( "出库单已保存成功");
				} else {
					WarningManager.warning( "请输入完整的信息");
				}

			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
	}
}
