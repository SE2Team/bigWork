package data.financedata;

import dataservice.financedataservice.FinanceDataService;
import po.AccountPO;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class FinancedataImpl implements FinanceDataService{
    public String get() {
        return null;
    }

    public String get(String startDate, String endDate) {
        return null;
    }

    public boolean addAccount(AccountPO accountPO) {
        return false;
    }

    public AccountPO searchAccount() {
        return null;
    }

    public AccountPO searchAccount(String name) {
        return null;
    }

    public boolean DelAccount(AccountPO accountPO) {
        return false;
    }

    public boolean EditAccount(String name, AccountPO newAccountPO) {
        return false;
    }
}
