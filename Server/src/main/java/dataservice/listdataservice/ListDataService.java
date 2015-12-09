package dataservice.listdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import po.*;
import util.ExistException;
import util.ResultMessage;

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
}
