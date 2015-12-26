package edu.nju.presentation.approveui;

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import edu.nju.presentation.widget.MyTextField;
import edu.nju.vo.SendDocVO;

import java.awt.Font;

@SuppressWarnings("serial")
public class CheckSendDoc extends JPanel{
	private MyTextField sNameField;
	private MyTextField sTelePhoneField;
	private MyTextField rNameField;
	private MyTextField rTelephoneField;
	private MyTextField rAddressField;
	private MyTextField itemNumField;
	private MyTextField weightField;
	private MyTextField sMobilePhoneField;
	private MyTextField sAddressField;
	private MyTextField rMobilePhoneField;
	private MyTextField lengthField;
	private MyTextField widethField;
	private MyTextField heightField;
	private MyTextField packField;
	private MyTextField sendTypeField;
	private MyTextField IDField;
	private MyTextField dateField;
	private MyTextField kindField;
	private MyTextField timeField;
	private MyTextField priceField;
	private MyTextField sUnitField;
	private MyTextField rUnitField;
	private MyTextField scityField;
	private MyTextField rcityField;
	public CheckSendDoc(SendDocVO vo) {
		setBorder(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {281, 224, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.gridwidth = 2;
		gbc_panel_16.insets = new Insets(0, 0, 5, 0);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 0;
		add(panel_16, gbc_panel_16);
		
		JLabel label_22 = new JLabel("\u5BC4\u4EF6\u5355");
		label_22.setFont(new Font("黑体", Font.BOLD, 16));
		panel_16.add(label_22);
		
		JPanel panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.anchor = GridBagConstraints.WEST;
		gbc_panel_14.insets = new Insets(0, 0, 5, 5);
		gbc_panel_14.fill = GridBagConstraints.VERTICAL;
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 1;
		add(panel_14, gbc_panel_14);
		
		JLabel label_19 = new JLabel("\u7F16\u53F7");
		label_19.setFont(new Font("黑体", Font.BOLD, 15));
		panel_14.add(label_19);
		
		IDField = new MyTextField();
		IDField.setEnabled(false);
		IDField.setEditable(false);
		panel_14.add(IDField);
		IDField.setColumns(20);
		
		JPanel panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.anchor = GridBagConstraints.WEST;
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.fill = GridBagConstraints.VERTICAL;
		gbc_panel_15.gridx = 1;
		gbc_panel_15.gridy = 1;
		add(panel_15, gbc_panel_15);
		
		JLabel label_20 = new JLabel("\u65E5\u671F");
		label_20.setFont(new Font("黑体", Font.BOLD, 15));
		panel_15.add(label_20);
		
		dateField = new MyTextField();
		dateField.setEnabled(false);
		panel_15.add(dateField);
		dateField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u5BC4\u4EF6\u4EBA");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		add(panel_1, gbc_panel_1);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		panel_1.add(label_1);
		
		sNameField = new MyTextField();
		sNameField.setEnabled(false);
		sNameField.setColumns(10);
		panel_1.add(sNameField);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		panel_1.add(label_3);
		
		sTelePhoneField = new MyTextField();
		sTelePhoneField.setEnabled(false);
		sTelePhoneField.setColumns(20);
		panel_1.add(sTelePhoneField);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.anchor = GridBagConstraints.WEST;
		gbc_panel_11.insets = new Insets(0, 0, 5, 0);
		gbc_panel_11.fill = GridBagConstraints.VERTICAL;
		gbc_panel_11.gridx = 1;
		gbc_panel_11.gridy = 3;
		add(panel_11, gbc_panel_11);
		
		JLabel label_2 = new JLabel("\u624B\u673A");
		label_2.setFont(new Font("黑体", Font.BOLD, 15));
		panel_11.add(label_2);
		
		sMobilePhoneField = new MyTextField();
		sMobilePhoneField.setEnabled(false);
		sMobilePhoneField.setColumns(20);
		panel_11.add(sMobilePhoneField);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.WEST;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		add(panel_2, gbc_panel_2);
		
		JLabel label_25 = new JLabel("\u57CE\u5E02");
		label_25.setFont(new Font("黑体", Font.BOLD, 15));
		panel_2.add(label_25);
		
		scityField = new MyTextField();
		scityField.setEditable(false);
		panel_2.add(scityField);
		scityField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		panel_2.add(label_4);
		
		sAddressField = new MyTextField();
		sAddressField.setEnabled(false);
		panel_2.add(sAddressField);
		sAddressField.setColumns(30);
		
		JPanel panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.anchor = GridBagConstraints.WEST;
		gbc_panel_17.insets = new Insets(0, 0, 5, 0);
		gbc_panel_17.fill = GridBagConstraints.VERTICAL;
		gbc_panel_17.gridx = 1;
		gbc_panel_17.gridy = 4;
		add(panel_17, gbc_panel_17);
		
		JLabel label_23 = new JLabel("\u5355\u4F4D");
		label_23.setFont(new Font("黑体", Font.BOLD, 15));
		panel_17.add(label_23);
		
		sUnitField = new MyTextField();
		sUnitField.setEditable(false);
		sUnitField.setColumns(20);
		panel_17.add(sUnitField);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.WEST;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 5;
		add(panel_3, gbc_panel_3);
		
		JLabel label_5 = new JLabel("\u6536\u4EF6\u4EBA");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		panel_3.add(label_5);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 6;
		add(panel_4, gbc_panel_4);
		
		JLabel label_6 = new JLabel("\u59D3\u540D");
		label_6.setFont(new Font("黑体", Font.BOLD, 15));
		panel_4.add(label_6);
		
		rNameField = new MyTextField();
		rNameField.setEnabled(false);
		rNameField.setColumns(10);
		panel_4.add(rNameField);
		
		JLabel label_8 = new JLabel("\u7535\u8BDD");
		label_8.setFont(new Font("黑体", Font.BOLD, 15));
		panel_4.add(label_8);
		
		rTelephoneField = new MyTextField();
		rTelephoneField.setEnabled(false);
		rTelephoneField.setColumns(20);
		panel_4.add(rTelephoneField);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.anchor = GridBagConstraints.WEST;
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.VERTICAL;
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 6;
		add(panel_12, gbc_panel_12);
		
		JLabel label_7 = new JLabel("\u624B\u673A");
		label_7.setFont(new Font("黑体", Font.BOLD, 15));
		panel_12.add(label_7);
		
		rMobilePhoneField = new MyTextField();
		rMobilePhoneField.setEnabled(false);
		rMobilePhoneField.setColumns(20);
		panel_12.add(rMobilePhoneField);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.anchor = GridBagConstraints.WEST;
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.VERTICAL;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 7;
		add(panel_5, gbc_panel_5);
		
		JLabel label_26 = new JLabel("\u57CE\u5E02");
		label_26.setFont(new Font("黑体", Font.BOLD, 15));
		panel_5.add(label_26);
		
		rcityField = new MyTextField();
		rcityField.setEditable(false);
		panel_5.add(rcityField);
		rcityField.setColumns(10);
		
		JLabel label_9 = new JLabel("\u5730\u5740");
		label_9.setFont(new Font("黑体", Font.BOLD, 15));
		panel_5.add(label_9);
		
		rAddressField = new MyTextField();
		rAddressField.setEnabled(false);
		rAddressField.setColumns(30);
		panel_5.add(rAddressField);
		
		JPanel panel_18 = new JPanel();
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.anchor = GridBagConstraints.WEST;
		gbc_panel_18.insets = new Insets(0, 0, 5, 0);
		gbc_panel_18.fill = GridBagConstraints.VERTICAL;
		gbc_panel_18.gridx = 1;
		gbc_panel_18.gridy = 7;
		add(panel_18, gbc_panel_18);
		
		JLabel label_24 = new JLabel("\u5355\u4F4D");
		label_24.setFont(new Font("黑体", Font.BOLD, 15));
		panel_18.add(label_24);
		
		rUnitField = new MyTextField();
		rUnitField.setEditable(false);
		rUnitField.setColumns(20);
		panel_18.add(rUnitField);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.anchor = GridBagConstraints.WEST;
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.VERTICAL;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 8;
		add(panel_7, gbc_panel_7);
		
		JLabel label_11 = new JLabel("\u539F\u4EF6\u6570  ");
		label_11.setFont(new Font("黑体", Font.BOLD, 15));
		panel_7.add(label_11);
		
		itemNumField = new MyTextField();
		itemNumField.setEnabled(false);
		itemNumField.setColumns(5);
		panel_7.add(itemNumField);
		
		JLabel label_12 = new JLabel("\u91CD\u91CF");
		label_12.setFont(new Font("黑体", Font.BOLD, 15));
		panel_7.add(label_12);
		
		weightField = new MyTextField();
		weightField.setEnabled(false);
		weightField.setColumns(5);
		panel_7.add(weightField);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.anchor = GridBagConstraints.WEST;
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.fill = GridBagConstraints.VERTICAL;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 8;
		add(panel_13, gbc_panel_13);
		
		JLabel label_13 = new JLabel("\u4F53\u79EF");
		label_13.setFont(new Font("黑体", Font.BOLD, 15));
		panel_13.add(label_13);
		
		lengthField = new MyTextField();
		lengthField.setEnabled(false);
		lengthField.setColumns(5);
		panel_13.add(lengthField);
		
		JLabel label_14 = new JLabel("*");
		panel_13.add(label_14);
		
		widethField = new MyTextField();
		widethField.setEnabled(false);
		widethField.setColumns(5);
		panel_13.add(widethField);
		
		JLabel label_15 = new JLabel("*");
		panel_13.add(label_15);
		
		heightField = new MyTextField();
		heightField.setEnabled(false);
		heightField.setColumns(5);
		panel_13.add(heightField);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.anchor = GridBagConstraints.WEST;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.VERTICAL;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 9;
		add(panel_8, gbc_panel_8);
		
		JLabel label_16 = new JLabel("\u5305\u88C5\u7C7B\u578B");
		label_16.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(label_16);
		
		packField = new MyTextField();
		packField.setEnabled(false);
		panel_8.add(packField);
		packField.setColumns(10);
		
		JLabel label_10 = new JLabel("\u79CD\u7C7B");
		label_10.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(label_10);
		
		kindField = new MyTextField();
		kindField.setEnabled(false);
		kindField.setColumns(10);
		panel_8.add(kindField);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.anchor = GridBagConstraints.WEST;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.VERTICAL;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 9;
		add(panel_6, gbc_panel_6);
		
		JLabel label_18 = new JLabel("\u65F6\u95F4\u9884\u4F30");
		label_18.setFont(new Font("黑体", Font.BOLD, 15));
		panel_6.add(label_18);
		
		timeField = new MyTextField();
		timeField.setEnabled(false);
		panel_6.add(timeField);
		timeField.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.anchor = GridBagConstraints.WEST;
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.VERTICAL;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 10;
		add(panel_9, gbc_panel_9);
		
		JLabel label_17 = new JLabel("\u5FEB\u9012\u7C7B\u578B");
		label_17.setFont(new Font("黑体", Font.BOLD, 15));
		panel_9.add(label_17);
		
		sendTypeField = new MyTextField();
		sendTypeField.setEnabled(false);
		panel_9.add(sendTypeField);
		sendTypeField.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 0);
		gbc_panel_10.anchor = GridBagConstraints.WEST;
		gbc_panel_10.fill = GridBagConstraints.VERTICAL;
		gbc_panel_10.gridx = 1;
		gbc_panel_10.gridy = 10;
		add(panel_10, gbc_panel_10);
		
		JLabel label_21 = new JLabel("\u4EF7\u683C");
		label_21.setFont(new Font("黑体", Font.BOLD, 15));
		panel_10.add(label_21);
		
		priceField = new MyTextField();
		priceField.setEnabled(false);
		panel_10.add(priceField);
		priceField.setColumns(10);
		
		dateField.setText(vo.getDate());
		IDField.setText(vo.getID());
		sNameField.setText(vo.getsName());
		scityField.setText(vo.getsCity());
		sAddressField.setText(vo.getsAddress());
		sTelePhoneField.setText(vo.getsTelePhone());
		sMobilePhoneField.setText(vo.getsMobilePhone());
		sUnitField.setText(vo.getsUnit());
		rNameField.setText(vo.getrName());
		rcityField.setText(vo.getrCity());
		rAddressField.setText(vo.getrAddress());
		rTelephoneField.setText(vo.getrTelePhone());
		rMobilePhoneField.setText(vo.getrMobilePhone());
		rUnitField.setText(vo.getrUnit());
		itemNumField.setText(vo.getItemNum());
		weightField.setText(vo.getWeight());
		kindField.setText(vo.getItem_type());
		lengthField.setText(vo.getVolume()[0]);
		widethField.setText(vo.getVolume()[1]);
		heightField.setText(vo.getVolume()[2]);
		packField.setText(vo.getPackageType());
		timeField.setText(vo.getTime());
		priceField.setText(vo.getSumPrice());
		sendTypeField.setText(vo.getCourier_Type());
	}
	
}
