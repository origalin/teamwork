package edu.nju.presentation.infoui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import edu.nju.businesslogic.infobl.Car;
import edu.nju.businesslogicservice.infologicservice.CarLogicService;
import edu.nju.po.CarPO;
import edu.nju.tools.Time;
import edu.nju.vo.CarVO;

public class CarPanel extends JPanel {
	private JTable table;
	DefaultTableModel model;
	CarLogicService carBl = new Car();

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */

	public CarPanel(String institutionName) throws RemoteException {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 63, 0, 320, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JLabel label = new JLabel("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 22));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 57, 64, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 49, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JButton button = new JButton("\u65B0\u589E");

		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);

		// 新增的监听
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.addRow(new Object[]{"","","","","","",""});
				
				table.setEnabled(true);
			}
		});

		JButton button_1 = new JButton("\u4FEE\u6539\r\n");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		panel_1.add(button_1, gbc_button_1);

		// 修改的监听
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);

			}
		});

		JButton button_2 = new JButton("\u5220\u9664");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 0;
		panel_1.add(button_2, gbc_button_2);

		// 删除当前行的监听
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
//				if(table.getSelectedRow()==-1){
				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				
				if (str != null) {
					findInTable(str);
				}
//				}
				int row = table.getSelectedRow();
				if (row >= 0) {
					Date date = null;
					int year=0;
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					try {
						date=df.parse( (String) table.getValueAt(row, 5));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					year=Integer.valueOf( (String) table.getValueAt(row, 6));
					CarPO carPO = new CarPO((String) table.getValueAt(row, 0),
							(String) table.getValueAt(row,1), (String) table
									.getValueAt(row, 2), (String) table
									.getValueAt(row, 3), (String) table
									.getValueAt(row, 4),date, year);
					
						try {
							carBl.deleteCar(carPO);
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					model.removeRow(row);
				}
				table.revalidate();
			}
		});

		JButton button_3 = new JButton("\u67E5\u8BE2");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 0;
		panel_1.add(button_3, gbc_button_3);

		// 查询的监听

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				System.out.println("S");
				if (str != null) {
					findInTable(str);
				}
			}
		});

		JButton button_4 = new JButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 6;
		gbc_button_4.gridy = 0;
		panel_1.add(button_4, gbc_button_4);

		// 保存的监听

		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
				table.setEnabled(false);
				for (int i = 0; i < table.getRowCount(); i++) {
					CarPO carPO;
						Date date = null;
						int year=0;
						try {
							date=df.parse( (String) table.getValueAt(i, 5));
							year=Integer.valueOf( (String) table.getValueAt(i, 6));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
//						System.out.println(date);
				
						carPO = new CarPO((String) table.getValueAt(i, 0),
								(String) table.getValueAt(i, 1), (String) table
										.getValueAt(i, 2), (String) table
										.getValueAt(i, 3), (String) table
										.getValueAt(i, 4),date, year);
							try {
								carBl.saveCar(carPO);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				}		
				
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"\u8F66\u8F86\u4EE3\u53F7", "\u53D1\u52A8\u673A\u53F7",
				"\u8F66\u724C\u53F7", "\u5E95\u76D8\u53F7",
				"\u8F66\u8F86\u5355\u4F4D", "\u8D2D\u4E70\u65F6\u95F4",
				"\u670D\u5F79\u65F6\u95F4" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(149);
		table.setEnabled(false);

		model = (DefaultTableModel) table.getModel();

		ArrayList<CarVO> carList = carBl.getCarList(institutionName);
		for (CarVO vo : carList) {
			model.addRow(new Object[] { vo.getCarID(), vo.getEngineID(),
					vo.getPlateID(), vo.getUnderpanID(),
					vo.getInstitutionName(), Time.toDaysTime(vo.getBuyTime()), String.valueOf(vo.getYears()) });
		}
	}

	private void findInTable(String str) {
		int rowCount = table.getRowCount();
		int columnCount = table.getColumnCount();
		for (int i = 0; i < rowCount; i++) {
			for (int k = 0; k < columnCount; k++) {
				Object value = table.getValueAt(i, k);
				if (str.equals(value)) {
					table.getSelectionModel().setSelectionInterval(i, i);
					Rectangle cellRect = table.getCellRect(i, k, true);
					table.scrollRectToVisible(cellRect);
					return;
				}
			}
		}
	}
}
