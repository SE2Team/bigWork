package dataservice.financedataservice;

import po.*;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinanceDataService extends Remote {
    /**
     * @return
     */
    ArrayList<String> get() throws RemoteException;

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    ArrayList<String> get(String startDate, String endDate) throws RemoteException;

    /**
     * @param accountPO
     * @return
     * @throws RemoteException
     * @throws ExistException
     */
    Boolean addAccount(AccountPO accountPO) throws RemoteException, ExistException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<AccountPO> searchAccount() throws RemoteException;

    /**
     * @param name
     * @return
     * @throws RemoteException
     */
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

    /**
     * 获得所有收款单数据
     *
     * @return
     */

    ArrayList<GatheringPO> getGathering() throws RemoteException;
    
    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(WorkerPO po) throws RemoteException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(VehiclePO po) throws RemoteException;

    /**
     * 设置库存的报警值和上限
     *
     * @param po
     * @return
     */
    boolean initial(StockPO po) throws RemoteException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(AccountPO po) throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     * @throws ExistException 
     */

    boolean initial(OrganizationPO po) throws RemoteException, ExistException;
    
    ArrayList<WorkerPO> checkInitWorker() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<VehiclePO> checkInitVehicle() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<AccountPO> checkInitAccount() throws RemoteException;

    /**
     * @return
     * @throws RemoteException
     */
    StockPO checkInitStock() throws RemoteException;

 ArrayList<OrganizationPO> checkInitOrganization() throws RemoteException;

}
