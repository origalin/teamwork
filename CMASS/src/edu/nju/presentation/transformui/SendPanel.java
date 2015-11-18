package edu.nju.presentation.transformui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

import edu.nju.businesslogic.transformbl.OverDoc;
import edu.nju.businesslogic.transformbl.YDeliverDoc;
import edu.nju.po.YDeliverDocPO;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	private JTable toSendTable;
	private JTable toOverTable;
	String institutionID;
	String staffID;
	DefaultTableModel toSendModel;
	DefaultTableModel toOverModel;
	YDeliverDoc yDeliverDoc;
	OverDoc overDoc;
	public SendPanel(String institutionID,String staffID) {
		this.institutionID = institutionID;
		this.staffID = staffID;
		yDeliverDoc = new YDeliverDoc(institutionID,staffID);
		overDoc = new OverDoc(institutionID,staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{104, 1, 107, 93, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		
		JLabel label_3 = new JLabel("\u6D3E\u4EF6\u5355");
		panel_1.add(label_3);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		toSendTable = new JTable();
		toSendTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"单号", "收件人", "地址", "时间"
			}
		));
		toSendModel = (DefaultTableModel) toSendTable.getModel();
		scrollPane.setViewportView(toSendTable);
		
		JButton receiveButton = new JButton("\u586B\u5199\u6536\u4EF6\u5355");
		GridBagConstraints gbc_receiveButton = new GridBagConstraints();
		gbc_receiveButton.insets = new Insets(0, 0, 5, 0);
		gbc_receiveButton.gridx = 4;
		gbc_receiveButton.gridy = 2;
		add(receiveButton, gbc_receiveButton);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u6536\u4EF6\u5355");
		panel.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 5;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);
		
		toOverTable = new JTable();
		toOverTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6536\u4EF6\u5355", "\u6536\u4EF6\u4EBA"
			}
		));
		toOverModel = (DefaultTableModel) toOverTable.getModel();
		scrollPane_1.setViewportView(toOverTable);
		
		JButton createButtom = new JButton("\u751F\u6210\u6536\u4EF6\u5355");
		GridBagConstraints gbc_createButtom = new GridBagConstraints();
		gbc_createButtom.anchor = GridBagConstraints.NORTH;
		gbc_createButtom.gridx = 4;
		gbc_createButtom.gridy = 5;
		add(createButtom, gbc_createButtom);
	}
	private void  intialize() {
		for(int i = toSendModel.getRowCount();i>0;i--) {
			toSendModel.removeRow(i);
		}
		for(int i = toOverModel.getRowCount();i>0;i--) {
			toOverModel.removeRow(i);
		}
		ArrayList<YDeliverDocPO> yDeliverDocPOs = yDeliverDoc.getDeliverDocPOsByID(staffID);
		
	}
}
