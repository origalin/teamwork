package edu.nju.po;
//���տ����ڡ��տ���տ���Ա����Ӧ�����п�ݶ���������š���

public class GatheringDocPO extends Doc {
	Long date;
	Double money;
	String courier_name;
	int[] itemIDs;
	public GatheringDocPO(Double money, String courier_name, int[] itemIDs) {
		super();
		this.money = money;
		this.courier_name = courier_name;
		this.itemIDs = itemIDs;
		this.date = System.currentTimeMillis();
	}
	public Long getDate() {
		return date;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getCourier_name() {
		return courier_name;
	}
	public void setCourier_name(String courier_name) {
		this.courier_name = courier_name;
	}
	public int[] getItemIDs() {
		return itemIDs;
	}
	public void setItemIDs(int[] itemIDs) {
		this.itemIDs = itemIDs;
	}
	
	
}
