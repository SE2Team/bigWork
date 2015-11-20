package businesslogicservice;

import util.ResultMessage;
import vo.*;

public interface FinanceblService {
    ResultMessage gathering(GatheringVO gatheringVO);

    ResultMessage payment(PaymentVO paymentVO);

    ResultMessage generateForm();

    ResultMessage generateForm(String startDate, String endDate);

    ResultMessage initial(String institution);

    ResultMessage addAccount(AccountVO accountVO);

    ResultMessage searchAccount();

    ResultMessage searchAccount(String name);

    ResultMessage DelAccount(AccountVO accountVO);

    ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew);

}
