package businesslogic.financebl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InvalidDoubleException;
import businesslogic.Exception.MoneyException;
import businesslogic.listbl.ListController;
import businesslogicservice.ListblService;
import dataservice.DataFactory;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;
import util.ResultMessage;
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
     * The Data factory.
     */
    DataFactoryService dataFactory;


    /**
     * The Finance.
     */
    FinanceDataService finance;

    /**
     * Instantiates a new Finance.
     *
     * @throws RemoteException the remote exception
     */
    public Finance() throws RemoteException {
        dataFactory = DataFactory.getInstance();
        finance = dataFactory.getFinanceData();
    }

    /**
     * Gathering result message.
     *
     * @param gatheringVO the gathering vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage gathering(GatheringVO gatheringVO) throws RemoteException, InvalidDoubleException, DateException {
        ListblService list = new ListController();
        /**
         *判断输入是否合法
         */

        list.gathering(gatheringVO);

        return ResultMessage.SUCCESS;
    }

    /**
     * Payment result message.
     *
     * @param paymentVO the payment vo
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage payment(PaymentVO paymentVO) throws RemoteException, DateException, MoneyException {
        ListblService list = new ListController();

        /**
         *判断输入是否合法
         */


        list.payment(paymentVO);
        return ResultMessage.SUCCESS;
    }

    /**
     * Generate form result message.
     *
     * @return the result message
     */
    public ResultMessage generateForm() {
        finance.get();

        return ResultMessage.SUCCESS;
    }

    /**
     * Generate form result message.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return the result message
     * @throws RemoteException the remote exception
     */
    public ResultMessage generateForm(String startDate, String endDate) throws RemoteException {
        /**
         *判断输入是否合法
         */


        finance.get(startDate, endDate);
        return ResultMessage.SUCCESS;
    }

    /**
     * Initial result message.
     *
     * @param institution the institution
     * @return the result message
     */
//TODO data层接口待讨论
    public ResultMessage initial(String institution) {
        return null;
    }

    /**
     * Add account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public ResultMessage addAccount(AccountVO accountVO) {

        finance.addAccount(new AccountPO(accountVO.getAccountName(), accountVO.getAccountBalance()));
        //数据层的异常……
        return ResultMessage.SUCCESS;
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
    public AccountVO searchAccount(String name) {
        if (name.length() == 0) {
            //抛出找不到的异常
        }
        AccountPO accountPO = finance.searchAccount(name);
        AccountVO accountVO = new AccountVO(accountPO.getAccountName(), accountPO.getAccountBalance());
        return accountVO;
    }

    /**
     * Del account result message.
     *
     * @param accountVO the account vo
     * @return the result message
     */
    public ResultMessage DelAccount(AccountVO accountVO) {
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
    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        //判断输入的合法性

        //名字与已存在的是否冲突交给数据层判断
        AccountPO accountPO = new AccountPO(accountVONew.getAccountName(), accountVONew.getAccountBalance());
        return finance.EditAccount(accountVOOld.getAccountName(), accountPO);
    }
}
