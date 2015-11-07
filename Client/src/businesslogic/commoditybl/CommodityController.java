package src.businesslogic.commoditybl;

import src.util.ResultMessage;
import src.businesslogicservice.CommodityblService;
import src.vo.StockInVO;
import src.vo.StockOutVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class CommodityController implements CommodityblService {
    @Override
    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return null;
    }

    @Override
    public ResultMessage stockIn(StockInVO stockInVO) {
        return null;
    }


    @Override
    public ResultMessage checkStock(String startDate, String endDate) {
        return null;
    }

    @Override
    public ResultMessage StockSum(String startDate, String endDate) {
        return null;
    }
}
