package businesslogicservice;

import businesslogic.Exception.InvalidDoubleException;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

public interface FinanceblService {
    ResultMessage gathering(GatheringVO gatheringVO);

    ResultMessage payment(PaymentVO paymentVO);

    ResultMessage generateForm();

    ResultMessage generateForm(String startDate, String endDate);

    ResultMessage initial(String institution);

    ResultMessage addAccount(AccountVO accountVO) throws InvalidDoubleException;

    ArrayList<AccountVO> searchAccount();

    AccountVO searchAccount(String name);

    ResultMessage DelAccount(AccountVO accountVO);

    ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew);

}
