package businesslogic.financebl;

import businesslogicservice.FinanceblService;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class FinanceController implements FinanceblService {

    public ResultMessage gathering(GatheringVO gatheringVO) {
        return null;
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        return null;
    }

    public ResultMessage generateForm() {
        return null;
    }

    public ResultMessage generateForm(String startDate, String endDate) {
        return null;
    }

    public ResultMessage initial(String institution) {
        return null;
    }

    public ResultMessage addAccount(AccountVO accountVO) {
        return null;
    }

    public ResultMessage searchAccount() {
        return null;
    }

    public ResultMessage searchAccount(String name) {
        return null;
    }

    public ResultMessage DelAccount(AccountVO accountVO) {
        return null;
    }

    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        return null;
    }
}
