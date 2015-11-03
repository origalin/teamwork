package edu.nju.presentation.collectionui;

import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.border.BevelBorder;

public class CollertionPanel extends JPanel{
	private JTextField sNameField;
	private JTextField sMobilePhoneField;
	private JTextField sTelePhoneField;
	private JTextField sAddressField;
	private JTextField rNameField;
	private JTextField rMobilePhoneField;
	private JTextField rTelePhoneField;
	private JTextField rAddressField;
	private JTextField numField;
	private JTextField weightField;
	private JTextField lengthField;
	private JTextField widethField;
	private JTextField heightField;
	private JTextField kindField;
	private JTextField priceField;
	private JTextField timeField;
	public CollertionPanel() {
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		ButtonGroup buttonGroup2 = new ButtonGroup();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(null);
		add(panel_11, BorderLayout.NORTH);
		panel_11.setLayout(new GridLayout(13, 0, 0, 0));
		
		JPanel panel = new JPanel();
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
		
		JLabel label_3 = new JLabel("\u624B\u673A");
		panel_1.add(label_3);
		
		sMobilePhoneField = new JTextField();
		panel_1.add(sMobilePhoneField);
		sMobilePhoneField.setColumns(20);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		panel_1.add(label_2);
		
		sTelePhoneField = new JTextField();
		panel_1.add(sTelePhoneField);
		sTelePhoneField.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		panel_11.add(panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		panel_2.add(label_4);
		
		sAddressField = new JTextField();
		panel_2.add(sAddressField);
		sAddressField.setColumns(40);
		
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
		
		JLabel label_6 = new JLabel("\u624B\u673A");
		panel_4.add(label_6);
		
		rMobilePhoneField = new JTextField();
		rMobilePhoneField.setColumns(20);
		panel_4.add(rMobilePhoneField);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		panel_4.add(label_7);
		
		rTelePhoneField = new JTextField();
		rTelePhoneField.setColumns(20);
		panel_4.add(rTelePhoneField);
		
		JPanel panel_5 = new JPanel();
		panel_11.add(panel_5);
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		panel_5.add(label_9);
		
		rAddressField = new JTextField();
		rAddressField.setColumns(40);
		panel_5.add(rAddressField);
		
		JPanel panel_6 = new JPanel();
		panel_11.add(panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		JLabel label_10 = new JLabel("\u6258\u8FD0\u8D27\u7269\u4FE1\u606F");
		panel_6.add(label_10);
		
		JPanel panel_8 = new JPanel();
		panel_11.add(panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		JLabel label_11 = new JLabel("\u539F\u4EF6\u6570");
		panel_8.add(label_11);
		
		numField = new JTextField();
		panel_8.add(numField);
		numField.setColumns(5);
		
		JLabel lblNewLabel = new JLabel("\u91CD\u91CF");
		panel_8.add(lblNewLabel);
		
		weightField = new JTextField();
		panel_8.add(weightField);
		weightField.setColumns(5);
		
		JLabel label_12 = new JLabel("\u4F53\u79EF");
		panel_8.add(label_12);
		
		lengthField = new JTextField();
		panel_8.add(lengthField);
		lengthField.setColumns(5);
		
		JLabel label_13 = new JLabel("*");
		panel_8.add(label_13);
		
		widethField = new JTextField();
		panel_8.add(widethField);
		widethField.setColumns(5);
		
		JLabel label_14 = new JLabel("*");
		panel_8.add(label_14);
		
		heightField = new JTextField();
		panel_8.add(heightField);
		heightField.setColumns(5);
		
		JPanel panel_9 = new JPanel();
		panel_11.add(panel_9);
		FlowLayout flowLayout_8 = (FlowLayout) panel_9.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		
		JLabel label_15 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		panel_9.add(label_15);
		
		JRadioButton woodradio = new JRadioButton("\u6728\u7BB1");
		panel_9.add(woodradio);
		
		JRadioButton paperradio = new JRadioButton("\u7EB8\u7BB1");
		panel_9.add(paperradio);
		
		JRadioButton bagradio = new JRadioButton("\u5FEB\u9012\u888B");
		panel_9.add(bagradio);
		
		JRadioButton otherradio = new JRadioButton("\u5176\u4ED6");
		panel_9.add(otherradio);
		buttonGroup.add(paperradio);
		buttonGroup.add(bagradio);
		buttonGroup.add(otherradio);
		buttonGroup.add(woodradio);
		
		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		FlowLayout flowLayout_9 = (FlowLayout) panel_10.getLayout();
		flowLayout_9.setAlignment(FlowLayout.LEFT);
		
		JLabel label_16 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		panel_10.add(label_16);
		
		JRadioButton superradio = new JRadioButton("\u7279\u5FEB\u5FEB\u9012");
		panel_10.add(superradio);
		
		JRadioButton stantardradio = new JRadioButton("\u6807\u51C6\u5FEB\u9012");
		panel_10.add(stantardradio);
		
		JRadioButton cheapradio = new JRadioButton("\u7ECF\u6D4E\u5FEB\u9012");
		panel_10.add(cheapradio);
		buttonGroup2.add(superradio);
		buttonGroup2.add(stantardradio);
		buttonGroup2.add(cheapradio);
		
		JPanel panel_7 = new JPanel();
		panel_11.add(panel_7);
		FlowLayout flowLayout_10 = (FlowLayout) panel_7.getLayout();
		flowLayout_10.setAlignment(FlowLayout.LEFT);
		
		JLabel label_17 = new JLabel("\u79CD\u7C7B");
		panel_7.add(label_17);
		
		kindField = new JTextField();
		panel_7.add(kindField);
		kindField.setColumns(10);
		
		JPanel panel_13 = new JPanel();
		FlowLayout flowLayout_13 = (FlowLayout) panel_13.getLayout();
		flowLayout_13.setAlignment(FlowLayout.LEFT);
		panel_11.add(panel_13);
		
		JLabel label_18 = new JLabel("\u4EF7\u683C");
		panel_13.add(label_18);
		
		priceField = new JTextField();
		priceField.setColumns(5);
		panel_13.add(priceField);
		
		JLabel label_19 = new JLabel("\u65F6\u95F4\u9884\u4F30");
		panel_13.add(label_19);
		
		timeField = new JTextField();
		timeField.setColumns(5);
		panel_13.add(timeField);
		
		JPanel panel_12 = new JPanel();
		FlowLayout flowLayout_12 = (FlowLayout) panel_12.getLayout();
		flowLayout_12.setAlignment(FlowLayout.RIGHT);
		panel_11.add(panel_12);
		
		JButton estimateButton = new JButton("\u62A5\u4EF7\u4E0E\u65F6\u95F4\u9884\u4F30");
		panel_12.add(estimateButton);
		
		JButton createButton = new JButton("\u8BA2\u5355\u751F\u6210");
		panel_12.add(createButton);
	}
	
}
