package edu.nju.presentation.approveui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.vo.GatheringDocVO;
public class checkGatheringDoc extends JPanel{
	private MyTextField GatheringDocID;
	private MyTextField money;
	private MyTextField courier_ID;
	private JTable table;
	private MyTextField GatheringDocDate;
	private MyTextField account;
	private MyScrollPane scrollPane;
	/*
	public static void main(String args[]){
		JFrame frame=new JFrame();
		checkGatheringDoc ui=new checkGatheringDoc();
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	*/
	public checkGatheringDoc(GatheringDocVO vo) {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 69, 164, 0, 62, 0, 48, 0};
		gridBagLayout.rowHeights = new int[]{42, 0, 19, 42, 127, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_2 = new JLabel("\u6536\u6B3E\u5355");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 0;
		add(label_2, gbc_label_2);
		
		JLabel label_4 = new JLabel("\u6536\u6B3E\u5355\u7F16\u53F7");
		label_4.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 1;
		add(label_4, gbc_label_4);
		
		GatheringDocID = new MyTextField();
		GatheringDocID.setEditable(false);
		GridBagConstraints gbc_GatheringDocID = new GridBagConstraints();
		gbc_GatheringDocID.insets = new Insets(0, 0, 5, 5);
		gbc_GatheringDocID.fill = GridBagConstraints.HORIZONTAL;
		gbc_GatheringDocID.gridx = 1;
		gbc_GatheringDocID.gridy = 1;
		add(GatheringDocID, gbc_GatheringDocID);
		GatheringDocID.setColumns(10);
		
		JLabel label = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
		courier_ID = new MyTextField();
		courier_ID.setEditable(false);
		GridBagConstraints gbc_courier_ID = new GridBagConstraints();
		gbc_courier_ID.insets = new Insets(0, 0, 5, 5);
		gbc_courier_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_courier_ID.gridx = 4;
		gbc_courier_ID.gridy = 1;
		add(courier_ID, gbc_courier_ID);
		courier_ID.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6536\u6B3E\u65E5\u671F");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		add(label_1, gbc_label_1);
		
		GatheringDocDate = new MyTextField();
		GatheringDocDate.setEditable(false);
		GridBagConstraints gbc_GatheringDocDate = new GridBagConstraints();
		gbc_GatheringDocDate.insets = new Insets(0, 0, 5, 5);
		gbc_GatheringDocDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_GatheringDocDate.gridx = 1;
		gbc_GatheringDocDate.gridy = 2;
		add(GatheringDocDate, gbc_GatheringDocDate);
		GatheringDocDate.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6536\u6B3E\u91D1\u989D");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 2;
		add(label_3, gbc_label_3);
		
		money = new MyTextField();
		money.setEditable(false);
		GridBagConstraints gbc_money = new GridBagConstraints();
		gbc_money.insets = new Insets(0, 0, 5, 5);
		gbc_money.fill = GridBagConstraints.HORIZONTAL;
		gbc_money.gridx = 4;
		gbc_money.gridy = 2;
		add(money, gbc_money);
		money.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6536\u6B3E\u8D26\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		add(lblNewLabel, gbc_lblNewLabel);
		
		account = new MyTextField();
		account.setEditable(false);
		GridBagConstraints gbc_account = new GridBagConstraints();
		gbc_account.insets = new Insets(0, 0, 5, 5);
		gbc_account.fill = GridBagConstraints.HORIZONTAL;
		gbc_account.gridx = 1;
		gbc_account.gridy = 3;
		add(account, gbc_account);
		account.setColumns(10);
		
		scrollPane = new MyScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		/*
		ArrayList<String> tempList=new ArrayList<String>();
		for(int i=0;i<5;i++){
			tempList.add(null);
		}
		scrollPane.setViewportView(initializeTable(tempList));
		*/
		scrollPane.setViewportView(initializeTable(vo.getItemIDs()));
		GatheringDocID.setText(vo.getID());
		GatheringDocDate.setText(toDaysTime(vo.getDate()));
		account.setText(vo.getAccount());
		money.setText(vo.getMoney()+"");
		courier_ID.setText(vo.getCourier_ID());
	}
	public MyTable initializeTable(ArrayList<String> list){
		MyTable table=new MyTable();
		Object[][] array=new Object[list.size()][];
		for(int i=0;i<list.size();i++){
			Object[] oneLine={list.get(i)};
			array[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
				array,
				new String[] {
					"\u5BC4\u4EF6\u5355\u53F7"
				}
			));
		return table;
		
	}
	
	public static String toDaysTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");	
		String result = sdm.format(date);
		return result;
		
	}
	
	public MyTextField getTextField_2() {
		return GatheringDocID;
	}

	public void setTextField_2(MyTextField textField_2) {
		this.GatheringDocID = textField_2;
	}

	public MyTextField getTextField_3() {
		return money;
	}

	public void setTextField_3(MyTextField textField_3) {
		this.money = textField_3;
	}

	public MyTextField getTextField_4() {
		return courier_ID;
	}

	public void setTextField_4(MyTextField textField_4) {
		this.courier_ID = textField_4;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public MyTextField getTextField() {
		return GatheringDocDate;
	}

	public void setTextField(MyTextField textField) {
		this.GatheringDocDate = textField;
	}

	public MyTextField getTextField_1() {
		return account;
	}

	public void setTextField_1(MyTextField textField_1) {
		this.account = textField_1;
	}
	public MyScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(MyScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

}
