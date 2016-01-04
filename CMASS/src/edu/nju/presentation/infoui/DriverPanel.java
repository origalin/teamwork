package edu.nju.presentation.infoui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;

import java.awt.Font;







import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import edu.nju.businesslogic.infobl.Driver;
import edu.nju.businesslogicservice.infologicservice.DriverLogicService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.Time;
import edu.nju.tools.WarningManager;
import edu.nju.vo.CarVO;
import edu.nju.vo.DriverVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;

import java.awt.Dimension;

public class DriverPanel extends JPanel {
	private MyTable table;
	DefaultTableModel model;
	DriverLogicService driverLogicService=UiFactory.getDriverLogicService();
	/**
	 * Create the panel.
	 */
	public DriverPanel(String institutionName) {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{53, 337, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 51, 20, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{35, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		SmallButton button = new SmallButton("\u65B0\u589E");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		// 新增的监听
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.addRow(new Object[]{"","","","","","","","",""});
				
				table.setEnabled(true);
			}
		});
		
		
		SmallButton button_1 = new SmallButton("\u4FEE\u6539");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 0;
		panel_1.add(button_1, gbc_button_1);
		
		// 修改的监听
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setEnabled(true);

			}
		});
		
		SmallButton button_2 = new SmallButton("\u5220\u9664");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 0;
		panel_1.add(button_2, gbc_button_2);
		
		// 删除当前行的监听
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Event) {
				JOptionPane.showConfirmDialog(null,"确认删除当前行吗");
			
		

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
					
						e.printStackTrace();
					
						WarningManager.warning("日期格式错误，应为yyyy-MM-dd，请检查");
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
							
							e.printStackTrace();
					
							WarningManager.warning("网络连接出错，请检查");
						}
					model.removeRow(row);
				}
				table.revalidate();
			}
		});

		
		SmallButton button_3 = new SmallButton("\u67E5\u8BE2");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(null, "请输入关键字:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				if (str != null) {
					findInTable(str);
				}
			}
		});
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		panel_1.add(button_3, gbc_button_3);
		
		SmallButton button_4 = new SmallButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 0;
		panel_1.add(button_4, gbc_button_4);
		
		SmallButton button_5 = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.gridx = 6;
		gbc_button_5.gridy = 0;
		panel_1.add(button_5, gbc_button_5);
		
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				initTable(table,institutionName);
				
			}
		});
		
		
		// 保存的监听

				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
					if(check(table)){
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
									WarningManager.warning("日期格式错误，应为yyyy-MM-dd，请检查");
								}

							DriverPO po= new DriverPO((String) table.getValueAt(i, 0),
										(String) table.getValueAt(i,1), (String) table
												.getValueAt(i, 2), brithday, (String) table
												.getValueAt(i, 4),(String) table
												.getValueAt(i, 5),(String) table
												.getValueAt(i, 6),beginLimit,endLimit);
									try {
										driverLogicService.saveDriver(po);
									} catch (RemoteException e1) {
										e1.printStackTrace();
									
										WarningManager.warning("网络连接出错，请检查");
									}
						}		
						
					}
					
					}
				});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(null);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		
		table = new MyTable();
		table.setPreferredScrollableViewportSize(new Dimension(300, 300));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u53F8\u673A\u7F16\u53F7", "\u53F8\u673A\u59D3\u540D", "\u6027\u522B", "\u51FA\u751F\u65E5\u671F", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u65B9\u5F0F", "\u8F66\u8F86\u5355\u4F4D", "\u884C\u9A76\u8BC1\u521D\u59CB\u65E5\u671F", "\u884C\u9A76\u8BC1\u5931\u6548\u65E5\u671F"
			}
		));
		table.setEnabled(false);
		initTable(table, institutionName);
		
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
	
	void initTable(MyTable table,String institutionName){
		model = (DefaultTableModel) table.getModel();
		table.setEnabled(false);
	
		int row=model.getRowCount();
		for(int i=0;i<row;i++){
			System.out.println(model.getRowCount());
				model.removeRow(0);
		}
		ArrayList<DriverVO> driverList = null;
		try {
			driverList = driverLogicService.getDriveVOList(institutionName);
		} catch (RemoteException e1) {
		
			e1.printStackTrace();
	
			WarningManager.warning("网络连接出错，请检查");
		}
		for (DriverVO vo : driverList) {
			model.addRow(new Object[] {vo.getDriverID(),vo.getName(),vo.getSex(),Time.toDaysTime(vo.getBirthday()),vo.getIdentity(),vo.getTel(),vo.getInstitution(),Time.toDaysTime(vo.getBeginLimit()),Time.toDaysTime(vo.getEndLimit())});
		}
	}
	
	boolean check(MyTable table){
		for (int row = 0; row < table.getRowCount();row++) {
			for(int col=0;col<table.getColumnCount();col++){
				if(((String)table.getValueAt(row, col)).equals("")){
					WarningManager.warning("信息不完整，请检查");
					return false;
				}
			}	
	}
		for (int i = 0; i < table.getRowCount(); i++) {
			
		if(((String) table.getValueAt(i, 0)).length()!=10||
					((String) table.getValueAt(i,4)).length()!=18|| ((String) table
							.getValueAt(i, 5)).length()!=11){
			WarningManager.warning("输入的信息格式有误，请检查");
			return false;
		}
			
	}		
	
		return true;
}
}
