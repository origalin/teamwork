package edu.nju.presentation.systemui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;

import javax.swing.JRadioButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import edu.nju.businesslogic.systembl.SystemBl;
import edu.nju.businesslogicservice.systemlogicservice.SystemLogicService;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.Time;
import edu.nju.vo.CarVO;
import edu.nju.vo.OperationVO;

public class OperationPanel extends JPanel {
	private MyTable table;
	private JTextField textField;
	private JTextField textField_1;	
	DefaultTableModel model;
	JScrollPane scrollPane = new JScrollPane();
	SystemLogicService systemBl=UiFactory.getSystemLogicService();
	

	/**
	 * Create the panel.
	 * @throws ParseException 
	 * @throws RemoteException 
	 */
	public OperationPanel() throws ParseException, RemoteException {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{220, 0};
		gridBagLayout.rowHeights = new int[]{89, 209, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		
		gbl_panel_1.columnWidths = new int[]{56, 155, 71, 123, 40, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{44, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("\u5F00\u59CB\u65E5\u671F");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setText("2015-1-1 00:00:00\r\n");
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u7ED3\u675F\u65E5\u671F");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		panel_1.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setText("2016-1-1 00:00:00\r\n");
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 0;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		SmallButton button = new SmallButton("\u5F00\u59CB\u67E5\u8BE2");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		//search 
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
model=(DefaultTableModel)table.getModel();
		int row=model.getRowCount();
		for(int i=0;i<row;i++){
			System.out.println(model.getRowCount());
				model.removeRow(0);
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date beginTime = null;
		try {
			beginTime = sdf.parse(textField.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "日期格式错误，应为yyyy-MM-dd，请检查");
		}
		Date endTime = null;
		try {
			endTime = sdf.parse(textField_1.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "日期格式错误，应为yyyy-MM-dd，请检查");
		}
		ArrayList<OperationVO> operationList = null;
		try {
			operationList = systemBl.getOperationVOList(beginTime, endTime);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
		}
		for (OperationVO vo : operationList) {
			model.addRow(new Object[] { Time.toSecondTime(vo.getDate()),vo.getStaffID(),vo.getStaffName(),vo.getDescribration()
			 });
			
		}
			}
		});
	
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		table = new MyTable();
		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u65F6\u95F4", "\u64CD\u4F5C\u4EBA", "\u5DE5\u53F7", "\u64CD\u4F5C\u63CF\u8FF0"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(359);
		
		
		model = (DefaultTableModel) table.getModel();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date beginTime = null;
		try {
			beginTime = sdf.parse(textField.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "日期格式错误，应为yyyy-MM-dd，请检查");
		}
		Date endTime = null;
		try {
			endTime = sdf.parse(textField_1.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "日期格式错误，应为yyyy-MM-dd，请检查");
		}
		ArrayList<OperationVO> operationList = null;
		try {
			operationList = systemBl.getOperationVOList(beginTime, endTime);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "网络连接出错，请检查");
		}
		for (OperationVO vo : operationList) {
			model.addRow(new Object[] { Time.toSecondTime(vo.getDate()),vo.getStaffID(),vo.getStaffName(),vo.getDescribration()
			 });
		}
		
		
		
		
	}

}
