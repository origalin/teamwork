package edu.nju.data.InfoDataServiceImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;




import java.util.Date;

import javafx.util.converter.DateStringConverter;
import edu.nju.data.SystemDataServiceImpl.SystemDataServiceImpl;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;
import edu.nju.po.OperationPO;

public class Main {
	public static void main(String[] args) throws ParseException {
		//����driverdata
//		DriverDataServiceImpl d=new DriverDataServiceImpl();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//		
//		DriverPO po=new DriverPO("0025000002","������",	"��", sdf.parse("2006-12-20"),	"622555198610116000",	"15768565555","�Ͼ��й�¥Ӫҵ��",
//				sdf.parse("2006-12-20"),sdf.parse("2006-12-20"));
//		d.addDriver(po);System.out.println(po);
//		po.setName("������");
//		d.changeDriver(po);
//		d.deleteDriver(po);
//		
//		
//		ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
//		driverList=d.findDriver("�Ͼ��й�¥Ӫҵ��");
//		System.out.println(driverList);
		
		
		//���Բ�����־
//		Date date=new Date();
//		OperationPO po=new OperationPO(date,"00251001100","�Ž�",	"�����˻����");
//		SystemDataServiceImpl s=new SystemDataServiceImpl();
//		s.saveOperationLog(po);
//		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		ArrayList<OperationPO> operationList=new ArrayList<OperationPO>();
//		operationList=s.findOperationLog(f.parse("2015-11-24 20:30:27"),f.parse("2015-11-24 20:53:20"));
//		System.out.println(operationList);
		
		CarDataServiceImpl c=new CarDataServiceImpl();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-ww-ww");
//		CarPO po=new CarPO("0025000000",	"CY1111023",	"��A00000",	"WVWZZZ32ZHN153624",	"�Ͼ��й�¥Ӫҵ��",sdf.parse("2014-11-11"),3);
	
		CarPO po=new CarPO("0025001001","CY1111021",	"��J00000",	"WVWZZZ32ZHN153625",	"�Ͼ��й�¥Ӫҵ��",sdf.parse("2015-11-11"),2);
//		c.addCar(po);
		po.setInstitutionName("�Ͼ��й�¥Ӫҵ��");
		c.changeCar(po);
		c.deleteCar(po);
		ArrayList<CarPO> carList=new ArrayList<CarPO>();
		carList=c.findCar("�Ͼ��й�¥Ӫҵ��");
		System.out.println(carList);
	
		
	}

}
