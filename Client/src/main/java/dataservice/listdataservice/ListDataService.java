package dataservice.listdataservice;

import po.*;
import util.ExistException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;

public interface ListDataService extends Remote{
	public ExpenseAndDatePO getExpenseOfTransport(ExpenseAndDatePO expenseAndDate) throws RemoteException, ExistException;
	
    public Boolean save(OrderPO orderPO) throws RemoteException;

    public Boolean save(AddresseeInformationPO addresseeInformationPO)throws RemoteException;

    public Boolean save(LoadingPO loadingPO) throws RemoteException;

    public Boolean save(ReceivePO receivePO) throws RemoteException;

    public Boolean save(DistributePO distributePO) throws RemoteException;

    public Boolean save(ReceiptPO receiptPO) throws RemoteException;

    public Boolean save(TransferPO transferPO) throws RemoteException;

    public Boolean save(TransferReceivePO transferReceivePO) throws RemoteException;

    public Boolean save(StockOutPO stockOutPO) throws RemoteException;

    public Boolean save(StockInPO stockInPO) throws RemoteException;

    public Boolean save(PaymentPO paymentPO) throws RemoteException;

    public Boolean save(GatheringPO gatheringPO) throws RemoteException;
    
    public Boolean saveAsList(ListPO listPo) throws RemoteException;
    
    public Iterator<ListPO> checkList() throws RemoteException;

    /**
     * 获取最近的单据的审批情况
     * @param start
     * @param end
     * @return
     */
    Iterator<ListPO> getRecent(String start,String end);
}
