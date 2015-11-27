package businesslogic.financebl;

import businesslogic.Exception.InvalidDoubleException;
import businesslogicservice.FinanceblService;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class FinanceController implements FinanceblService {
    Finance finance=new Finance();

    public ResultMessage gathering(GatheringVO gatheringVO) {
        return finance.gathering(gatheringVO);
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        return finance.payment(paymentVO);
    }

    public ResultMessage generateForm() {
        return finance.generateForm();
    }

    public ResultMessage generateForm(String startDate, String endDate) {
        return finance.generateForm(startDate,endDate);
    }

    public ResultMessage initial(String institution) {
        return finance.initial(institution);
    }

    public ResultMessage addAccount(AccountVO accountVO) throws InvalidDoubleException {
        return finance.addAccount(accountVO);
    }

    public ArrayList<AccountVO> searchAccount() {
        return finance.searchAccount();
    }

    public AccountVO searchAccount(String name) {
        return finance.searchAccount(name);
    }

    public ResultMessage DelAccount(AccountVO accountVO) {
        return finance.DelAccount(accountVO);
    }

    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        return finance.EditAccount(accountVOOld,accountVONew);
    }
}
