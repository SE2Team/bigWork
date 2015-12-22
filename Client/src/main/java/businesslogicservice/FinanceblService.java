package businesslogicservice;

import po.AccountPO;
import po.StockPO;
import po.VehiclePO;
import po.WorkerPO;
import util.ExistException;
import vo.AccountVO;
import vo.GatheringVO;
import vo.PaymentVO;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * @author WANXING
 */
public interface FinanceblService {
    /**
     * @param gatheringVO 传入一个收款单VO
     * @return
     * @throws RemoteException 网络异常
     */
    boolean gathering(GatheringVO gatheringVO) throws RemoteException;

    /**
     * @param paymentVO 传入一个paymentVO
     * @return
     * @throws RemoteException 网络异常
     */
    boolean payment(PaymentVO paymentVO) throws RemoteException;

    /**
     * @return
     * @throws RemoteException 网络异常
     */
    boolean generateForm() throws RemoteException;

    /**
     * @param startDate 传入起始日期
     * @param endDate   传入截止日期
     * @return
     * @throws RemoteException 网络异常
     */
    boolean generateForm(String startDate, String endDate) throws RemoteException;

    /**
     * @param institution 传入机构名称
     * @return
     */
    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(WorkerPO po) throws RemoteException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(VehiclePO po) throws RemoteException;

    /**
     * 设置库存的报警值和上限
     *
     * @param po
     * @return
     */
    boolean initial(StockPO po) throws RemoteException;

    /**
     * @param po
     * @return
     * @throws RemoteException
     */
    boolean initial(AccountPO po) throws RemoteException;

    /**
     * @param accountVO 传入账单vo
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException  异常，该账单已存在，无法添加
     */
    boolean addAccount(AccountVO accountVO) throws RemoteException, ExistException;

    /**
     * @return
     * @throws RemoteException 网络异常
     */
    Iterator<AccountVO> searchAccount() throws RemoteException;

    /**
     * @param name 传入名称string
     * @return
     * @throws RemoteException 网络异常
     */
    AccountVO searchAccount(String name) throws RemoteException;

    /**
     * @param accountVO 传入账单vo
     * @return
     * @throws RemoteException 网络异常
     */
    boolean DelAccount(AccountVO accountVO) throws RemoteException;

    /**
     * @param accountVOOld 传入原来账单
     * @param accountVONew 传入新的账单
     * @return
     * @throws RemoteException 网络异常
     * @throws ExistException
     */
    boolean EditAccount(AccountVO accountVOOld, AccountVO accountVONew) throws RemoteException, ExistException;

}
