package businesslogicservice;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.Exception.TransferException;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
     * @throws TransferException the transfer exception
     * @throws InvalidInput      the invalid input
     * @throws DateException     the date exception
     * @throws RemoteException   the remote exception
     */
    boolean stockOut(StockOutVO stockOutVO) throws TransferException, InvalidInput, DateException, RemoteException;

    /**
     * Stock in boolean.
     *
     * @param stockInVO the stock in vo
     * @return the boolean
     * @throws DateException   the date exception
     * @throws InvalidInput    the invalid input
     * @throws RemoteException the remote exception
     */
    boolean stockIn(StockInVO stockInVO) throws DateException, InvalidInput, RemoteException;

    /**
     * Check stock stock vo.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the stock vo
     */
//日期的格式必须是：yyyy-mm-dd
    StockVO checkStock(String startDate, String endDate);


    /**
     * Stock sum array list.
     *
     * @return the array list
     */
    ArrayList<StockInVO> stockSum();
}
