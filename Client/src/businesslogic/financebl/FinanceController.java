package src.businesslogic.financebl;

import src.businesslogicservice.FinanceblService;
import src.vo.AccountVO;
import src.vo.GatheringVO;
import src.vo.PaymentVO;
import util.ResultMessage;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class FinanceController implements FinanceblService {

    @Override
    public ResultMessage gathering(GatheringVO gatheringVO) {
        return null;
    }

    @Override
    public ResultMessage payment(PaymentVO paymentVO) {
        return null;
    }

    @Override
    public ResultMessage generateForm() {
        return null;
    }

    @Override
    public ResultMessage generateForm(String startDate, String endDate) {
        return null;
    }

    @Override
    public ResultMessage initial(String institution) {
        return null;
    }

    @Override
    public ResultMessage addAccount(AccountVO accountVO) {
        return null;
    }

    @Override
    public ResultMessage searchAccount() {
        return null;
    }

    @Override
    public ResultMessage searchAccount(String name) {
        return null;
    }

    @Override
    public ResultMessage DelAccount(AccountVO accountVO) {
        return null;
    }

    @Override
    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        return null;
    }
}
