package dataservice.financedataservice;

import po.AccountPO;
import util.ResultMessage;

import java.util.ArrayList;

public interface FinanceDataService {
    /**
     * TODO 只生成不返回？
     * @return
     */
    public String get();

    /**
     * TODO 同上啊？
     * @param startDate
     * @param endDate
     * @return
     */
    public String get(String startDate, String endDate);

    public boolean addAccount(AccountPO accountPO);

    public ArrayList<AccountPO> searchAccount();

    public AccountPO searchAccount(String name);

    /**
     * 通过一个PO来找到对应的账户来删除
     *
     * @param accountPO
     * @return
     */
    public ResultMessage DelAccount(AccountPO accountPO);

    /**
     * @param name
     * @param newAccountPO 新的账户信息
     * @return
     */
    public ResultMessage EditAccount(String name, AccountPO newAccountPO);


}
