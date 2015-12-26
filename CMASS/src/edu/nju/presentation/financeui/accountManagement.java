package edu.nju.presentation.financeui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.po.OperationPO;
import edu.nju.presentation.approveui.checkMainUI;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.AccountVO;

import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class accountManagement extends JPanel{
	financebl bl;
	SystemBl systembl;
	Institution institution;
	private MyTextField textField;
	private MyTable table;
	private JPanel thisPanel=this;
	private String staffID;
	private String staffName;
	private String newAccountName;
	/*
	public static void main(String[]args){
		JFrame frame=new JFrame();
		accountManagement ui=new accountManagement("120003");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	*/
	public accountManagement(String staffID) {
		setOpaque(false);
		institution=new Institution();
		systembl=new SystemBl();
		this.staffID=staffID;
		System.out.println("id is" +staffID);
		try {
			this.staffName=institution.getStaffName(staffID);
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			bl=new financebl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 55, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 140, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u8D26\u6237\u7BA1\u7406");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("\u8D26\u6237\u540D\u79F0");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		textField = new MyTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		add(textField, gbc_textField);
		textField.setColumns(10);
		//增加按钮
		SmallButton button = new SmallButton("\u589E\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					
					
					if(!textField.getText().equals("")){
					String newAccountName=textField.getText().trim();
					//首先更新表格
					Object[]rowValues={newAccountName,0};
					((DefaultTableModel) table.getModel()).addRow(rowValues);
					textField.setText("");
					bl.addAccountPO(newAccountName);
					String description="新增账户";
					OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
					try {
						systembl.saveOperation(po);
					} catch (RemoteException e1) {
						System.out.println("保存失败");
						e1.printStackTrace();
					}
					}else{
					    JOptionPane.showMessageDialog(null, "请输入新加账户名", "错误",JOptionPane.PLAIN_MESSAGE);  
					}
					
					/*
					Object[]rowValues={"",0};
					((DefaultTableModel) table.getModel()).addRow(rowValues);
					table.setRowSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
					*/
				}
			}
		});
		//查询按钮
		SmallButton button_3 = new SmallButton("\u67E5\u770B");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_3){
					String checkAccountName=textField.getText().trim();
					int lineNumber=getRowCount(checkAccountName,getTableArray(table));
					if(lineNumber!=-1){
						table.setRowSelectionInterval(lineNumber,lineNumber);
					}else{
						JOptionPane.showMessageDialog(thisPanel,"查询账户不存在","错误",JOptionPane.ERROR_MESSAGE);
					}
					textField.setText("");
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_3.gridx = 6;
		gbc_button_3.gridy = 3;
		add(button_3, gbc_button_3);
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 4;
		add(button, gbc_button);
		//修改按钮
		SmallButton button_2 = new SmallButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_2){
					int selectedRow = table.getSelectedRow();
					String newAccountName=textField.getText().trim();
					if(selectedRow!=-1){
						if(!textField.getText().equals("")){
						bl.modifyAccountPO((String) (table.getModel()).getValueAt(selectedRow, 0), newAccountName);
						 ((DefaultTableModel) table.getModel()).setValueAt(newAccountName, selectedRow, 0);
						 textField.setText("");
							String description="修改账户";
							OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
							try {
								systembl.saveOperation(po);
							} catch (RemoteException e1) {
								System.out.println("保存失败");
								e1.printStackTrace();
							}
						}else{
							JOptionPane.showMessageDialog(thisPanel,"尚未输入新账户名称","错误",JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(thisPanel,"尚未选择账户","错误",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		//删除按钮
		SmallButton button_1 = new SmallButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button_1){
					int selectedRow = table.getSelectedRow();
	                if(selectedRow!=-1)
	                {
	                	bl.deleteAccountPO((String) (table.getModel()).getValueAt(selectedRow, 0));
	                    ((DefaultTableModel) table.getModel()).removeRow(selectedRow); 
	                	String description="删除账户";
						OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
						try {
							systembl.saveOperation(po);
						} catch (RemoteException e1) {
							System.out.println("保存失败");
							e1.printStackTrace();
						}
	                }else{
	                	JOptionPane.showMessageDialog(thisPanel,"尚未选择账户","错误",JOptionPane.ERROR_MESSAGE);
	                }
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 4;
		add(button_1, gbc_button_1);
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 4;
		add(button_2, gbc_button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 5;
		add(scrollPane, gbc_scrollPane);
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
			},
			new String[] {
				"\u516C\u53F8\u94F6\u884C\u8D26\u6237", "\u8D26\u6237\u4F59\u989D"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		*/
		/*
		ArrayList<AccountVO> list=new ArrayList<AccountVO>();
		for(int i=0;i<5;i++){
			AccountVO vo=new AccountVO("账户名"+i,i*1000.0);
			list.add(vo);
		}
		*/
		ArrayList<AccountVO> list=bl.getAccountList();
		if(list==null){
			System.out.println("一定是搞错了");
		}
		scrollPane.setViewportView(initializeTable(list));
		
		SmallButton button_4 = new SmallButton("\u786E\u5B9A");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 6;
		add(button_4, gbc_button_4);
		
	}
	public JTable initializeTable(ArrayList<AccountVO> accountList){
		table = new MyTable();
		Object[][] tableInfo=new Object[accountList.size()][2];
		for(int i=0;i<accountList.size();i++){
			Object[] oneLine={accountList.get(i).getName(),accountList.get(i).getBalance()};
			tableInfo[i]=oneLine;
		}
		table.setModel(new DefaultTableModel(
			tableInfo,
				new String[] {
					"\u516C\u53F8\u94F6\u884C\u8D26\u6237", "\u8D26\u6237\u4F59\u989D"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class,String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		return table;
		
	}
	public int getRowCount(String accountName,Object[][]tableInfo)
	{
		for(int i=0;i<tableInfo.length;i++)
		{
			String temp=(String) tableInfo[i][0];
			if(accountName.equals(temp)){
				return i;
			}
		}
		return -1;
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
