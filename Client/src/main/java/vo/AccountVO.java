package vo;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class AccountVO {

    /**
     * 账户名称和余额
     */
    private String accountName;
    private String accountBalance;

    public AccountVO(String accountName, String accountBalance) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public AccountVO() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
