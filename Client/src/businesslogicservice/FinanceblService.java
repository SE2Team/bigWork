package src.businesslogicservice;

import src.vo.AccountVO;
import src.vo.GatheringVO;
import src.vo.PaymentVO;
import util.ResultMessage;

import java.util.ArrayList;

public interface FinanceblService {
    public ResultMessage gathering(GatheringVO gatheringVO);

    public ResultMessage payment(PaymentVO paymentVO);

    public ResultMessage generateForm();

    public ResultMessage generateForm(String startDate, String endDate);

    public ResultMessage initial(src.vo.InstitutionVO institutionVO);

    public ResultMessage addAccount(AccountVO accountVO);

    public ArrayList<AccountVO> searchAccount();

    public AccountVO searchAccount(String name);

    public ResultMessage delAccount(AccountVO accountVO);

    public ResultMessage editAccount(AccountVO accountVOOld, AccountVO accountVONew);

}
