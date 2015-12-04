package dataservice.listdataservice;

import po.*;
import util.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ListDataService extends Remote{
    public ResultMessage save(OrderPO orderPO) throws RemoteException;

    public ResultMessage save(AddresseeInformationPO addresseeInformationPO)throws RemoteException;

    public ResultMessage save(LoadingPO loadingPO) throws RemoteException;

    public ResultMessage save(ReceivePO receivePO) throws RemoteException;

    public ResultMessage save(DistributePO distributePO) throws RemoteException;

    public ResultMessage save(ReceiptPO receiptPO) throws RemoteException;

    public ResultMessage save(TransferPO transferPO) throws RemoteException;

    public ResultMessage save(TransferReceivePO transferReceivePO) throws RemoteException;

    public ResultMessage save(StockOutPO stockOutPO) throws RemoteException;

    public ResultMessage save(StockInPO stockInPO) throws RemoteException;

    public ResultMessage save(PaymentPO paymentPO) throws RemoteException;

    public ResultMessage save(GatheringPO gatheringPO) throws RemoteException;
    
    public ResultMessage saveAsList(ListPO listPo) throws RemoteException;
    
    public ArrayList<ListPO> checkList() throws RemoteException;
}
