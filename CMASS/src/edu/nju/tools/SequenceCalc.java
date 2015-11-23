package edu.nju.tools;

public class SequenceCalc {
	public static  String calcNextSequence6(String current) {
		int sequence = Integer.parseInt(current);
		if(sequence+1==1000000) {
			return "000000";
		}else {
			return String.format("%06d", sequence+1);
		}
	}
	public static  String calcNextSequence5(String current) {
		int sequence = Integer.parseInt(current);
		if(sequence+1==1000000) {
			return "000000";
		}else {
			return String.format("%05d", sequence+1);
		}
	}
	public static String toString6(int sequence) {
		return  String.format("%06d", sequence);
	}
	public static String toString5(int sequence) {
		return  String.format("%05d", sequence);
	}
}
