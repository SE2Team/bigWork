package businesslogicservice;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface FinanceblService {
    /**
     * Gathering boolean.
     *
     * @param date     the date
     * @param payee    the payee
     * @param name     the name
     * @param money    the money
     * @param location the location
     * @return the boolean
     */
    public boolean gathering(String date,String payee,String name,int money,String location);

    /**
     * Payment boolean.
     *
     * @param date    the date
     * @param money   the money
     * @param name    the name
     * @param account the account
     * @param entry   the entry
     * @param comment the comment
     * @return the boolean
     */
    public boolean payment(String date,int money,String name,String account,String entry,String comment);

    /**
     * Generate form.
     */
//生成成本收益表
    public void generateForm();

    /**
     * Generate form.
     *
     * @param startDate the start date
     * @param endDate   the end date
     */
//生成经营情况表
    public void generateForm(String startDate,String endDate);

    /**
     * Initial boolean.
     *
     * @param institution the institution
     * @return the boolean
     */
//未完成
    public boolean initial(String institution);

    /**
     * Add account boolean.
     *
     * @param name  the name
     * @param money the money
     * @return the boolean
     */
    public boolean addAccount(String name,int money);

    /**
     * Search account boolean.
     *
     * @return the boolean
     */
    public boolean searchAccount();

    /**
     * Search account boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean searchAccount(String name);

    /**
     * Del account boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean DelAccount(String name);

    /**
     * Edit account boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public boolean EditAccount(String originalName,String newName);

}
