package businesslogicservice;
import enumClass.*;
import po.StockPO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface CommodityblService {
    //出库

    /**
     *
     * @param deliveryNum
     * @param outDate
     * @param city
     * @param transportType
     * @param transferNum
     * @return
     */
    public boolean stockOut(String deliveryNum, String outDate,
                            City city, TransportType transportType, String transferNum);

    /**
     *
     * @param deliveryNum
     * @param outDate
     * @param city
     * @return
     */
    public boolean stockIn(String deliveryNum, String outDate,
                            City city);

    /**
     *
     * @param stockPO
     * @return
     */
    boolean isFull(StockPO stockPO);
    //日期的格式必须是：yyyy-mm-dd
    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean checkStock(String startDate,String endDate);
    //日期的格式必须是：yyyy-mm-dd-hh
    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public boolean StockSum(String startDate,String endDate);
}
