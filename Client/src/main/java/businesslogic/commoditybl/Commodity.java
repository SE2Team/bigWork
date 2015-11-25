package businesslogic.commoditybl;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import data.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import po.StockInPO;
import po.StockOutPO;
import po.StockPO;
import util.Helper;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;
import vo.StockVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Commodity {
    DataFactoryService dataFactory=new DataFactory();
    CommodityDataService commodity=dataFactory.getCommodityData();
    StockPO stockPO;

    public Commodity() {
        stockPO=commodity.check();
    }

    //TODO 所有输入是否为空的判断
    public ResultMessage stockOut(StockOutVO stockOutVO) {
        ListblService list=new ListController();
        /**
         * 判断输入是否合法
         */
        if(stockOutVO.getDeliveryNum().length()!=10)//TODO 快递编号长度
            return ResultMessage.FAILED;
        //……
        StockOutPO stockOutPO=new StockOutPO(stockOutVO.getDeliveryNum(),stockOutVO.getOutDate(),stockOutVO.getEnd(),
                stockOutVO.getLoadingWay(),stockOutVO.getTransferNum());

        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……
        list.stockOut(stockOutVO);
        //从库存中删去
        stockPO.remove(stockOutVO.getDeliveryNum());

        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        ListblService list=new ListController();
        /**
         *判断输入是否合法
         */
        if(stockInVO.getDeliveryNum().length()!=8)//TODO 快递编号长度
            return ResultMessage.FAILED;

        if(Helper.compareTo(stockInVO.getInDate())>0){
            return ResultMessage.FAILED;
        }
        //……

        StockInPO stockInPO=new StockInPO(stockInVO.getDeliveryNum(),stockInVO.getInDate(),stockInVO.getEnd(),stockInVO.getZoneNum(),
                stockInVO.getRowNum(),stockInVO.getShelfNum(),stockInVO.getPositionNum());

        list.stockIn(stockInVO);
        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……

        //添加到库存
        stockPO.add(stockInPO);
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

    /**
     * 待完善的内部判断代码
     *
     * @return
     */
    private boolean isFull() {
        return false;
    }
}
