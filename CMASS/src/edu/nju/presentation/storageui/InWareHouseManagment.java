package edu.nju.presentation.storageui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import edu.nju.businesslogic.storagebl.InWareHouseManagementbl;
import edu.nju.businesslogicservice.storagelogicservice.InWareHouseManagementService;
import edu.nju.vo.InWareHouseDocLineItem;
import edu.nju.vo.InWareHouseDocVO;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class InWareHouseManagment extends JPanel {
	private JTextField textField_1;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JButton btnNewButton_1;
	private String currInstitution;
	private String currPersonID;
	private JComboBox comboBox;
public static void main(String[] args) {
	InWareHouseManagment in=new InWareHouseManagment();
	JFrame mainFrame=new JFrame();
	mainFrame.add(in);
	mainFrame.setVisible(true);
	mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	mainFrame.setLocationRelativeTo(null);
	mainFrame.setSize(500, 300);
}
	public InWareHouseManagment(String currInstitution, String currPersonID) {
		this();
		this.currInstitution = currInstitution;
		this.currPersonID = currPersonID;
	}

	public InWareHouseManagment() {
		String[] columnNames = { "快递编号", "入库日期", "目的地", "区号", "排号", "架号", "位号" };
		String[][] data = { { "100031", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100032", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100033", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100034", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100035", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100036", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100037", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100038", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100039", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100040", "20151031", "北京", "航运区", "10", "12", "1" },
				{ "100041", "20151031", "北京", "航运区", "10", "12", "1" }, };
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u5165\u5E93\u7BA1\u7406",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 134, 114, 0, 87, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 39, 217, 32, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		comboBox = new JComboBox();
		comboBox.addItem("中转单编号");
		comboBox.addItem("装车单编号");
		panel.add(comboBox);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		lblNewLabel = new JLabel("\u5165\u5E93\u5355\u7F16\u53F7");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);

		btnNewButton = new JButton("\u81EA\u52A8\u751F\u6210\u4E00\u90E8\u5206");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				InWareHouseManagementService inWare;
				InWareHouseDocVO inWareHouseDocVO;
				String selectedItem = (String) comboBox.getSelectedItem();
				
				if (selectedItem.equals("中转单编号")) {
					System.out.println("hello");
					inWare = new InWareHouseManagementbl();
					inWareHouseDocVO=inWare.getInWareHouseDocVO_Transfer(textField_1.getText());
					System.out.println("hello");
					textField.setText(inWareHouseDocVO.getID());
					ArrayList<InWareHouseDocLineItem>  list=inWareHouseDocVO.getList();
					JTable table;
					String[][] data1=new String[list.size()][7];
					int i=0;
					for(InWareHouseDocLineItem temp:list){
						data1[i][0]=temp.getSendDocID();
						data1[i][1]=temp.getDate().toString();
						data1[i][2]=temp.getDestination();
						data1[i][3]=temp.getDistrict();
						data1[i][4]=temp.getLocation().substring(0, 2);
						data1[i][5]=temp.getLocation().substring(2, 4);
						data1[i][6]=temp.getLocation().substring(4);
						i++;
					}
					table=new JTable(data1,columnNames);
					scrollPane.add(table);
				}
				

			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 监听
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);

		btnNewButton_1 = new JButton("\u786E\u8BA4");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 3;
		add(btnNewButton_1, gbc_btnNewButton_1);

	}
}
