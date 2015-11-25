package edu.nju.po;

public class DistancePO {
	String city1;
	String city2;
    double distance;
	public DistancePO(String city1, String city2, double distance) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getCity2() {
		return city2;
	}
	public void setCity2(String city2) {
		this.city2 = city2;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "DistancePO [city1=" + city1 + ", city2=" + city2
				+ ", distance=" + distance + "]";
	}
    
	
}
