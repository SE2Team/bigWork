package businesslogic.commoditybl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.Exception.TransferException;
import businesslogicservice.CommodityblService;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;


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

    public boolean stockOut(StockOutVO stockOutVO) throws TransferException, InvalidInput, DateException, RemoteException {

        return commodity.stockOut(stockOutVO);
    }


    public boolean stockIn(StockInVO stockInVO) throws DateException, InvalidInput, RemoteException {
        return commodity.stockIn(stockInVO);
    }


    public StockVO checkStock(String startDate, String endDate) {
        return commodity.checkStock(startDate, endDate);
    }


    public ArrayList<StockInVO> stockSum() {
        return commodity.stockSum();
    }
}
