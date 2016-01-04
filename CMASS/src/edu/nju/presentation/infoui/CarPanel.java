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









import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;




import edu.nju.businesslogic.infobl.Car;
import edu.nju.businesslogicservice.infologicservice.CarLogicService;
import edu.nju.po.CarPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyScrollPane;
import edu.nju.presentation.widget.MyTable;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.MyDialog;
import edu.nju.tools.Time;
import edu.nju.tools.WarningManager;
import edu.nju.vo.CarVO;

import javax.swing.JButton;





import java.awt.Dimension;

public class CarPanel extends JPanel {
	private MyTable table;
	DefaultTableModel model;
	CarLogicService carBl =UiFactory.getCarLogicService();
	MyDialog d=new MyDialog();
	 String str="";
	

	/**
	 * Create the panel.
	 * @throws RemoteException 
	 */

	public CarPanel(String institutionName) throws RemoteException {
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 320, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0,
				Double.MIN_VALUE };
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
		gbl_panel_1.columnWidths = new int[] { 0, 0, 57, 64, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 49, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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

				model.addRow(new Object[]{"","","","","","",""});
				
				table.setEnabled(true);
			}
		});

		SmallButton button_1 = new SmallButton("\u4FEE\u6539\r\n");
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
							WarningManager.warning("网络连接出错，请检查");
						}
					model.removeRow(row);
				}
				table.revalidate();
			}
		});

		SmallButton button_3 = new SmallButton("\u67E5\u8BE2");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 0;
		panel_1.add(button_3, gbc_button_3);

		// 查询的监听

		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				d.setVisible(true);
				d.btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					
						str=d.textField.getText();
						if (str != null) {
					findInTable(str);
				}
				d.dispose();			
					}
				});
				System.out.println(str);
				
				
			}
		});

		SmallButton button_4 = new SmallButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 5;
		gbc_button_4.gridy = 0;
		panel_1.add(button_4, gbc_button_4);
		
	

		// 保存的监听

		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
			
				if(check(table)){
				
				table.setEnabled(false);
				for (int i = 0; i < table.getRowCount(); i++) {
					CarPO carPO;
						Date date = null;
						int year=0;
						try {
							date=df.parse( (String) table.getValueAt(i, 5));
						} catch (ParseException e1) {
							e1.printStackTrace();
							WarningManager.warning("日期格式错误，应为yyyy-MM-dd，请检查");
						}	
						try{
						year=Integer.valueOf( (String) table.getValueAt(i, 6));
						}catch(NumberFormatException e1){
							e1.printStackTrace();
							WarningManager.warning("输入的服役时间有误，请检查");
						}
				System.out.println(year);
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
						
								WarningManager.warning("网络连接出错，请检查");
							}
				}		
				
			}
			}
		});
		SmallButton button_5 = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.gridx = 6;
		gbc_button_5.gridy = 0;
		panel_1.add(button_5, gbc_button_5);
		
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				initTable(table, institutionName);
			}
		});
		
		
		
		MyScrollPane scrollPane = new MyScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.getViewport().setBorder(null);
		scrollPane.setViewportBorder(null);
		
		table = new MyTable();
		table.setPreferredScrollableViewportSize(new Dimension(300, 300));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"\u8F66\u8F86\u4EE3\u53F7", "\u53D1\u52A8\u673A\u53F7",
				"\u8F66\u724C\u53F7", "\u5E95\u76D8\u53F7",
				"\u8F66\u8F86\u5355\u4F4D", "\u8D2D\u4E70\u65F6\u95F4",
				"\u670D\u5F79\u65F6\u95F4" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(149);
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
		
		table.setEnabled(false);
		model=(DefaultTableModel)table.getModel();
		int row=model.getRowCount();
		for(int i=0;i<row;i++){
			System.out.println(model.getRowCount());
				model.removeRow(0);
		}
	

		ArrayList<CarVO> carList = null;
		try {
			carList = carBl.getCarList(institutionName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			WarningManager.warning("网络连接出错，请检查");
		}
		for (CarVO vo : carList) {
			model.addRow(new Object[] { vo.getCarID(), vo.getEngineID(),
					vo.getPlateID(), vo.getUnderpanID(),
					vo.getInstitutionName(), Time.toDaysTime(vo.getBuyTime()), String.valueOf(vo.getYears()) });
		}
	}
	boolean check(MyTable table){
	
		for (int row = 0; row < table.getRowCount();row++) {
			for(int col=0;col<table.getColumnCount();col++){
				if(((String)table.getValueAt(row, col)).equals(""))
				{
					
					WarningManager.warning("信息不完整，请检查");
					return false;
				}
			}
			
		
	}
	
		for (int i = 0; i < table.getRowCount(); i++) {
		if(((String) table.getValueAt(i, 0)).length()!=10){
		WarningManager.warning("车辆代号格式不符，请检查");
			return false;
				
		}
		}
		
		return true;
	}
}