package edu.nju.dataservice.infodataservice;

import java.util.ArrayList;

import edu.nju.po.BusinessManPO;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public class InfoDataService_stub {
	public ArrayList<StaffPO> getBusinessManList(){
		ArrayList<StaffPO> t=new ArrayList<StaffPO>();
		t.add(new StaffPO());//返回人员职务为财务的所有职员
		t.add(new StaffPO());
		return t;
	}
	public ArrayList<DriverPO> findDriver(){
		ArrayList<DriverPO> t=new ArrayList<DriverPO>();
		int driverID=025000000;
		String name="";
		String birthday="";
		String identity="";
		String phone_numer="";
		String sex="";
		int limit=0;
		t.add(new DriverPO(driverID, name, birthday, identity, phone_numer, sex, limit));//这边可以提供一些参数用来构造PO
		return t;
	}
	public ArrayList<CarPO> findCar(){
		ArrayList<CarPO> t=new ArrayList<CarPO>();
		int CarID=000;
		String plate_number="";
		t.add(new CarPO(CarID, plate_number));//这边可以提供一些参数用来构造PO
		return t;
	}
	public int findSalary(){
		StaffPO staffpo=new StaffPO();
		int salary=staffpo.getSalary();
		return salary;
	}
	public ArrayList<StaffPO> findStaff(){
		ArrayList<StaffPO> t=new ArrayList<StaffPO>();
		t.add(new StaffPO());//这边可以提供一些参数用来构造PO
		t.add(new StaffPO());
		return t;
	}
	public ArrayList<InstitutionPO> findInstitution(){
		ArrayList<InstitutionPO> t=new ArrayList<InstitutionPO>();
		t.add(new InstitutionPO());//这边可以提供一些参数用来构造PO
		t.add(new InstitutionPO());
		return t;
	}
	public double  getDistance(String city1,String city2){
		double distance=0;
		return distance;
	}
	public void saveDriver(DriverPO po){
		System.out.println("saveDriver  success!");
	}
	public void saveCar(CarPO po){
		System.out.println("saveCar  success!");
	}
	public void saveSalary (StaffPO po){
		int salary=5000;
		po.setSalary(salary);
		System.out.println("saveSalary  success!");
	}
	public void saveStaff(StaffPO po){
		System.out.println("saveStaff  success!");
	}
	public void saveInstitution (InstitutionPO po){
		System.out.println("saveInstitution  success!");
	}
	public void saveDistance(String city1,String city2,double distance){
		System.out.println("saveDiatance  success!");
	}
}
