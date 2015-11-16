package edu.nju.businesslogic.infobl;

import java.util.ArrayList;

import edu.nju.po.InstitutionPO;
import edu.nju.po.StaffPO;

public class MockInstitution extends Institution{
		double distance;
		
		public double getDistance(String city){
			return 100;
		}
		public ArrayList<InstitutionPO> getUnpaidInstitutionList() {
			InstitutionPO po1 = null;
			InstitutionPO po2 = null;
			ArrayList<InstitutionPO> poList = null;
			poList.add(po1);
			poList.add(po2);
			
			return poList;
		}
		public ArrayList<StaffPO> getUnpaidStaffList() {
			// TODO Auto-generated method stub
			StaffPO po1 = null;
			StaffPO po2 = null;
			ArrayList<StaffPO> poList = null;
			poList.add(po1);
			poList.add(po2);
			
			return poList;
		}
		
	
}
