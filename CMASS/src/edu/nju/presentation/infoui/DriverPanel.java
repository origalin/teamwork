package edu.nju.presentation.infoui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.presentation.UiFactory;
import edu.nju.tools.Time;
import edu.nju.vo.CarVO;
import edu.nju.vo.DriverVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DriverPanel extends JPanel {
	private JTable table;
	DefaultTableModel model;
	DriverLogicService driverLogicService=UiFactory.getDriverLogicService();
	/**
	 * Create the panel.
	 */
	public DriverPanel(String institutionName) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{42, 53, 337, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JLabel label = new JLabel("\u53F8\u673A\u4FE1\u606F\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{19, 0, 0, 0, 51, 20, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{35, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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

				model.addRow(new Object[]{"","","","","","","","",""});
				
				table.setEnabled(true);
			}
		});
		
		
		JButton button_1 = new JButton("\u4FEE\u6539");
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
				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				
				if (str != null) {
					findInTable(str);
				}

				int row = table.getSelectedRow();
				if (row >= 0) {
					Date brithday = null;
					Date beginLimit=null;
					Date endLimit=null;
				
					SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					try {
						brithday=df.parse( (String) table.getValueAt(row, 3));
						beginLimit=df.parse( (String) table.getValueAt(row, 7));
						endLimit=df.parse( (String) table.getValueAt(row, 8));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					DriverPO po = new DriverPO((String) table.getValueAt(row, 0),
							(String) table.getValueAt(row,1), (String) table
									.getValueAt(row, 2), brithday, (String) table
									.getValueAt(row, 4),(String) table
									.getValueAt(row, 5),(String) table
									.getValueAt(row, 6),beginLimit,endLimit);
					
						try {
							driverLogicService.deleteDriver(po);
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
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				if (str != null) {
					findInTable(str);
				}
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridx = 4;
		gbc_button_3.gridy = 0;
		panel_1.add(button_3, gbc_button_3);
		
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
						Date brithday = null;
						Date beginLimit=null;
						Date endLimit=null;
					
						for (int i = 0; i < table.getRowCount(); i++) {
				
								try {
									brithday=df.parse( (String) table.getValueAt(i, 3));
									beginLimit=df.parse( (String) table.getValueAt(i, 7));
									endLimit=df.parse( (String) table.getValueAt(i, 8));
								
								} catch (ParseException e1) {
									e1.printStackTrace();
								}
//								System.out.println(date);
							DriverPO po= new DriverPO((String) table.getValueAt(i, 0),
										(String) table.getValueAt(i,1), (String) table
												.getValueAt(i, 2), brithday, (String) table
												.getValueAt(i, 4),(String) table
												.getValueAt(i, 5),(String) table
												.getValueAt(i, 6),beginLimit,endLimit);
									try {
										driverLogicService.saveDriver(po);
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u53F8\u673A\u7F16\u53F7", "\u53F8\u673A\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u65E5\u671F", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u65B9\u5F0F", "\u8F66\u8F86\u5355\u4F4D", "\u884C\u9A76\u8BC1\u521D\u59CB\u65E5\u671F", "\u884C\u9A76\u8BC1\u5931\u6548\u65E5\u671F"
			}
		));
		table.setEnabled(false);

		model = (DefaultTableModel) table.getModel();

		ArrayList<DriverVO> driverList = null;
		try {
			driverList = driverLogicService.getDriveVOList(institutionName);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (DriverVO vo : driverList) {
			model.addRow(new Object[] {vo.getDriverID(),vo.getName(),vo.getSex(),Time.toDaysTime(vo.getBirthday()),vo.getIdentity(),vo.getTel(),vo.getInstitution(),Time.toDaysTime(vo.getBeginLimit()),Time.toDaysTime(vo.getEndLimit())});
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
