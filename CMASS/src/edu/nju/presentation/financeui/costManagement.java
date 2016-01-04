package edu.nju.presentation.financeui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.InstitutionPO;
import edu.nju.po.OperationPO;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.SalaryPO;
import edu.nju.po.StaffPO;
import edu.nju.po.TransferDocPO;
import edu.nju.po.YLoadDocPO;
import edu.nju.po.ZLoadDocPO;
import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.presentation.approveui.checkPayDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.WarningManager;
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
import java.util.Date;
public class costManagement extends JPanel{
	/*
	public static void main(String args[]){
		JFrame frame=new JFrame();
		costManagement ui=new costManagement("12000003");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(700,400);
		frame.setVisible(true);
	}
*/
	
	private ArrayList<StaffPO>staffList;
	private String staffName;
	private String staffID;
	private ArrayList<ZLoadDocPO>ZLoadDoc;
	private ArrayList<YLoadDocPO> YLoadDoc;
	private ArrayList<TransferDocPO> transferDoc;
	private ArrayList<AccountVO>accountList;
	private ArrayList<InstitutionPO> institutionList;
	private MyComboBox accountComboBox ;
	private financebl bl;
	private JPanel thisPanel=this;
	private JPanel panel;
	private MyComboBox comboBox;
	private MyTextField back;
	private GridBagConstraints gbc_panel ;
	private Institution institution;
	private SystemBl systembl;
	public costManagement(String staffID) {
		this.staffID=staffID;
		setOpaque(false);
		try {
			systembl=new SystemBl();
			institution=new Institution();
			this.staffName=institution.getStaffName(staffID);
			bl=new financebl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridwidth=5;
		gbc_panel.gridy = 4;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 13, 68, 100, 100, 0, 0, 0, 73, 44, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 200, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_3 = new JLabel("\u6210\u672C\u7BA1\u7406");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		add(label_3, gbc_label_3);
		
		JLabel label = new JLabel("\u6761\u76EE");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(label, gbc_label);
		
		comboBox = new MyComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u79DF\u91D1", "\u5DE5\u8D44", "\u8FD0\u8D39"}));
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 2;
		add(comboBox, gbc_comboBox);
		accountList=bl.getAccountList();
		String[]accountName=new String[accountList.size()];
		for(int i=0;i<accountList.size();i++){
			accountName[i]=accountList.get(i).getName();
		}
		
		
		SmallButton button = new SmallButton("\u83B7\u53D6\u5217\u8868");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String payAccount=(String) accountComboBox.getSelectedItem();
				if(payAccount.equals("")){
					WarningManager.warning("尚未输入账户");
				}else{
					String type=(String) comboBox.getSelectedItem();
					switch(type){
					case "租金":
						if(panel!=null){
							remove(panel);
						}
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
						if(panel!=null){
							remove(panel);
						}
						panel=new freightMoneyPanel();
						addPanel(panel);
						transferDoc=bl.getUnpaidCarTransferList();
						System.out.println("transferDoc:"+transferDoc.size());
						YLoadDoc=bl.getUnpaidYLoadDocList();
						System.out.println("YLoadDoc:"+YLoadDoc.size());
						ZLoadDoc=bl.getUnpaidZLoadDocList();
						System.out.println("ZLoadDoc:"+ZLoadDoc.size());
						((freightMoneyPanel)panel).initializeTable(transferDoc, YLoadDoc, ZLoadDoc);
						updateUI();
						break;
					case "工资":
						if(panel!=null){
							remove(panel);
						}
						panel=new salaryPanel();
						addPanel(panel);
						staffList=bl.getUnpaidStaffList();
						System.out.println(staffList.size());
						((salaryPanel)panel).initializeTable(staffList);
						updateUI();
						break;
					}
				}
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 2;
		add(button, gbc_button);
		
		SmallButton button_4 = new SmallButton("\u5168\u9009");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						String type=(String) comboBox.getSelectedItem();
						switch(type){
						case "租金":
							((rentMoneyPanel) panel).chooseAll();
							break;
						case"工资":
							
							((salaryPanel) panel).chooseAll();
							break;
						case"运费":
							((freightMoneyPanel) panel).chooseAll();
							break;
						}
			}	
			});
			
		
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 2;
		add(button_4, gbc_button_4);
		
		JLabel label_2 = new JLabel("\u4ED8\u6B3E\u8D26\u53F7");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		add(label_2, gbc_label_2);
		
		accountComboBox = new MyComboBox();
		accountComboBox.setEditable(true);
		accountComboBox.setModel(new DefaultComboBoxModel(accountName));
		accountComboBox.setSelectedIndex(0);
		GridBagConstraints gbc_accountComboBox = new GridBagConstraints();
		gbc_accountComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_accountComboBox.gridx = 3;
		gbc_accountComboBox.gridy = 3;
		add(accountComboBox, gbc_accountComboBox);
		
		JLabel label_4 = new JLabel("\u5907\u6CE8");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 3;
		add(label_4, gbc_label_4);
		
		back = new MyTextField();
		GridBagConstraints gbc_back = new GridBagConstraints();
		gbc_back.insets = new Insets(0, 0, 5, 5);
		gbc_back.fill = GridBagConstraints.HORIZONTAL;
		gbc_back.gridx = 5;
		gbc_back.gridy = 3;
		add(back, gbc_back);
		back.setColumns(10);
		
		SmallButton button_1 = new SmallButton("\u65B0\u5EFA\u4ED8\u6B3E\u5355");
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
					if(rentPayMent!=0){
					PayDocVO vo=bl.reviewPayDoc(rentPayMent,staffName, (String) account, stringToType(type), back.getText());
					CheckDialog dialog=new CheckDialog();
					checkPayDoc ui=new checkPayDoc(vo);
					dialog.setPreviewMode(ui);
			        dialog.getConfirmButton().addActionListener(new ActionListener(){
			            	@Override
			            	public void actionPerformed(ActionEvent e){
			            		ArrayList<InstitutionPO> tempList=new ArrayList<InstitutionPO>();
			            		bl.createPayDoc(vo);
			            		bl.minusMoney(vo.getAccount(), vo.getMoney());
			            		for(int i=0;i<rentTableInfo.length;i++){
									Object[] oneLine=rentTableInfo[i];
									if((boolean)oneLine[0]==true){
										tempList.add(institutionList.get(i));
									}
								}
			            		bl.setInstitutionList(tempList);
			            		//已经生成付款单后我们要把添加的面板清空并且让institutionList重新变为null,方便进行下一次成本管理
			            		panel.removeAll();
			            		updateUI();
			            		institutionList=null;
			            		createRecord();
			            	}
			            });
					}else{
					    
					    WarningManager.warning("没有付款项");
					}
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
					if(freightPayMent!=0){
					PayDocVO freightVo=bl.reviewPayDoc(freightPayMent,staffName, (String) account, stringToType(type), back.getText());
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
		            		panel.removeAll();
		            		updateUI();
		            		ZLoadDoc=null;
		            		YLoadDoc=null;
		            		transferDoc=null;
		            		createRecord();
		            	}
		            });
					}else{
						WarningManager.warning("没有付款项");
					}
					break;
				case"工资":
					JTable salaryTable=((salaryPanel)panel).getTable();//每列分别为工号，姓名，工资
					Object[][]salaryTableInfo=getTableArray(salaryTable);
					double salaryPayMent=0;
					for(int i=0;i<salaryTableInfo.length;i++){
						Object[] oneLine=salaryTableInfo[i];
						if((boolean)oneLine[0]==true){
							salaryPayMent+=(double)oneLine[3];
						}
					}
					if(salaryPayMent!=0){
					PayDocVO salaryVo=bl.reviewPayDoc(salaryPayMent,staffName, (String) account, stringToType(type), back.getText());
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
									StaffPO staff=staffList.get(i);
									SalaryPO po=bl.getSalaryPO(staff.getStaffID());
									po.setPaid(true);
									bl.saveSalaryPO(po);
								}
							}
							
		            		bl.setStaffList(staffList);
		            		//已经生成付款单后我们要把添加的面板清空并且让institutionList重新变为null,方便进行下一次成本管理
		            		panel.removeAll();
		            		updateUI();
		            		staffList=null;
		            		createRecord();
		            	}
		            });
					}else{
						WarningManager.warning("没有付款项");
					}
					break;
				}
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 5;
		add(button_1, gbc_button_1);
		
		SmallButton button_2 = new SmallButton("\u91CD\u7F6E\u5DE5\u8D44");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    
			    WarningManager.warning("工资已被重置.");
			    String description="重置工资";
				OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
				try {
					systembl.saveOperation(po);
				} catch (RemoteException e1) {
					System.out.println("保存失败");
					e1.printStackTrace();
				}
				bl.resetSalary();
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 1;
		gbc_button_2.gridy = 6;
		add(button_2, gbc_button_2);
		
		SmallButton button_3 = new SmallButton("\u91CD\u7F6E\u79DF\u91D1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 WarningManager.warning( "租金已被重置.");
				 String description="重置租金";
					OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
					try {
						systembl.saveOperation(po);
					} catch (RemoteException e1) {
						System.out.println("保存失败");
						e1.printStackTrace();
					}
				bl.resetRent();
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 6;
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
		/*
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 4;
		gbc_panel.gridy = 4;
		*/
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
	
	public void createRecord(){
		String description="新建付款单";
		OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
		try {
			systembl.saveOperation(po);
		} catch (RemoteException e1) {
			System.out.println("保存失败");
			e1.printStackTrace();
		}
	}
	
	public void chooseAll(MyTable table){
		for (int i=0; i<table.getRowCount(); i++)
        {
            table.setValueAt(true, i, 0);
        }
	}

}
