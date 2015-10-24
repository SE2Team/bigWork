package businesslogicservice;
import enumClass.*;
import po.StockPO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface CommodityblService {
    //出库
    public boolean stockOut(String deliveryNum, String outDate,
                            City city, TransportType transportType,String transferNum);
    public boolean stockIn(String deliveryNum, String outDate,
                            City city);

    boolean isFull(StockPO stockPO);
    //日期的格式必须是：yyyy-mm-dd
    public boolean checkStock(String startDate,String endDate);
    //日期的格式必须是：yyyy-mm-dd-hh
    public boolean StockSum(String startDate,String endDate);
}
