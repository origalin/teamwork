package edu.nju.presentation.logispicqueryui;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.nju.businesslogic.logispicsquerybl.Logisticsquerybl;
import edu.nju.businesslogicservice.logispicsquerylogicservice.LogispicsQueryLogicService;
import edu.nju.presentation.UiFactory;
import edu.nju.vo.PositionVO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.Position;

public class QueryFrame extends JFrame{
	private JTextField textField;
	JTextArea textArea ;
	public QueryFrame() {
		Image image = Toolkit.getDefaultToolkit().getImage(   
	               "images/icon.png"); 

     // 设置标题栏的图标为face.gif  
     this.setIconImage(image);
		textArea = new JTextArea();
		setSize(500, 300);
		setLocation(500, 200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{29, 387, 71, 28, 0};
		gridBagLayout.rowHeights = new int[]{22, 26, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		textField = new JTextField();
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "请先输入快递单号");
				else{
					LogispicsQueryLogicService logicService=UiFactory.getLogisticsQueryService();
					PositionVO vo=logicService.historyQuery(textField.getText());
					if(vo==null)
						JOptionPane.showMessageDialog(null, "不存在该快递单号，请查验重新输入");
					else{
						ArrayList<String> history=vo.getHistory();						
						textArea.append(textField.getText()+":"+'\n');
						String result="";
						for(String temp:history)
							result+=temp+"\n";
						textArea.append(result);
				}			
				}
				
			}
		});
		
		JButton button = new JButton("\u67E5\u8BE2\u4E00\u4E0B");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals(""))
					JOptionPane.showMessageDialog(null, "请先输入快递单号");
				else{
					System.out.println(textField.getText());
					LogispicsQueryLogicService logicService=new Logisticsquerybl();
					PositionVO vo=logicService.historyQuery(textField.getText());
					if(vo==null)
						JOptionPane.showMessageDialog(null, "不存在该快递单号，请查验重新输入");
					else{
						ArrayList<String> history=vo.getHistory();
						
						textArea.append(textField.getText()+":"+'\n');
						String result="";
						for(String temp:history)
							result+=temp+"\n";
						textArea.append(result);
				}
			
				}
				
				
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 1;
		getContentPane().add(button, gbc_button);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void comeout() {
		setVisible(true);
	}
//	public static void main(String args[]){
//		QueryFrame frame=new QueryFrame();
//	}
}
