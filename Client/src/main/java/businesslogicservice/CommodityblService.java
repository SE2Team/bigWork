package businesslogicservice;

import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;

public interface CommodityblService {
    //出库

    ResultMessage stockOut(StockOutVO stockOutVO);

    ResultMessage stockIn(StockInVO stockInVO);

    //日期的格式必须是：yyyy-mm-dd
    ResultMessage checkStock(String startDate, String endDate);

    //日期的格式必须是：yyyy-mm-dd-hh
    ResultMessage StockSum(String startDate, String endDate);
}
