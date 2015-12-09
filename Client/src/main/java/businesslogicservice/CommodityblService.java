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
     * @param stockOutVO the stock out vo传入一个 出库VO
     * @return the boolean
     * @throws RemoteException the remote exception网络异常
     */
    boolean stockOut(StockOutVO stockOutVO) throws RemoteException;

    /**
     * Stock in boolean.
     *
     * @param stockInVO the stock in vo传入一个 入库VO
     * @return the boolean
     * @throws RemoteException 网络异常
     */
    boolean stockIn(StockInVO stockInVO) throws RemoteException;

    /**
     * 这个迭代器包含出库、入库数量和库存数量
     *
     * @param startDate the start date传入初始日期
     * @param endDate   the end date传入截止日期
     * @return the stock vo返回一个 库存VO
     */
    Iterator<Integer> checkStock(String startDate, String endDate) throws RemoteException;


    /**
     * 截取当日的库存状态
     * Stock sum array list.
     *
     * @return the array list
     */
    Iterator<StockInVO> stockSum();

    /**
     * 生成时间段内库存状态
     *
     * @param startDate 传入起始日期
     * @param endDate   传入截止日期
     * @return返回一个<StockInVO>
     */
    Iterator<StockInVO> stockSum(String startDate, String endDate);
}
