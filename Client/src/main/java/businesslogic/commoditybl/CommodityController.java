package businesslogic.commoditybl;

import businesslogicservice.CommodityblService;
import vo.StockInVO;
import vo.StockOutVO;

import java.rmi.RemoteException;
import java.util.Iterator;


/**
 * Created by Administrator on 2015/11/1 0001.
 *
 * @author myk
 */
public class CommodityController implements CommodityblService {
    /**
     * The Commodity.
     */
    private Commodity commodity;

    /**
     * Instantiates a new Commodity controller.
     *
     * @throws RemoteException the remote exception
     */
    public CommodityController() throws RemoteException {
        commodity = new Commodity();
    }

    public boolean stockOut(StockOutVO stockOutVO) throws RemoteException {

        return commodity.stockOut(stockOutVO);
    }


    public boolean stockIn(StockInVO stockInVO) throws RemoteException {
        return commodity.stockIn(stockInVO);
    }


    public Iterator<Integer> checkStock(String startDate, String endDate) throws RemoteException {
        return commodity.checkStock(startDate, endDate);
    }


    public Iterator<StockInVO> stockSum() throws RemoteException {
        return commodity.stockSum().iterator();
    }

    public Iterator<StockInVO> stockSum(String startDate, String endDate) throws RemoteException {
        return commodity.stockSum(startDate, endDate);
    }
}
