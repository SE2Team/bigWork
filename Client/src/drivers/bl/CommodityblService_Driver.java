package src.drivers.bl;

import src.businesslogicservice.CommodityblService;
import src.vo.StockInVO;
import src.vo.StockOutVO;

public class CommodityblService_Driver {
    StockOutVO stockOutVO;
    StockInVO stockInVO;
    private String startDate;
    private String endDate;

    public void driver(CommodityblService commodityblService) {
        boolean isOut = commodityblService.stockOut(stockOutVO);
        if (isOut == true) {
            System.out.println("Success!");
        }

        boolean isIn = commodityblService.stockIn(stockInVO);
        if (isIn == true) {
            System.out.println("Success!");
        }

        boolean isCheck = commodityblService.checkStock(startDate, endDate);
        if (isCheck == true) {
            System.out.println("Success!");
        }

        boolean isSum = commodityblService.StockSum(startDate, endDate);
        if (isSum == true) {
            System.out.println("Success!");
        }
    }

}
