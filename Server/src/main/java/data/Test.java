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
import po.AccountPO;
import po.GatheringPO;
import po.ListPO;
import po.StockInPO;
import po.StockOutPO;
import po.StockPO;
import util.DeliveryType;
import util.ExistException;
import util.TransportType;

public class Test {
		public static void main(String[] args) throws RemoteException, ExistException{
//			DataFactoryService dataFactory=new DataFactory().getInstance();
//			ListDataService listData=dataFactory.getListData();
//			ArrayList<StockInPO> pos=new ArrayList<>();
//			CommodityDataService commodityData=dataFactory.getCommodityData();
//			StockInPO po=new StockInPO("333", "2015-10-14", "333", "4444", "5555", "6666", "7777", true);
//			
//			pos.add(po);
//			pos.add(po);
//			commodityData.update(new StockPO(true, pos));
//			listData.save(new StockInPO("333", "2015-10-14", "333", "4444", "5555", "6666", "7777", true));
//			listData.save(new StockOutPO("333", "2015-10-18", "555", TransportType.AIRPLANE, "777", true));
//			
//			Iterator<Integer> list=commodityData.check("2015-10-01", "2015-10-30");
//			while (list.hasNext()){
//				System.out.println(list.next());
//				
//			}
		}
}
