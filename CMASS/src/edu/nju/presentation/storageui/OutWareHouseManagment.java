package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
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
import edu.nju.vo.OutWareHouseDocLineItem;
import edu.nju.vo.OutWareHouseDocVO;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OutWareHouseManagment extends JPanel{
	private OutWareHouseManagementService outWareHouseManagement;
	private String currPersonID;
	private String currInstitution;
	private JTextField textField;
	private JTable table;
	private TableModel model;
	private JTextField textField_1;
	private OutWareHouseDocVO outWareHouseDocVO;
	String[] columnNames={"��ݱ��","Ŀ�ĵ�"};
	private JTextField textField_2;
	
	
	
	public OutWareHouseManagment(String staffID) {
		this();
		
		this.currPersonID = staffID; 
		try {
			currInstitution=UiFactory.getInstitutionLogicService().getInstitutionID(currPersonID);
		} catch (RemoteException e) {
			System.out.println("������Աid��ʼ������id����");
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		OutWareHouseManagment outWareHouseManagment=new OutWareHouseManagment("001000");
//		JFrame mainFrame = new JFrame();
//		mainFrame.getContentPane().add(outWareHouseManagment);
//		mainFrame.setVisible(true);
//		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		mainFrame.setLocationRelativeTo(null);
//		mainFrame.setSize(500, 300);
//	}
	public OutWareHouseManagment() {
		
		
//		String[][] data={
//				{"10003665","20151031","����","����"},
//				{"10003666","20151031","����","����"},
//				{"10003667","20151031","����","����"},
//				{"10003668","20151031","����","����"},
//				{"10003669","20151031","����","����"},
//				{"10003670","20151031","����","����"},
//				{"10003671","20151031","����","����"},
//				{"10003672","20151031","����","����"},
//		};
		
		setBorder(new TitledBorder(null, "\u51FA\u5E93\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{114, 223, 0, 0};
		gridBagLayout.rowHeights = new int[]{20, 171, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		comboBox.addItem("��ת�����");
		comboBox.addItem("װ�������");
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addItem("����");
		comboBox_1.addItem("����");
		comboBox_1.addItem("����");
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 0;
		add(comboBox_1, gbc_comboBox_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		
//		table = new JTable(data,columnNames);
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();

				outWareHouseManagement = UiFactory.getOutWareHouseManagementService();//���߼��㽨����ϵ�Ա����
				
				if (selectedItem.equals("��ת�����"))
					try {
						outWareHouseDocVO = outWareHouseManagement.getOutWareHouseDocVO_Transfer(textField.getText(), currInstitution);
					} catch (RemoteException e1) {
						System.out.println("Զ�������쳣���������绷��");
						e1.printStackTrace();
					} catch (DatabaseNULLException e1) {
						System.out.println("��ѯ���Ϊ��");
						e1.printStackTrace();
					}
				else if (selectedItem.equals("װ�������"))
					try {
						outWareHouseDocVO = outWareHouseManagement.getOutWareHouseDocVO_ZloadDoc(textField.getText(), currInstitution);
					} catch (RemoteException e1) {
						System.out.println("Զ�������쳣���������绷��");
						e1.printStackTrace();
					} catch (DatabaseNULLException e1) {
						System.out.println("��ѯ���Ϊ��");
						e1.printStackTrace();
					}
				
				outWareHouseDocVO.setTransferPattern((String)comboBox_1.getSelectedItem());//����װ����ʽ
				outWareHouseDocVO.setStorageID(currInstitution);
				textField_1.setText(outWareHouseDocVO.getID());//���õ�ǰ���ⵥ���
				textField_2.setText(outWareHouseDocVO.getDate().toString());
				//���¶�vo���н����ڽ�������ʾ����
				ArrayList<OutWareHouseDocLineItem> list = outWareHouseDocVO.getLineItemList();

				String[][] data1 = new String[list.size()][4];
				int i = 0;
				for (OutWareHouseDocLineItem temp : list) {
					data1[i][0] = temp.getSendDocID();// ��ݱ��
							
					i++;
				}

				table = new JTable(data1, columnNames);
				scrollPane_1.setViewportView(table);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 2;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		JButton btnNewButton = new JButton("\u751F\u6210\u51FA\u5E93\u5355");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();

				int rowNum = table.getRowCount();
				int columnNum = table.getColumnCount();
				model = (table.getModel());
				ArrayList<OutWareHouseDocLineItem> lines = outWareHouseDocVO.getLineItemList();
				int i = 0, j = 1;
				for (OutWareHouseDocLineItem temp : lines)

				{
					String object = (String) model.getValueAt(i, j);
					temp.setDestination(object);
					i++;
				}
				//����table��model����vo����Ϣ

				for (OutWareHouseDocLineItem temp : lines) {
					if (temp.getDestination() == null)
						JOptionPane.showMessageDialog(null, "��������������Ϣ");
				}
				//check�Ƿ���ĳ��Ŀ�ĵ�û����д
				
				outWareHouseDocVO.setLineItemList(lines);
				outWareHouseManagement = UiFactory.getOutWareHouseManagementService();
				outWareHouseManagement.updateOutWareHouseDoc(outWareHouseDocVO,currPersonID);
				//�����µ�voȥ���µ����߼���������ݲ�
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u5E93\u65E5\u671F");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		add(btnNewButton, gbc_btnNewButton);
	}
}
