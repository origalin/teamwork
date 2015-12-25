package edu.nju.presentation.infoui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTree;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JButton;
import javax.swing.JTabbedPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.CarPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.Post;
import edu.nju.po.StaffPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyTable;
import edu.nju.tools.Time;
import edu.nju.vo.CarVO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;

public class InstitutionPanel extends JPanel {
	private MyTable table;
	DefaultTableModel model;
	private JTree tree ;
	ArrayList<InstitutionVO> institutionList = null;
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	/**
	 * Create the panel.
	 */
	public InstitutionPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 527, 0};
		gridBagLayout.rowHeights = new int[]{56, 501, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		add(panel_3, gbc_panel_3);
		
		JLabel label = new JLabel("\u4EBA\u5458\u4E0E\u673A\u6784\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 23));
		panel_3.add(label);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		add(scrollPane_1, gbc_scrollPane_1);
		
		tree = new JTree();
	
		try {
			institutionList = institutionLogicService.getInstitutionVOList();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//tree的监听
		treeListener(tree);
	
		scrollPane_1.setViewportView(tree);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{66, 85, 81, 0, 154, 0};
		gbl_panel_1.rowHeights = new int[]{23, 23, 418, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u673A\u6784");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		
		//增加机构
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InstitutionAdd addInstitution=new InstitutionAdd();
			}
		});
		
		
		JButton button = new JButton("\u5220\u9664\u673A\u6784");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 0;
		panel_1.add(button, gbc_button);
		
		//delete
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String str = JOptionPane.showInputDialog(null, "Find:", "Find",
							JOptionPane.QUESTION_MESSAGE);
					
					if (str != null) {
						findInTree(tree,str);
					}
					  DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					int option = JOptionPane.showConfirmDialog(null,
						       "是否确认删除？", "删除", JOptionPane.YES_NO_OPTION,
						       JOptionPane.WARNING_MESSAGE, null);
						     switch (option) {
						     case JOptionPane.YES_NO_OPTION: {
						    	 try {
									institutionLogicService.deleteInstitution(note.toString());
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						      break;
						     }
						     case JOptionPane.NO_OPTION:
						      System.exit(0);

						     }
				
				}
		});
		
		JButton button_1 = new JButton("\u4FEE\u6539\u673A\u6784");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.NORTH;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 2;
		gbc_button_1.gridy = 0;
		panel_1.add(button_1, gbc_button_1);
		
		//change
	
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InstitutionAdd addInstitution=new InstitutionAdd();
			}
		});
		
		JButton button_7 = new JButton("\u67E5\u8BE2\u673A\u6784");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 3;
		gbc_button_7.gridy = 0;
		panel_1.add(button_7, gbc_button_7);
		
		button_7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				
				if (str != null) {
					findInTree(tree,str);
				}
			}
		});
	
		JButton button_8 = new JButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.anchor = GridBagConstraints.EAST;
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 4;
		gbc_button_8.gridy = 0;
		panel_1.add(button_8, gbc_button_8);
		
		
		//保存
		button_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				table.setEnabled(false);
				StaffPO po = null;

				for (int row = 0; row < table.getRowCount();row++) {
					if(((String) table.getValueAt(row, 0)).equals("")||
							((String) table.getValueAt(row,1)).equals("")||((String) table
									.getValueAt(row, 2)).equals("")||((String) table
									.getValueAt(row, 3)).equals("")||((String) table
									.getValueAt(row, 4)).equals("")||((String)table.getValueAt(row, 5)).equals("")){
						JOptionPane.showMessageDialog(null,"信息未填完整，请检查");
						continue;
					}
					try {
						po = new StaffPO((String) table.getValueAt(row, 0),
								(String) table.getValueAt(row,1), (String) table
										.getValueAt(row, 2), (String) table
										.getValueAt(row, 3), (String) table
										.getValueAt(row, 4),institutionLogicService.getID(((DefaultMutableTreeNode) tree.getLastSelectedPathComponent()).toString()),Post.valueOf((String)table.getValueAt(row, 5)));
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							try {
								institutionLogicService.saveStaff(po);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				}		
				
			}
		});
		
		JButton button_3 = new JButton("\u65B0\u589E\u4EBA\u5458");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 1;
		panel_1.add(button_3, gbc_button_3);
		
		
		//新增人员
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				model.addRow(new Object[]{"","","","","",""});
				
				table.setEnabled(true);
			}
		});
		
		JButton button_4 = new JButton("\u5220\u9664\u4EBA\u5458");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 1;
		panel_1.add(button_4, gbc_button_4);
		
		//删除人员
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					String str = JOptionPane.showInputDialog(null, "Find:", "Find",
							JOptionPane.QUESTION_MESSAGE);
					
					if (str != null) {
						findInTable(str);
					}

					int row = table.getSelectedRow();
					if (row >= 0) {
					
						StaffPO po = null;
						try {
							po = new StaffPO((String) table.getValueAt(row, 0),
									(String) table.getValueAt(row,1), (String) table
											.getValueAt(row, 2), (String) table
											.getValueAt(row, 3), (String) table
											.getValueAt(row, 4),institutionLogicService.getID(tree.getSelectionPath().toString()),Post.valueOf((String)table.getValueAt(row, 5)));
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
			
								try {
									institutionLogicService.deleteStaff(po);
								} catch (RemoteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					
						model.removeRow(row);
					}
					table.revalidate();
				}
				
			
		});
		
		JButton button_5 = new JButton("\u4FEE\u6539\u4EBA\u5458");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 1;
		panel_1.add(button_5, gbc_button_5);
		
		//修改人员
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.setEnabled(true);
				
			}
		});
		
		JButton button_2 = new JButton("\u67E5\u8BE2\u4EBA\u5458");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
		//查询人员
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = JOptionPane.showInputDialog(null, "Find:", "Find",
						JOptionPane.QUESTION_MESSAGE);
				System.out.println("S");
				if (str != null) {
					findInTable(str);
				}
				
			}
		});
		
		JButton button_6 = new JButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.anchor = GridBagConstraints.EAST;
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 4;
		gbc_button_6.gridy = 1;
		panel_1.add(button_6, gbc_button_6);
		
		//取消
		button_6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.setEnabled(false);
				model=(DefaultTableModel)table.getModel();
				int row=model.getRowCount();
				for(int i=0;i<row;i++){
					System.out.println(model.getRowCount());
						model.removeRow(0);
				}
					treeListener(tree);	
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setToolTipText("");
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		table = new MyTable();
		
		
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			"\u5458\u5DE5\u5DE5\u53F7", "\u5458\u5DE5\u59D3\u540D", "\u6027\u522B", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u7535\u8BDD", "\u804C\u4F4D"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(139);
		table.getColumnModel().getColumn(2).setPreferredWidth(103);
		table.getColumnModel().getColumn(5).setPreferredWidth(179);
		
		table.setEnabled(false);

		model = (DefaultTableModel) table.getModel();
		MyComboBox courierBox = new MyComboBox();
		String[] post={"总经理","高级财务","会计","中转中心业务员","仓库管理人员","营业厅业务员","快递员","管理员"};
		courierBox.setModel(new DefaultComboBoxModel<String>(post));
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(5).setCellEditor(new DefaultCellEditor(courierBox));
		
		ArrayList<StaffVO> staffList=new ArrayList<StaffVO>();
		for (StaffVO vo:staffList) {
			model.addRow(new Object[] { vo.getStaffID(),vo.getName(),vo.getSex(),vo.getIdenity(),vo.getTel(),String.valueOf(vo.getPost())});
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	private void findInTree(JTree tree,String str)
	{
	Object root = tree.getModel().getRoot();
	TreePath treePath = new TreePath(root);
	treePath = findInPath(tree,treePath, str);
	if (treePath != null) {
	tree.setSelectionPath(treePath);
	tree.scrollPathToVisible(treePath);
	}
	}

	private TreePath findInPath(JTree tree,TreePath treePath, String str)
	{
	Object object = treePath.getLastPathComponent();
	if (object == null) {
	return null;
	}

	String value = object.toString();
	if (str.equals(value)) {
	return treePath;
	}
	else {
	TreeModel model = tree.getModel();
	int n = model.getChildCount(object);
	for (int i = 0; i < n; i++) {
	Object child = model.getChild(object, i);
	TreePath path = treePath.pathByAddingChild(child);

	path = findInPath(tree,path, str);
	if (path != null) {
	return path;
	}
	}
	return null;
	}
	}

	private void findInTable(String str)
	{
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
	
	void treeListener(JTree tree){
		DefaultTreeCellRenderer render=new DefaultTreeCellRenderer();
		tree.setCellRenderer(render);
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			ArrayList<StaffVO> staffVOs=new ArrayList<StaffVO>();
			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				
				model=(DefaultTableModel)table.getModel();
				int row=model.getRowCount();
				for(int i=0;i<row;i++){
					System.out.println(model.getRowCount());
						model.removeRow(0);
				}
				
				  DefaultMutableTreeNode note = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
		
				try {
				 staffVOs=institutionLogicService.getStaffVOList(note.toString());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model = (DefaultTableModel) table.getModel();
				for (StaffVO vo:staffVOs) {
					model.addRow(new Object[] { vo.getStaffID(),vo.getName(),vo.getSex(),vo.getIdenity(),vo.getTel(),String.valueOf(vo.getPost())});
				}
				updateUI();
				
			}
		});
		
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("总部") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					DefaultMutableTreeNode node_4;
					node_1 = new DefaultMutableTreeNode("中转中心");
					node_3=new DefaultMutableTreeNode("仓库");
					node_4=new DefaultMutableTreeNode("营业厅");
					for(InstitutionVO vo:institutionList){
						if(vo.getParentInstitution().equals("0")){
							node_2=new DefaultMutableTreeNode(vo.getName());
							
						
							
							node_2.add(node_3);
							node_2.add(node_4);
							for(InstitutionVO vo1:institutionList){
								if(vo1.getParentInstitution().equals(vo.getId())&&vo1.getId().toString().length()==6){
									node_3.add(new DefaultMutableTreeNode(vo1.getName()));
								}else if(vo1.getParentInstitution().equals(vo.getId())&&vo1.getId().toString().length()==7){
									node_4.add(new DefaultMutableTreeNode(vo1.getName()));
								}
							}
							node_1.add(node_2);				
						}
					}
					add(node_1);
				}}
		));
	}
	
	
}
