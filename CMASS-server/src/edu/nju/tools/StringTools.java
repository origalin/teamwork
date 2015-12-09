package edu.nju.tools;

import java.util.ArrayList;

public class StringTools {
	public static String toAString(String[] str) {
		String reString = "";
		for(String string : str) {
			reString+=(string+" ");
		}
		return reString.substring(0,reString.length()-1);
	}
	public static String[] toGroup(ArrayList<String> list) {
		String[] result = new String[list.size()];
		for(int i = 0;i < list.size();i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}
