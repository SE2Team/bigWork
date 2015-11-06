package src.dataservice.financedataservice;

import src.po.AccountPO;
import src.po.InstitutionPO;
import util.ResultMessage;

public interface FinanceDataService {
    public String get();

    public String get(String startDate, String endDate);

    public ResultMessage addAccount(AccountPO accountPO);

    public AccountPO searchAccount();

    public AccountPO searchAccount(String name);

    /**
     * 通过一个PO来找到对应的账户来删除
     *
     * @param accountPO
     * @return
     */
    public ResultMessage delAccount(AccountPO accountPO);

    /**
     * @param name
     * @param newAccountPO 新的账户信息
     * @return
     */
    public ResultMessage editAccount(String name, AccountPO newAccountPO);

    public ResultMessage initial(InstitutionPO institutionPO);

}
