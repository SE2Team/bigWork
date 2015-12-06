package businesslogicservice;

import businesslogic.Exception.*;
import util.ResultMessage;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ListblService {
    //订单
    ResultMessage order(OrderVO orderVO) throws OtherException, RemoteException;

    //收件单
    ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws DateException, RemoteException;

    //装车单
    ResultMessage loadingInfo(LoadingVO loadingVO) throws MoneyException, OtherException, DateException, InvalidIntegerException, RemoteException;

    //接收单
    ResultMessage receiveInfo(ReceiveVO receiveVO) throws RemoteException;

    //派件单
    ResultMessage distributeInfo(DistributeVO distributeVO) throws DateException, RemoteException;

    //营业厅业务员建的收款单
    ResultMessage receipt(ReceiptVO receiptVO) throws RemoteException, MoneyException, DateException, DeliverNumException;

    //中转单
    ResultMessage transInfo(TransferVO transferVO) throws RemoteException;

    //中转中心到达单
    ResultMessage transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException;

    //入库单
    ResultMessage stockOut(StockOutVO stockOutVO) throws RemoteException;

    //出库单
    ResultMessage stockIn(StockInVO stockInVO) throws RemoteException;

    //财务人员建的收款单
    ResultMessage gathering(GatheringVO gatheringVO) throws InvalidDoubleException, DateException, RemoteException;

    //付款单
    ResultMessage payment(PaymentVO paymentVO) throws RemoteException, MoneyException, DateException;


    ArrayList<ListVO> push() throws RemoteException;
}
