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


    public boolean afterCheck(AddresseeInformationVO vo) throws RemoteException {
        return new AddresseeInfomation().afterCheck(vo);
    }

    public boolean afterCheck(DistributeVO vo) throws RemoteException {
        return new DistributeInfo().afterCheck(vo);
    }

    public boolean afterCheck(LoadingVO vo) throws RemoteException {
        return new LoadingInfo().afterCheck(vo);
    }

    public boolean afterCheck(OrderVO vo) throws RemoteException {
        return new Order().afterCheck(vo);
    }

    public boolean afterCheck(StockInVO vo) throws RemoteException {
        return new StockIn().afterCheck(vo);
    }

    public boolean afterCheck(StockOutVO vo) throws RemoteException {
        return new StockOut().afterCheck(vo);
    }

    public boolean afterCheck(PaymentVO vo) throws RemoteException {
        return new Payment().afterCheck(vo);
    }

    public boolean afterCheck(GatheringVO vo) throws RemoteException {
        return new Gathering().afterCheck(vo);
    }

    public boolean afterCheck(TransferVO vo) throws RemoteException {
        return new TransInfo().afterCheck(vo);
    }

    public boolean afterCheck(TransferReceiveVO vo) throws RemoteException {
        return new TransArrive().afterCheck(vo);
    }

    public boolean afterCheck(ReceiptVO vo) throws RemoteException {
        return new Receipt().afterCheck(vo);
    }

    public boolean afterCheck(ReceiveVO vo) throws RemoteException {
        return new ReceiveInfo().afterCheck(vo);
    }

    public Iterator<ListVO> push() throws RemoteException {

        return new List().push();
    }


    public boolean save(AddresseeInformationVO vo) throws RemoteException {

        return new AddresseeInfomation().save(vo);
    }

    public boolean save(DistributeVO vo) throws RemoteException {

        return new DistributeInfo().save(vo);
    }

    public boolean save(LoadingVO vo) throws RemoteException {

        return new LoadingInfo().save(vo);
    }

    public boolean save(OrderVO vo) throws RemoteException {

        return new Order().save(vo);
    }

    public boolean save(StockInVO vo) throws RemoteException {

        return new StockIn().save(vo);
    }

    public boolean save(StockOutVO vo) throws RemoteException {

        return new StockOut().save(vo);
    }

    public boolean save(PaymentVO vo) throws RemoteException {

        return new Payment().save(vo);
    }

    public boolean save(GatheringVO vo) throws RemoteException {

        return new Gathering().save(vo);
    }

    public boolean save(TransferVO vo) throws RemoteException {

        return new TransInfo().save(vo);
    }


    public boolean save(TransferReceiveVO vo) throws RemoteException {

        return new TransArrive().save(vo);
    }

    public boolean save(ReceiveVO vo) throws RemoteException {

        return new ReceiveInfo().save(vo);
    }

    public boolean save(ReceiptVO vo) throws RemoteException {

        return new Receipt().save(vo);
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

    public OrderVO getOrder(String num) throws RemoteException {
        return new Order().getOrder(num);
    }
}
