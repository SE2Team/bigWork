package businesslogicservice;

import vo.StockInVO;
import vo.StockOutVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * The interface Commoditybl service.
 *
 * @author myk
 */
public interface CommodityblService {


    /**
     * Stock out boolean.
     *
     * @param stockOutVO the stock out vo
     * @return the boolean
     * @throws RemoteException   the remote exception
     */
    boolean stockOut(StockOutVO stockOutVO) throws RemoteException;

    /**
     * Stock in boolean.
     *
     * @param stockInVO the stock in vo
     * @return the boolean
     * @throws
     * @throws RemoteException the remote exception
     */
    boolean stockIn(StockInVO stockInVO) throws RemoteException;

    /**
     * 这个迭代器包含出库、入库数量和库存数量
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the stock vo
     */
    Iterator<Integer> checkStock(String startDate, String endDate) throws RemoteException;


    /**截取当日的库存状态
     * Stock sum array list.
     *
     * @return the array list
     */
    Iterator<StockInVO> stockSum();

    /**
     * 生成时间段内库存状态
     * @param startDate
     * @param endDate
     * @return
     */
    Iterator<StockInVO> stockSum(String startDate, String endDate);
}
