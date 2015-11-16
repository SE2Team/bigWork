package src.test;

import src.drivers.bl1.*;
import src.drivers.data1.*;
import src.stubs.bl1.*;
import src.stubs.data1.*;

public class Test {
		public static void main(String[] args){
			Test test=new Test();
			test.testBlService();
			test.testDataService();
		}
		
		
		private void testBlService(){
			CommodityblService_Driver d1=new CommodityblService_Driver();
			d1.driver(new  CommodityblService_Stub());
			System.out.println("-------Succeed---------");
			
			FinanceblService_Drivers d2=new FinanceblService_Drivers();
			d2.driver(new FinanceblService_Stub());
			System.out.println("-------Succeed---------");
			
			InquiryblService_Drivers d3=new InquiryblService_Drivers();
			d3.drive(new InquiryblService_Stub());
			System.out.println("-------Succeed---------");
			
			ListblService_Driver d4=new ListblService_Driver();
			d4.driver(new ListblService_Stub());
			System.out.println("-------Succeed---------");
			
			ManageblService_Driver d5=new ManageblService_Driver();
			d5.driver(new ManageblService_Stub()) ;
			System.out.println("-------Succeed---------");	
			
			UserblService_Driver d6=new UserblService_Driver();
			d6.driver(new UserblService_Stub());
			System.out.println("-------Succeed---------");
			
		}
		
		private void testDataService(){
			CommoditydataService_Driver t1=new CommoditydataService_Driver();
			t1.driver(new CommodityDataService_Stub());
			System.out.println("-------Succeed---------");
			
			FinanceDataService_Driver t2=new FinanceDataService_Driver();
			t2.driver(new FinanceDataService_Stub());
			System.out.println("-------Succeed---------");
			
			InquiryDataService_Driver t3=new InquiryDataService_Driver();
			t3.driver(new InquiryDataService_Stub());
			System.out.println("-------Succeed---------");
			
			ListDataService_Driver t4=new ListDataService_Driver();
			t4.driver(new ListDataService_Stub());
			System.out.println("-------Succeed---------");
			
			ManageDataService_Driver t5=new ManageDataService_Driver();
			t5.drive(new ManageDataService_Stub());
			System.out.println("-------Succeed---------");
			
			UserDataService_Driver t6=new UserDataService_Driver();
			t6.drive(new UserDataService_Stub());
			System.out.println("-------Succeed---------");
			
		}
}
