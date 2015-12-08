package edu.nju.tools;

import java.text.DateFormat;
import java.text.ParseException;
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
	
	public static Date stringToDate(String s){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    try {
			Date d = df.parse(s);
			return d;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("不符合日期格式，请重新输入");
			e.printStackTrace();
		}  
	    return null;
	}
}
