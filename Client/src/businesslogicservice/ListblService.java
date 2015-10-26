package businesslogicservice;

import po.ListPO;
import vo.*;

public interface ListblService {
    //订单
    public OrderVO order(OrderVO orderVO);

    //收件单
    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO);

    //装车单
    public void loadingInfo(LoadingVO loadingVO);

    //接收单
    public void receiveInfo(ReceiveVO receiveVO);

    //派件单
    public void distributeInfo(DistributeVO distributeVO);

    //营业厅业务员建的收款单
    public void receipt(ReceiptVO receiptVO);

    //中转单
    public void transInfo(TransferVO transferVO);

    //中转中心到达单
    public void transArrive(TransferReceiveVO transferReceiveVO);

    //入库单
    public void stockOut(StockOutVO stockOutVO);

    //出库单
    public void stockIn(StockInVO stockInVO);

    //财务人员建的收款单
    public void gathering(GatheringVO gatheringVO);

    //付款单
    public void payment(PaymentVO paymentVO);

    public void saveList(ListPO list);

    public ListVO push();
}
