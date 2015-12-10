package edu.nju.data.InfoDataServiceImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;

import edu.nju.data.database.SQL;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.po.CarPO;
import edu.nju.po.DriverPO;

public class CarDataServiceImpl extends UnicastRemoteObject implements CarDataService{

	public CarDataServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<CarPO> findCar(String institutionName) throws RemoteException{
		ArrayList<CarPO> carList = new ArrayList<CarPO>();
		String sql = "SELECT ��������,��������,���ƺ�,���̺�,������λ,����ʱ��,����ʱ�� FROM CAR WHERE ������λ='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				CarPO carPO=new CarPO(SQL.rs.getString("��������"),SQL.rs.getString("��������"),SQL.rs.getString("���ƺ�"),SQL.rs.getString("���̺�"),SQL.rs.getString("������λ"),SQL.rs.getDate("����ʱ��"),SQL.rs.getInt("����ʱ��"));
				carList.add(carPO);
			}
		} catch (SQLException e) {
			System.out.println("���ҳ�����Ϣ����");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return carList;
	}

	@Override
	public void addCar(CarPO po) throws RemoteException{
		DateFormat df=DateFormat.getDateInstance();
		String sql = "INSERT INTO CAR VALUES('"+po.getCarID()+"','"+po.getEngineID()+"','"+po.getPlateID()+"','"+po.getUnderpanID()+"','"+po.getInstitutionName()+"','"+df.format(po.getBuyTime())+"','"+po.getYears()+"');";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void changeCar(CarPO po) throws RemoteException{
		DateFormat df=DateFormat.getDateInstance();
		String sql = "UPDATE CAR SET ��������='"+po.getEngineID()+"',"+"���ƺ�='"+po.getPlateID()+"',���̺�='"+po.getUnderpanID()+"',"+"������λ='"+po.getInstitutionName()+"',"+"����ʱ��='"+df.format(po.getBuyTime())+"',"+"����ʱ��='"+po.getYears()+"' where ��������='"
	+ po.getCarID() + "';";
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public void deleteCar(CarPO po) throws RemoteException{
		String sql ="DELETE FROM CAR WHERE ��������='"+po.getCarID()+"';" ;
		SQL.databaseUpdate(sql);
		SQL.closeDatabase();
	}

	@Override
	public boolean isVaild(String id,String institutionName) throws RemoteException{
		boolean flag=false;
		String sql = "SELECT �������� FROM CAR WHERE ������λ='"+institutionName+"';";
		SQL.databaseQuery(sql);
		try {
			while (SQL.rs.next()) {
				String ID=SQL.rs.getString("��������");
				if(ID.equals(id)){
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("�жϴ���");
			e.printStackTrace();
		}
		SQL.closeDatabase();
		return flag;
	}

}
