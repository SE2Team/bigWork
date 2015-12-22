package businesslogic.financebl;

import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;
import po.StockPO;
import po.VehiclePO;
import po.WorkerPO;
import util.ExistException;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 *
 * @author myk
 */
public class Finance {


    /**
     * The Finance.
     */
    private FinanceDataService finance;

    /**
     * Instantiates a new Finance.
     *
     * @throws RemoteException the remote exception
     */
    public Finance() throws RemoteException {
        /*
      The Data factory.
     */
        DataFactoryService dataFactory = DataFactory.getInstance();
        finance = dataFactory.getFinanceData();
    }

    /**
     * Gathering result message.
     *
     * @param gatheringVO the gathering vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean gathering(GatheringVO gatheringVO) throws RemoteException {
        ListblService list = new ListController();
        /**
         *判断输入是否合法
         */

        list.gathering(gatheringVO);

        return false;
    }

    /**
     * Payment result message.
     *
     * @param paymentVO the payment vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean payment(PaymentVO paymentVO) throws RemoteException {
        ListblService list = new ListController();

        /**
         *判断输入是否合法
         */


        list.payment(paymentVO);
        return true;
    }

    /**
     * Generate form result message.
     *
     * @return the result message
     */
    public boolean generateForm() throws RemoteException {
        finance.get();

        return false;
    }

    /**
     * Generate form result message.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public boolean generateForm(String startDate, String endDate) throws RemoteException {
        /**
         *判断输入是否合法
         */


        finance.get(startDate, endDate);
        return false;
    }

    /**
     * 期初建账
     *
     * @param institution the institution
     * @return the result message
     */
    public boolean initial(String institution) {
        return false;
    }

    /**
     * Add account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public boolean addAccount(AccountVO accountVO) throws RemoteException, ExistException {
        finance.addAccount(new AccountPO(accountVO.getAccountName(), accountVO.getAccountBalance()));
        return false;
    }

    /**
     * 完成
     *
     * @return array list
     * @throws RemoteException the remote exception
     */
    public ArrayList<AccountVO> searchAccount() throws RemoteException {
        ArrayList<AccountPO> accountPOList = finance.searchAccount();
        ArrayList<AccountVO> accountVOList = new ArrayList<AccountVO>();

        for (AccountPO temp : accountPOList) {
            accountVOList.add(new AccountVO(temp.getAccountName(), temp.getAccountBalance()));
        }

        return accountVOList;
    }

    /**
     * Search account account vo.
     *
     * @param name the name
     * @return the account vo
     */
    public AccountVO searchAccount(String name) throws RemoteException {
        AccountPO accountPO = finance.searchAccount(name);
        return new AccountVO(accountPO.getAccountName(), accountPO.getAccountBalance());
    }

    /**
     * Del account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public boolean DelAccount(AccountVO accountVO) throws RemoteException {
        AccountPO accountPO = new AccountPO(accountVO.getAccountName(), accountVO.getAccountBalance());

        return finance.DelAccount(accountPO);
    }

    /**
     * Edit account result message.
     *
     * @param accountVOOld the account vo old
     * @param accountVONew the account vo new
     * @return the result message
     */
    public boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws RemoteException, ExistException {
        //判断输入的合法性

        //名字与已存在的是否冲突交给数据层判断
        AccountPO accountPO = new AccountPO(accountVONew.getAccountName(), accountVONew.getAccountBalance());
        return finance.EditAccount(accountVOOld.getAccountName(), accountPO);
    }

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(WorkerPO po) throws RemoteException{
        return finance.initial(po);
    }

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(VehiclePO po) throws RemoteException{
        return finance.initial(po);
    }

    /**
     *
     *
     * @param po
     * @return
     */
    boolean initial(StockPO po) throws RemoteException{
        return finance.initial(po);

    }

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(AccountPO po) throws RemoteException{
        return finance.initial(po);

    }
}
