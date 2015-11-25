package businesslogicservice;

import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.util.ArrayList;

public interface CommodityblService {
    //出库

    public ResultMessage stockOut(StockOutVO stockOutVO);

    public ResultMessage stockIn(StockInVO stockInVO);

    //日期的格式必须是：yyyy-mm-dd
    public StockVO checkStock(String startDate, String endDate);

    //日期的格式必须是：yyyy-mm-dd-hh
    public ArrayList<StockInVO> stockSum();
}
