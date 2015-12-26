package dataservice.listdataservice;

import po.*;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ListDataService extends Remote {
    /**
     * @param expenseAndDate
     * @return
     * @throws RemoteException
     * @throws ExistException
     */
    ExpenseAndDatePO getExpenseOfTransport(ExpenseAndDatePO expenseAndDate) throws RemoteException, ExistException;

    /**
     * @param orderPO
     * @return
     * @throws RemoteException
     */
    Boolean save(OrderPO orderPO) throws RemoteException;

    /**
     * @param addresseeInformationPO
     * @return
     * @throws RemoteException
     */
    Boolean save(AddresseeInformationPO addresseeInformationPO) throws RemoteException;

    /**
     * @param loadingPO
     * @return
     * @throws RemoteException
     */
    Boolean save(LoadingPO loadingPO) throws RemoteException;

    /**
     * @param receivePO
     * @return
     * @throws RemoteException
     */
    Boolean save(ReceivePO receivePO) throws RemoteException;

    /**
     * @param distributePO
     * @return
     * @throws RemoteException
     */
    Boolean save(DistributePO distributePO) throws RemoteException;

    /**
     * @param receiptPO
     * @return
     * @throws RemoteException
     */
    Boolean save(ReceiptPO receiptPO) throws RemoteException;

    /**
     * @param transferPO
     * @return
     * @throws RemoteException
     */
    Boolean save(TransferPO transferPO) throws RemoteException;

    /**
     * @param transferReceivePO
     * @return
     * @throws RemoteException
     */
    Boolean save(TransferReceivePO transferReceivePO) throws RemoteException;

    /**
     * @param stockOutPO
     * @return
     * @throws RemoteException
     */
    Boolean save(StockOutPO stockOutPO) throws RemoteException;

    /**
     * @param stockInPO
     * @return
     * @throws RemoteException
     */
    Boolean save(StockInPO stockInPO) throws RemoteException;

    /**
     * @param paymentPO
     * @return
     * @throws RemoteException
     */
    Boolean save(PaymentPO paymentPO) throws RemoteException;

    /**
     * @param gatheringPO
     * @return
     * @throws RemoteException
     */
    Boolean save(GatheringPO gatheringPO) throws RemoteException;


//    Boolean saveAsList(ListPO listPo) throws RemoteException;

    boolean saveAsList(AddresseeInformationPO po) throws RemoteException;

    boolean saveAsList(DistributePO po) throws RemoteException;

    boolean saveAsList(GatheringPO po) throws RemoteException;

    boolean saveAsList(OrderPO po) throws RemoteException;

    boolean saveAsList(PaymentPO po) throws RemoteException;

    boolean saveAsList(ReceiptPO po) throws RemoteException;

    boolean saveAsList(StockInPO po) throws RemoteException;

    boolean saveAsList(StockOutPO po) throws RemoteException;

    boolean saveAsList(TransferReceivePO po) throws RemoteException;

    boolean saveAsList(ReceivePO po) throws RemoteException;

    boolean saveAsList(LoadingPO po) throws RemoteException;

    boolean saveAsList(TransferPO po) throws RemoteException;


    /**
     * @return
     * @throws RemoteException
     */
    ArrayList<ListPO> checkList() throws RemoteException;

    /**
     * 获取最近的单据的审批情况
     *
     * @param start
     * @param end
     * @return
     * @throws RemoteException
     */
    ArrayList<ListPO> getRecent(String start, String end) throws RemoteException;
}
