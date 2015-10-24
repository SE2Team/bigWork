package businesslogicservice;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface FinanceblService {
    public boolean gathering(String date,String payee,String name,int money,String location);
    public boolean payment(String date,int money,String name,String account,String entry,String comment);

    //生成成本收益表
    public void generateForm();
    //生成经营情况表
    public void generateForm(String startDate,String endDate);
    //未完成
    public boolean initial(String institution);
    public boolean addAccount(String name,int money);
    public boolean searchAccount();
    public boolean searchAccount(String name);
    public boolean DelAccount(String name);
    public boolean EditAccount(String name);

}
