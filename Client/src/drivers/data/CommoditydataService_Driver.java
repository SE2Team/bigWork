package src.drivers.data;

import src.dataservice.commoditydataservice.CommodityDataService;
import src.po.StockPO;

public class CommoditydataService_Driver {
	StockPO po;
	public void driver(CommodityDataService commodityDataService){
		StockPO isCheck=commodityDataService.check();
		if(isCheck==po){
			System.out.println("Success!");
		}
//		
//		StockPO isInitial=commodityDataService.initial();
//		if(isInitial==po){
//			System.out.println("Success!");
//		}
	}
}
