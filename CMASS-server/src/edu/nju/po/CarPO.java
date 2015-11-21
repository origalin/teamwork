package edu.nju.po;
//车辆（车辆代号（城市编号（电话号码区号南京025）+
//营业厅编号（000三位数字）+000三位数字）、车牌号（
//苏A 00000）、服役时间）
public class CarPO {
	int CarID;
	String plate_number;
	int years;
	public CarPO(int carID, String plate_number) {
		super();
		CarID = carID;
		this.plate_number = plate_number;
	}
	public int getCarID() {
		return CarID;
	}
	public void setCarID(int carID) {
		CarID = carID;
	}
	public String getPlate_number() {
		return plate_number;
	}
	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	
}
