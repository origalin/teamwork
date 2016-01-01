package edu.nju.presentation.transformui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import edu.nju.businesslogic.collectionbl.Collectionbl;
import edu.nju.businesslogic.transferbl.OverDoc;
import edu.nju.businesslogic.transferbl.YDeliverDoc;
import edu.nju.exception.DatabaseNULLException;
import edu.nju.po.SendDocPO;
import edu.nju.po.YDeliverDocPO;
import edu.nju.presentation.approveui.checkOverDoc;
import edu.nju.presentation.financeui.accountManagement;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.OverDocVO;
import edu.nju.vo.SendDocVO;
import edu.nju.vo.YDeliverDocVO;
import java.awt.Dimension;
import java.awt.Color;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	private MyTable toSendTable;
	private MyTable toOverTable;
	String institutionID;
	String staffID;
	DefaultTableModel toSendModel;
	DefaultTableModel toOverModel;
	YDeliverDoc yDeliverDoc;
	Collectionbl collectionbl;
	OverDoc overDoc;
	ArrayList<YDeliverDocVO> yDeliverDocVOs;
	public SendPanel(String staffID) {
		this.staffID = staffID;
		try {
			overDoc = new OverDoc(staffID);
			yDeliverDoc = new YDeliverDoc(staffID);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning();
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 100, 93, 87, 30, 0};
		gridBagLayout.rowHeights = new int[]{0, 17, 0, 0, 20, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.5, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		MyScrollPane scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		toSendTable = new MyTable();
		toSendTable.setShowVerticalLines(false);
		toSendTable.setGridColor(Color.LIGHT_GRAY);
		toSendTable.setRowHeight(30);
		toSendTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		toSendTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5FEB\u9012\u5355\u53F7", "\u6536\u4EF6\u4EBA", "\u5730\u5740"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		toSendModel = (DefaultTableModel) toSendTable.getModel();
		scrollPane.setViewportView(toSendTable);
		
		JButton receiveButton = new SmallButton("\u586B\u5199\u6536\u4EF6\u5355");
		receiveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					intialize();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					warning();
				}
				createOverTable();
				
			}
		});
		GridBagConstraints gbc_receiveButton = new GridBagConstraints();
		gbc_receiveButton.anchor = GridBagConstraints.EAST;
		gbc_receiveButton.insets = new Insets(0, 0, 5, 5);
		gbc_receiveButton.gridx = 3;
		gbc_receiveButton.gridy = 2;
		add(receiveButton, gbc_receiveButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u6536\u4EF6\u5355");
		panel.add(label);
		
		MyScrollPane scrollPane_1 = new MyScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);
		
		toOverTable = new MyTable();
		toOverTable.setRowHeight(30);
		toOverTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		toOverTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5FEB\u9012\u5355\u53F7", "\u6536\u4EF6\u4EBA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		toOverModel = (DefaultTableModel) toOverTable.getModel();
		scrollPane_1.setViewportView(toOverTable);
		
		JButton createButtom = new SmallButton("\u751F\u6210\u6536\u4EF6\u5355");
		createButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createOverDoc();
			}
		});
		GridBagConstraints gbc_createButtom = new GridBagConstraints();
		gbc_createButtom.insets = new Insets(0, 0, 0, 5);
		gbc_createButtom.anchor = GridBagConstraints.NORTHEAST;
		gbc_createButtom.gridx = 3;
		gbc_createButtom.gridy = 5;
		add(createButtom, gbc_createButtom);
		
		
		try {
			intialize();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			warning();
		}
		panel.setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setOpaque(false);
		setOpaque(false);
		
	}
	private void  intialize() throws RemoteException {
		int i = toSendModel.getRowCount();
		int j = toOverModel.getRowCount();
		for(;i>0;i--) {
			toSendModel.removeRow(i-1);
		}
		for(;j>0;j--) {
			toOverModel.removeRow(j-1);
		}
		collectionbl = new Collectionbl(staffID);
		yDeliverDocVOs = yDeliverDoc.findYDeliverDocVOs(staffID);
		SendDocVO sendDocVO = null ;
		if(yDeliverDocVOs.size()!=0)
		for(YDeliverDocVO vo:yDeliverDocVOs) {
			String[] itemIDs = vo.getItemIDs();
			for(String itemID : itemIDs) {
				try {
					sendDocVO = collectionbl.getSendDocVOByID(itemID);
				} catch (DatabaseNULLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toSendModel.addRow(new Object[] {itemID,sendDocVO.getrName(),sendDocVO.getrAddress()});		
			}
		}
		
	}
	private void createOverTable() {
		if(toSendModel.getRowCount()==0) {
			JOptionPane.showMessageDialog(this, "您没有可派件");
		}
		for(int i = 0;i<toSendModel.getRowCount();i++) {
			toOverModel.addRow(new Object[] {toSendModel.getValueAt(i, 0),toSendModel.getValueAt(i, 1)});
		}
	}
	private void createOverDoc() {
		if(createable()) {
			String[] itemIDs = new String[toOverModel.getRowCount()];
			String[] receivers = new String[toOverModel.getRowCount()];
			for(int i = 0;i<toSendModel.getRowCount();i++) {
				itemIDs[i] = (String) toOverModel.getValueAt(i, 0);
				receivers[i] = (String) toOverModel.getValueAt(i, 1);
			}
			OverDocVO vo = null;
			try {
				vo = overDoc.createOverDocVO(itemIDs, receivers);
				CheckDialog cDialog = new CheckDialog();
				cDialog.setPreviewMode(new checkOverDoc(vo));
				cDialog.getConfirmButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						saveDoc();
						try {
							intialize();
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							warning();
							e1.printStackTrace();
						}
					}
				});
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				warning();
			}
		}else {
			JOptionPane.showMessageDialog(this, "没有可保存数据");
		}
		
		
	}
	private boolean createable() {
		// TODO Auto-generated method stub
		if(toOverModel.getRowCount()==0)
		return false;
		return true;
	}
	private void saveDoc() {
		try {
			for(YDeliverDocVO vo : yDeliverDocVOs) {
				YDeliverDocPO po = yDeliverDoc.getDeliverDocPOsByID(vo.getID());
				po.setDealed(true);
				po.setChecked(true);
				yDeliverDoc.saveYDeliverDocPO(po);
			}
			overDoc.confirmSave();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			warning();
		} catch (DatabaseNULLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void warning() {
	
		JOptionPane.showMessageDialog(this, "网络异常，请重启客户端！");
		
		
	}
	private void  intialize2() throws RemoteException {
		int i = toOverModel.getRowCount();
		for(;i>0;i--) {
			toOverModel.removeRow(i-1);
		}
		
		collectionbl = new Collectionbl(staffID);
		yDeliverDocVOs = yDeliverDoc.findYDeliverDocVOs(staffID);
		SendDocVO sendDocVO = null ;
		if(yDeliverDocVOs.size()!=0)
		for(YDeliverDocVO vo:yDeliverDocVOs) {
			String[] itemIDs = vo.getItemIDs();
			for(String itemID : itemIDs) {
				try {
					sendDocVO = collectionbl.getSendDocVOByID(itemID);
				} catch (DatabaseNULLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				toSendModel.addRow(new Object[] {itemID,sendDocVO.getrName(),sendDocVO.getrAddress()});		
			}
		}
		
	}
//	private void refresh() {
//		int i = toSendModel.getRowCount();
//		int j = toOverModel.getRowCount();
//		for(;i>0;i--) {
//			toSendModel.removeRow(i);
//		}
//		for(;j>0;j--) {
//			toOverModel.removeRow(i);
//		}
//		
//	}
}
