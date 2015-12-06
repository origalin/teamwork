package edu.nju.vo;

public class DistanceVO {
	int id;
	String city1;
	String city2;
    double distance;
	public DistanceVO(int id,String city1, String city2, double distance) {
		super();
		this.id=id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}

    
}
