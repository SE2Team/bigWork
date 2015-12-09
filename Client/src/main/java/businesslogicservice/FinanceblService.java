package businesslogicservice;

import util.ExistException;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.Iterator;

public interface FinanceblService {
    boolean gathering(GatheringVO gatheringVO) throws RemoteException;

    boolean payment(PaymentVO paymentVO) throws RemoteException;

    boolean generateForm() throws RemoteException;

    boolean generateForm(String startDate, String endDate) throws RemoteException;

    boolean initial(String institution);

    boolean addAccount(AccountVO accountVO) throws  RemoteException, ExistException;

    Iterator<AccountVO> searchAccount() throws RemoteException;

    AccountVO searchAccount(String name) throws RemoteException;

    boolean DelAccount(AccountVO accountVO) throws RemoteException;

    boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws RemoteException, ExistException;

}
