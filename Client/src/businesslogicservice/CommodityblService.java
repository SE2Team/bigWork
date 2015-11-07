package src.businesslogicservice;

import src.util.ResultMessage;
import src.vo.StockInVO;
import src.vo.StockOutVO;

public interface CommodityblService {
    //出库

    public ResultMessage stockOut(StockOutVO stockOutVO);

    public ResultMessage stockIn(StockInVO stockInVO);

    //日期的格式必须是：yyyy-mm-dd
    public ResultMessage checkStock(String startDate,String endDate);
    //日期的格式必须是：yyyy-mm-dd-hh
    public ResultMessage StockSum(String startDate,String endDate);
}
