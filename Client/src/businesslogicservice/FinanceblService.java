package businesslogicservice;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public interface FinanceblService {
    public boolean gathering(String date,String payee,String name,int money,String location);
    public boolean payment(String date,int money,String name,String account,String entry,String comment);

    //���ɳɱ������
    public void generateForm();
    //���ɾ�Ӫ�����
    public void generateForm(String startDate,String endDate);
    //δ���
    public boolean initial(String institution);
    public boolean addAccount(String name,int money);
    public boolean searchAccount();
    public boolean searchAccount(String name);
    public boolean DelAccount(String name);
    public boolean EditAccount(String name);

}
