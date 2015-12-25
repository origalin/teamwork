package edu.nju.presentation.collectionui;

import javax.swing.*;

import java.awt.GridLayout;

import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.presentation.approveui.CheckSendDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.presentation.widget.BigButton;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.SendDocVO;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CollertionPanel extends JPanel{
	String sName,rName,scity,rcity,sAddress,rAddress,sTelePhone,rTelePhone,sMobilePhone,rMobilePhone,itemKind,sUnit,rUnit;
	double weight;
	double[] volume;
	int itemNum,packageType,sendType;
	String institutionID;
	String staffID;
	CollectionLogicService collection;
	private MyTextField sNameField;
	private MyTextField sMobilePhoneField;
	private MyTextField sAddressField;
	private MyTextField rNameField;
	private MyTextField rMobilePhoneField;
	private MyTextField rAddressField;
	private MyTextField ItemkindField;
	private MyTextField priceField;
	private MyTextField timeField;
	private MyTextField ScityField;
	private MyTextField RcityField;
	private MyTextField ItemNumField;
	private MyTextField WeightField;
	private MyTextField LengthField;
	private MyTextField WidethField;
	private MyTextField HeighthField;
	private MyTextField rTelePhoneField;
	private MyTextField rUnitField;
	private MyTextField sTelePhoneField;
	private MyTextField sUnitField;
	public CollertionPanel(String staffID) {
		this.staffID = staffID;
		sendType = -1;
		weight = -1.0;
		try {
			collection = new Collectionbl(staffID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning("net");
		}
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{213, 30, 0};
		gridBagLayout.rowHeights = new int[]{560, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		setOpaque(false);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBorder(null);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 0, 5);
		gbc_panel_11.anchor = GridBagConstraints.NORTH;
		gbc_panel_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{471, 0};
		gbl_panel_11.rowHeights = new int[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};
		gbl_panel_11.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_11.add(panel, gbc_panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		panel_11.add(panel_1, gbc_panel_1);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		panel_1.add(label_1);
		
		sNameField = new MyTextField();
		panel_1.add(sNameField);
		sNameField.setColumns(10);
		
		JLabel label_22 = new JLabel("*");
		label_22.setForeground(Color.RED);
		panel_1.add(label_22);
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		panel_1.add(label_3);
		
		sMobilePhoneField = new MyTextField();
		panel_1.add(sMobilePhoneField);
		sMobilePhoneField.setColumns(20);
		
		JLabel label_25 = new JLabel("*");
		label_25.setForeground(Color.RED);
		panel_1.add(label_25);
		
		JPanel panel_14 = new JPanel();
		panel_14.setOpaque(false);
		FlowLayout flowLayout_11 = (FlowLayout) panel_14.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 2;
		panel_11.add(panel_14, gbc_panel_14);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		panel_14.add(label_2);
		
		sTelePhoneField = new MyTextField();
		sTelePhoneField.setColumns(20);
		panel_14.add(sTelePhoneField);
		
		JLabel label_19 = new JLabel("\u5355\u4F4D");
		panel_14.add(label_19);
		
		sUnitField = new MyTextField();
		sUnitField.setColumns(10);
		panel_14.add(sUnitField);
		
		JLabel label_24 = new JLabel("*");
		label_24.setForeground(Color.RED);
		panel_14.add(label_24);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 3;
		panel_11.add(panel_2, gbc_panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		panel_2.add(label_4);
		
		ScityField = new MyTextField();
		panel_2.add(ScityField);
		ScityField.setColumns(10);
		
		JLabel label_20 = new JLabel("\u5E02");
		panel_2.add(label_20);
		
		sAddressField = new MyTextField();
		panel_2.add(sAddressField);
		sAddressField.setColumns(40);
		
		JLabel label_23 = new JLabel("*");
		label_23.setForeground(Color.RED);
		panel_2.add(label_23);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 4;
		panel_11.add(panel_3, gbc_panel_3);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel label_8 = new JLabel("\u6536\u4EF6\u4EBA");
		panel_3.add(label_8);
		
		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 5;
		panel_11.add(panel_4, gbc_panel_4);
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		JLabel label_5 = new JLabel("\u59D3\u540D");
		panel_4.add(label_5);
		
		rNameField = new MyTextField();
		rNameField.setColumns(10);
		panel_4.add(rNameField);
		
		JLabel label_26 = new JLabel("*");
		label_26.setForeground(Color.RED);
		panel_4.add(label_26);
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		panel_4.add(label_6);
		
		rMobilePhoneField = new MyTextField();
		rMobilePhoneField.setColumns(20);
		panel_4.add(rMobilePhoneField);
		
		JLabel label_27 = new JLabel("*");
		label_27.setForeground(Color.RED);
		panel_4.add(label_27);
		
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 6;
		panel_11.add(panel_8, gbc_panel_8);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		panel_8.add(label_7);
		
		rTelePhoneField = new MyTextField();
		rTelePhoneField.setColumns(20);
		panel_8.add(rTelePhoneField);
		
		JLabel label_11 = new JLabel("\u5355\u4F4D");
		panel_8.add(label_11);
		
		rUnitField = new MyTextField();
		rUnitField.setColumns(10);
		panel_8.add(rUnitField);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		panel_8.add(label_12);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 7;
		panel_11.add(panel_5, gbc_panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		panel_5.add(label_9);
		
		RcityField = new MyTextField();
		panel_5.add(RcityField);
		RcityField.setColumns(10);
		
		JLabel label_21 = new JLabel("\u5E02");
		panel_5.add(label_21);
		
		rAddressField = new MyTextField();
		rAddressField.setColumns(40);
		panel_5.add(rAddressField);
		
		JLabel label_31 = new JLabel("*");
		label_31.setForeground(Color.RED);
		panel_5.add(label_31);
		
		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 8;
		panel_11.add(panel_6, gbc_panel_6);
		
		JLabel label_10 = new JLabel("\u539F\u4EF6\u6570");
		panel_6.add(label_10);
		
		ItemNumField = new MyTextField();
		ItemNumField.setColumns(5);
		panel_6.add(ItemNumField);
		
		JLabel label_30 = new JLabel("*");
		label_30.setForeground(Color.RED);
		panel_6.add(label_30);
		
		JLabel lblkg = new JLabel("\u91CD\u91CF(kg)");
		panel_6.add(lblkg);
		
		WeightField = new MyTextField();
		WeightField.setColumns(5);
		panel_6.add(WeightField);
		
		JLabel lblcm = new JLabel("\u4F53\u79EF(cm)");
		panel_6.add(lblcm);
		
		LengthField = new MyTextField();
		LengthField.setColumns(5);
		panel_6.add(LengthField);
		
		JLabel label_13 = new JLabel("*");
		panel_6.add(label_13);
		
		WidethField = new MyTextField();
		WidethField.setColumns(5);
		panel_6.add(WidethField);
		
		JLabel label_14 = new JLabel("*");
		panel_6.add(label_14);
		
		HeighthField = new MyTextField();
		HeighthField.setColumns(5);
		panel_6.add(HeighthField);
		
		JLabel label_29 = new JLabel("*");
		label_29.setForeground(Color.RED);
		panel_6.add(label_29);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 9;
		panel_11.add(panel_9, gbc_panel_9);
		FlowLayout flowLayout_8 = (FlowLayout) panel_9.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		
		JLabel label_15 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		panel_9.add(label_15);
		
		JRadioButton woodradio = new JRadioButton("\u6728\u7BB1");
		woodradio.setOpaque(false);
		woodradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 1;
			}
		});
		panel_9.add(woodradio);
		
		JRadioButton paperradio = new JRadioButton("\u7EB8\u7BB1");
		paperradio.setOpaque(false);
		paperradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 2;
			}
		});
		panel_9.add(paperradio);
		
		JRadioButton bagradio = new JRadioButton("\u5FEB\u9012\u888B");
		bagradio.setOpaque(false);
		bagradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 3;
			}
		});
		panel_9.add(bagradio);
		
		JRadioButton otherradio = new JRadioButton("\u5176\u4ED6");
		otherradio.setOpaque(false);
		otherradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 4;
			}
		});
		panel_9.add(otherradio);
		buttonGroup.add(paperradio);
		buttonGroup.add(bagradio);
		buttonGroup.add(otherradio);
		buttonGroup.add(woodradio);
		
		JLabel label_32 = new JLabel("*");
		label_32.setForeground(Color.RED);
		panel_9.add(label_32);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 10;
		panel_11.add(panel_10, gbc_panel_10);
		FlowLayout flowLayout_9 = (FlowLayout) panel_10.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		
		JLabel label_16 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		panel_10.add(label_16);
		
		JRadioButton superradio = new JRadioButton("\u7279\u5FEB\u5FEB\u9012");
		superradio.setOpaque(false);
		superradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendType = 0;
			}
		});
		panel_10.add(superradio);
		
		JRadioButton stantardradio = new JRadioButton("\u6807\u51C6\u5FEB\u9012");
		stantardradio.setOpaque(false);
		stantardradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendType = 1;
			}
		});
		panel_10.add(stantardradio);
		
		JRadioButton cheapradio = new JRadioButton("\u7ECF\u6D4E\u5FEB\u9012");
		cheapradio.setOpaque(false);
		cheapradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendType = 2;
			}
		});
		panel_10.add(cheapradio);
		buttonGroup2.add(superradio);
		buttonGroup2.add(stantardradio);
		buttonGroup2.add(cheapradio);
		
		JLabel label_33 = new JLabel("*");
		label_33.setForeground(Color.RED);
		panel_10.add(label_33);
		
		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 11;
		panel_11.add(panel_7, gbc_panel_7);
		FlowLayout flowLayout_10 = (FlowLayout) panel_7.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		
		JLabel label_17 = new JLabel("\u79CD\u7C7B");
		panel_7.add(label_17);
		
		ItemkindField = new MyTextField();
		panel_7.add(ItemkindField);
		ItemkindField.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		panel_13.setOpaque(false);
		FlowLayout flowLayout_13 = (FlowLayout) panel_13.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 12;
		panel_11.add(panel_13, gbc_panel_13);
		
		JLabel label_18 = new JLabel("\u4EF7\u683C(\u5143)");
		panel_13.add(label_18);
		
		priceField = new MyTextField();
		priceField.setEditable(false);
		priceField.setColumns(5);
		panel_13.add(priceField);
		
		JLabel lblday = new JLabel("\u65F6\u95F4\u9884\u4F30(day)");
		panel_13.add(lblday);
		
		timeField = new MyTextField();
		timeField.setEditable(false);
		timeField.setColumns(5);
		panel_13.add(timeField);
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 13;
		panel_11.add(panel_12, gbc_panel_12);
		
		JButton createButton = new SmallButton("\u8BA2\u5355\u751F\u6210");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				create();
			}
		});
		
		JButton estimateButton = new SmallButton("\u62A5\u4EF7\u4E0E\u65F6\u95F4\u9884\u4F30");
		
		estimateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				estimate();
				
			}
		});
		panel_12.add(estimateButton);
		
		
		panel_12.add(createButton);
	}
	public void estimate() {
		intialize();
		if(estimatable()) {
			try {
				timeField.setText(String.valueOf(collection.timeEstimate(scity, rcity)));
				priceField.setText(String.valueOf(collection.priceCalc(scity, rcity, packageType, volume, weight,sendType)));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				warning("net");
			}
			
		}else {
			warning("lost");
		}
	}
	public void create() {
		intialize();
		if(creatable()) {
			SendDocVO sendDoc = null;
			try {
				sendDoc = collection.createSendDocVO(sName,scity, sAddress, sUnit, sTelePhone, sMobilePhone,
						rName,rcity, rAddress, rUnit, rTelePhone, rMobilePhone, itemNum, weight, volume, itemKind, packageType,sendType);
				CheckDialog cDialog = new CheckDialog();
				cDialog.setPreviewMode(new CheckSendDoc(sendDoc));
				cDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						saveDoc();
					}
				});
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				warning("net");
			}
			
			
		}else {
			warning("lost");
		}
	}
	public boolean estimatable() {
		if(!scity.equals("")&&!rcity.equals("")&&volume!=null&&weight!=-1.0&&packageType!=0&&sendType!=-1) {
			return true;
		}else {
			return false;
		}
	}
	public boolean creatable() {
		if(!scity.equals("")&&!sAddress.equals("")&&!sName.equals("")&&!sUnit.equals("")&&!sTelePhone.equals("")&&!sMobilePhone.equals("")&&!rName.equals("")&&
				!rUnit.equals("")&&!rAddress.equals("")&&!rTelePhone.equals("")&&!rMobilePhone.equals("")&&!rcity.equals("")&&itemNum!=0&&volume!=null&&
				weight!=-1.0&&packageType!=0&&sendType!=-1) {
			return true;
		}else {
			return false;
		}
	}
	public void intialize() {
		this.sAddress = sAddressField.getText();
		this.sName = sNameField.getText();
		this.scity = ScityField.getText();
		this.sTelePhone = sTelePhoneField.getText();
		this.sMobilePhone = sMobilePhoneField.getText();
		this.sUnit = sUnitField.getText();
		this.rAddress = rAddressField.getText();
		this.rName = rNameField.getText();
		this.rcity = RcityField.getText();
		this.rTelePhone = rTelePhoneField.getText();
		this.rMobilePhone = rMobilePhoneField.getText();
		this.rUnit = rUnitField.getText();
		this.itemKind = ItemkindField.getText();
		if(!ItemNumField.getText().equals("")&&!WeightField.getText().equals("")&&!LengthField.getText().equals("")&&!WidethField.getText().equals("")&&!HeighthField.getText().equals("")) {
			this.itemNum = Integer.parseInt(ItemNumField.getText());
			this.weight = Double.parseDouble(WeightField.getText());
			this.volume = new double[3];
			this.volume[0] = Double.parseDouble(LengthField.getText());
			this.volume[1] = Double.parseDouble(WidethField.getText());
			this.volume[2] = Double.parseDouble(HeighthField.getText());
		}
		
	}
	public void warning(String type) {
		
		switch (type) {
		case "net":
			JOptionPane.showMessageDialog(this, "网络异常，请重启客户端！");
			break;	
		case "lost":
			JOptionPane.showMessageDialog(this, "请检查信息完整性");
			break;

		default:
			break;
		}
	}
	public void  saveDoc() {
		try {
			collection.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning("net");
		}
	}
	
}
