package businesslogicservice;

import businesslogic.Exception.DateException;
import businesslogic.Exception.InputNullException;
import businesslogic.Exception.InvalidDoubleException;
import businesslogic.Exception.MoneyException;
import util.ResultMessage;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FinanceblService {
    ResultMessage gathering(GatheringVO gatheringVO) throws InvalidDoubleException, DateException, RemoteException;

    ResultMessage payment(PaymentVO paymentVO) throws InvalidDoubleException, DateException, RemoteException, MoneyException;

    ResultMessage generateForm();

    ResultMessage generateForm(String startDate, String endDate) throws DateException, RemoteException;

    ResultMessage initial(String institution);

    ResultMessage addAccount(AccountVO accountVO) throws InvalidDoubleException, InputNullException;

    ArrayList<AccountVO> searchAccount() throws RemoteException;

    AccountVO searchAccount(String name);

    ResultMessage DelAccount(AccountVO accountVO);

    ResultMessage EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws InvalidDoubleException;

}
