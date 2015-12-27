package businesslogic.listbl;

import businesslogicservice.ListblService;
import vo.*;

import java.rmi.RemoteException;
import java.util.Iterator;

/**
 * Created by Administrator on 2015/10/30 0030.
 *
 * @author myk
 */
public class ListController implements ListblService {
    private List list;

    public ListController() throws RemoteException {
        list = new List();
    }


//    public boolean order(OrderVO orderVO) throws RemoteException {
//        return new Order().save(orderVO);
//    }
//
//    public boolean addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException {
//        return new AddresseeInfomation().save(addresseeInformationVO);
//    }
//
//    public boolean loadingInfo(LoadingVO loadingVO) throws RemoteException {
//        return new LoadingInfo().save(loadingVO);
//    }
//
//    public boolean receiveInfo(ReceiveVO receiveVO) throws RemoteException {
//        return new ReceiveInfo().save(receiveVO);
//    }
//
//    public boolean distributeInfo(DistributeVO distributeVO) throws RemoteException {
//        return new DistributeInfo().save(distributeVO);
//    }
//
//    public boolean receipt(ReceiptVO receiptVO) throws RemoteException {
//        return new Receipt().save(receiptVO);
//    }
//
//    public boolean transInfo(TransferVO transferVO) throws RemoteException {
//        return new TransInfo().save(transferVO);
//    }
//
//    public boolean transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException {
//        return new TransArrive().save(transferReceiveVO);
//    }
//
//    public boolean stockOut(StockOutVO stockOutVO) throws RemoteException {
//        return new StockOut().save(stockOutVO);
//    }
//
//    public boolean stockIn(StockInVO stockInVO) throws RemoteException {
//        return new StockIn().save(stockInVO);
//    }
//
//    public boolean gathering(GatheringVO gatheringVO) throws RemoteException {
//        return new Gathering().save(gatheringVO);
//    }
//
//    public boolean payment(PaymentVO paymentVO) throws RemoteException {
//        return new Payment().save(paymentVO);
//    }


    public Iterator<ListVO> push() throws RemoteException {

        return new List().push();
    }


    public boolean save(AddresseeInformationVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(DistributeVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(LoadingVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(OrderVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(StockInVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(StockOutVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(PaymentVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(GatheringVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(TransferVO vo) throws RemoteException {

        return list.save(vo);
    }


    public boolean save(TransferReceiveVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(ReceiveVO vo) throws RemoteException {

        return list.save(vo);
    }

    public boolean save(ReceiptVO vo) throws RemoteException {

        return list.save(vo);
    }


    public Iterator<ListVO> getRecent(String date) throws RemoteException {
        return list.getRecent(date);
    }

    @Deprecated
    public boolean save2File(ListVO vo) throws RemoteException {
        return false;
    }

    public boolean save2File(AddresseeInformationVO vo) throws RemoteException {
        return new AddresseeInfomation().save2File(vo);
    }

    public boolean save2File(DistributeVO vo) throws RemoteException {
        return new DistributeInfo().save2File(vo);
    }

    public boolean save2File(GatheringVO vo) throws RemoteException {
        return new Gathering().save2File(vo);
    }

    public boolean save2File(LoadingVO vo) throws RemoteException {
        return new LoadingInfo().save2File(vo);
    }

    public boolean save2File(OrderVO vo) throws RemoteException {
        return new Order().save2File(vo);
    }

    public boolean save2File(PaymentVO vo) throws RemoteException {

        return new Payment().save2File(vo);
    }

    public boolean save2File(ReceiptVO vo) throws RemoteException {

        return new Receipt().save2File(vo);
    }

    public boolean save2File(ReceiveVO vo) throws RemoteException {

        return new ReceiveInfo().save2File(vo);
    }

    public boolean save2File(StockInVO vo) throws RemoteException {

        return new StockIn().save2File(vo);
    }

    public boolean save2File(StockOutVO vo) throws RemoteException {
        return new StockOut().save2File(vo);
    }

    public boolean save2File(TransferReceiveVO vo) throws RemoteException {
        return new TransArrive().save2File(vo);
    }

    public boolean save2File(TransferVO vo) throws RemoteException {
        return new TransInfo().save2File(vo);
    }
}
