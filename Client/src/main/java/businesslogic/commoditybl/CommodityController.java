package businesslogic.commoditybl;

import businesslogicservice.CommodityblService;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;



/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class CommodityController implements CommodityblService {
    Commodity commodity = new Commodity();

    public ResultMessage stockOut(StockOutVO stockOutVO) {

        return commodity.stockOut(stockOutVO);
    }


    public ResultMessage stockIn(StockInVO stockInVO) {
        return null;
    }


    public ResultMessage checkStock(String startDate, String endDate) {
        return null;
    }


    public ResultMessage StockSum(String startDate, String endDate) {
        return null;
    }
}
