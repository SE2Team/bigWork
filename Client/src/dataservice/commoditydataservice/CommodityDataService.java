package src.dataservice.commoditydataservice;

import src.po.StockPO;
import util.ResultMessage;

public interface CommodityDataService {
    /**
     * 操作完库存之后更新库存对象
     *
     * @param PO
     * @return
     */
    public ResultMessage update(StockPO PO);

    /**
     * 库存盘点
     *
     * @return
     */
    public StockPO check();

    /**
     * 库存查看
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public ResultMessage check(String startDate, String endDate);
//	public StockPO initial();
}
