package businesslogic.listbl;

import businesslogicservice.ListblService;
import po.ListPO;
import util.ResultMessage;
import vo.*;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class ListController implements ListblService {

    List list;


    public ResultMessage order(OrderVO orderVO) {
        return new Order().save(orderVO);
    }

    public ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        return new AddresseeInfomation().save();
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO) {
        return list.loadingInfo(loadingVO);
    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO) {
        return list.receiveInfo(receiveVO);
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO) {
        return list.distributeInfo(distributeVO);
    }

    public ResultMessage receipt(ReceiptVO receiptVO) {
        return list.receipt(receiptVO);
    }

    public ResultMessage transInfo(TransferVO transferVO) {
        return list.transInfo(transferVO);
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) {
        return list.transArrive(transferReceiveVO);
    }

    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return list.stockOut(stockOutVO);
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        return list.stockIn(stockInVO);
    }

    public ResultMessage gathering(GatheringVO gatheringVO) {
        return list.gathering(gatheringVO);
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        return list.payment(paymentVO);
    }

    public ResultMessage saveList(ListPO list) {
        return ResultMessage.FAILED;
    }

    public ListVO push() {
        return null;
    }
}
