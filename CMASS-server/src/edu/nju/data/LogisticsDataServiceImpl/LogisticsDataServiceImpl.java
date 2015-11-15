package edu.nju.data.LogisticsDataServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;



import edu.nju.dataservice.logisticsqueryDataService.LogisticsDataService;
import edu.nju.po.PositionPO;

public class LogisticsDataServiceImpl implements LogisticsDataService{

	public static void main(String[] args) {
		LogisticsDataServiceImpl t=new LogisticsDataServiceImpl();
	    t.createPosition("0002500010","朝阳区营业厅,北京市中转中心,南京市中转中心,栖霞区营业厅,派件中" );
	
	}
	@Override
	public PositionPO positionQuery(String ItemID) {
		try {
			BufferedReader reader=new BufferedReader(new FileReader("D:\\teamwork\\CMASS-server\\data\\LogisticsData\\Position.txt"));
			PositionPO positionPO = null;
			String input="";
			try {
				while((input=reader.readLine())!=null){
					
					String[] s1=input.split(" ");
					String currID=s1[0];
					if(!currID.equals(ItemID))
						continue;
					String[] s2=s1[1].split(",");
					ArrayList<String> history=new ArrayList<String>();
					for(String str:s2){
						history.add(str);
					}
					positionPO=new PositionPO(currID, history);
					break;
				}
				reader.close();
				return positionPO;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot find the LogisticsData file");
			e.printStackTrace();
			
		}
		return null;
	}

	@Override
	public void changePosition(String ItemID, String pos) {
		
		
	}

	@Override
	public void createPosition(String Item, String pos) {
		File file=new File("D:\\teamwork\\CMASS-server\\data\\LogisticsData\\Position.txt");
		try {
			FileWriter writer=new FileWriter(file,true);
			writer.write(Item+" "+pos+"\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("cannot find the logisticsData file");
			e.printStackTrace();
		}
		
		
	}

}
