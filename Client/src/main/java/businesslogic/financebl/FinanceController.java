package businesslogic.financebl;

import businesslogicservice.FinanceblService;
import util.ExistException;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

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

    public boolean payment(PaymentVO paymentVO) throws RemoteException {
        return finance.payment(paymentVO);
    }

    public boolean generateForm() throws RemoteException {
        return finance.generateForm();
    }

    public boolean generateForm(String startDate, String endDate) throws RemoteException {
        return finance.generateForm(startDate, endDate);
    }

    public boolean initial(WorkerVO vo) throws RemoteException {
        return finance.initial(vo);
    }

    public boolean initial(VehicleVO vo) throws RemoteException {
        return finance.initial(vo);

    }

    public boolean initial(StockVO vo) throws RemoteException {
        return finance.initial(vo);

    }

    public boolean initial(AccountVO vo) throws RemoteException {
        return finance.initial(vo);

    }


    public boolean addAccount(AccountVO accountVO) throws RemoteException, ExistException {
        return finance.addAccount(accountVO);
    }

    public Iterator<AccountVO> searchAccount() throws RemoteException {
        return finance.searchAccount().iterator();
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

    public Iterator<GatheringVO> checkGathering() throws RemoteException {
        return finance.checkGathering();
    }

    public Iterator<WorkerVO> checkInitWorker() throws RemoteException {
        return finance.checkInitWorker();
    }

    public Iterator<VehicleVO> checkInitVehicle() throws RemoteException {
        return finance.checkInitVehicle();
    }

    public Iterator<AccountVO> checkInitAccount() throws RemoteException {
        return finance.checkInitAccount();
    }

    public StockVO checkInitStock() throws RemoteException {
        return finance.checkInitStock();
    }

    public Iterator<OrganizationVO> checkInitOrganization() throws RemoteException {
        return finance.checkInitOrganization();
    }
}
