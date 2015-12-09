package dataservice.financedataservice;

import po.AccountPO;
import po.StockPO;
import po.VehiclePO;
import po.WorkerPO;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

public interface FinanceDataService extends Remote{
    /**
     *
     * @return
     */
     String get() throws RemoteException;

    /**
     * @param startDate
     * @param endDate
     * @return
     */
     String get(String startDate, String endDate) throws RemoteException;

     Boolean addAccount(AccountPO accountPO) throws RemoteException, ExistException;

     ArrayList<AccountPO> searchAccount()throws RemoteException;

     AccountPO searchAccount(String name) throws RemoteException;

    /**
     * 通过一个PO来找到对应的账户来删除
     *
     * @param accountPO
     * @return
     */
     Boolean DelAccount(AccountPO accountPO) throws RemoteException;

    /**
     * @param name
     * @param newAccountPO 新的账户信息
     * @return
     * @throws ExistException 
     */
     Boolean EditAccount(String name, AccountPO newAccountPO) throws RemoteException, ExistException;

    boolean initial(WorkerPO po) throws RemoteException;

    boolean initial(VehiclePO po) throws RemoteException;

    /**
     * 设置库存的报警值和上限
     * @param po
     * @return
     */
    boolean initial(StockPO po) throws RemoteException;

    boolean initial(AccountPO po) throws RemoteException;

    Iterator<WorkerPO> checkInitWorker() throws RemoteException;

    Iterator<VehiclePO> checkInitVehicle() throws RemoteException;

    Iterator<AccountPO> checkInitAccount() throws RemoteException;

    StockPO checkInitStock() throws RemoteException;

}
