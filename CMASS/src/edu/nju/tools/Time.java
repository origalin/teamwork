package edu.nju.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	
	public static String toDaysTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd");	
		String result = sdm.format(date);
		return result;
		
	}
	public static String toSecondTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");	
		String result = sdm.format(date);
		return result;
	}
	public static String  toDocTime(Date date) {
		SimpleDateFormat sdm = new SimpleDateFormat("yyyyMMdd");	
		String result = sdm.format(date);
		return result;
	}
}
