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

import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.GatheringDocPO;
import edu.nju.presentation.approveui.checkGatheringDoc;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.vo.AccountVO;
import edu.nju.vo.GatheringDocVO;
public class createGatheringDocPO extends JPanel{
		private financebl bl;
		private JTextField courier_ID;
		private JTextField textField_1;
		private JButton button;
		private JComboBox comboBox;
		private ArrayList<AccountVO>accountList;
		public static void main(String[]args){
			JFrame frame=new JFrame();
			createGatheringDocPO ui=new createGatheringDocPO();
			ui.setVisible(true);
			frame.getContentPane().add(ui);
			frame.setSize(500,500);
			frame.setVisible(true);
		}
 
		public createGatheringDocPO() {
			try {
				bl=new financebl();
			} catch (RemoteException e1) {
				
				e1.printStackTrace();
			}
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{115, 102, 65, 62, 76, 0};
			gridBagLayout.rowHeights = new int[]{30, 0, 0, 19, 77, 0, 0, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			
			JLabel label_4 = new JLabel("\u6536\u6B3E\u5355\u7F16\u53F7");
			label_4.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.gridx = 0;
			gbc_label_4.gridy = 1;
			add(label_4, gbc_label_4);
			
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
			
			JLabel label = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7");
			label.setFont(new Font("ËÎÌו", Font.PLAIN, 12));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.EAST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 3;
			gbc_label.gridy = 1;
			add(label, gbc_label);
			
			courier_ID = new JTextField();
			GridBagConstraints gbc_courier_ID = new GridBagConstraints();
			gbc_courier_ID.insets = new Insets(0, 0, 5, 0);
			gbc_courier_ID.fill = GridBagConstraints.HORIZONTAL;
			gbc_courier_ID.gridx = 4;
			gbc_courier_ID.gridy = 1;
			add(courier_ID, gbc_courier_ID);
			courier_ID.setColumns(10);
			
			JLabel label_1 = new JLabel("\u6536\u6B3E\u8D26\u6237");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.anchor = GridBagConstraints.EAST;
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 3;
			add(label_1, gbc_label_1);
			
			button = new JButton("\u786E\u5B9A");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String GatheringDocID=textField_1.getText().trim();
					String courierID=courier_ID.getText().trim();
					String account=(String) comboBox.getSelectedItem();
					GatheringDocVO GatheringDocVO=bl.reviewGatheringDoc(GatheringDocID, courierID, account);
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
		            	}
		            });
		            
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
			
			comboBox = new JComboBox();
			accountList=bl.getAccountList();
			String[]accountName=new String[accountList.size()];
			for(int i=0;i<accountList.size();i++){
				accountName[i]=accountList.get(i).getName();
			}
			comboBox.setEditable(true);
			comboBox.setModel(new DefaultComboBoxModel(accountName));
			comboBox.setSelectedIndex(0);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 3;
			add(comboBox, gbc_comboBox);
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.insets = new Insets(0, 0, 5, 5);
			gbc_button.gridx = 2;
			gbc_button.gridy = 5;
			add(button, gbc_button);
		}

	
}
