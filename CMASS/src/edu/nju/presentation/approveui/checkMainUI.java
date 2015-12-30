package edu.nju.presentation.approveui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.nju.businesslogic.approvebl.approvebl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.po.Doc;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.InWareHouseDocPO;
import edu.nju.po.OperationPO;
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
import edu.nju.vo.InWareHouseDocVO;
import edu.nju.vo.OutWareHouseDocVO;
import edu.nju.vo.OverDocVO;
import edu.nju.vo.PayDocVO;
import edu.nju.vo.SendDocVO;
import edu.nju.vo.TransferDocVO;
import edu.nju.vo.TransferDoc_CarVO;
import edu.nju.vo.TransferDoc_PlaneVO;
import edu.nju.vo.TransferDoc_TrainVO;
import edu.nju.vo.YArrivalDocVO;
import edu.nju.vo.YDeliverDocVO;
import edu.nju.vo.YLoadDocVO;
import edu.nju.vo.ZArrivalDocVO;
import edu.nju.vo.ZLoadDocVO;
import edu.nju.presentation.mainui.*;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
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
	approvebl bl;
	private Institution institution;
	private String staffName;
	private SystemBl systembl;
	private String staffID;
	private MyTable table;
	private JScrollPane scrollPane;
	private MyTextField textField;
	/*
	public static void main(String args[]){
		JFrame frame=new JFrame();
		checkMainUI ui=new checkMainUI("12034");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	*/
	public checkMainUI(String staffID) {
		setOpaque(false);
		systembl=new SystemBl();
		institution=new Institution();
		this.staffID=staffID;
		try {
			this.staffName=institution.getStaffName(staffID);
		} catch (RemoteException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			bl=new approvebl();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
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
		
		MyComboBox comboBox = new MyComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6536\u6B3E\u5355", "\u5165\u5E93\u5355", "\u4E2D\u8F6C\u5355", "\u51FA\u5E93\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355", "\u8425\u4E1A\u5385\u88C5\u8F66\u5355", "\u6536\u4EF6\u5355", "\u4ED8\u6B3E\u5355", "\u8425\u4E1A\u5385\u5230\u8FBE\u5355", "\u5BC4\u4EF6\u5355", "\u4E2D\u8F6C\u4E2D\u5FC3\u5230\u8FBE\u5355", "\u6D3E\u4EF6\u5355"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		add(comboBox, gbc_comboBox);
		
		SmallButton button_1 = new SmallButton("\u663E\u793A\u672A\u5BA1\u6279\u5355\u636E");
		button_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String s=(String) comboBox.getSelectedItem();
				textField.setText("");
				switch(s){
				case "收款单":
					/*
					ArrayList<String> uncheckedGatheringDocID=new ArrayList<String>();
					uncheckedGatheringDocList=bl.getunchekedGatheringDocList();
					for(GatheringDocPO GatheringDoc:uncheckedGatheringDocList){
						uncheckedGatheringDocID.add(GatheringDoc.getID());
					}
					table=initializeTable(uncheckedGatheringDocID);
					scrollPane.setViewportView(table);
					updateUI();
					*/
					uncheckedGatheringDocList=bl.getunchekedGatheringDocList();
					showUncheckedDoc(uncheckedGatheringDocList);
					break;
				case "付款单":
					/*
					ArrayList<String> uncheckedPayDocID=new ArrayList<String>();
					uncheckedPayDocList=bl.getunchekedPayDocList();
					for(PayDocPO PayDoc:uncheckedPayDocList){
						uncheckedPayDocID.add(PayDoc.getID());
					}
					table=initializeTable(uncheckedPayDocID);
					scrollPane.setViewportView(table);
					updateUI();
					break;
					*/
					uncheckedPayDocList=bl.getunchekedPayDocList();
					showUncheckedDoc(uncheckedPayDocList);
					break;
				case "寄件单":
					try {
						uncheckedSendDocList=bl.getuncheckedSendDocList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedSendDocList);
					break;
				case "中转中心到达单":
					try {
						uncheckedZArrivalDocList=bl.getunchekedZArrivalDocList();
						System.out.println(uncheckedZArrivalDocList.size());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedZArrivalDocList);
					break;
				case"营业厅到达单":
					try {
						uncheckedYArrivalDocList=bl.getunchekedYArrivalDocList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedYArrivalDocList);
					break;
				case"收件单":
					try {
						uncheckedOverDocList=bl.getunchekedOverDocList();
						System.out.println("uncheckedOverDocList"+uncheckedOverDocList.size());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedOverDocList);
					break;
				case"营业厅装车单":
					try {
						uncheckedYLoadDocList=bl.getunchekedYLoadDocList();
						System.out.println(uncheckedYLoadDocList.size());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedYLoadDocList);
					break;
				case"中转中心装车单":
					try {
						uncheckedZLoadDocList=bl.getunchekedZLoadDocList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedZLoadDocList);
					break;
				case"派件单":
					try {
						uncheckedYDeliverDocList=bl.getunchekedYDeliverDocList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedYDeliverDocList);
					break;
				case"中转单":
					try {
						uncheckedTransferDocList=bl.getunchekedTransferDocList();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					showUncheckedDoc(uncheckedTransferDocList);
					break;
				case"入库单":
					uncheckedInWareHouseDocList=bl.getunchekedInWareHouseDocList();
					System.out.println("uncheckedInWareHouseDocList"+uncheckedInWareHouseDocList.size());
					showUncheckedDoc(uncheckedInWareHouseDocList);
					break;
				case"出库单":
					uncheckedOutWareHouseDocList=bl.getunchekedOutWareHouseDocList();
					showUncheckedDoc(uncheckedOutWareHouseDocList);
					break;
					/*
				收款单.
				入库单
				中转单
				出库单
				中转中心装车单.
				营业厅装车单.
				收件单.
				付款单.
				营业厅到达单.
				寄件单.
				中转中心到达单.
				派件单.
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
		
		textField = new MyTextField();
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER){
					String inputID=textField.getText().trim();
					String DocType=(String) comboBox.getSelectedItem();
					switch(DocType){
					case "收款单":
						GatheringDocPO GatheringDocPO=getDocPOByID(inputID,uncheckedGatheringDocList);//getGatheringDocPOByID(inputID);
						if(GatheringDocPO!=null){
						GatheringDocVO GatheringDocVO=GatheringDocVOToPO(GatheringDocPO);
						CheckDialog GatheringDocdialog=new CheckDialog();
			            checkGatheringDoc GatheringDocui=new checkGatheringDoc(GatheringDocVO);
			            GatheringDocdialog.setCheckMode(GatheringDocui);
						}
						break;
					case"付款单":
						PayDocPO PayDocPO=getDocPOByID(inputID,uncheckedPayDocList);//getPayDocPOByID(inputID);
						if(PayDocPO!=null){
						PayDocVO PayDocVO=PayDocVOToPO(PayDocPO);
						CheckDialog PayDocdialog=new CheckDialog();
			            checkPayDoc PayDocui=new checkPayDoc(PayDocVO);
			            PayDocdialog.setCheckMode(PayDocui);
						}
						break;
					case "入库单":
						InWareHouseDocPO InWareHouseDocPO=getDocPOByID(inputID,uncheckedInWareHouseDocList);
						if(InWareHouseDocPO!=null){
						InWareHouseDocVO InWareHouseDocVO=new InWareHouseDocVO(InWareHouseDocPO);
						CheckDialog InWareHouseDocDialog=new CheckDialog();
						CheckInWareHouseDoc InWareHouseDocui=new CheckInWareHouseDoc(InWareHouseDocVO);
						InWareHouseDocDialog.setCheckMode(InWareHouseDocui);
						}
						break;
					case "出库单":
						OutWareHouseDocPO OutWareHouseDocPO=getDocPOByID(inputID,uncheckedOutWareHouseDocList);
						if(OutWareHouseDocPO!=null){
						OutWareHouseDocVO OutWareHouseDocVO=new OutWareHouseDocVO(OutWareHouseDocPO);
						CheckDialog OutWareHouseDocDialog=new CheckDialog();
						CheckWareHouseDoc OutWareHouseDocui=new CheckWareHouseDoc(OutWareHouseDocVO);
						OutWareHouseDocDialog.setCheckMode(OutWareHouseDocui);
						}
						break;
						
					case"中转单":
						TransferDocPO TransferDocPO=getDocPOByID(inputID,uncheckedTransferDocList);
						if(TransferDocPO!=null){
						String carNum=TransferDocPO.getCarNum();
						String trainNum=TransferDocPO.getTrainNum();
						String planeNum=TransferDocPO.getPlaneNum();
						
						if(!carNum.equals("1")){
							TransferDoc_CarVO vo=new TransferDoc_CarVO(TransferDocPO);
							CheckDialog carDialog=new CheckDialog();
							CheckTransferDoc_Car carui=new CheckTransferDoc_Car(vo);
							carDialog.setCheckMode(carui);
						}else if(!trainNum.equals("1")){
							TransferDoc_TrainVO vo=new TransferDoc_TrainVO(TransferDocPO);
							CheckDialog trainDialog=new CheckDialog();
							CheckTransferDoc_Train trainui=new CheckTransferDoc_Train(vo);
							trainDialog.setCheckMode(trainui);
						}else{
							TransferDoc_PlaneVO vo=new TransferDoc_PlaneVO(TransferDocPO);
							CheckDialog planeDialog=new CheckDialog();
							CheckTransferDoc_Plane planeui=new CheckTransferDoc_Plane(vo);
							planeDialog.setCheckMode(planeui);
						}
						}
						 break;
					case "中转中心装车单":
						ZLoadDocPO ZLoadDocPO=getDocPOByID(inputID,uncheckedZLoadDocList);
						if(ZLoadDocPO!=null){
						ZLoadDocVO ZLoadDocVO=new ZLoadDocVO(ZLoadDocPO);
						CheckDialog ZLoadDocDialog=new CheckDialog();
						CheckZLoadDoc ZLoadDocui=new CheckZLoadDoc(ZLoadDocVO);
						ZLoadDocDialog.setCheckMode(ZLoadDocui);
						}
						break;
					case"营业厅装车单":
						YLoadDocPO YLoadDocPO=getDocPOByID(inputID,uncheckedYLoadDocList);
						if(YLoadDocPO!=null){
						YLoadDocVO YLoadDocVO=new YLoadDocVO(YLoadDocPO);
						CheckDialog YLoadDocDialog=new CheckDialog();
						checkYLoadDoc YLoadDocui=new checkYLoadDoc(YLoadDocVO);
						YLoadDocDialog.setCheckMode(YLoadDocui);
						}
						break;
					case"收件单":
						OverDocPO OverDocPO=getDocPOByID(inputID,uncheckedOverDocList);
						if(OverDocPO!=null){
						OverDocVO OverDocVO=new OverDocVO(OverDocPO);
						CheckDialog OverDocDialog=new CheckDialog();
						checkOverDoc OverDocui=new checkOverDoc(OverDocVO);
						OverDocDialog.setCheckMode(OverDocui);
						}
						break;
					case"营业厅到达单":
						YArrivalDocPO YArrivalDocPO=getDocPOByID(inputID,uncheckedYArrivalDocList);
						if(YArrivalDocPO!=null){
						YArrivalDocVO YArrivalDocVO=new YArrivalDocVO(YArrivalDocPO);
						CheckDialog YArrivalDocDialog=new CheckDialog();
						checkYArrivalDoc YArrivalDocui=new checkYArrivalDoc(YArrivalDocVO);
						YArrivalDocDialog.setCheckMode(YArrivalDocui);
						}
						break;
					case"寄件单":
						SendDocPO SendDocPO=getDocPOByID(inputID,uncheckedSendDocList);
						if(SendDocPO!=null){
						SendDocVO SendDocVO=new SendDocVO(SendDocPO);
						CheckDialog SendDocDialog=new CheckDialog();
						CheckSendDoc SendDocui=new CheckSendDoc(SendDocVO);
						SendDocDialog.setCheckMode(SendDocui);
						}
						break;
					case"中转中心到达单":
						ZArrivalDocPO ZArrivalDocPO=getDocPOByID(inputID,uncheckedZArrivalDocList);
						if(ZArrivalDocPO!=null){
						ZArrivalDocVO ZArrivalDocVO=new ZArrivalDocVO(ZArrivalDocPO);
						CheckDialog ZArrivalDocDialog=new CheckDialog();
						checkZArrivalDoc ZArrivalDocui=new checkZArrivalDoc(ZArrivalDocVO);
						ZArrivalDocDialog.setCheckMode(ZArrivalDocui);
						}
						break;
					case"派件单":
						YDeliverDocPO YDeliverDocPO=getDocPOByID(inputID,uncheckedYDeliverDocList);
						if(YDeliverDocPO!=null){
						YDeliverDocVO YDeliverDocVO=new YDeliverDocVO(YDeliverDocPO);
						CheckDialog YDeliverDocDialog=new CheckDialog();
						checkYDeliverDoc YDeliverDocui=new checkYDeliverDoc(YDeliverDocVO);
						YDeliverDocDialog.setCheckMode(YDeliverDocui);
						}
						break;
						
					/*
						收款单.
						入库单
						中转单
						出库单
						中转中心装车单.
						营业厅装车单.
						收件单.
						付款单.
						营业厅到达单.
						寄件单.
						中转中心到达单.
						派件单.
						*/
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
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		SmallButton btnNewButton = new SmallButton("\u5168\u9009");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chooseAll();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		/*
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
		SmallButton button = new SmallButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					switch((String) comboBox.getSelectedItem()){
					case "收款单":
						//首先遍历JTable,改变ArrayList中的是否已经被审批的属性
						/*
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
						*/
						bl.setGatheringDocList(approveFinished(uncheckedGatheringDocList));
						uncheckedGatheringDocList=null;
						break;
					case"付款单":
						/*
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
						*/
						bl.setPayDocList(approveFinished(uncheckedPayDocList));
						uncheckedPayDocList=null;
						break;
					case"入库单":
						bl.setInWareHouseDocList(approveFinished(uncheckedInWareHouseDocList));
						uncheckedInWareHouseDocList=null;
						break;
					case"出库单":
						bl.setOutWareHouseDocList(approveFinished(uncheckedOutWareHouseDocList));
						uncheckedOutWareHouseDocList=null;
						break;
					case"中转单":
						try {
							bl.setTransferDocList(approveBossFinished(uncheckedTransferDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedTransferDocList=null;
						break;
					case"中转中心装车单":
						try {
							bl.setZLoadDocList(approveBossFinished(uncheckedZLoadDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedZLoadDocList=null;
						break;
					case"营业厅装车单":
						try {
							bl.setYLoadDocList(approveBossFinished(uncheckedYLoadDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedYLoadDocList=null;
						break;
					case"收件单":
						bl.setOverDocList(approveBossFinished(uncheckedOverDocList));
						uncheckedOverDocList=null;
						break;
					case "营业厅到达单":
						try {
							bl.setYArrivalDocList(approveBossFinished(uncheckedYArrivalDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedYArrivalDocList=null;
						break;
					case"寄件单":
						try {
							bl.setSendDocList(approveBossFinished(uncheckedSendDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedSendDocList=null;
						break;
					case "中转中心到达单":
						try {
							bl.setZArrivalDocList(approveBossFinished(uncheckedZArrivalDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedZArrivalDocList=null;
						break;
					case"派件单":
						try {
							bl.setYDeliverDocList(approveBossFinished(uncheckedYDeliverDocList));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						uncheckedYDeliverDocList=null;
						break;
					 /*
				收款单.
				入库单
				中转单
				出库单
				中转中心装车单.
				营业厅装车单.
				收件单.
				付款单.
				营业厅到达单.
				寄件单.
				中转中心到达单.
				派件单.
					*/
					 
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 2;
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
	public MyTable initializeTable(ArrayList<String> uncheckedDocID){
		table = new MyTable();
		Object[][] tableInfo=new Object[uncheckedDocID.size()][2];
		for(int i=0;i<uncheckedDocID.size();i++){
			Object[] oneLine={false,uncheckedDocID.get(i)};
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
	
	public void showUncheckedDoc(ArrayList<? extends Doc> docList){
		if(docList.size()!=0){
		ArrayList<String> uncheckedDocID=new ArrayList<String>();
		for(Doc doc:docList){
			uncheckedDocID.add(doc.getID());
		}
		table=initializeTable(uncheckedDocID);
		scrollPane.setViewportView(table);
		}else{
			table.setModel(new DefaultTableModel(
					new Object[1][],
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
		}
		updateUI();
	}
	
	public <T extends Doc> ArrayList<T> approveFinished(ArrayList<T> docList) {
		/*
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
		*/
		ArrayList<T> checkedDocList=new ArrayList<T>();
		for(int i=0;i<table.getRowCount();i++){
			if((boolean)table.getValueAt(i, 0)==true){
				checkedDocList.add(docList.get(i));
			}
		}
		table=initializeTable(getEmptyList());
		scrollPane.setViewportView(table);
		updateUI();
		String description="审批单据";
		OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
		try {
			systembl.saveOperation(po);
		} catch (RemoteException e1) {
			System.out.println("保存失败");
			e1.printStackTrace();
		}
		return checkedDocList;
	}
	
	public <T extends Doc> ArrayList<T> approveBossFinished(ArrayList<T> docList) {
		ArrayList<T> checkedDocList=new ArrayList<T>();
		for(int i=0;i<table.getRowCount();i++){
			checkedDocList.add(docList.get(i));
			if((boolean)table.getValueAt(i, 0)==true){
				checkedDocList.get(i).setChecked(true);
			}
		}
		table=initializeTable(getEmptyList());
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		updateUI();
		String description="审批单据";
		OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
		try {
			systembl.saveOperation(po);
		} catch (RemoteException e1) {
			System.out.println("保存失败");
			e1.printStackTrace();
		}
		return checkedDocList;
	}
	
	public <T extends Doc> T getDocPOByID(String ID,ArrayList<T> docList){
		for(T Doc:docList){
			if(Doc.getID().equals(ID)){
				return Doc;
			}
		}
		JOptionPane.showMessageDialog(null, "您输入的单号不存在", "错误",JOptionPane.PLAIN_MESSAGE); 
		textField.setText("");
		return null;
	}
	
	public void chooseAll(){
		for (int i=0; i<table.getRowCount(); i++)
        {
            table.setValueAt(true, i, 0);
        }
	}

}
