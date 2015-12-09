package data;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import data.Common.Common;
import data.commoditydata.CommoditydataImpl;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import dataservice.listdataservice.ListDataService;
import dataservice.userdataservice.UserDataService;
import po.AccountPO;
import po.GatheringPO;
import po.ListPO;
import po.StockInPO;
import po.StockOutPO;
import po.StockPO;
import po.UserPO;
import util.DeliveryType;
import util.ExistException;
import util.TransportType;

public class Test {
		public static void main(String[] args) throws RemoteException, ExistException{
			DataFactoryService dataFactory=new DataFactory().getInstance();
			ListDataService listData=dataFactory.getListData();
//			ArrayList<StockInPO> pos=new ArrayList<>();
//			CommodityDataService commodityData=dataFactory.getCommodityData();
//			StockInPO po=new StockInPO("333", "2015-10-14", "333", "4444", "5555", "6666", "7777", true);
//			
//			pos.add(po);
//			pos.add(po);
//			commodityData.update(new StockPO(true, pos));
//			listData.saveAsList(new StockInPO("333", "2015-10-14", "333", "4444", "5555", "6666", "7777", true));
			listData.saveAsList(new StockOutPO("333", "2015-11-11", "555", TransportType.AIRPLANE, "777", true));
			Iterator<ListPO> listPO=listData.getRecent("2015-10-01", "2015-11-30");
			while (listPO.hasNext()) {
				ListPO listPO2=listPO.next();
				System.out.println(listPO2.getType()+" "+listPO2.getIsCheck());
			}
			
			
			//			
//			Iterator<Integer> list=commodityData.check("2015-10-01", "2015-10-30");
//			while (list.hasNext()){
//				System.out.println(list.next());
//				
//			}
			
//			UserDataService userDataService=dataFactory.getUserData();
//			UserPO po=userDataService.login("admin001", "123456");
//			System.out.println(po.getName()+po.getPermission()+"");
			
			
		}
}
