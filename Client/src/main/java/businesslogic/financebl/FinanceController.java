package businesslogic.financebl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InputNullException;
import businesslogic.Exception.InvalidDoubleException;
import businesslogicservice.FinanceblService;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 */
public class FinanceController implements FinanceblService {
    Finance finance;

    public FinanceController() throws RemoteException {
        finance = new Finance();
    }


    public ResultMessage gathering(GatheringVO gatheringVO) throws InvalidDoubleException, DateException {
        return finance.gathering(gatheringVO);
    }

    public ResultMessage payment(PaymentVO paymentVO) throws InvalidDoubleException, DateException {
        return finance.payment(paymentVO);
    }

    public ResultMessage generateForm() {
        return finance.generateForm();
    }

    public ResultMessage generateForm(String startDate, String endDate) throws DateException, RemoteException {
        return finance.generateForm(startDate,endDate);
    }

    public ResultMessage initial(String institution){
        return finance.initial(institution);
    }

    public ResultMessage addAccount(AccountVO accountVO) throws InvalidDoubleException, InputNullException {
        return finance.addAccount(accountVO);
    }

    public ArrayList<AccountVO> searchAccount() throws RemoteException {
        return finance.searchAccount();
    }

    public AccountVO searchAccount(String name) {
        return finance.searchAccount(name);
    }

    public ResultMessage DelAccount(AccountVO accountVO) {
        return finance.DelAccount(accountVO);
    }

    public ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws InvalidDoubleException {
        return finance.EditAccount(accountVOOld,accountVONew);
    }
}
