package edu.nju.presentation.financeui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.businesslogic.infobl.Institution;
import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.po.GatheringDocPO;
import edu.nju.po.OperationPO;
import edu.nju.presentation.approveui.checkGatheringDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
public class createGatheringDocPO extends JPanel{
		private SystemBl systembl;
		private String staffName;
		private Institution institution;
		private String staffID;
		private financebl bl;
		private JTextField courier_ID;
		private SmallButton button;
		private JComboBox comboBox;
		private ArrayList<AccountVO>accountList;
		/*
		public static void main(String[]args){
			JFrame frame=new JFrame();
			createGatheringDocPO ui=new createGatheringDocPO("120004");
			ui.setVisible(true);
			frame.getContentPane().add(ui);
			frame.setSize(500,500);
			frame.setVisible(true);
		}
 */
		public createGatheringDocPO(String staffID) {
			systembl=new SystemBl();
			institution=new Institution();
			this.staffID=staffID;
			try {
				this.staffName=institution.getStaffName(staffID);
			} catch (RemoteException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				bl=new financebl();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{115, 102, 65, 62, 76, 0, 0};
			gridBagLayout.rowHeights = new int[]{30, 0, 0, 19, 77, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			JLabel label_2 = new JLabel("\u6536\u6B3E\u5355");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_label_2.anchor = GridBagConstraints.NORTH;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 0;
			add(label_2, gbc_label_2);
			
			JLabel label = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7");
			label.setFont(new Font("宋体", Font.PLAIN, 12));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 1;
			add(label, gbc_label);
			
			courier_ID = new JTextField();
			GridBagConstraints gbc_courier_ID = new GridBagConstraints();
			gbc_courier_ID.insets = new Insets(0, 0, 5, 5);
			gbc_courier_ID.fill = GridBagConstraints.HORIZONTAL;
			gbc_courier_ID.gridx = 1;
			gbc_courier_ID.gridy = 1;
			add(courier_ID, gbc_courier_ID);
			courier_ID.setColumns(10);
			accountList=bl.getAccountList();
			String[]accountName=new String[accountList.size()];
			for(int i=0;i<accountList.size();i++){
				accountName[i]=accountList.get(i).getName();
			}
			
			JLabel label_1 = new JLabel("\u6536\u6B3E\u8D26\u6237");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.EAST;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 3;
			gbc_label_1.gridy = 1;
			add(label_1, gbc_label_1);
			
			comboBox = new JComboBox();
			comboBox.setEditable(true);
			comboBox.setModel(new DefaultComboBoxModel(accountName));
			comboBox.setSelectedIndex(0);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 4;
			gbc_comboBox.gridy = 1;
			add(comboBox, gbc_comboBox);
			
			button = new SmallButton("\u786E\u5B9A");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String courierID=courier_ID.getText().trim();
					if(!courierID.equals("")){
					String account=(String) comboBox.getSelectedItem();
					GatheringDocVO GatheringDocVO=bl.reviewGatheringDoc(courierID,(String)comboBox.getSelectedItem());
					if(GatheringDocVO.getMoney()!=0){
					GatheringDocPO GatheringDocPO=new GatheringDocPO(GatheringDocVO.getID(), GatheringDocVO.getDate(),GatheringDocVO.getMoney(), GatheringDocVO.getAccount(), GatheringDocVO.getItemIDs(),GatheringDocVO.getAccount());
					CheckDialog dialog=new CheckDialog();
		            checkGatheringDoc ui=new checkGatheringDoc(GatheringDocVO);
		            dialog.setPreviewMode(ui);
		            dialog.getConfirmButton().addActionListener(new ActionListener(){
		            	@Override
		            	public void actionPerformed(ActionEvent e){
		            		bl.setSendDocList(courierID);
		            		bl.createGatheringDoc(GatheringDocVO);
		            		bl.addMoney(GatheringDocPO.getAccount(), GatheringDocPO.getMoney());
		            		String description="新建收款单";
		            		OperationPO po=new OperationPO(new Date(), staffID, staffName, description);
		            		try {
		            			systembl.saveOperation(po);
		            		} catch (RemoteException e1) {
		            			System.out.println("保存失败");
		            			e1.printStackTrace();
		            		}
		            	}
		            });
					}else{
						JOptionPane.showMessageDialog(null, "该快递员还没有进行新的派件", "错误",JOptionPane.PLAIN_MESSAGE);
					}
					}else{
					    JOptionPane.showMessageDialog(null, "未输入快递员编号", "错误",JOptionPane.PLAIN_MESSAGE);  
					}
		            
					/*
					 GatheringDocPO po=getGatheringDocPOByID(inputID);
						CheckDialog dialog=new CheckDialog();
						dialog.setSize(500,500);
						checkGatheringDoc  ui=new checkGatheringDoc();
						ui.getTextField_2().setText(po.getID());
						ui.getTextField().setText(DateToString(po.getDate()));
						ui.getTextField_4().setText(po.getCourier_ID());
						ui.getTextField_3().setText(po.getMoney().toString());
						ui.getTextField_1().setText(po.getAccount());
						ui.getScrollPane().setViewportView(ui.initializeTable(po.getItemIDs()));
					 */
					
				}
			});
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.insets = new Insets(0, 0, 5, 0);
			gbc_button.gridx = 5;
			gbc_button.gridy = 1;
			add(button, gbc_button);
		}

	
}
