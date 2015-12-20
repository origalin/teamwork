package edu.nju.presentation.collectionui;

import javax.swing.*;

import java.awt.GridLayout;

import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.border.BevelBorder;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogicservice.collectionlogicservice.CollectionLogicService;
import edu.nju.presentation.approveui.CheckSendDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.SendDocVO;

import java.awt.Color;

public class CollertionPanel extends JPanel{
	String sName,rName,scity,rcity,sAddress,rAddress,sTelePhone,rTelePhone,sMobilePhone,rMobilePhone,itemKind,sUnit,rUnit;
	double weight;
	double[] volume;
	int itemNum,packageType,sendType;
	String institutionID;
	String staffID;
	CollectionLogicService collection;
	private JTextField sNameField;
	private JTextField sMobilePhoneField;
	private JTextField sAddressField;
	private JTextField rNameField;
	private JTextField rMobilePhoneField;
	private JTextField rAddressField;
	private JTextField ItemkindField;
	private JTextField priceField;
	private JTextField timeField;
	private JTextField ScityField;
	private JTextField RcityField;
	private JTextField ItemNumField;
	private JTextField WeightField;
	private JTextField LengthField;
	private JTextField WidethField;
	private JTextField HeighthField;
	private JTextField rTelePhoneField;
	private JTextField rUnitField;
	private JTextField sTelePhoneField;
	private JTextField sUnitField;
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
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBorder(null);
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(14, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel_11.add(panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_11.add(panel_1);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		panel_1.add(label_1);
		
		sNameField = new JTextField();
		panel_1.add(sNameField);
		sNameField.setColumns(10);
		
		JLabel label_22 = new JLabel("*");
		label_22.setForeground(Color.RED);
		panel_1.add(label_22);
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		panel_1.add(label_3);
		
		sMobilePhoneField = new JTextField();
		panel_1.add(sMobilePhoneField);
		sMobilePhoneField.setColumns(20);
		
		JLabel label_25 = new JLabel("*");
		label_25.setForeground(Color.RED);
		panel_1.add(label_25);
		
		JPanel panel_14 = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) panel_14.getLayout();
		flowLayout_11.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_14);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		panel_14.add(label_2);
		
		sTelePhoneField = new JTextField();
		sTelePhoneField.setColumns(20);
		panel_14.add(sTelePhoneField);
		
		JLabel label_19 = new JLabel("\u5355\u4F4D");
		panel_14.add(label_19);
		
		sUnitField = new JTextField();
		sUnitField.setColumns(10);
		panel_14.add(sUnitField);
		
		JLabel label_24 = new JLabel("*");
		label_24.setForeground(Color.RED);
		panel_14.add(label_24);
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		panel_2.add(label_4);
		
		ScityField = new JTextField();
		panel_2.add(ScityField);
		ScityField.setColumns(10);
		
		JLabel label_20 = new JLabel("\u5E02");
		panel_2.add(label_20);
		
		sAddressField = new JTextField();
		panel_2.add(sAddressField);
		sAddressField.setColumns(40);
		
		JLabel label_23 = new JLabel("*");
		label_23.setForeground(Color.RED);
		panel_2.add(label_23);
		
		JPanel panel_3 = new JPanel();
		panel_11.add(panel_3);
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		
		JLabel label_8 = new JLabel("\u6536\u4EF6\u4EBA");
		panel_3.add(label_8);
		
		JPanel panel_4 = new JPanel();
		panel_11.add(panel_4);
		FlowLayout flowLayout_4 = (FlowLayout) panel_4.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		
		JLabel label_5 = new JLabel("\u59D3\u540D");
		panel_4.add(label_5);
		
		rNameField = new JTextField();
		rNameField.setColumns(10);
		panel_4.add(rNameField);
		
		JLabel label_26 = new JLabel("*");
		label_26.setForeground(Color.RED);
		panel_4.add(label_26);
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		panel_4.add(label_6);
		
		rMobilePhoneField = new JTextField();
		rMobilePhoneField.setColumns(20);
		panel_4.add(rMobilePhoneField);
		
