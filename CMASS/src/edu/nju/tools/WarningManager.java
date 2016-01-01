package edu.nju.tools;

import edu.nju.presentation.mainui.CheckDialog;

public class WarningManager {
	static CheckDialog cDialog;
	public static void warning(String s) {
		cDialog = new CheckDialog();
		cDialog.setWarningMode(s);
	}
}
