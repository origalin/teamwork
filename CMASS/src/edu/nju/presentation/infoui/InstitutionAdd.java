package edu.nju.presentation.infoui;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;









import edu.nju.businesslogicservice.infologicservice.InstitutionLogicService;
import edu.nju.po.Institutation;
import edu.nju.po.InstitutionPO;
import edu.nju.presentation.UiFactory;
import edu.nju.presentation.widget.MyComboBox;
import edu.nju.presentation.widget.MyTextField;
import edu.nju.presentation.widget.SmallButton;
import edu.nju.tools.WarningManager;

public class InstitutionAdd extends JDialog{
	private MyTextField textField_1;
	private MyTextField textField_3;
	private MyTextField textField;
	private MyTextField textField_2;
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	ImageIcon imageIcon = new ImageIcon("images/dback.png");
	
	/**
	 * Create the panel.
	 */
	public InstitutionAdd() {
		JLabel back = new JLabel(imageIcon);
		back.setSize(imageIcon.getIconWidth(),imageIcon.getIconHeight());
		getLayeredPane().setLayout(null);
		getLayeredPane().add(back, new Integer(Integer.MIN_VALUE));
		((JPanel)getContentPane()).setOpaque(false);
		
		
		setBounds(0,0,503, 242);
		
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{218, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 28, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label_1 = new JLabel("\u673A\u6784\u7C7B\u578B");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
		MyComboBox comboBox = new MyComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4E2D\u8F6C\u4E2D\u5FC3", "\u8425\u4E1A\u5385", "\u4ED3\u5E93"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);
		
		JLabel label_2 = new JLabel("\u673A\u6784\u7F16\u53F7");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		textField_1 = new MyTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 1;
		panel_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u673A\u6784\u6240\u5728\u5730");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 2;
		panel_1.add(label_3, gbc_label_3);
		
		MyComboBox comboBox_1 = new MyComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u5357\u4EAC", "\u4E0A\u6D77", "\u5317\u4EAC", "\u6DF1\u5733", "\u5E7F\u5DDE"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panel_1.add(comboBox_1, gbc_comboBox_1);
		
		JLabel label_4 = new JLabel("\u673A\u6784\u540D\u79F0");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 2;
		panel_1.add(label_4, gbc_label_4);
		
		textField_3 = new MyTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 5;
		gbc_textField_3.gridy = 2;
		panel_1.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("\u4E0A\u7EA7\u673A\u6784\u7F16\u53F7");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 3;
		panel_1.add(label_5, gbc_label_5);
		
		textField = new MyTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u79DF\u91D1");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.anchor = GridBagConstraints.EAST;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 4;
		gbc_label_6.gridy = 3;
		panel_1.add(label_6, gbc_label_6);
		
		textField_2 = new MyTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 5;
		gbc_textField_2.gridy = 3;
		panel_1.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		SmallButton button = new SmallButton("\u786E\u8BA4");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridwidth = 2;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 5;
		panel_1.add(button, gbc_button);
		
		//ok
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			InstitutionPO po=null;
			try{
			po=new InstitutionPO(textField_1.getText(), Institutation.valueOf((String)comboBox.getSelectedItem()), textField_3.getText(),(String)comboBox_1.getSelectedItem(), textField.getText(),Double.valueOf( textField_2.getText()), false);
			}
			catch(NumberFormatException e1){
				WarningManager.warning("���ݸ�ʽ��������");
			}
			try {	institutionLogicService.saveInstitution(po);
			} catch (RemoteException e) {
				e.printStackTrace();
				WarningManager.warning("�������Ӵ�������");
			}
			dispose();
			}
		});
		
		
		SmallButton button_1 = new SmallButton("\u53D6\u6D88");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.gridwidth = 2;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 5;
		panel_1.add(button_1, gbc_button_1);
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

}
