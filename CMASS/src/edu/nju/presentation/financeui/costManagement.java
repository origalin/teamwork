package edu.nju.presentation.financeui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.InstitutionPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.StaffPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.vo.AccountVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class costManagement extends JPanel{
	public static void main(String args[]){
		JFrame frame=new JFrame();
		costManagement ui=new costManagement();
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(700,400);
		frame.setVisible(true);
	}
	private ArrayList<ZLoadDocPO>ZLoadDoc;
	private ArrayList<YLoadDocPO> YLoadDoc;
	private ArrayList<TransferDocPO> transferDoc;
	private ArrayList<AccountVO>accountList;
	private ArrayList<InstitutionPO> institutionList;
	private JComboBox comboBox_1 ;
	private financebl bl=new financebl();
	private JPanel thisPanel=this;
	private JPanel panel;
	private JComboBox comboBox;
	private JTextField PayDocID;
	private JTextField back;
	public costManagement() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 13, 68, 389, 0, 0, 0, 73, 44, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_3 = new JLabel("\u6210\u672C\u7BA1\u7406");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		add(label_3, gbc_label_3);
		
		JButton button = new JButton("\u83B7\u53D6\u5217\u8868");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String payAccount=(String) comboBox_1.getSelectedItem();
				if(payAccount.equals("")){
					JOptionPane.showMessageDialog(thisPanel,"尚未输入账户","错误",JOptionPane.ERROR_MESSAGE);
				}else{
					String type=(String) comboBox.getSelectedItem();
					switch(type){
					case "租金":
						panel=new rentMoneyPanel();
						addPanel(panel);
						institutionList=bl.getUnpaidInstitutionList();
						((rentMoneyPanel) panel).initializeTable(institutionList);
						updateUI();
						break;
					case"运费":
						panel=new freightMoneyPanel();
						addPanel(panel);
						transferDoc=bl.getUnpaidCarTransferList();
						YLoadDoc=bl.getUnpaidYLoadDocList();
						ZLoadDoc=bl.getUnpaidZLoadDocList();
						((freightMoneyPanel)panel).initializeTable(transferDoc, YLoadDoc, ZLoadDoc);
						updateUI();
						break;
					case "工资":
						panel=new salaryPanel();
						addPanel(panel);
						ArrayList<StaffPO>staffList=bl.getUnpaidStaffList();
						((salaryPanel)panel).initializeTable(staffList);
						updateUI();
						break;
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		add(button, gbc_button);
		
		JButton button_1 = new JButton("\u65B0\u5EFA\u4ED8\u6B3E\u5355");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type=(String) comboBox.getSelectedItem();
				String account=(String) comboBox_1.getSelectedItem();
				switch(type){
				case "租金":
					//首先根据JTable里面哪些打了勾来确定生成付款单的内容
					JTable rentTable=((rentMoneyPanel)panel).getTable();//每列分别为bool,机构，租金
					
					Object[][]rentTableInfo=getTableArray(rentTable);
					ArrayList<InstitutionPO>usefulInstitutionList=new ArrayList<InstitutionPO>();
					for(int i=0;i<rentTableInfo.length;i++){
						Object[] oneLine=rentTableInfo[i];
					}
					break;
				case"运费":
					JTable freightTable=((freightMoneyPanel)panel).getTable();//每列分别为bool,单据类型，单据编号，运费
					Object[][]freightTableInfo=getTableArray(freightTable);
					break;
				case"工资":
					JTable salaryTable=((salaryPanel)panel).getTable();//每列分别为工号，姓名，工资
					Object[][]salaryTableInfo=getTableArray(salaryTable);
					break;
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		JLabel label = new JLabel("\u6761\u76EE");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u79DF\u91D1", "\u5DE5\u8D44", "\u8FD0\u8D39"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		
		JLabel label_2 = new JLabel("\u4ED8\u6B3E\u8D26\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 6;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		comboBox_1 = new JComboBox();
		accountList=bl.getAccountList();
		String[]accountName=new String[accountList.size()];
		for(int i=0;i<accountList.size();i++){
			accountName[i]=accountList.get(i).getName();
		}
		comboBox_1.setEditable(true);
		comboBox_1.setModel(new DefaultComboBoxModel(accountName));
		comboBox_1.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 8;
		gbc_comboBox_1.gridy = 2;
		add(comboBox_1, gbc_comboBox_1);
		
		JLabel label_1 = new JLabel("\u4ED8\u6B3E\u5355\u7F16\u53F7");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		PayDocID = new JTextField();
		GridBagConstraints gbc_PayDocID = new GridBagConstraints();
		gbc_PayDocID.insets = new Insets(0, 0, 5, 5);
		gbc_PayDocID.fill = GridBagConstraints.HORIZONTAL;
		gbc_PayDocID.gridx = 3;
		gbc_PayDocID.gridy = 3;
		add(PayDocID, gbc_PayDocID);
		PayDocID.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5907\u6CE8");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 6;
		gbc_label_4.gridy = 3;
		add(label_4, gbc_label_4);
		
		back = new JTextField();
		GridBagConstraints gbc_back = new GridBagConstraints();
		gbc_back.insets = new Insets(0, 0, 5, 5);
		gbc_back.fill = GridBagConstraints.HORIZONTAL;
		gbc_back.gridx = 8;
		gbc_back.gridy = 3;
		add(back, gbc_back);
		back.setColumns(10);
		/*
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		*/
	}
	public void addPanel(JPanel panel){
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 4;
		thisPanel.add(panel, gbc_panel);
	}
	
	public Object[][] getTableArray(JTable table){
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		Object[][] answer=new Object[model.getRowCount()][model.getColumnCount()];
		for(int row=0;row<model.getRowCount();row++){
			for(int column=0;column<model.getColumnCount();column++){
				answer[row][column]=model.getValueAt(row, column);
			}
		}
		return answer;
	}

}
