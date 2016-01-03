package edu.nju.presentation.financeui;
import javax.swing.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import edu.nju.businesslogic.financebl.financebl;
import edu.nju.po.RecordPO;
import edu.nju.presentation.export.ExportExcel;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.vo.exCostIncomDocVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
public class checkCostIncomDocPO extends JPanel{
	/*
	public static void main(String[]args){
		JFrame frame=new JFrame();
		checkCostIncomDocPO ui=new checkCostIncomDocPO("1200003");
		ui.setVisible(true);
		frame.getContentPane().add(ui);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	*/
	financebl bl;
	private MyTextField Income;
	private MyTextField Payment;
	private MyTextField Profit;
	private String staffID;
	public checkCostIncomDocPO(String staffID) {
		setOpaque(false);
		this.staffID=staffID;
		try {
			bl=new financebl();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0,0 , 22, 0, 22, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("\u6210\u672C\u6536\u76CA\u8868");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		add(label, gbc_label);
		
		SmallButton button = new SmallButton("\u5BFC\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExportExcel<exCostIncomDocVO> ex=new ExportExcel<exCostIncomDocVO>();
				String[] headers={"成本","收入","利润"};
				List<exCostIncomDocVO> dataset=new ArrayList<exCostIncomDocVO>();
				dataset.add(new exCostIncomDocVO(Double.parseDouble(Payment.getText()), Double.parseDouble(Income.getText()), Double.parseDouble(Profit.getText())));
				try {
					OutputStream out = new FileOutputStream("D://项目报表导出//成本收益表.xls");		
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
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 0;
		gbc_button.gridy = 1;
		add(button, gbc_button);
		
		JLabel label_1 = new JLabel("\u603B\u6536\u5165");
		label_1.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 3;
		add(label_1, gbc_label_1);
		
		Income = new MyTextField();
		Income.setText(bl.getTotalIncome()+"");
		Income.setEditable(false);
		GridBagConstraints gbc_Income = new GridBagConstraints();
		gbc_Income.insets = new Insets(0, 0, 5, 5);
		gbc_Income.fill = GridBagConstraints.HORIZONTAL;
		gbc_Income.gridx = 5;
		gbc_Income.gridy = 3;
		add(Income, gbc_Income);
		Income.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\u603B\u652F\u51FA");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 5;
		add(lblNewLabel, gbc_lblNewLabel);
		
		Payment = new MyTextField();
		Payment.setText(bl.getTotalPayment()+"");
		Payment.setEditable(false);
		GridBagConstraints gbc_Payment = new GridBagConstraints();
		gbc_Payment.insets = new Insets(0, 0, 5, 5);
		gbc_Payment.fill = GridBagConstraints.HORIZONTAL;
		gbc_Payment.gridx = 5;
		gbc_Payment.gridy = 5;
		add(Payment, gbc_Payment);
		Payment.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel label_2 = new JLabel("\u603B\u5229\u6DA6");
		label_2.setFont(new Font("宋体", Font.PLAIN, 12));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 7;
		add(label_2, gbc_label_2);
		
		Profit = new MyTextField();
		double profit=bl.getTotalIncome()-bl.getTotalPayment();
		Profit.setText(profit+"");
		Profit.setEditable(false);
		GridBagConstraints gbc_Profit = new GridBagConstraints();
		gbc_Profit.insets = new Insets(0, 0, 0, 5);
		gbc_Profit.fill = GridBagConstraints.HORIZONTAL;
		gbc_Profit.gridx = 5;
		gbc_Profit.gridy = 7;
		add(Profit, gbc_Profit);
		Profit.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 6;
		gbc_lblNewLabel_2.gridy = 7;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
	}

}
