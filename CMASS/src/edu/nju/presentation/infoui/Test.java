package edu.nju.presentation.infoui;

import java.rmi.RemoteException;
import java.text.ParseException;

import javax.swing.JFrame;

import edu.nju.presentation.systemui.OperationPanel;

public class Test {
public static void main(String[] args) throws RemoteException, ParseException {
	JFrame frame = new JFrame();
frame.setVisible(true);
//frame.add(new CarPanel("�Ͼ��й�¥Ӫҵ��"));
//frame.add(new OperationPanel());
//frame.add(new DistancePanel());
frame.add(new DriverPanel("�Ͼ��й�¥Ӫҵ��"));
//frame.add(new InstitutionPanel());
}
}
