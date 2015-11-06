package src.businesslogic.financebl;

import src.vo.AccountVO;
import src.vo.GatheringVO;
import util.ResultMessage;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class Finance {
    public ResultMessage gathering(GatheringVO gatheringVO) {
        return null;
    }

    public ResultMessage payment(src.vo.PaymentVO paymentVO) {
        return null;
    }

    /**
     * 成本收益表
     *
     * @return
     */
    public ResultMessage generateForm() {
        return null;
    }

    /**
     * 经营情况表
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public ResultMessage generateForm(String startDate, String endDate) {
        return null;
    }

    public ResultMessage initial(src.vo.InstitutionVO institutionVO) {
        return null;
    }

    public ResultMessage addAccount(AccountVO accountVO) {
        return null;
    }

    public ArrayList<AccountVO> searchAccount() {
        return null;
    }

    public AccountVO searchAccount(String name) {
        return null;
    }

    public ResultMessage delAccount(AccountVO accountVO) {
        return null;
    }

    public ResultMessage editAccount(AccountVO accountVOOld, AccountVO accountVONew) {
        return null;
    }
}