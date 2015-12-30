package edu.nju.presentation.storageui;

import javax.swing.JPanel;
import javax.swing.JTable;

import org.omg.CORBA.PRIVATE_MEMBER;

import edu.nju.businesslogicservice.storagelogicservice.StorageQueryService;
import edu.nju.dataFactory.DataFactory;
import edu.nju.po.RecordPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.export.ExportExcel;
import edu.nju.presentation.widget.MyTable;
import edu.nju.vo.storageItemVO;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class StorageQuery extends JPanel {
	String[] columnNames = { "��ݱ��", "�������", "��", "�ź�", "�ܺ�", "λ��" };
	ArrayList<RecordPO> list;
	ArrayList<RecordPO> list_1 ;
	ArrayList<RecordPO> list_2 ;
	private String currStorageID;
	private String currPersonID;
	private DefaultTableModel model;
	private DefaultTableModel model_1;
	private DefaultTableModel model_2;
	String[][] rowData = {};
	// String[][] rowData = { { "1002520", "20151031", "����", "������", "31", "21",
	// "12" },
	// { "1002521", "20151031", "����", "������", "31", "21", "12" },
	// { "1002522", "20151031", "����", "������", "31", "21", "12" },
	// { "1002523", "20151031", "����", "������", "31", "21", "12" },
	// { "1002524", "20151031", "����", "������", "31", "21", "12" },
	// { "1002525", "20151031", "����", "������", "31", "21", "12" },
	// { "1002526", "20151031", "����", "������", "31", "21", "12" } };
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	public StorageQuery(String staffID) {
		this();
		this.currPersonID = staffID;
		try {
			currStorageID = UiFactory.getInstitutionLogicService().getInstitutionID(currPersonID);
		} catch (RemoteException e) {
			System.out.println("������Աid��ʼ������id����");
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// StorageQuery storageQuery=new StorageQuery("001000");
	// JFrame mainFrame = new JFrame();
	// mainFrame.getContentPane().add(storageQuery);
	// mainFrame.setVisible(true);
	// mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// mainFrame.setLocationRelativeTo(null);
	// mainFrame.setSize(500, 300);
	// }
	public StorageQuery() {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 584, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 104, 106, 106, 45, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(
				new TitledBorder(null, "\u822A\u8FD0\u533A", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);

		table = new MyTable();
		table.setPreferredScrollableViewportSize(new Dimension(450, 150));
		table.setModel(new DefaultTableModel(rowData, columnNames));
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8D27\u8FD0\u533A",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane_1);

		table_1 = new MyTable(rowData, columnNames);
		table_1.setPreferredScrollableViewportSize(new Dimension(450, 150));
		table_1.setModel(new DefaultTableModel(rowData, columnNames));
		model_1 = (DefaultTableModel) table_1.getModel();
		scrollPane_1.setViewportView(table_1);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6C7D\u8FD0\u533A",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 3;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane_2);

		table_2 = new MyTable(rowData, columnNames);
		table_2.setPreferredScrollableViewportSize(new Dimension(450, 150));
		table_2.setModel(new DefaultTableModel(rowData, columnNames));
		model_2 = (DefaultTableModel) table_2.getModel();
		scrollPane_2.setViewportView(table_2);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);

		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 38, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JButton query = new JButton("\u67E5\u8BE2");
		GridBagConstraints gbc_query = new GridBagConstraints();
		gbc_query.insets = new Insets(0, 0, 5, 5);
		gbc_query.gridx = 1;
		gbc_query.gridy = 3;
		add(query, gbc_query);

		// JLabel label =new JLabel();
		//// label.setOpaque(true);
		//// label.setBackground(Color.BLACK);
		//
		//
		// gbc_query.anchor = GridBagConstraints.EAST;
		// gbc_query.insets = new Insets(0, 0, 0, 5);
		// gbc_query.gridx = 10;
		// gbc_query.gridy = 0;
		// gbc_query.weightx = 1;
		// panel_3.add(label, gbc_query);
		// gbl_panel_3.setConstraints(label, gbc_query);

		JButton export = new JButton("\u5BFC\u51FA");
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ExportExcel<storageItemVO> ex = new ExportExcel<storageItemVO>();
				String[] headers ={ "��ݱ��", "�������", "Ŀ�ĵ�", "��","�ź�", "�ܺ�", "λ��" ,"�ֿ���"};
				List<storageItemVO> dataset=new ArrayList<storageItemVO>() ;
				
				for(RecordPO temp:list)	    {	dataset.add(new storageItemVO(temp));}
				for(RecordPO temp:list_1)	{	dataset.add(new storageItemVO(temp));}
				for(RecordPO temp:list_2)	{	dataset.add(new storageItemVO(temp));}
		
				try {
					OutputStream out = new FileOutputStream("D://�ֿ����嵥.xls");		
					ex.exportExcel(headers, dataset, out);	
					
					out.close();		
					
					System.out.println("excel�����ɹ���");
				} catch (FileNotFoundException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				} catch (IOException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_export = new GridBagConstraints();
		gbc_export.insets = new Insets(0, 0, 0, 5);
		gbc_export.gridx = 1;
		gbc_export.gridy = 4;
		add(export, gbc_export);
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean normal1 = true, normal2 = true, normal3 = true;
				StorageQueryService storageQueryService = UiFactory.getStorageQueryService();
				list = new ArrayList<RecordPO>();

				try {
					list = storageQueryService.getInWareHouseDocVO_Fly(currPersonID, currStorageID);
				} catch (RemoteException e2) {
					System.out.println("��ѯ������������ʧ�ܣ������������������");
					e2.printStackTrace();
					normal1 = false;
				}
				if (normal1) {
					int rows = list.size();
					int columns = 6;
					String[][] data1 = new String[rows][columns];
					int i = 0;
					for (RecordPO temp : list) {
						data1[i][0] = temp.getItemID();
						data1[i][1] = temp.getDate().toString();
						data1[i][2] = temp.getDistrict();
						data1[i][3] = temp.getLocation().substring(0, 2);
						data1[i][4] = temp.getLocation().substring(2, 4);
						data1[i][5] = temp.getLocation().substring(4);
						i++;
					}
					// table = new JTable(data1, columnNames);
					// scrollPane.setViewportView(table);
					for (i = 0; i < rows; i++) {
						model.addRow(new Object[] { data1[i][0], data1[i][1], data1[i][2], data1[i][3], data1[i][4],
								data1[i][5] });
					}
				}

				list_1 = null;
				try {
					list_1 = storageQueryService.getInWareHouseDocVO_Train(currPersonID, currStorageID);
				} catch (RemoteException e1) {
					System.out.println("��ѯ������������ʧ�ܣ������������������");
					e1.printStackTrace();
					normal2 = false;
				}

				if (normal2) {
					int rows = list_1.size();
					int columns = 6;
					String[][] data2 = new String[rows][columns];
					int i = 0;
					for (RecordPO temp : list_1) {
						data2[i][0] = temp.getItemID();
						data2[i][1] = temp.getDate().toString();
						data2[i][2] = temp.getDistrict();
						data2[i][3] = temp.getLocation().substring(0, 2);
						data2[i][4] = temp.getLocation().substring(2, 4);
						data2[i][5] = temp.getLocation().substring(4);
						i++;
					}
					// table_1 = new JTable(data2, columnNames);
					// scrollPane_1.setViewportView(table);
					for (i = 0; i < rows; i++) {
						model_1.addRow(new Object[] { data2[i][0], data2[i][1], data2[i][2], data2[i][3], data2[i][4],
								data2[i][5] });
					}
				}

				if (normal3) {
					int columns = 6;
					list_2 = null;
					try {
						list_2 = storageQueryService.getInWareHouseDocVO_Car(currPersonID, currStorageID);
					} catch (RemoteException e1) {
						System.out.println("��ѯ������������ʧ�ܣ������������������");
						e1.printStackTrace();
					}
					int rows = list_2.size();
					String[][] data3 = new String[rows][columns];
					int i = 0;
					for (RecordPO temp : list_2) {
						data3[i][0] = temp.getItemID();
						data3[i][1] = temp.getDate().toString();
						data3[i][2] = temp.getDistrict();
						data3[i][3] = temp.getLocation().substring(0, 2);
						data3[i][4] = temp.getLocation().substring(2, 4);
						data3[i][5] = temp.getLocation().substring(4);
						i++;
					}
					table = new JTable(data3, columnNames);
					scrollPane_2.setViewportView(table);
				}

			}
		});
		// repaint();
	}

}
