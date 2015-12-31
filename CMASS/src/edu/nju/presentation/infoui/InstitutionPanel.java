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
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.Time;
import edu.nju.vo.CarVO;
import edu.nju.vo.InstitutionVO;
import edu.nju.vo.StaffVO;
import java.awt.Dimension;

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
		setOpaque(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 527, 0};
		gridBagLayout.rowHeights = new int[]{501, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		add(scrollPane_1, gbc_scrollPane_1);
		scrollPane_1.setOpaque(false);
		scrollPane_1.getViewport().setOpaque(false);
		tree = new JTree();
		tree.setMaximumSize(new Dimension(30, 30));
	
		try {
			institutionList = institutionLogicService.getInstitutionVOList();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		//tree�ļ���
		treeListener(tree);
	
		scrollPane_1.setViewportView(tree);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{66, 85, 81, 0, 154, 0};
		gbl_panel_1.rowHeights = new int[]{23, 23, 418, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		SmallButton btnNewButton = new SmallButton("\u589E\u52A0\u673A\u6784");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		
		
		//���ӻ���
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InstitutionAdd addInstitution=new InstitutionAdd();
				addInstitution.setVisible(true);
		
			}
		});
		
		
		SmallButton button = new SmallButton("\u5220\u9664\u673A\u6784");
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
						       "�Ƿ�ȷ��ɾ����", "ɾ��", JOptionPane.YES_NO_OPTION,
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
		
		SmallButton button_1 = new SmallButton("\u4FEE\u6539\u673A\u6784");
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
				addInstitution.setVisible(true);
			}
		});
		
		SmallButton button_7 = new SmallButton("\u67E5\u8BE2\u673A\u6784");
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
	
		SmallButton button_8 = new SmallButton("\u4FDD\u5B58");
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.anchor = GridBagConstraints.EAST;
		gbc_button_8.insets = new Insets(0, 0, 5, 0);
		gbc_button_8.gridx = 4;
		gbc_button_8.gridy = 0;
		panel_1.add(button_8, gbc_button_8);
		
		
		//����
		button_8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(check(table)){
				table.setEnabled(false);
				StaffPO po = null;

				for (int row = 0; row < table.getRowCount();row++) {
		
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
				treeListener(tree);
				
			}
		});
		
		SmallButton button_3 = new SmallButton("\u65B0\u589E\u4EBA\u5458");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 0;
		gbc_button_3.gridy = 1;
		panel_1.add(button_3, gbc_button_3);
		
		
		//������Ա
		button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				model.addRow(new Object[]{"","","","","",""});
				
				table.setEnabled(true);
			}
		});
		
		SmallButton button_4 = new SmallButton("\u5220\u9664\u4EBA\u5458");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 1;
		panel_1.add(button_4, gbc_button_4);
		
		//ɾ����Ա
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
		
		SmallButton button_5 = new SmallButton("\u4FEE\u6539\u4EBA\u5458");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 1;
		panel_1.add(button_5, gbc_button_5);
		
		//�޸���Ա
		button_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table.setEnabled(true);
				
			}
		});
		
		SmallButton button_2 = new SmallButton("\u67E5\u8BE2\u4EBA\u5458");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		panel_1.add(button_2, gbc_button_2);
		
		//��ѯ��Ա
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
		
		SmallButton button_6 = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.anchor = GridBagConstraints.EAST;
		gbc_button_6.insets = new Insets(0, 0, 5, 0);
		gbc_button_6.gridx = 4;
		gbc_button_6.gridy = 1;
		panel_1.add(button_6, gbc_button_6);
		
		//ȡ��
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
		scrollPane.setMaximumSize(new Dimension(200, 200));
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
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
		table.setPreferredScrollableViewportSize(new Dimension(300, 300));
		
		
		
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
		String[] post={"�ܾ���","�߼�����","���","��ת����ҵ��Ա","�ֿ������Ա","Ӫҵ��ҵ��Ա","���Ա","����Ա"};
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
			new DefaultMutableTreeNode("�ܲ�") {
				{
					DefaultMutableTreeNode node_1;
					DefaultMutableTreeNode node_2;
					DefaultMutableTreeNode node_3;
					DefaultMutableTreeNode node_4;
					node_1 = new DefaultMutableTreeNode("��ת����");
				
					for(InstitutionVO vo:institutionList){
						if(vo.getParentInstitution().equals("0")){
							node_2=new DefaultMutableTreeNode(vo.getName());
							
							node_3=new DefaultMutableTreeNode("�ֿ�");
							node_4=new DefaultMutableTreeNode("Ӫҵ��");
							
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
	
	boolean check(MyTable table){
		for (int row = 0; row < table.getRowCount();row++) {
			for(int col=0;col<table.getColumnCount();col++){
				if(((String)table.getValueAt(row, col)).equals("")){
					JOptionPane.showMessageDialog(null,"��Ϣ������������");
					return false;
				}
			}
			
		
	}
		for (int row = 0; row < table.getRowCount();row++) {
			
				if(((String)table.getValueAt(row, 0)).length()>11||((String)table.getValueAt(row, 3)).length()>18||((String)table.getValueAt(row, 4)).length()>11){
					JOptionPane.showMessageDialog(null,"��Ϣ��ʽ����������");
					return false;
				}
			}
		return true;
}
	
}
