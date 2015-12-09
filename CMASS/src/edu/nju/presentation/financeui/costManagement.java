package edu.nju.presentation.financeui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.InstitutionPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.StaffPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.presentation.approveui.checkPayDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.AccountVO;
import edu.nju.vo.PayDocVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
public class costManagement extends JPanel{
	public static void main(String args[]){
		JFrame frame=new JFrame();
		costManagement ui=new costManagement("12000003");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(700,400);
		frame.setVisible(true);
	}
	private ArrayList<StaffPO>staffList;
	private String staffID;
	private ArrayList<ZLoadDocPO>ZLoadDoc;
	private ArrayList<YLoadDocPO> YLoadDoc;
	private ArrayList<TransferDocPO> transferDoc;
	private ArrayList<AccountVO>accountList;
	private ArrayList<InstitutionPO> institutionList;
	private JComboBox accountComboBox ;
	private financebl bl;
	private JPanel thisPanel=this;
	private JPanel panel;
	private JComboBox comboBox;
	private JTextField PayDocID;
	private JTextField back;
	private JTextField currentWorker;
	public costManagement(String staffID) {
		this.staffID=staffID;
		try {
			bl=new financebl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 13, 68, 389, 0, 0, 0, 73, 44, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
				String payAccount=(String) accountComboBox.getSelectedItem();
				if(payAccount.equals("")){
					JOptionPane.showMessageDialog(thisPanel,"尚未输入账户","错误",JOptionPane.ERROR_MESSAGE);
				}else{
					String type=(String) comboBox.getSelectedItem();
					switch(type){
					case "租金":
						panel=new rentMoneyPanel();
						addPanel(panel);
						institutionList=bl.getUnpaidInstitutionList();
						if(institutionList==null){
							System.out.println("error");
						}
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
						staffList=bl.getUnpaidStaffList();
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
				String account=(String) accountComboBox.getSelectedItem();
				switch(type){
				case "租金":
					//首先根据JTable里面哪些打了勾来确定生成付款单的内容
					JTable rentTable=((rentMoneyPanel)panel).getTable();//每列分别为bool,机构，租金
					Object[][]rentTableInfo=getTableArray(rentTable);
					double rentPayMent=0;
					for(int i=0;i<rentTableInfo.length;i++){
						Object[] oneLine=rentTableInfo[i];
						if((boolean)oneLine[0]==true){
							rentPayMent+=(double)oneLine[2];
						}
					}
					PayDocVO vo=bl.reviewPayDoc(PayDocID.getText(), rentPayMent,currentWorker.getText(), (String) account, stringToType(type), back.getText());
					CheckDialog dialog=new CheckDialog();
					checkPayDoc ui=new checkPayDoc(vo);
					dialog.setPreviewMode(ui);
			        dialog.getConfirmButton().addActionListener(new ActionListener(){
			            	@Override
			            	public void actionPerformed(ActionEvent e){
			            		bl.createPayDoc(vo);
			            		bl.minusMoney(vo.getAccount(), vo.getMoney());
			            		for(int i=0;i<rentTableInfo.length;i++){
									Object[] oneLine=rentTableInfo[i];
									if((boolean)oneLine[0]==true){
										institutionList.get(i).setPaid(true);
									}
								}
			            		bl.setInstitutionList(institutionList);
			            		//已经生成付款单后我们要把添加的面板清空并且让institutionList重新变为null,方便进行下一次成本管理
			            		panel=null;
			            		updateUI();
			            		institutionList=null;
			            	}
			            });
					break;
				case"运费":
					JTable freightTable=((freightMoneyPanel)panel).getTable();//每列分别为bool,单据类型，单据编号，运费
					Object[][]freightTableInfo=getTableArray(freightTable);
					double freightPayMent=0;
					for(int i=0;i<freightTableInfo.length;i++){
						Object[]oneLine=freightTableInfo[i];
						if((boolean)oneLine[0]==true){
							freightPayMent+=(double)oneLine[3];
						}
					}
					PayDocVO freightVo=bl.reviewPayDoc(PayDocID.getText(), freightPayMent,currentWorker.getText(), (String) account, stringToType(type), back.getText());
					CheckDialog freightDialog=new CheckDialog();
					checkPayDoc freightUi=new checkPayDoc(freightVo);
					freightDialog.setPreviewMode(freightUi);
					freightDialog.getConfirmButton().addActionListener(new ActionListener(){
		            	@Override
		            	public void actionPerformed(ActionEvent e){
		            		bl.createPayDoc(freightVo);
		            		bl.minusMoney(freightVo.getAccount(), freightVo.getMoney());
		            		for(int i=0;i<freightTableInfo.length;i++){
								Object[] oneLine=freightTableInfo[i];
								if((boolean)oneLine[0]==true){
									if(i<transferDoc.size()){
										transferDoc.get(i).setPaid(true);
									}else if(i<transferDoc.size()+YLoadDoc.size()){
										YLoadDoc.get(i-transferDoc.size()).setPaid(true);
									}else{
										ZLoadDoc.get(i-transferDoc.size()-YLoadDoc.size()).setPaid(true);
									}
								}
							}
		            		bl.setTransferDocList(transferDoc);
		            		bl.setYLoadDocList(YLoadDoc);
		            		bl.setZLoadDocList(ZLoadDoc);
		            		//已经生成付款单后我们要把添加的面板清空并且让institutionList重新变为null,方便进行下一次成本管理
		            		panel=null;
		            		updateUI();
		            		ZLoadDoc=null;
		            		YLoadDoc=null;
		            		transferDoc=null;
		            	}
		            });
					break;
				case"工资":
					JTable salaryTable=((salaryPanel)panel).getTable();//每列分别为工号，姓名，工资
					Object[][]salaryTableInfo=getTableArray(salaryTable);
					double salaryPayMent=0;
					for(int i=0;i<salaryTableInfo.length;i++){
						Object[] oneLine=salaryTableInfo[i];
						if((boolean)oneLine[0]==true){
							salaryPayMent+=(double)oneLine[2];
						}
					}
					PayDocVO salaryVo=bl.reviewPayDoc(PayDocID.getText(), salaryPayMent,currentWorker.getText(), (String) account, stringToType(type), back.getText());
					CheckDialog salaryDialog=new CheckDialog();
					checkPayDoc salaryUi=new checkPayDoc(salaryVo);
					salaryDialog.setPreviewMode(salaryUi);
					salaryDialog.getConfirmButton().addActionListener(new ActionListener(){
		            	@Override
		            	public void actionPerformed(ActionEvent e){
		            		bl.createPayDoc(salaryVo);
		            		bl.minusMoney(salaryVo.getAccount(), salaryVo.getMoney());
		            		
		            		for(int i=0;i<salaryTableInfo.length;i++){
								Object[] oneLine=salaryTableInfo[i];
								if((boolean)oneLine[0]==true){
									staffList.get(i).isPaid(true);
								}
							}
							
		            		bl.setStaffList(staffList);
		            		//已经生成付款单后我们要把添加的面板清空并且让institutionList重新变为null,方便进行下一次成本管理
		            		panel=null;
		            		updateUI();
		            		staffList=null;
		            	}
		            });
					break;
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 1;
		add(button_1, gbc_button_1);
		
		currentWorker = new JTextField();
		GridBagConstraints gbc_currentWorker = new GridBagConstraints();
		gbc_currentWorker.insets = new Insets(0, 0, 5, 5);
		gbc_currentWorker.fill = GridBagConstraints.HORIZONTAL;
		gbc_currentWorker.gridx = 8;
		gbc_currentWorker.gridy = 1;
		add(currentWorker, gbc_currentWorker);
		currentWorker.setColumns(10);
		
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
		
		accountComboBox = new JComboBox();
		accountList=bl.getAccountList();
		String[]accountName=new String[accountList.size()];
		for(int i=0;i<accountList.size();i++){
			accountName[i]=accountList.get(i).getName();
		}
		accountComboBox.setEditable(true);
		accountComboBox.setModel(new DefaultComboBoxModel(accountName));
		accountComboBox.setSelectedIndex(0);
		GridBagConstraints gbc_accountComboBox = new GridBagConstraints();
		gbc_accountComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_accountComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_accountComboBox.gridx = 8;
		gbc_accountComboBox.gridy = 2;
		add(accountComboBox, gbc_accountComboBox);
		
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
		
		JButton button_2 = new JButton("\u91CD\u7F6E\u5DE5\u8D44");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bl.resetSalary();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 6;
		gbc_button_2.gridy = 4;
		add(button_2, gbc_button_2);
		
		JButton button_3 = new JButton("\u91CD\u7F6E\u79DF\u91D1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bl.resetRent();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 8;
		gbc_button_3.gridy = 4;
		add(button_3, gbc_button_3);
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
	
	public PayType stringToType(String type){
		if(type.equals("租金")){
			return PayType.RENT;
		}else if(type.equals("运费")){
			return PayType.FREIGHT;
		}else{
			return PayType.SALARY;
		}
	}

}
