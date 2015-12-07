package businesslogic.listbl;

import businesslogicservice.ListblService;
import util.ExistException;
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


    public boolean order(OrderVO orderVO) throws RemoteException {
        return list.save(orderVO);
    }

    public boolean addresseeInfomation(AddresseeInformationVO addresseeInformationVO) throws RemoteException {
        return list.save(addresseeInformationVO);
    }

    public boolean loadingInfo(LoadingVO loadingVO) throws RemoteException {
        return list.save(loadingVO);
    }

    public boolean receiveInfo(ReceiveVO receiveVO) throws RemoteException {
        return list.save(receiveVO);
    }

    public boolean distributeInfo(DistributeVO distributeVO) throws RemoteException {
        return list.save(distributeVO);
    }

    public boolean receipt(ReceiptVO receiptVO) throws RemoteException{
        return list.save(receiptVO);
    }

    public boolean transInfo(TransferVO transferVO) throws RemoteException {
        return list.save(transferVO);
    }

    public boolean transArrive(TransferReceiveVO transferReceiveVO) throws RemoteException {
        return list.save(transferReceiveVO);
    }

    public boolean stockOut(StockOutVO stockOutVO) throws RemoteException {
        return list.save(stockOutVO);
    }

    public boolean stockIn(StockInVO stockInVO) throws RemoteException {
        return list.save(stockInVO);
    }

    public boolean gathering(GatheringVO gatheringVO) throws  RemoteException {
        return list.save(gatheringVO);
    }

    public boolean payment(PaymentVO paymentVO) throws RemoteException{
        return list.save(paymentVO);
    }


    public Iterator<ListVO> push() throws RemoteException {
        return new List().push();
    }

    /**
     * 审批一份订单后，通过ischeck来决定是否保存
     * @param vo 要保存的单据
     * @return
     * @throws ExistException
     * @throws RemoteException
     */
    public boolean save(ListVO vo) throws ExistException, RemoteException {
        if(!vo.getIsCheck())
            return true;
        switch (vo.getType()){
            case LOADINGINFO:
                new LoadingInfo().save(vo);
                break;
            case ADDRESSEEINFOMATION:
                new AddresseeInfomation().save(vo);
                break;
            case DISTRIBUTEINFO:
                new DistributeInfo().save(vo);
                break;
            case GATHERING:
                new Gathering().save(vo);
                break;
            case ORDER:
                new Order().save(vo);
                break;
            case PAYMENT:
                new Payment().save(vo);
                break;
            case RECEIPT:
                new Receipt().save(vo);
                break;
            case RECEIVEINFO:
                new ReceiveInfo().save(vo);
                break;
            case STOCKIN:
                new StockIn().save(vo);
                break;
            case STOCKOUT:
                new StockOut().save(vo);
                break;
            case TRANSARRIVE:
                new TransArrive().save(vo);
                break;
            case TRANSINFO:
                new TransInfo().save(vo);
                break;
        }
        return true;
    }
}
