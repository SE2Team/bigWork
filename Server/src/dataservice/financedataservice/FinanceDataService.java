package src.dataservice.financedataservice;

import src.po.AccountPO;

public interface FinanceDataService {
    public String get();

    public String get(String startDate, String endDate);

    public boolean addAccount(AccountPO accountPO);

    public AccountPO searchAccount();

    public AccountPO searchAccount(String name);

    /**
     * 通过一个PO来找到对应的账户来删除
     *
     * @param accountPO
     * @return
     */
    public boolean DelAccount(AccountPO accountPO);

    /**
     * @param name
     * @param newAccountPO 新的账户信息
     * @return
     */
    public boolean EditAccount(String name, AccountPO newAccountPO);


}
