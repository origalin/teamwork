package edu.nju.po;
//�������������ţ����б�ţ��绰���������Ͼ�025��+
//Ӫҵ����ţ�000��λ���֣�+000��λ���֣������ƺţ�
//��A 00000��������ʱ�䣩
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
