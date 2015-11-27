package businesslogicservice;

import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

public interface ListblService {
    //订单
    ResultMessage order(OrderVO orderVO);

    //收件单
    ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO);

    //装车单
    ResultMessage loadingInfo(LoadingVO loadingVO);

    //接收单
    ResultMessage receiveInfo(ReceiveVO receiveVO);

    //派件单
    ResultMessage distributeInfo(DistributeVO distributeVO);

    //营业厅业务员建的收款单
    ResultMessage receipt(ReceiptVO receiptVO);

    //中转单
    ResultMessage transInfo(TransferVO transferVO);

    //中转中心到达单
    ResultMessage transArrive(TransferReceiveVO transferReceiveVO);

    //入库单
    ResultMessage stockOut(StockOutVO stockOutVO);

    //出库单
    ResultMessage stockIn(StockInVO stockInVO);

    //财务人员建的收款单
    ResultMessage gathering(GatheringVO gatheringVO);

    //付款单
    ResultMessage payment(PaymentVO paymentVO);



    ArrayList<ListVO> push();
}
