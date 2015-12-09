package edu.nju.po;

import java.awt.SecondaryLoop;
import java.io.Serializable;

//´ý¶¨
public class HistoryTimePO implements Serializable{
	String start;
	String end;
	int days;
	public HistoryTimePO(String start, String end, int days) {
		super();
		this.start = start;
		this.end = end;
		this.days = days;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
}
