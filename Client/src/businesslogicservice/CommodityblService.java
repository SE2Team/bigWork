package businesslogicservice;
import enumClass.*;
import po.StockPO;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface CommodityblService {
    //����
    public boolean stockOut(String deliveryNum, String outDate,
                            City city, TransportType transportType,String transferNum);
    public boolean stockIn(String deliveryNum, String outDate,
                            City city);

    boolean isFull(StockPO stockPO);
    //���ڵĸ�ʽ�����ǣ�yyyy-mm-dd
    public boolean checkStock(String startDate,String endDate);
    //���ڵĸ�ʽ�����ǣ�yyyy-mm-dd-hh
    public boolean StockSum(String startDate,String endDate);
}
