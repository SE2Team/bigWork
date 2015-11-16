package src.businesslogicservice;

import src.po.ListPO;
import src.util.ResultMessage;
import src.vo.*;

public interface ListblService {
    //订单
    public ResultMessage order(OrderVO orderVO);

    //收件单
    public ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO);

    //装车单
    public ResultMessage loadingInfo(LoadingVO loadingVO);

    //接收单
    public ResultMessage receiveInfo(ReceiveVO receiveVO);

    //派件单
    public ResultMessage distributeInfo(DistributeVO distributeVO);

    //营业厅业务员建的收款单
    public ResultMessage receipt(ReceiptVO receiptVO);

    //中转单
    public ResultMessage transInfo(TransferVO transferVO);

    //中转中心到达单
    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO);

    //入库单
    public ResultMessage stockOut(StockOutVO stockOutVO);

    //出库单
    public ResultMessage stockIn(StockInVO stockInVO);

    //财务人员建的收款单
    public ResultMessage gathering(GatheringVO gatheringVO);

    //付款单
    public ResultMessage payment(PaymentVO paymentVO);

    public ResultMessage saveList(ListPO list);

    public ListVO push();
}
