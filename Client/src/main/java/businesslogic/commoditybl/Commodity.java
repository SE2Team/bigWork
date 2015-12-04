package businesslogic.commoditybl;

import businesslogic.Exception.*;
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import data.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import po.StockInPO;
import po.StockOutPO;
import po.StockPO;
import businesslogic.utilitybl.Helper;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Commodity {
    DataFactoryService dataFactory;
    CommodityDataService commodity;
    StockPO stockPO;

    public Commodity() throws RemoteException {
        stockPO=commodity.check();
        dataFactory = DataFactory.getInstance();
        commodity = dataFactory.getCommodityData();
    }

    //TODO 所有输入是否为空的判断
    public ResultMessage stockOut(StockOutVO stockOutVO) throws InvalidInput, TransferException, DateException, RemoteException {
        ListblService list=new ListController();
        /**
         * 判断输入是否合法
         */
        if(stockOutVO.getDeliveryNum().length()!=10)//TODO 快递编号长度
            throw new InvalidInput("快递编号错误！");
        if(!DateException.isValid(stockOutVO.getOutDate()))
            throw new DateException("出库日期格式错误！");
        else if(Helper.compareTo(stockOutVO.getOutDate()))
            throw  new InvalidInput("出库日期晚于当前时间！");
        if(!TransferException.isValid(stockOutVO.getTransferNum()))
            throw new TransferException("中转单号错误");
        //……
        StockOutPO stockOutPO=new StockOutPO(stockOutVO.getDeliveryNum(),stockOutVO.getOutDate(),stockOutVO.getEnd(),
                stockOutVO.getTransportType(),stockOutVO.getTransferNum());

        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……
        list.stockOut(stockOutVO);
        //从库存中删去
        stockPO.remove(stockOutVO.getDeliveryNum());

        commodity.update(stockPO);

        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO) throws InvalidInput, DateException, RemoteException {
        ListblService list=new ListController();
        /**
         *判断输入是否合法
         */
        if(stockInVO.getDeliveryNum().length()!=10)//TODO 快递编号长度
            throw new InvalidInput("快递编号错误！");
        if(!DateException.isValid(stockInVO.getInDate()))
            throw new DateException("入库日期格式错误！");
        if(Helper.compareTo(stockInVO.getInDate())){
            throw new InvalidInput("出库日期晚于当前时间！");
        }
        if(!InvalidIntegerException.isValid(stockInVO.getPositionNum()))
            throw new InvalidInput("位号错误！");
        if(!InvalidIntegerException.isValid(stockInVO.getRowNum()))
            throw new InvalidInput("排号错误！");
        if(!InvalidIntegerException.isValid(stockInVO.getShelfNum()))
            throw new InvalidInput("架号错误！");
        if(!InvalidIntegerException.isValid(stockInVO.getZoneNum()))
            throw new InvalidInput("区号错误！");
            //……

        StockInPO stockInPO=new StockInPO(stockInVO.getDeliveryNum(),stockInVO.getInDate(),stockInVO.getEnd(),stockInVO.getZoneNum(),
                stockInVO.getRowNum(),stockInVO.getShelfNum(),stockInVO.getPositionNum());

        list.stockIn(stockInVO);
        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……

        //添加到库存
        stockPO.add(stockInPO);

        commodity.update(stockPO);
        return ResultMessage.SUCCESS;
    }

    /**
     * TODO 先不写这个吧，
     * @param startDate
     * @param endDate
     * @return
     */
    public StockVO checkStock(String startDate, String endDate) {

        /**
         *判断输入是否合法
         */
        //……


        StockVO stockVO=new StockVO();
        return stockVO;
    }

    /**
     *截取当日的库存状态
     * @return
     */
    public ArrayList<StockInVO> stockSum() {
        ArrayList<StockInVO> arrayList=new ArrayList<StockInVO>();
        for(StockInPO temp:stockPO.getStockList()){
            if(Helper.isBetween(temp.getInDate()))
                arrayList.add(new StockInVO(temp.getDeliveryNum(),temp.getInDate(),temp.getEnd(),
                        temp.getZoneNum(),temp.getRowNum(),temp.getShelfNum(),temp.getPositionNum()));
        }
        return arrayList;
    }
}
