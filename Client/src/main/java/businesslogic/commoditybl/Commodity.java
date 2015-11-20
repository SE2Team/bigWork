package businesslogic.commoditybl;

import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Commodity {
    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return null;
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

    /**
     * 待完善的内部判断代码
     *
     * @return
     */
    private boolean isFull() {
        return false;
    }
}
