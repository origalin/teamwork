package edu.nju.presentation.infoui;

import java.rmi.RemoteException;
import java.text.ParseException;

import javax.swing.JFrame;

import edu.nju.presentation.systemui.AccountPanel;
import edu.nju.presentation.systemui.OperationPanel;

public class Test {
public static void main(String[] args) throws RemoteException, ParseException {
	JFrame frame = new JFrame();

frame.setSize(770, 500);
//frame.add(new CarPanel("南京市鼓楼营业厅"));
//frame.add(new OperationPanel());
//frame.add(new DistancePanel());

//frame.add(new DriverPanel("南京市鼓楼营业厅"));
//frame.add(new InstitutionPanel());
//frame.add(new AccountPanel());
frame.add(new SalaryPanel());

frame.setVisible(true);
}
}
