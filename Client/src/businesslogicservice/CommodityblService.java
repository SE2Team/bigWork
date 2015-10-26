package src.businesslogicservice;

import src.po.StockPO;
import src.vo.StockInVO;
import src.vo.StockOutVO;

public interface CommodityblService {
    //出库

    public boolean stockOut(StockOutVO stockOutVO);

    public boolean stockIn(StockInVO stockInVO);

    boolean isFull(StockPO stockPO);
    //日期的格式必须是：yyyy-mm-dd
    public boolean checkStock(String startDate,String endDate);
    //日期的格式必须是：yyyy-mm-dd-hh
    public boolean StockSum(String startDate,String endDate);
}
