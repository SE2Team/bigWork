package src.dataservice.commoditydataservice;

import src.po.StockPO;

public interface CommodityDataService {
	public void update(StockPO PO);
	public StockPO check();
	public StockPO initial();
}
