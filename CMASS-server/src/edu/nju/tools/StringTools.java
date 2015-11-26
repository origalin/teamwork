package edu.nju.tools;

public class StringTools {
	public static String toAString(String[] str) {
		String reString = "";
		for(String string : str) {
			reString+=(string+" ");
		}
		return reString.substring(0,reString.length()-1);
	}
}
