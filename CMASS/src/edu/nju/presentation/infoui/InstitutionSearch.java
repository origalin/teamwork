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

public class InstitutionSearch extends JDialog{
	private MyTextField textField_1;
	private MyTextField textField_3;
	private MyTextField textField;
	private MyTextField textField_2;
	InstitutionLogicService institutionLogicService=UiFactory.getInstitutionLogicService();
	ImageIcon imageIcon = new ImageIcon("images/dback.png");
	InstitutionPO po=null;
	
	/**
	 * Create the panel.
	 */
	public InstitutionSearch(String institutionName) {
		try {
			po=institutionLogicService.getInstitutionPO(institutionLogicService.getID(institutionName));
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();WarningManager.warning("�������Ӵ�������");
		}
		
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
		
		MyTextField myTextField_1 = new MyTextField();
		myTextField_1.setText(String.valueOf(po.getType()));
		myTextField_1.setEditable(false);
		myTextField_1.setText((String) null);
		myTextField_1.setEditable(false);
		myTextField_1.setColumns(10);
		GridBagConstraints gbc_myTextField_1 = new GridBagConstraints();
		gbc_myTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_myTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_myTextField_1.gridx = 2;
		gbc_myTextField_1.gridy = 1;
		panel_1.add(myTextField_1, gbc_myTextField_1);
		
		JLabel label_2 = new JLabel("\u673A\u6784\u7F16\u53F7");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		textField_1 = new MyTextField();
		textField_1.setText(po.getId());
		textField_1.setEditable(false);
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
		
		MyTextField myTextField = new MyTextField();
		myTextField.setText(String.valueOf(po.getCity()));
		textField.setEditable(false);
		myTextField.setText((String) null);
		myTextField.setEditable(false);
		myTextField.setColumns(10);
		GridBagConstraints gbc_myTextField = new GridBagConstraints();
		gbc_myTextField.insets = new Insets(0, 0, 5, 5);
		gbc_myTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_myTextField.gridx = 2;
		gbc_myTextField.gridy = 2;
		panel_1.add(myTextField, gbc_myTextField);
		
		JLabel label_4 = new JLabel("\u673A\u6784\u540D\u79F0");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 4;
		gbc_label_4.gridy = 2;
		panel_1.add(label_4, gbc_label_4);
		
		textField_3 = new MyTextField();
		textField_3.setText(po.getName());
		textField_3.setEditable(false);
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
		textField.setText(po.getParentInstitution());
		textField.setEditable(false);
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
		textField_2.setText(String.valueOf(po.getRent()));
		textField_2.setEditable(false);
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
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 5;
		gbc_button.gridy = 5;
		panel_1.add(button, gbc_button);
		
		//ok
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
			dispose();
			}
		});

	}

}
