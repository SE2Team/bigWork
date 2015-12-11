package dataservice.commoditydataservice;

import po.StockPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;

public interface CommodityDataService extends Remote{
	void update(StockPO PO) throws RemoteException;
	 StockPO check() throws RemoteException;//返回完整的stockpo

	 
	 /**
	  * 初始化库存
	  * @return
	  * @throws RemoteException
	  */
	 StockPO initial() throws RemoteException;
	
	/**
	 * 
	 * 
	 * @param start
	 * @param end
	 * @return 出库数量/入库数量      库存数量
	 * @throws RemoteException
	 */
	Iterator<Integer> check(String start,String end) throws RemoteException;

}
