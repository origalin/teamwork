package edu.nju.presentation.approveui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.vo.TransferDoc_TrainVO;

import javax.swing.SwingConstants;

import java.awt.Font;

@SuppressWarnings("serial")
public class CheckTransferDoc_Train extends JPanel{
	private JTextField train_num;
	private JTextField watcherField;
	private JTextField endPlace;
	private JTable table;
	private JTextField startPlace;
	private JTextField transferID;
	private JTextField date;
	private JTextField textField_3;
	private JTextField train_corridge;
	private JTextField tranceID;
	public CheckTransferDoc_Train(TransferDoc_TrainVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{418, 0};
		gridBagLayout.rowHeights = new int[]{248, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel train_trance = new JPanel();
		GridBagConstraints gbc_train_trance = new GridBagConstraints();
		gbc_train_trance.fill = GridBagConstraints.BOTH;
		gbc_train_trance.gridx = 0;
		gbc_train_trance.gridy = 0;
		add(train_trance, gbc_train_trance);
		train_trance.setBorder(null);
		GridBagLayout gbl_train_trance = new GridBagLayout();
		gbl_train_trance.columnWidths = new int[]{0, 245, 0, 0, 0};
		gbl_train_trance.rowHeights = new int[]{42, 0, 42, 42, 42, 0};
		gbl_train_trance.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_train_trance.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		train_trance.setLayout(gbl_train_trance);
				
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.gridwidth = 4;
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
				train_trance.add(panel, gbc_panel);
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				
				JLabel label = new JLabel("\u94C1\u8DEF\u4E2D\u8F6C\u5355");
				label.setFont(new Font("黑体", Font.BOLD, 15));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
				
				JLabel label_3 = new JLabel("\u4E2D\u8F6C\u5355\u7F16\u53F7");
				GridBagConstraints gbc_label_3 = new GridBagConstraints();
				gbc_label_3.insets = new Insets(0, 0, 5, 5);
				gbc_label_3.gridx = 0;
				gbc_label_3.gridy = 1;
				train_trance.add(label_3, gbc_label_3);
				label_3.setFont(new Font("黑体", Font.BOLD, 15));
				
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.anchor = GridBagConstraints.WEST;
				gbc_panel_1.insets = new Insets(0, 0, 5, 5);
				gbc_panel_1.fill = GridBagConstraints.VERTICAL;
				gbc_panel_1.gridx = 1;
				gbc_panel_1.gridy = 1;
				train_trance.add(panel_1, gbc_panel_1);
				
				transferID = new JTextField();
				transferID.setEditable(false);
				panel_1.add(transferID);
				transferID.setColumns(20);
				
				JLabel label_4 = new JLabel("\u65E5\u671F");
				GridBagConstraints gbc_label_4 = new GridBagConstraints();
				gbc_label_4.anchor = GridBagConstraints.WEST;
				gbc_label_4.insets = new Insets(0, 0, 5, 5);
				gbc_label_4.gridx = 2;
				gbc_label_4.gridy = 1;
				train_trance.add(label_4, gbc_label_4);
				label_4.setFont(new Font("黑体", Font.BOLD, 15));
				
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.anchor = GridBagConstraints.WEST;
				gbc_panel_2.insets = new Insets(0, 0, 5, 0);
				gbc_panel_2.fill = GridBagConstraints.VERTICAL;
				gbc_panel_2.gridx = 3;
				gbc_panel_2.gridy = 1;
				train_trance.add(panel_2, gbc_panel_2);
				
				date = new JTextField();
				date.setEditable(false);
				panel_2.add(date);
				date.setColumns(20);
				
				JLabel label_2 = new JLabel("\u51FA\u53D1\u5730    ");
				GridBagConstraints gbc_label_2 = new GridBagConstraints();
				gbc_label_2.insets = new Insets(0, 0, 5, 5);
				gbc_label_2.gridx = 0;
				gbc_label_2.gridy = 2;
				train_trance.add(label_2, gbc_label_2);
				label_2.setFont(new Font("黑体", Font.BOLD, 15));
		
				
				JPanel panel_6 = new JPanel();
				GridBagConstraints gbc_panel_6 = new GridBagConstraints();
				gbc_panel_6.fill = GridBagConstraints.BOTH;
				gbc_panel_6.insets = new Insets(0, 0, 5, 5);
				gbc_panel_6.gridx = 1;
				gbc_panel_6.gridy = 2;
				train_trance.add(panel_6, gbc_panel_6);
				FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
				flowLayout_6.setAlignment(FlowLayout.LEFT);
				
				startPlace = new JTextField();
				startPlace.setEditable(false);
				panel_6.add(startPlace);
				startPlace.setColumns(10);
				
				JLabel label_10 = new JLabel("\u5230\u8FBE\u5730");
				label_10.setFont(new Font("黑体", Font.BOLD, 15));
				panel_6.add(label_10);
				
				endPlace = new JTextField();
				endPlace.setEditable(false);
				panel_6.add(endPlace);
				endPlace.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D27\u8FD0\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		train_trance.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("黑体", Font.BOLD, 15));
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.anchor = GridBagConstraints.WEST;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.VERTICAL;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 2;
		train_trance.add(panel_4, gbc_panel_4);
		
		tranceID = new JTextField();
		tranceID.setEditable(false);
		panel_4.add(tranceID);
		tranceID.setColumns(10);
		
		JLabel 车次号 = new JLabel("\u8F66\u6B21\u53F7");
		车次号.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_车次号 = new GridBagConstraints();
		gbc_车次号.anchor = GridBagConstraints.WEST;
		gbc_车次号.insets = new Insets(0, 0, 5, 5);
		gbc_车次号.gridx = 0;
		gbc_车次号.gridy = 3;
		train_trance.add(车次号, gbc_车次号);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 3;
		train_trance.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		train_num = new JTextField();
		train_num.setEditable(false);
		panel_8.add(train_num);
		train_num.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(lblNewLabel);
		
		watcherField = new JTextField();
		watcherField.setEditable(false);
		panel_8.add(watcherField);
		watcherField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u8F66\u53A2\u53F7");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 2;
		gbc_label_6.gridy = 3;
		train_trance.add(label_6, gbc_label_6);
		label_6.setFont(new Font("黑体", Font.BOLD, 15));
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.WEST;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.VERTICAL;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 3;
		train_trance.add(panel_3, gbc_panel_3);
		
		train_corridge = new JTextField();
		train_corridge.setEditable(false);
		panel_3.add(train_corridge);
		train_corridge.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8FD0\u8D39");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		panel_3.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		train_trance.add(scrollPane, gbc_scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_13 = new JPanel();
		scrollPane.setColumnHeaderView(panel_13);
		
		JLabel label_1 = new JLabel("\u8FD0\u5355\u53F7");
		label_1.setFont(new Font("黑体", Font.BOLD, 15));
		panel_13.add(label_1);
		
		JPanel panel_14 = new JPanel();
		scrollPane.setViewportView(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		String[]itemID=vo.getItemIDs();
		Object[][]tableInfo=new Object[itemID.length][1];
		for(int i=0;i<itemID.length;i++){
			Object[]oneLine={itemID[i]};
			tableInfo[i]=oneLine;
		}
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u8FD0\u5355\u53F7"
			}
		));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		table.getColumnModel().getColumn(0).setPreferredWidth(130);
		panel_14.add(table);
		
		transferID.setText(vo.getID());
		date.setText(vo.getDate());
		startPlace.setText(vo.getFrom());
		endPlace.setText(vo.getTargetCity());
		tranceID.setText(vo.getTranceID());
		train_num.setText(vo.getTrainNum());
		watcherField.setText(vo.getWatcher());
		train_corridge.setText(vo.getCorriage());
	}
}
