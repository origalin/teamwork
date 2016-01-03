package edu.nju.presentation.financeui;
import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.table.DefaultTableModel;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.PayDocPO;
import edu.nju.po.PayType;
import edu.nju.po.RecordPO;
import edu.nju.presentation.approveui.checkGatheringDoc;
import edu.nju.presentation.approveui.checkPayDoc;
import edu.nju.presentation.export.ExportExcel;
import edu.nju.presentation.mainui.CheckDialog;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.GatheringDocVO;
import edu.nju.vo.PayDocVO;
import edu.nju.vo.storageItemVO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class checkManageStateDoc extends JPanel{
	/*
	public static void main(String[]args){
		JFrame frame=new JFrame();
		checkManageStateDoc ui=new checkManageStateDoc("12000003");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	*/
	ArrayList<PayDocVO> PayDocVOList=new ArrayList<PayDocVO>();
	ArrayList<GatheringDocVO> GatheringDocVOList=new ArrayList<GatheringDocVO>();
	financebl bl;
	private String staffID;
	private MyTextField textField;
	private MyTextField textField_1;
	private JTable PayDocTable;
	private JTable GatheringDocTable;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private SmallButton button;
	public checkManageStateDoc(String staffID) {
		setOpaque(false);
		this.staffID=staffID;
		try {
			bl=new financebl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 34, 58, 92, 21, 66, 0, 0};
		gridBagLayout.rowHeights = new int[]{43, -10, 0, 12, 97, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u7ECF\u8425\u60C5\u51B5\u8868");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("\u8D77\u59CB\u65F6\u95F4");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		add(label_2, gbc_label_2);
		
		textField = new MyTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7EC8\u6B62\u65F6\u95F4");
		label_3.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 3;
		gbc_label_3.gridy = 2;
		add(label_3, gbc_label_3);
		
		textField_1 = new MyTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		/*
		ArrayList<PayDocVO> tempPayDocList=new ArrayList<PayDocVO>();
		for(int i=0;i<5;i++){
			tempPayDocList.add(null);
		}
		scrollPane.setViewportView(initializeTable(tempPayDocList));
		*/
		
		SmallButton checkButton = new SmallButton("\u67E5\u8BE2");
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startDate=textField.getText().trim();
				String endDate=textField_1.getText().trim();
				
				PayDocVOList=bl.getPayDoc(startDate, endDate);
				GatheringDocVOList=bl.getGatheringDoc(startDate, endDate);
				/*
				//测试代码
				PayDocVOList=new ArrayList<PayDocVO>();
				for(int i=0;i<5;i++){
					PayDocVOList.add(new PayDocVO(100000+i+"", new Date(),(double) 500+i*10, "付款人"+i+"", "付款账户"+i+"", PayType.RENT,"备注"+i+""));
				}
				GatheringDocVOList=new ArrayList<GatheringDocVO>();
				for(int i=0;i<6;i++){
					ArrayList<String> itemIDs=new ArrayList<String>();
					for(int temp=0;temp<5;temp++){
					itemIDs.add(i*1000+temp+"");
					}
					GatheringDocVOList.add(new GatheringDocVO(110000+i+"",new Date(),(double) (1000+i*10),"快递员"+i+"",itemIDs,"付款账号"+i+""));
				}
				*/
				PayDocTable=initializeTable(PayDocVOList);
				PayDocTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
				GatheringDocTable=initializeTable_1(GatheringDocVOList);
				GatheringDocTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
				scrollPane.setViewportView(PayDocTable);
				scrollPane.setOpaque(false);
				scrollPane.getViewport().setOpaque(false);
				scrollPane_1.setViewportView(GatheringDocTable);
				scrollPane_1.setOpaque(false);
				scrollPane_1.getViewport().setOpaque(false);
				updateUI();
			}
		});
		GridBagConstraints gbc_checkButton = new GridBagConstraints();
		gbc_checkButton.insets = new Insets(0, 0, 5, 0);
		gbc_checkButton.gridx = 6;
		gbc_checkButton.gridy = 2;
		add(checkButton, gbc_checkButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		button = new SmallButton("\u5BFC\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//付款单部分
				ExportExcel<PayDocVO> ex1=new ExportExcel<PayDocVO>();
				String[] headers1={"付款单号","日期","钱","付款人","付款账号","付款类型","备注"};
				List<PayDocVO> dataset1=new ArrayList<PayDocVO>();
				for(int temp=0;temp<PayDocVOList.size();temp++){
					dataset1.add(PayDocVOList.get(temp));
				}
				try {
					OutputStream out = new FileOutputStream("D://项目报表导出//经营情况表付款单.xls");		
					ex1.exportExcel(headers1, dataset1, out);		
					out.close();		
					
					System.out.println("excel导出成功！");
				} catch (FileNotFoundException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				} catch (IOException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				}
				//收款单部分
				ExportExcel<GatheringDocVO> ex2=new ExportExcel<GatheringDocVO>();
				String[] headers2={"收款单号","日期","钱","快递员","寄件单编号列表"};
				List<GatheringDocVO> dataset2=new ArrayList<GatheringDocVO>();
				for(int temp=0;temp<GatheringDocVOList.size();temp++){
					dataset2.add(GatheringDocVOList.get(temp));
				}
				try {
					OutputStream out = new FileOutputStream("D://项目报表导出//经营情况表收款单.xls");		
					ex2.exportExcel(headers2, dataset2, out);		
					out.close();		
					
					System.out.println("excel导出成功！");
				} catch (FileNotFoundException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				} catch (IOException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				}
				/*
				 * ExportExcel<storageItemVO> ex = new ExportExcel<storageItemVO>();
				String[] headers ={ "快递编号", "入库日期", "目的地", "区","排号", "架号", "位号" ,"仓库编号"};
				List<storageItemVO> dataset=new ArrayList<storageItemVO>() ;
				List<storageItemVO> dataset_1=new ArrayList<storageItemVO>() ;
				List<storageItemVO> dataset_2=new ArrayList<storageItemVO>() ;
				
				for(RecordPO temp:list)	    {	dataset.add(new storageItemVO(temp));}
				for(RecordPO temp:list_1)	{	dataset_1.add(new storageItemVO(temp));}
				for(RecordPO temp:list_2)	{	dataset_2.add(new storageItemVO(temp));}
		
				try {
					OutputStream out = new FileOutputStream("D://b.xls");		
					ex.exportExcel(headers, dataset, out);		
					out.close();		
					
					System.out.println("excel导出成功！");
				} catch (FileNotFoundException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				} catch (IOException exce) {
					// TODO Auto-generated catch block
					exce.printStackTrace();
				}
			}
				 */
			
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 6;
		gbc_button.gridy = 3;
		add(button, gbc_button);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		PayDocTable = new JTable();
		PayDocTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		scrollPane.setViewportView(PayDocTable);
		PayDocTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u4ED8\u6B3E\u5355"
			}
		));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setOpaque(false);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 4;
		add(scrollPane_1, gbc_scrollPane_1);
		
		GatheringDocTable = new JTable();
		GatheringDocTable.setPreferredScrollableViewportSize(new Dimension(200, 200));
		scrollPane_1.setViewportView(GatheringDocTable);
		GatheringDocTable.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"\u6536\u6B3E\u5355"
			}
		));
		
		/*
		ArrayList<GatheringDocVO> tempGatheringDocList=new ArrayList<GatheringDocVO>();
		for(int i=0;i<5;i++){
			tempGatheringDocList.add(null);
		}
		scrollPane_1.setViewportView(initializeTable_1(tempGatheringDocList));
		*/
	}

	public JTable initializeTable(ArrayList<PayDocVO> vo ){
		JTable table = new JTable();
		Object[][] PayDocList=new Object[vo.size()][];
		for(int i=0;i<vo.size();i++){
			if(vo.get(i)!=null){
			Object[] oneLine={vo.get(i).getID()};
			PayDocList[i]=oneLine;
			}else{
				PayDocList[i]=null;
			}
		}
		table.setModel(new DefaultTableModel(
			PayDocList,
			new String[] {
				"\u4ED8\u6B3E\u5355"
			}
		));
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				 int r= table.getSelectedRow();
	             int c= table.getSelectedColumn();
	              //得到选中的单元格的值，表格中都是字符串
	              String value= (String) table.getValueAt(r, c);
	              PayDocVO vo=getPayDocByID(value);
	              CheckDialog dialog=new CheckDialog();
	              checkPayDoc ui=new checkPayDoc(vo);
	              dialog.setCheckMode(ui);
	              /*
	              CheckDialog dialog=new CheckDialog();
	              dialog.setSize(500,500);
	              checkPayDoc ui=new checkPayDoc(vo);
	              dialog.getContentPane().add(ui);
	              dialog.setVisible(true);
	              */
	              /*
	               CheckDialog dialog=new CheckDialog();
						dialog.setSize(500,500);
						checkGatheringDoc  ui=new checkGatheringDoc();
						ui.getTextField_2().setText(po.getID());
						ui.getTextField().setText(DateToString(po.getDate()));
						ui.getTextField_4().setText(po.getCourier_name());
						ui.getTextField_3().setText(po.getMoney().toString());
						ui.getTextField_1().setText(po.getAccount());
						ui.getScrollPane().setViewportView(ui.initializeTable(po.getItemIDs()));
					
						dialog.getContentPane().add(ui);
						dialog.setVisible(true);
	               */
			}
		});
		return table;
	}
	
	public JTable initializeTable_1(ArrayList<GatheringDocVO> vo ){
		JTable table= new JTable();
		Object[][] GatheringDocList=new Object[vo.size()][];
		for(int i=0;i<vo.size();i++){
			if(vo.get(i)!=null){
			Object[] oneLine={vo.get(i).getID()};
			GatheringDocList[i]=oneLine;
			}else{
				Object[] oneLine={null};
				GatheringDocList[i]=oneLine;
			}
			/*
			 *if(vo.get(i)!=null){
			Object[] oneLine={vo.get(i).getID()};
			PayDocList[i]=oneLine;
			}else{
				PayDocList[i]=null;
			}
			 */
			
		}
		table.setModel(new DefaultTableModel(
				GatheringDocList,
			new String[] {
						"\u6536\u6B3E\u5355"
			}
		));
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				 int r= table.getSelectedRow();
	             int c= table.getSelectedColumn();
	              //得到选中的单元格的值，表格中都是字符串
	              String value= (String) table.getValueAt(r, c);
	              GatheringDocVO vo=getGatheringDocByID(value);
	              CheckDialog dialog=new CheckDialog();
	              checkGatheringDoc ui=new checkGatheringDoc(vo);
	              dialog.setCheckMode(ui);
			}
		});
		
		return table;
	}
	
	public PayDocVO getPayDocByID(String ID){
		for(PayDocVO vo:PayDocVOList){
			if(vo.getID().equals(ID)){
				return vo;
			}
		}
		return null;
	}
	
	public GatheringDocVO getGatheringDocByID(String ID){
		for(GatheringDocVO vo:GatheringDocVOList){
			if(vo.getID().equals(ID)){
				return vo;
			}
		}
		return null;
	}

}
