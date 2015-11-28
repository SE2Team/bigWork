package businesslogic.commoditybl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.Exception.TransferException;
import businesslogicservice.CommodityblService;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.util.ArrayList;


/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class CommodityController implements CommodityblService {
    Commodity commodity = new Commodity();

    public ResultMessage stockOut(StockOutVO stockOutVO) throws TransferException, InvalidInput, DateException {

        return commodity.stockOut(stockOutVO);
    }


    public ResultMessage stockIn(StockInVO stockInVO) throws DateException, InvalidInput {
        return commodity.stockIn(stockInVO);
    }


    public StockVO checkStock(String startDate, String endDate) {
        return commodity.checkStock(startDate, endDate);
    }


    public ArrayList<StockInVO> stockSum() {
        return commodity.stockSum();
    }
}
