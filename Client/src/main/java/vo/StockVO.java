package vo;

import po.StockInPO;
import po.StockPO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class StockVO {

    private static final long serialVersionUID = 1L;//序列化编号

    private String stockState;//库存状态

    private ArrayList<StockInPO> stockList;//TODO 后期加入排序处理

    public StockVO(StockPO po) {
        this.stockState = po.getStockState();
        this.stockList = po.getStockList();
    }

    public String getStockState() {
        return stockState;
    }

    public void add(StockInPO stockInPO) {
        stockList.add(stockInPO);
    }

    public void remove(String num) {
        for (int i = 0; i < stockList.size(); i++) {
            StockInPO temp = stockList.get(i);

            if (temp.getDeliveryNum() == num)
                stockList.remove(i);
        }
    }

    public ArrayList<StockInPO> getStockList() {
        return stockList;
    }


}
