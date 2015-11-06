package src.businesslogic.financebl;

import src.businesslogicservice.FinanceblService;
import src.vo.AccountVO;
import src.vo.GatheringVO;
import src.vo.InstitutionVO;
import src.vo.PaymentVO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/1 0001.
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
    public ResultMessage initial(InstitutionVO institutionVO) {
        return null;
    }

    @Override
    public ResultMessage addAccount(AccountVO accountVO) {
        return null;
    }

    @Override
    public ArrayList<AccountVO> searchAccount() {
        return null;
    }

    @Override
    public AccountVO searchAccount(String name) {
        return null;
    }

    @Override
    public ResultMessage delAccount(AccountVO accountVO) {
        return null;
    }

    @Override
    public ResultMessage editAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        return null;
    }
}
