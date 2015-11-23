package businesslogicservice;

import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;

public interface CommodityblService {
    //出库

    public ResultMessage stockOut(StockOutVO stockOutVO);

    public ResultMessage stockIn(StockInVO stockInVO);

    //日期的格式必须是：yyyy-mm-dd
    public ResultMessage checkStock(String startDate, String endDate);

    //日期的格式必须是：yyyy-mm-dd-hh
    public ResultMessage stockSum(String startDate, String endDate);
}
