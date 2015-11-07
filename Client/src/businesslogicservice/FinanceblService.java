package src.businesslogicservice;

import src.util.ResultMessage;
import src.vo.*;

public interface FinanceblService {
    public ResultMessage gathering(GatheringVO gatheringVO);

    public ResultMessage payment(PaymentVO paymentVO);

    public ResultMessage generateForm();

    public ResultMessage generateForm(String startDate,String endDate);

    public ResultMessage initial(String institution);

    public ResultMessage addAccount(AccountVO accountVO);

    public ResultMessage searchAccount();

    public ResultMessage searchAccount(String name);

    public ResultMessage DelAccount(AccountVO accountVO);

    public ResultMessage EditAccount(AccountVO accountVOOld,AccountVO accountVONew);

}
