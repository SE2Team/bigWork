package vo;

import po.StockInPO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class StockVO {

    private static final long serialVersionUID = 1L;//序列化编号

    private boolean stockState;//库存状态

    private String capacity;


    private String warning;

    private ArrayList<StockInPO> stockList;//TODO 后期加入排序处理

    public StockVO(Boolean stockState, ArrayList<StockInPO> stockList) {
        this.stockState = stockState;
        this.stockList = stockList;
    }

    public boolean getStockState() {
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

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean isStockState() {
        return stockState;
    }

    public void setStockState(boolean stockState) {
        this.stockState = stockState;
    }

    public void setStockList(ArrayList<StockInPO> stockList) {
        this.stockList = stockList;
    }


}
