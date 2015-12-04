package edu.nju.presentation.infoui;

import java.rmi.RemoteException;

import javax.swing.JFrame;

public class Test {
public static void main(String[] args) throws RemoteException {
	JFrame frame = new JFrame();
frame.setVisible(true);
frame.add(new CarPanel("南京市鼓楼营业厅"));
}
}
