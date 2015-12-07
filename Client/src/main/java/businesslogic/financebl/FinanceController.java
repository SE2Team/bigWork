package businesslogic.financebl;

import businesslogicservice.FinanceblService;
import util.ExistException;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/11/7 0007.
 *
 * @author myk
 */
public class FinanceController implements FinanceblService {
    /**
     * The Finance.
     */
    private Finance finance;

    /**
     * Instantiates a new Finance controller.
     *
     * @throws RemoteException the remote exception
     */
    public FinanceController() throws RemoteException {
        finance = new Finance();
    }


    public boolean gathering(GatheringVO gatheringVO) throws RemoteException {
        return finance.gathering(gatheringVO);
    }

    public boolean payment(PaymentVO paymentVO) throws RemoteException{
        return finance.payment(paymentVO);
    }

    public boolean generateForm() throws RemoteException {
        return finance.generateForm();
    }

    public boolean generateForm(String startDate, String endDate) throws RemoteException {
        return finance.generateForm(startDate, endDate);
    }

    public boolean initial(String institution) {
        return finance.initial(institution);
    }

    public boolean addAccount(AccountVO accountVO) throws RemoteException, ExistException {
        return finance.addAccount(accountVO);
    }

    public ArrayList<AccountVO> searchAccount() throws RemoteException {
        return finance.searchAccount();
    }

    public AccountVO searchAccount(String name) throws RemoteException {
        return finance.searchAccount(name);
    }

    public boolean DelAccount(AccountVO accountVO) throws RemoteException {
        return finance.DelAccount(accountVO);
    }

    public boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws RemoteException, ExistException {
        return finance.EditAccount(accountVOOld, accountVONew);
    }
}
