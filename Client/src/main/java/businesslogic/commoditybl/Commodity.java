package businesslogic.commoditybl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidInput;
import businesslogic.Exception.TransferException;
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import dataservice.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import po.StockInPO;
import po.StockPO;
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
public class Commodity {
    /**
     * The Data factory.
     */
    private DataFactoryService dataFactory;
    /**
     * The Commodity.
     */
    private CommodityDataService commodity;
    /**
     * The Stock po.
     */
    private StockPO stockPO;

    /**
     * Instantiates a new Commodity.
     *
     * @throws RemoteException the remote exception
     */
    public Commodity() throws RemoteException {
        stockPO = commodity.check();
        dataFactory = DataFactory.getInstance();
        commodity = dataFactory.getCommodityData();
    }


    /**
     * Stock out result message.
     *
     * @param stockOutVO the stock out vo
     * @return the result message
     * @throws InvalidInput      the invalid input
     * @throws TransferException the transfer exception
     * @throws DateException     the date exception
     * @throws RemoteException   the remote exception
     */
    public boolean stockOut(StockOutVO stockOutVO) throws InvalidInput, TransferException, DateException, RemoteException {
        ListblService list = new ListController();

        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……
        list.stockOut(stockOutVO);
        //从库存中删去
        stockPO.remove(stockOutVO.getDeliveryNum());

        commodity.update(stockPO);

        return true;
    }

    /**
     * Stock in result message.
     *
     * @param stockInVO the stock in vo
     * @return the result message
     * @throws InvalidInput    the invalid input
     * @throws DateException   the date exception
     * @throws RemoteException the remote exception
     */
    public boolean stockIn(StockInVO stockInVO) throws InvalidInput, DateException, RemoteException {
        ListblService list = new ListController();

        StockInPO stockInPO = new StockInPO(stockInVO.getDeliveryNum(), stockInVO.getInDate(), stockInVO.getEnd(), stockInVO.getZoneNum(),
                stockInVO.getRowNum(), stockInVO.getShelfNum(), stockInVO.getPositionNum(),stockInVO.getIsCheck());

        list.stockIn(stockInVO);
        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……

        //添加到库存
        stockPO.add(stockInPO);

        commodity.update(stockPO);
        return true;
    }

    /**
     * Check stock stock vo.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return stock vo
     */
    public StockVO checkStock(String startDate, String endDate) {
        StockVO stockVO = new StockVO(stockPO.getStockState(),stockPO.getStockList());
        return stockVO;
    }

    /**
     * 截取当日的库存状态
     *
     * @return array list
     */
    public ArrayList<StockInVO> stockSum() {
        ArrayList<StockInVO> arrayList = new ArrayList<StockInVO>();
        for (StockInPO temp : stockPO.getStockList()) {
            arrayList.add(new StockInVO(temp.getDeliveryNum(), temp.getInDate(), temp.getEnd(),
                    temp.getZoneNum(), temp.getRowNum(), temp.getShelfNum(), temp.getPositionNum(),temp.getIsCheck()));
        }
        return arrayList;
    }
}
