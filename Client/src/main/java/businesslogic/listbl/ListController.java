package businesslogic.listbl;

import businesslogic.Exception.*;
import businesslogicservice.ListblService;
import util.ResultMessage;
import vo.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/30 0030.
 *
 * @author myk
 */
public class ListController implements ListblService {

    /**
     * The List.
     */
    List list;


    public ResultMessage order(OrderVO orderVO) throws RemoteException {
        return new Order().save(orderVO);
    }

    public ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException {
        return new AddresseeInfomation().save(addresseeInformationVO);
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO) throws MoneyException, OtherException, DateException, InvalidIntegerException, RemoteException {
        return new LoadingInfo().save(loadingVO);
    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO) throws RemoteException {
        return new ReceiveInfo().save(receiveVO);
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO) throws DateException, RemoteException {
        return new DistributeInfo().save(distributeVO);
    }

    public ResultMessage receipt(ReceiptVO receiptVO) throws RemoteException, MoneyException, DateException, DeliverNumException {
        return new Receipt().save(receiptVO);
    }

    public ResultMessage transInfo(TransferVO transferVO) throws RemoteException {
        return new TransInfo().save(transferVO);
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException {
        return new TransArrive().save(transferReceiveVO);
    }

    public ResultMessage stockOut(StockOutVO stockOutVO) throws RemoteException {
        return new StockOut().save(stockOutVO);
    }

    public ResultMessage stockIn(StockInVO stockInVO) throws RemoteException {
        return new StockIn().save(stockInVO);
    }

    public ResultMessage gathering(GatheringVO gatheringVO) throws InvalidDoubleException, DateException, RemoteException {
        return new Gathering().save(gatheringVO);
    }

    public ResultMessage payment(PaymentVO paymentVO) throws RemoteException, MoneyException, DateException {
        return new Payment().save(paymentVO);
    }


    public ArrayList<ListVO> push() throws RemoteException {
        return new List().push();
    }
}
