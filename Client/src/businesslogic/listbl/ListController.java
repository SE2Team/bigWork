package src.businesslogic.listbl;

import src.businesslogicservice.ListblService;
import src.po.ListPO;
import src.util.ResultMessage;
import src.vo.*;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class ListController implements ListblService {

    List list=new List();


    @Override
    public ResultMessage order(OrderVO orderVO) {
        return list.order(orderVO);
    }

    @Override
    public ResultMessage AddresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        return list.AddresseeInfomation(addresseeInformationVO);
    }

    @Override
    public ResultMessage loadingInfo(LoadingVO loadingVO) {
        return list.loadingInfo(loadingVO);
    }

    @Override
    public ResultMessage receiveInfo(ReceiveVO receiveVO) {
        return list.receiveInfo(receiveVO);
    }

    @Override
    public ResultMessage distributeInfo(DistributeVO distributeVO) {
        return list.distributeInfo(distributeVO);
    }

    @Override
    public ResultMessage receipt(ReceiptVO receiptVO) {
        return list.receipt(receiptVO);
    }

    @Override
    public ResultMessage transInfo(TransferVO transferVO) {
        return list.transInfo(transferVO);
    }

    @Override
    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) {
        return list.transArrive(transferReceiveVO);
    }

    @Override
    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return list.stockOut(stockOutVO);
    }

    @Override
    public ResultMessage stockIn(StockInVO stockInVO) {
        return list.stockIn(stockInVO);
    }

    @Override
    public ResultMessage gathering(GatheringVO gatheringVO) {
        return list.gathering(gatheringVO);
    }

    @Override
    public ResultMessage payment(PaymentVO paymentVO) {
        return list.payment(paymentVO);
    }

    @Override
    public ResultMessage saveList(ListPO list) {
        return ResultMessage.FAILED;
    }

    @Override
    public ListVO push() {
        return null;
    }
}
