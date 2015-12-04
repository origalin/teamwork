package edu.nju.presentation.approveui;
import javax.swing.*;

import edu.nju.po.PayType;
import edu.nju.vo.PayDocVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
public class checkPayDoc extends JPanel{
	private JTextField PayDocDate;
	private JTextField Type;
	private JTextField Payer;
	private JTextField Money;
	private JTextField account;
	private JTextField PayDocID;
	private JTextField back;
	public checkPayDoc(PayDocVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 54, 70, 65, 0, 109, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("\u4ED8\u6B3E\u5355");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel label_5 = new JLabel("\u4ED8\u6B3E\u5355\u7F16\u53F7");
		label_5.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 1;
		add(label_5, gbc_label_5);
		
		PayDocID = new JTextField();
		PayDocID.setEditable(false);
		GridBagConstraints gbc_PayDocID = new GridBagConstraints();
		gbc_PayDocID.insets = new Insets(0, 0, 5, 5);
		gbc_PayDocID.fill = GridBagConstraints.HORIZONTAL;
		gbc_PayDocID.gridx = 3;
		gbc_PayDocID.gridy = 1;
		add(PayDocID, gbc_PayDocID);
		PayDocID.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6761\u76EE");
		label_1.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		Type= new JTextField();
		Type.setEditable(false);
		GridBagConstraints gbc_PayType = new GridBagConstraints();
		gbc_PayType.insets = new Insets(0, 0, 5, 0);
		gbc_PayType.fill = GridBagConstraints.HORIZONTAL;
		gbc_PayType.gridx = 6;
		gbc_PayType.gridy = 1;
		add(Type, gbc_PayType);
		Type.setColumns(10);
		
		JLabel label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 6;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		JLabel lbll = new JLabel("\u4ED8\u6B3E\u65E5\u671F");
		lbll.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_lbll = new GridBagConstraints();
		gbc_lbll.insets = new Insets(0, 0, 5, 5);
		gbc_lbll.gridx = 1;
		gbc_lbll.gridy = 4;
		add(lbll, gbc_lbll);
		
		PayDocDate = new JTextField();
		PayDocDate.setEditable(false);
		GridBagConstraints gbc_PayDocDate = new GridBagConstraints();
		gbc_PayDocDate.insets = new Insets(0, 0, 5, 5);
		gbc_PayDocDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_PayDocDate.gridx = 3;
		gbc_PayDocDate.gridy = 4;
		add(PayDocDate, gbc_PayDocDate);
		PayDocDate.setColumns(10);
		
		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u91D1\u989D");
		label_3.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 4;
		add(label_3, gbc_label_3);
		
		Money = new JTextField();
		Money.setEditable(false);
		GridBagConstraints gbc_Money = new GridBagConstraints();
		gbc_Money.insets = new Insets(0, 0, 5, 0);
		gbc_Money.fill = GridBagConstraints.HORIZONTAL;
		gbc_Money.gridx = 6;
		gbc_Money.gridy = 4;
		add(Money, gbc_Money);
		Money.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4ED8\u6B3E\u4EBA");
		label_2.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 6;
		add(label_2, gbc_label_2);
		
		Payer = new JTextField();
		Payer.setEditable(false);
		GridBagConstraints gbc_Payer = new GridBagConstraints();
		gbc_Payer.insets = new Insets(0, 0, 5, 5);
		gbc_Payer.fill = GridBagConstraints.HORIZONTAL;
		gbc_Payer.gridx = 3;
		gbc_Payer.gridy = 6;
		add(Payer, gbc_Payer);
		Payer.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4ED8\u6B3E\u8D26\u53F7");
		label_4.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 5;
		gbc_label_4.gridy = 6;
		add(label_4, gbc_label_4);
		
		account = new JTextField();
		account.setEditable(false);
		GridBagConstraints gbc_account = new GridBagConstraints();
		gbc_account.insets = new Insets(0, 0, 5, 0);
		gbc_account.fill = GridBagConstraints.HORIZONTAL;
		gbc_account.gridx = 6;
		gbc_account.gridy = 6;
		add(account, gbc_account);
		account.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5907\u6CE8");
		label_6.setFont(new Font("黑体", Font.BOLD, 12));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 0, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 8;
		add(label_6, gbc_label_6);
		
		back = new JTextField();
		back.setEditable(false);
		GridBagConstraints gbc_back = new GridBagConstraints();
		gbc_back.insets = new Insets(0, 0, 0, 5);
		gbc_back.fill = GridBagConstraints.HORIZONTAL;
		gbc_back.gridx = 3;
		gbc_back.gridy = 8;
		add(back, gbc_back);
		back.setColumns(10);
		
		PayDocID.setText(vo.getID());
		PayDocDate.setText( toDaysTime(vo.getDate()));
		Payer.setText(vo.getPayer());
		back.setText(vo.getBack());
		Type.setText(typeToString(vo.getType()));
		Money.setText(vo.getMoney()+"");
		account.setText(vo.getAccount());
	}
	
	public static String toDaysTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");	
		String result = sdm.format(date);
		return result;
		
	}
	
	public String typeToString(PayType type){
		if(type==PayType.RENT){
			return "租金";
		}else if(type==PayType.FREIGHT){
			return "运费";
		}else{
			return "工资";
		}
	}

}
