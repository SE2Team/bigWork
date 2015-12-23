package businesslogic.commoditybl;

import businesslogic.utilitybl.Helper;
import dataservice.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.inquirydataservice.InquiryDataService;
import po.OperationLogPO;
import po.StockInPO;
import po.StockPO;
import vo.StockInVO;
import vo.StockOutVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

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

    private InquiryDataService inquiryDataService;

    /**
     * Instantiates a new Commodity.
     *
     * @throws RemoteException the remote exception
     */
    public Commodity() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        commodity = dataFactory.getCommodityData();
        inquiryDataService=dataFactory.getInquiryData();
        try {
            stockPO = commodity.check();
        } catch (NullPointerException e) {
            System.out.println("没有连接到服务器！");
        }

    }


    /**
     * Stock out result message.
     *
     * @param stockOutVO the stock out vo
     * @return the result message
     * @throws RemoteException   the remote exception
     */
    public boolean stockOut(StockOutVO stockOutVO) throws RemoteException {
//        ListblService list = new ListController();

        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……
//        list.stockOut(stockOutVO);
        //从库存中删去
        stockPO.remove(stockOutVO.getDeliveryNum());

        commodity.update(stockPO);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"出库"));

        return true;
    }

    /**
     * Stock in result message.
     *
     * @param stockInVO the stock in vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean stockIn(StockInVO stockInVO) throws RemoteException {
//        ListblService list = new ListController();

        StockInPO stockInPO = new StockInPO(stockInVO.getDeliveryNum(), stockInVO.getInDate(), stockInVO.getEnd(), stockInVO.getZoneNum(),
                stockInVO.getRowNum(), stockInVO.getShelfNum(), stockInVO.getPositionNum(), stockInVO.getIsCheck());

//        list.stockIn(stockInVO);
        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……

        //添加到库存
        stockPO.add(stockInPO);

        commodity.update(stockPO);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"入库"));

        return true;
    }

    /**
     * Check stock stock vo.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return stock vo
     */
    public Iterator<Integer> checkStock(String startDate, String endDate) throws RemoteException {
        Iterator<Integer> itr = commodity.check(startDate, endDate);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"查看库存"));

        return itr;
    }

    /**
     * 截取当日的库存状态
     *
     * @return 一个当日入库单数组
     */
    public ArrayList<StockInVO> stockSum() throws RemoteException {
        ArrayList<StockInVO> arrayList = new ArrayList<StockInVO>();
        for (StockInPO temp : stockPO.getStockList()) {
            arrayList.add(new StockInVO(temp.getDeliveryNum(), temp.getInDate(), temp.getEnd(),
                    temp.getZoneNum(), temp.getRowNum(), temp.getShelfNum(), temp.getPositionNum(), temp.getIsCheck()));

        }

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"库存盘点"));

        return arrayList;
    }

    /**
     * 生成时间段内库存状态
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public Iterator<StockInVO> stockSum(String startDate, String endDate) throws RemoteException {
        ArrayList<StockInVO> arrayList = new ArrayList<StockInVO>();
        for (StockInPO temp : stockPO.getStockList()) {
            if (Helper.isBetween(startDate, temp.getInDate(), endDate)) {
                arrayList.add(new StockInVO(temp.getDeliveryNum(), temp.getInDate(), temp.getEnd(),
                        temp.getZoneNum(), temp.getRowNum(), temp.getShelfNum(), temp.getPositionNum(), temp.getIsCheck()));
            }
        }

        inquiryDataService.saveOperationLog(new
                OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),"库存盘点"));
        return arrayList.iterator();
    }

}
