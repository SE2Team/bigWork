package dataservice.financedataservice;

import po.AccountPO;
import util.ExistException;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinanceDataService extends Remote{
    /**
     * TODO 只生成不返回？
     * @return
     */
    public String get() throws RemoteException;

    /**
     * TODO 同上啊？
     * @param startDate
     * @param endDate
     * @return
     */
    public String get(String startDate, String endDate) throws RemoteException;

    public Boolean addAccount(AccountPO accountPO) throws RemoteException, ExistException;

    public ArrayList<AccountPO> searchAccount()throws RemoteException;

    public AccountPO searchAccount(String name) throws RemoteException;

    /**
     * 通过一个PO来找到对应的账户来删除
     *
     * @param accountPO
     * @return
     */
    public Boolean DelAccount(AccountPO accountPO) throws RemoteException;

    /**
     * @param name
     * @param newAccountPO 新的账户信息
     * @return
     * @throws ExistException 
     */
    public Boolean EditAccount(String name, AccountPO newAccountPO) throws RemoteException, ExistException;


}