		JLabel label_27 = new JLabel("*");
		label_27.setForeground(Color.RED);
		panel_4.add(label_27);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_8);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		panel_8.add(label_7);
		
		rTelePhoneField = new JTextField();
		rTelePhoneField.setColumns(20);
		panel_8.add(rTelePhoneField);
		
		JLabel label_11 = new JLabel("\u5355\u4F4D");
		panel_8.add(label_11);
		
		rUnitField = new JTextField();
		rUnitField.setColumns(10);
		panel_8.add(rUnitField);
		
		JLabel label_12 = new JLabel("*");
		label_12.setForeground(Color.RED);
		panel_8.add(label_12);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		panel_5.add(label_9);
		
		RcityField = new JTextField();
		panel_5.add(RcityField);
		RcityField.setColumns(10);
		
		JLabel label_21 = new JLabel("\u5E02");
		panel_5.add(label_21);
		
		rAddressField = new JTextField();
		rAddressField.setColumns(40);
		panel_5.add(rAddressField);
		
		JLabel label_31 = new JLabel("*");
		label_31.setForeground(Color.RED);
		panel_5.add(label_31);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_6);
		
		JLabel label_10 = new JLabel("\u539F\u4EF6\u6570");
		panel_6.add(label_10);
		
		ItemNumField = new JTextField();
		ItemNumField.setColumns(5);
		panel_6.add(ItemNumField);
		
		JLabel label_30 = new JLabel("*");
		label_30.setForeground(Color.RED);
		panel_6.add(label_30);
		
		JLabel lblkg = new JLabel("\u91CD\u91CF(kg)");
		panel_6.add(lblkg);
		
		WeightField = new JTextField();
		WeightField.setColumns(5);
		panel_6.add(WeightField);
		
		JLabel lblcm = new JLabel("\u4F53\u79EF(cm)");
		panel_6.add(lblcm);
		
		LengthField = new JTextField();
		LengthField.setColumns(5);
		panel_6.add(LengthField);
		
		JLabel label_13 = new JLabel("*");
		panel_6.add(label_13);
		
		WidethField = new JTextField();
		WidethField.setColumns(5);
		panel_6.add(WidethField);
		
		JLabel label_14 = new JLabel("*");
		panel_6.add(label_14);
		
		HeighthField = new JTextField();
		HeighthField.setColumns(5);
		panel_6.add(HeighthField);
		
		JLabel label_29 = new JLabel("*");
		label_29.setForeground(Color.RED);
		panel_6.add(label_29);
		
		JPanel panel_9 = new JPanel();
		panel_11.add(panel_9);
		FlowLayout flowLayout_8 = (FlowLayout) panel_9.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		
		JLabel label_15 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		panel_9.add(label_15);
		
		JRadioButton woodradio = new JRadioButton("\u6728\u7BB1");
		woodradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 1;
			}
		});
		panel_9.add(woodradio);
		
		JRadioButton paperradio = new JRadioButton("\u7EB8\u7BB1");
		paperradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 2;
			}
		});
		panel_9.add(paperradio);
		
		JRadioButton bagradio = new JRadioButton("\u5FEB\u9012\u888B");
		bagradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				packageType = 3;
			}
		});
		panel_9.add(bagradio);
		
		JRadioButton otherradio = new JRadioButton("\u5176\u4ED6");
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
		panel_11.add(panel_10);
		FlowLayout flowLayout_9 = (FlowLayout) panel_10.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		
		JLabel label_16 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		panel_10.add(label_16);
		
		JRadioButton superradio = new JRadioButton("\u7279\u5FEB\u5FEB\u9012");
		superradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendType = 0;
			}
		});
		panel_10.add(superradio);
		
		JRadioButton stantardradio = new JRadioButton("\u6807\u51C6\u5FEB\u9012");
		stantardradio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				sendType = 1;
			}
		});
		panel_10.add(stantardradio);
		
		JRadioButton cheapradio = new JRadioButton("\u7ECF\u6D4E\u5FEB\u9012");
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
		panel_11.add(panel_7);
		FlowLayout flowLayout_10 = (FlowLayout) panel_7.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		
		JLabel label_17 = new JLabel("\u79CD\u7C7B");
		panel_7.add(label_17);
		
		ItemkindField = new JTextField();
		panel_7.add(ItemkindField);
		ItemkindField.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_13.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_13);
		
		JLabel label_18 = new JLabel("\u4EF7\u683C(\u5143)");
		panel_13.add(label_18);
		
		priceField = new JTextField();
		priceField.setColumns(5);
		panel_13.add(priceField);
		
		JLabel lblday = new JLabel("\u65F6\u95F4\u9884\u4F30(day)");
		panel_13.add(lblday);
		
		timeField = new JTextField();
		timeField.setColumns(5);
		panel_13.add(timeField);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JButton estimateButton = new JButton("\u62A5\u4EF7\u4E0E\u65F6\u95F4\u9884\u4F30");
		estimateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				estimate();
			}
		});
		panel_12.add(estimateButton);
		
		JButton createButton = new JButton("\u8BA2\u5355\u751F\u6210");
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				create();
			}
		});
		panel_12.add(createButton);
		
		
		setOpaque(false);
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
