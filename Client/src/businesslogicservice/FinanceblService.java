package businesslogicservice;

import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

public interface FinanceblService {
    public boolean gathering(GatheringVO gatheringVO);

    public boolean payment(PaymentVO paymentVO);

    public void generateForm();

    public void generateForm(String startDate,String endDate);

    public boolean initial(String institution);

    public boolean addAccount(AccountVO accountVO);

    public boolean searchAccount();

    public boolean searchAccount(String name);

    public boolean DelAccount(AccountVO accountVO);

    public boolean EditAccount(AccountVO accountVOOld,AccountVO accountVONew);

}
