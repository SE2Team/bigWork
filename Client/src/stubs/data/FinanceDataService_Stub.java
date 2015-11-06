package src.stubs.data;

import src.dataservice.financedataservice.FinanceDataService;
import src.po.AccountPO;

public class FinanceDataService_Stub implements FinanceDataService {

    public FinanceDataService_Stub() {

    }

    public String get() {
        System.out.println("Success");
        return null;
    }

    public String get(String startDate, String endDate) {
        System.out.println("Success");
        return null;
    }

    public boolean addAccount(String name, int money) {
        System.out.println("Success");
        return true;
    }

    public AccountPO searchAccount() {
        System.out.println("Success");
        AccountPO po = new AccountPO();
        return po;
    }

    public AccountPO searchAccount(String name) {
        System.out.println("Success");
        AccountPO po = new AccountPO();
        return po;
    }

    public boolean DelAccount(AccountPO accountPO) {
        System.out.println("Success");
        return true;
    }

    public boolean EditAccount(String name, AccountPO newAccountPO) {
        System.out.println("Success");
        return true;
    }

    public boolean addAccount(AccountPO accountPO) {
        return false;
    }

}
