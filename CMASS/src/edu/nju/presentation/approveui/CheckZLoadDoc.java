package edu.nju.presentation.approveui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.presentation.widget.MyTable;
import edu.nju.vo.ZLoadDocVO;

import java.awt.Font;

public class CheckZLoadDoc extends JPanel{
	private JTextField transferCenterField;
	private JTextField carID;
	private JTextField watcherField;
	private JTextField Driver;
	private JTextField endPlace;
	private JTextField ZLoadID;
	private JTextField date;
	private JTextField carTransportID;
	private JTextField money;
	private MyTable table;
	public CheckZLoadDoc(ZLoadDocVO vo) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{439, 0};
		gridBagLayout.rowHeights = new int[]{248, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		panel_11.setBorder(null);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0, 322, 0, 0, 0, 0};
		gbl_panel_11.rowHeights = new int[]{41, 0, 41, 41, 41, 133, 0};
		gbl_panel_11.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_11.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_11.setLayout(gbl_panel_11);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_11.add(panel, gbc_panel);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel label = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u88C5\u8F66\u5355");
		label.setFont(new Font("黑体", Font.BOLD, 15));
		panel.add(label);
		
		JLabel textField = new JLabel("\u88C5\u8F66\u5355\u7F16\u53F7");
		textField.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_11.add(textField, gbc_textField);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_1.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		panel_11.add(panel_1, gbc_panel_1);
		
		ZLoadID = new JTextField();
		ZLoadID.setEditable(false);
		panel_1.add(ZLoadID);
		ZLoadID.setColumns(20);
		
		JLabel label_3 = new JLabel("\u65E5\u671F");
		label_3.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 1;
		panel_11.add(label_3, gbc_label_3);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_3.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 4;
		gbc_panel_3.gridy = 1;
		panel_11.add(panel_3, gbc_panel_3);
		
		date = new JTextField();
		date.setEditable(false);
		panel_3.add(date);
		date.setColumns(15);
		
		JLabel label_4 = new JLabel("\u4E2D\u8F6C\u4E2D\u5FC3\u7F16\u53F7");
		label_4.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.WEST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 2;
		panel_11.add(label_4, gbc_label_4);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 2;
		panel_11.add(panel_2, gbc_panel_2);
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		
		transferCenterField = new JTextField();
		transferCenterField.setEditable(false);
		panel_2.add(transferCenterField);
		transferCenterField.setColumns(38);
		
		JLabel label_5 = new JLabel("\u6C7D\u8FD0\u7F16\u53F7");
		label_5.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.WEST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 3;
		gbc_label_5.gridy = 2;
		panel_11.add(label_5, gbc_label_5);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 2;
		panel_11.add(panel_4, gbc_panel_4);
		
		carTransportID = new JTextField();
		carTransportID.setEditable(false);
		panel_4.add(carTransportID);
		carTransportID.setColumns(15);
		
		JLabel label_10 = new JLabel("\u5230\u8FBE\u5730      ");
		label_10.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_10 = new GridBagConstraints();
		gbc_label_10.anchor = GridBagConstraints.WEST;
		gbc_label_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_10.gridx = 1;
		gbc_label_10.gridy = 3;
		panel_11.add(label_10, gbc_label_10);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.gridx = 2;
		gbc_panel_6.gridy = 3;
		panel_11.add(panel_6, gbc_panel_6);
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		
		endPlace = new JTextField();
		endPlace.setEditable(false);
		panel_6.add(endPlace);
		endPlace.setColumns(20);
		
		JLabel label_6 = new JLabel("\u8FD0\u8D39");
		label_6.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.WEST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 3;
		gbc_label_6.gridy = 3;
		panel_11.add(label_6, gbc_label_6);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 4;
		gbc_panel_5.gridy = 3;
		panel_11.add(panel_5, gbc_panel_5);
		
		money = new JTextField();
		money.setEditable(false);
		panel_5.add(money);
		money.setColumns(10);
		
		JLabel label_11 = new JLabel("\u8F66\u8F86\u4EE3\u53F7    ");
		label_11.setFont(new Font("黑体", Font.BOLD, 15));
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.anchor = GridBagConstraints.WEST;
		gbc_label_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_11.gridx = 1;
		gbc_label_11.gridy = 4;
		panel_11.add(label_11, gbc_label_11);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.gridx = 2;
		gbc_panel_8.gridy = 4;
		panel_11.add(panel_8, gbc_panel_8);
		FlowLayout flowLayout_7 = (FlowLayout) panel_8.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		
		carID = new JTextField();
		carID.setEditable(false);
		panel_8.add(carID);
		carID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u76D1\u88C5\u5458");
		lblNewLabel.setFont(new Font("黑体", Font.BOLD, 15));
		panel_8.add(lblNewLabel);
		
		watcherField = new JTextField();
		watcherField.setEditable(false);
		panel_8.add(watcherField);
		watcherField.setColumns(10);
		
		JLabel label_12 = new JLabel("\u53F8\u673A");
		GridBagConstraints gbc_label_12 = new GridBagConstraints();
		gbc_label_12.anchor = GridBagConstraints.WEST;
		gbc_label_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_12.gridx = 3;
		gbc_label_12.gridy = 4;
		panel_11.add(label_12, gbc_label_12);
		label_12.setFont(new Font("黑体", Font.BOLD, 15));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_7.getLayout();
		flowLayout_8.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 4;
		gbc_panel_7.gridy = 4;
		panel_11.add(panel_7, gbc_panel_7);
		
		Driver = new JTextField();
		panel_7.add(Driver);
		Driver.setEditable(false);
		Driver.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		panel_11.add(scrollPane, gbc_scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		String[]itemID=vo.getItemIDs();
		Object[][]tableInfo=new Object[itemID.length][1];
		for(int i=0;i<itemID.length;i++){
			Object[]oneLine={itemID[i]};
			tableInfo[i]=oneLine;
		}
		table = new MyTable();
		table.setModel(new DefaultTableModel(
			tableInfo,
			new String[] {
				"\u8FD0\u5355\u53F7"
			}
		));
		scrollPane.setViewportView(table);
		ZLoadID.setText(vo.getID());
		date.setText(vo.getDate());
		carTransportID.setText(vo.getTranceID());
		endPlace.setText(vo.getTargetBusinessHall());
		Driver.setText(vo.getDriver());
		money.setText(vo.getPrice());
		watcherField.setText(vo.getWatcher());
		//transferCenterField.setText(vo.get);
		

	}
}
