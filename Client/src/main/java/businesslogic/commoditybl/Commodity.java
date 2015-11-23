package businesslogic.commoditybl;

import data.DataFactory;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.listdataservice.ListDataService;
import po.StockInPO;
import po.StockOutPO;
import util.Helper;
import util.ResultMessage;
import vo.StockInVO;
import vo.StockOutVO;

/**
 * Created by Administrator on 2015/11/1 0001.
 */
public class Commodity {
    DataFactoryService dataFactory=new DataFactory();
    //TODO 所有输入是否为空的判断
    public ResultMessage stockOut(StockOutVO stockOutVO) {
        ListDataService list=dataFactory.getListData();
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
        list.saveStockOut(stockOutPO);

        CommodityDataService commodity=dataFactory.getCommodityData();

        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        ListDataService list=dataFactory.getListData();
        /**
         *判断输入是否合法
         */
        if(stockInVO.getDeliveryNum().length()!=8)//TODO 快递编号长度
            return ResultMessage.FAILED;

        if(Helper.compareToNow(stockInVO.getInDate())>0){
            return ResultMessage.FAILED;
        }
        //……

        StockInPO stockInPO=new StockInPO(stockInVO.getDeliveryNum(),stockInVO.getInDate(),stockInVO.getEnd(),stockInVO.getZoneNum(),
                stockInVO.getRowNum(),stockInVO.getShelfNum(),stockInVO.getPositionNum());

        list.saveStockIn(stockInPO);
        //判断异常代码（数据层返回改对象是否存在等ResultMessage）
        //……

        return ResultMessage.SUCCESS;
    }


    public ResultMessage checkStock(String startDate, String endDate) {
        ListDataService list=dataFactory.getListData();
        /**
         *判断输入是否合法
         */

        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockSum(String startDate, String endDate) {
        return null;
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
