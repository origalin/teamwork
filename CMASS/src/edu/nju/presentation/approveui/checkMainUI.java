package edu.nju.presentation.approveui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.nju.businesslogic.approvebl.approvebl;
import edu.nju.po.Doc;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OutWareHouseDocPO;
import edu.nju.po.OverDocPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.SendDocPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YArrivalDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZArrivalDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;
import edu.nju.presentation.mainui.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class checkMainUI extends JPanel{
	ArrayList<SendDocPO> uncheckedSendDocList;
	ArrayList<GatheringDocPO> uncheckedGatheringDocList;
	ArrayList<InWareHouseDocPO> uncheckedInWareHouseDocList;
	ArrayList<OutWareHouseDocPO> uncheckedOutWareHouseDocList;
	ArrayList<TransferDocPO> uncheckedTransferDocList;
	ArrayList<ZLoadDocPO> uncheckedZLoadDocList;
	ArrayList<OverDocPO> uncheckedOverDocList;
	ArrayList<PayDocPO> uncheckedPayDocList;
	ArrayList<YArrivalDocPO> uncheckedYArrivalDocList;
	ArrayList<YDeliverDocPO> uncheckedYDeliverDocList;
	ArrayList<YLoadDocPO> uncheckedYLoadDocList;
	ArrayList<ZArrivalDocPO> uncheckedZArrivalDocList;
	approvebl bl=new approvebl();
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	public static void main(String args[]){
		JFrame frame=new JFrame();
		checkMainUI ui=new checkMainUI();
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public checkMainUI() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{157, 261, 104, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 208, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u5BA1\u6279\u5355\u636E");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6536\u6B3E\u5355", "\u5165\u5E93\u5355", "\u4E2D\u8F6C\u5355", "\u51FA\u5E93\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355", "\u8425\u4E1A\u5385\u88C5\u8F66\u5355", "\u6536\u4EF6\u5355", "\u4ED8\u6B3E\u5355", "\u8425\u4E1A\u5385\u5230\u8FBE\u5355", "\u6D3E\u4EF6\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		JButton button_1 = new JButton("\u663E\u793A\u672A\u5BA1\u6279\u5355\u636E");
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String s=(String) comboBox.getSelectedItem();
				switch(s){
				case "收款单":
					ArrayList<String> uncheckedGatheringDocID=new ArrayList<String>();
					uncheckedGatheringDocList=bl.getunchekedGatheringDocList();
					for(GatheringDocPO GatheringDoc:uncheckedGatheringDocList){
						uncheckedGatheringDocID.add(GatheringDoc.getID());
					}
					table=initializeTable(uncheckedGatheringDocID);
					scrollPane.setViewportView(table);
					updateUI();
					break;
				case "付款单":
					ArrayList<String> uncheckedPayDocID=new ArrayList<String>();
					uncheckedPayDocList=bl.getunchekedPayDocList();
					for(PayDocPO PayDoc:uncheckedPayDocList){
						uncheckedPayDocID.add(PayDoc.getID());
					}
					table=initializeTable(uncheckedPayDocID);
					scrollPane.setViewportView(table);
					updateUI();
					break;
					/*
				case"入库单":
				case"出库单"：
				case"收件单":
				case"付款单":
				case"营业厅装车单":
				case"中转中心装车单"：
				case"":
					*/
				
				}
			}
		});
		
		
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		JLabel label_1 = new JLabel("\u5355\u636E\u7F16\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		textField = new JTextField();
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER){
					String inputID=textField.getText().trim();
					String DocType=(String) comboBox.getSelectedItem();
					switch(DocType){
					case "收款单":
						GatheringDocPO GatheringDocPO=getGatheringDocPOByID(inputID);
						GatheringDocVO GatheringDocVO=GatheringDocVOToPO(GatheringDocPO);
						CheckDialog GatheringDocdialog=new CheckDialog();
			            checkGatheringDoc GatheringDocui=new checkGatheringDoc(GatheringDocVO);
			            GatheringDocdialog.setCheckMode(GatheringDocui);
						break;
					case"付款单":
						PayDocPO PayDocPO=getPayDocPOByID(inputID);
						PayDocVO PayDocVO=PayDocVOToPO(PayDocPO);
						CheckDialog PayDocdialog=new CheckDialog();
			            checkPayDoc PayDocui=new checkPayDoc(PayDocVO);
			            PayDocdialog.setCheckMode(PayDocui);
						break;
					}
				}
			}

			private PayDocVO PayDocVOToPO(PayDocPO payDocPO) {
				return new PayDocVO(payDocPO.getID(),payDocPO.getDate(),payDocPO.getMoney(),payDocPO.getPayer(),payDocPO.getAccount(), payDocPO.getType(), payDocPO.getBack());
			}

			private PayDocPO getPayDocPOByID(String inputID) {
				for(PayDocPO PayDoc:uncheckedPayDocList){
					if(PayDoc.getID().equals(inputID)){
						return PayDoc;
					}
				}
				return null;
			}

			private GatheringDocVO GatheringDocVOToPO(
					GatheringDocPO po) {
				return new GatheringDocVO(po.getID(), po.getDate(),po.getMoney(),po.getCourier_ID(), po.getItemIDs(),po.getAccount());
			}
		});
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		ArrayList<String> tempList=new ArrayList<String>();
		for(int i=0;i<10;i++){
			tempList.add(null);
		}
		scrollPane.setViewportView(initializeTable(tempList));
		/*
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"", "\u5355\u636E\u7F16\u53F7"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class,String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		*/
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					switch((String) comboBox.getSelectedItem()){
					case "收款单":
						//首先遍历JTable,改变ArrayList中的是否已经被审批的属性
						ArrayList<GatheringDocPO> checkedGatheringDocList=new ArrayList<GatheringDocPO>();
						for(int i=0;i<table.getRowCount();i++){
							if((boolean)table.getValueAt(i, 0)==true){
								checkedGatheringDocList.add(uncheckedGatheringDocList.get(i));
							}
						}
						bl.setGatheringDocList(checkedGatheringDocList);
						uncheckedGatheringDocList=null;
						table=initializeTable(getEmptyList());
						scrollPane.setViewportView(table);
						updateUI();
					case"付款单":
						ArrayList<PayDocPO> checkedPayDocList=new ArrayList<PayDocPO>();
						for(int i=0;i<table.getRowCount();i++){
							if((boolean)table.getValueAt(i, 0)==true){
								checkedPayDocList.add(uncheckedPayDocList.get(i));
							}
						}
						bl.setPayDocList(checkedPayDocList);
						uncheckedPayDocList=null;
						table=initializeTable(getEmptyList());
						scrollPane.setViewportView(table);
						updateUI();
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 4;
		add(button, gbc_button);
	}
	
	
	protected GatheringDocPO getGatheringDocPOByID(String inputID) {
		for(GatheringDocPO GatheringDoc:uncheckedGatheringDocList){
			if(GatheringDoc.getID().equals(inputID)){
				return GatheringDoc;
			}
		}
		return null;
	}
	public JTable initializeTable(ArrayList<String> uncheckedDocID){
		table = new JTable();
		Object[][] tableInfo=new Object[uncheckedDocID.size()][2];
		for(int i=0;i<uncheckedDocID.size();i++){
			Object[] oneLine={null,uncheckedDocID.get(i)};
			tableInfo[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
				new String[] {
					"", "\u5355\u636E\u7F16\u53F7"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class,String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		return table;
		
	}
	
	public ArrayList<String> getEmptyList(){
		ArrayList<String> tempList=new ArrayList<String>();
		for(int i=0;i<10;i++){
			tempList.add(null);
		}
		return tempList;
	}
	
	public String DateToString(Date date){
		 DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
		 return df1.format(date);
	}
	
	public void approveDoc(String DocID,ArrayList<Doc>list){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getID().equals(DocID)){
				list.get(i).setChecked(true);
			}
		}
	}
	

}
