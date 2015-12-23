package edu.nju.presentation.mainui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import edu.nju.presentation.collectionui.CollertionPanel;
import edu.nju.presentation.transformui.SendPanel;
import edu.nju.presentation.widget.BigButton;

import java.awt.Color;
import java.awt.Font;

public class GuidePanel_Courier extends JPanel{
	String institutionID;
	String staffID;
	MainFrame frame;
	CollertionPanel collertionPanel;
	SendPanel sendPanel;
	ArrayList<BigButton> buttons = new ArrayList<>();
	public GuidePanel_Courier(MainFrame frame,String staffID) {
		this.staffID = staffID;
		this.frame = frame;
		collertionPanel = new CollertionPanel(staffID);
		sendPanel = new SendPanel(staffID);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{66, 64, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		BigButton collectButtom = new BigButton("\u63FD\u4EF6");
		collectButtom.setForeground(Color.BLACK);
		collectButtom.setPressed();
		collectButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				clean();
				collectButtom.setPressed();
				collectFunc();
			}
		});
		GridBagConstraints gbc_collectButtom = new GridBagConstraints();
		gbc_collectButtom.anchor = GridBagConstraints.WEST;
		gbc_collectButtom.fill = GridBagConstraints.VERTICAL;
		gbc_collectButtom.insets = new Insets(0, 0, 0, 0);
		gbc_collectButtom.gridx = 0;
		gbc_collectButtom.gridy = 0;
		add(collectButtom, gbc_collectButtom);
		
		BigButton sendButtom = new BigButton("\u6D3E\u4EF6");
		sendButtom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				clean();
				sendButtom.setPressed();
				sendFunc();
			}
		});
		GridBagConstraints gbc_sendButtom = new GridBagConstraints();
		gbc_sendButtom.anchor = GridBagConstraints.WEST;
		sendButtom.setForeground(Color.BLACK);
		gbc_sendButtom.fill = GridBagConstraints.VERTICAL;
		gbc_sendButtom.insets = new Insets(0, 0, 0, 0);
		gbc_sendButtom.gridx = 0;
		gbc_sendButtom.gridy = 1;
		add(sendButtom, gbc_sendButtom);
		buttons.add(sendButtom);
		buttons.add(collectButtom);
		setOpaque(false);
	}
	void collectFunc(){
		frame.setFunctionPanel(collertionPanel);
	}
	void sendFunc() {
		frame.setFunctionPanel(sendPanel);
	}
	void clean() {
		for(BigButton bt:buttons) {
			bt.setNormal();
		}
	}
}
