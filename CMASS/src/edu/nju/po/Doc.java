package edu.nju.po;

public class Doc {
	String ID;
	boolean isChecked;//表示是否被审核过
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

}
