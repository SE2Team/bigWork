package dataservice.commoditydataservice;

import po.StockPO;

public interface CommodityDataService {
	public void update(StockPO PO);
	public StockPO check();//返回完整的stockpo

	public StockPO initial();

}
