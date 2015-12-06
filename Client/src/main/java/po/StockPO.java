package po;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public class StockPO implements Serializable {
	private static final long serialVersionUID = 1L;//序列化编号

	private String stockState;//库存状态

	private ArrayList<StockInPO> stockList;
//TODO 库存最大容量和报警容量
	
	public String getStockState(){
		return stockState;
	}

	public void add(StockInPO stockInPO){
		stockList.add(stockInPO);
	}

	public void remove(String num){
		for(int i=0;i<stockList.size();i++){
			StockInPO temp=stockList.get(i);

			if(temp.getDeliveryNum()==num)
				stockList.remove(i);
		}
	}

	public ArrayList<StockInPO> getStockList() {
		return stockList;
	}
}
