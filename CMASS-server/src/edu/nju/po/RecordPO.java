package edu.nju.po;
//��ⵥ����ݱ�š�������ڡ�Ŀ�ĵء����š��źš�
//�ܺš�λ�ţ�
//�൱��storageitempo
public class RecordPO {
	int itemID;
	String date;
	String destination;
	String district;
	int row;
	int shelf;
	int point;
	public RecordPO(int itemID, String date, String destination,
			String district, int row, int shelf, int point) {
		super();
		this.itemID = itemID;
		this.date = date;
		this.destination = destination;
		this.district = district;
		this.row = row;
		this.shelf = shelf;
		this.point = point;
	}
	public RecordPO() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getShelf() {
		return shelf;
	}
	public void setShelf(int shelf) {
		this.shelf = shelf;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
