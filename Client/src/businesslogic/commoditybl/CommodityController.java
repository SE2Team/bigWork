package src.businesslogic.commoditybl;

import src.businesslogicservice.CommodityblService;
import src.vo.StockInVO;
import src.vo.StockOutVO;
import src.vo.StockVO;
import util.ResultMessage;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class CommodityController implements CommodityblService {
    Commodity commodity=new Commodity();
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
    public StockVO StockSum() {
        return null;
    }
}
