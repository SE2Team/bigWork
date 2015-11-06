package src.stubs.data;

import src.dataservice.commoditydataservice.CommodityDataService;
import src.po.StockPO;

public class CommodityDataService_Stub implements CommodityDataService{
	
	public CommodityDataService_Stub(){
		
	}
	
	public void update(StockPO PO){
		System.out.println("Success");
	}
	public StockPO check(){
		System.out.println("Success");
		StockPO po=new StockPO();
		return po;
	}
	public StockPO initial(){
		System.out.println("Success");
		StockPO po=new StockPO();
		return po;
	}
	

}
