package edu.nju.dataservice.Start;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import com.mysql.jdbc.Driver;

import edu.nju.data.FinanceDataServiceImpl.FinanceDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.CarDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.DistanceDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.DriverDataServiceImpl;
import edu.nju.data.InfoDataServiceImpl.InstitutionDataServiceImpl;
import edu.nju.data.LogisticsDataServiceImpl.LogisticsDataServiceImpl;
import edu.nju.data.StorageDataServiceImpl.StorageDataServiceImpl;
import edu.nju.data.SystemDataServiceImpl.SystemDataServiceImpl;
import edu.nju.data.collectionDataServiceImpl.CollectionDataServiceImpl;
import edu.nju.data.transferDataServiceImpl.TransferDataServiceImpl;
import edu.nju.dataservice.approvedataservice.ApproveDataService;
import edu.nju.dataservice.collectiondataservice.CollectionDataService;
import edu.nju.dataservice.financedataservice.FinanceDataService;
import edu.nju.dataservice.infodataservice.CarDataService;
import edu.nju.dataservice.infodataservice.DistanceDataService;
import edu.nju.dataservice.infodataservice.DriverDataService;
import edu.nju.dataservice.infodataservice.InstitutionDataService;
import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.dataservice.storagedataservice.StorageDataService;
import edu.nju.dataservice.systemdataservice.SystemDataService;
import edu.nju.dataservice.transferdataservice.TransferDataService;

public class Start {

	public Start() {
	
	}
	
	public static void main(String[] args) {
		 
		 try {				
				LogisticsDataService logisticsDataService=new LogisticsDataServiceImpl();
				StorageDataService storageDataService=new StorageDataServiceImpl();
				FinanceDataService financeDataService=new FinanceDataServiceImpl();
				SystemDataService systemDataService=new SystemDataServiceImpl();
				CarDataService carDataService=new CarDataServiceImpl();
				DistanceDataService distanceDataService=new DistanceDataServiceImpl();
				DriverDataService driverDataService=new DriverDataServiceImpl();
				InstitutionDataService institutionDataService=new InstitutionDataServiceImpl();
				
				CollectionDataService collectionDataService = new CollectionDataServiceImpl();
				TransferDataService transferDataService = new TransferDataServiceImpl();
				
				//注册通讯端口
				LocateRegistry.createRegistry(6600);
				//注册通讯路径
				Naming.rebind("rmi://127.0.0.1:6600/LogisticsDataService", logisticsDataService);
				Naming.rebind("rmi://127.0.0.1:6600/storageDataService", storageDataService);
				Naming.rebind("rmi://127.0.0.1:6600/SystemDataService", systemDataService);
				
				Naming.rebind("rmi://127.0.0.1:6600/CarDataService", carDataService);
				Naming.rebind("rmi://127.0.0.1:6600/DistanceDataService", distanceDataService);
				Naming.rebind("rmi://127.0.0.1:6600/DriverDataService", driverDataService);

				Naming.rebind("rmi://127.0.0.1:6600/InstitutionDataService", institutionDataService);

				Naming.rebind("rmi://127.0.0.1:6600/FinanceDataService",financeDataService);

				Naming.rebind("rmi://127.0.0.1:6600/collectionDataService", collectionDataService);
				Naming.rebind("rmi://127.0.0.1:6600/transferDataService", transferDataService);
				System.out.println("Service Start!");
				isTray();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void isTray()   
    {   
		PopupMenu popupMenu1 = new PopupMenu();   
		MenuItem menuItem1 = new MenuItem();
		popupMenu1.setLabel("PopupMenu");   
        menuItem1.setLabel("退出");   
        menuItem1.addActionListener(new ActionListener()   
        {   
            public void actionPerformed(ActionEvent evt)   
            {   
            System.exit(0);
            }   
        });   
        popupMenu1.add(menuItem1); 
        try  
        {   
          if (SystemTray.isSupported())   
          {// 判断当前平台是否支持系统托盘   
            SystemTray st = SystemTray.getSystemTray();   
            Image image = Toolkit.getDefaultToolkit().getImage(   
               "images/smallIcon.png");//定义托盘图标的图片     
           TrayIcon ti = new TrayIcon( image);   
           ti.setToolTip ( "CMASS Server");   
           ti.setPopupMenu ( popupMenu1);
           st.add(ti);            
          }   
        }   
        catch (Exception e)   
        {   
               
        }   
       
  
    }

}
