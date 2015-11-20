package drivers.bl1;

import businesslogicservice.CommodityblService;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;

public class CommodityblService_Driver {
    StockOutVO stockOutVO;
    StockInVO stockInVO;
    private String startDate;
    private String endDate;

    public void driver(CommodityblService commodityblService) {
        ResultMessage isOut = commodityblService.stockOut(stockOutVO);
        if (isOut == ResultMessage.SUCCESS) {
            System.out.println("Success!");
        }

        ResultMessage isIn = commodityblService.stockIn(stockInVO);
        if (isIn == ResultMessage.SUCCESS) {
            System.out.println("Success!");
        }

        ResultMessage isCheck = commodityblService.checkStock(startDate, endDate);
        if (isCheck == ResultMessage.SUCCESS) {
            System.out.println("Success!");
        }

        ResultMessage isSum = commodityblService.StockSum(startDate, endDate);
        if (isSum == ResultMessage.SUCCESS) {
            System.out.println("Success!");
        }
    }

}
