package data;

import data.Common.Common;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.ExpenseAndDatePO;
import util.DeliveryType;
import util.ExistException;

import java.rmi.RemoteException;

public class Test {
		public static void main(String[] args) throws RemoteException, ExistException{
			DataFactoryService dataFactory=new DataFactory().getInstance();
			Common common=new Common("order");
			common.clearData("order");
			common.clearData("addresseeInformation");
			common.clearData("distribute");
			common.clearData("gathering");
//			common.clearData("list");
			ListDataService listData=dataFactory.getListData();
//			listData.saveAsList(new GatheringPO("3333", "44444", "5555", "6666", "77777", true));
//			Iterator<ListPO> list=listData.checkList();
//			while (list.hasNext()) {
//				GatheringPO po=(GatheringPO)list.next();
//				System.out.println(po.getDate()+po.getMan()+po.getType()+po.getIsCheck());
//			}
			ExpenseAndDatePO date=listData.getExpenseOfTransport(new ExpenseAndDatePO("南京", "北京", "纸箱", "0", "20", DeliveryType.FAST, "0", "0", "0"));
			
			System.out.println(date.getExpenseOfTransport()+"\n"+date.getExpenseOfWrap()+"\n"+date.getDays());
		}
}
