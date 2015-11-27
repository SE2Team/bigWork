package businesslogic.listbl;

import businesslogicservice.ListblService;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class ListController implements ListblService {

    List list;


    public ResultMessage order(OrderVO orderVO) {
        return new Order().save(orderVO);
    }

    public ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        return new AddresseeInfomation().save(addresseeInformationVO);
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO) {
        return new LoadingInfo().save(loadingVO);
    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO) {
        return new ReceiveInfo().save(receiveVO);
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO) {
        return new DistributeInfo().save(distributeVO);
    }

    public ResultMessage receipt(ReceiptVO receiptVO) {
        return new Receipt().save(receiptVO);
    }

    public ResultMessage transInfo(TransferVO transferVO) {
        return new TransInfo().save(transferVO);
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) {
        return new TransArrive().save(transferReceiveVO);
    }

    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return new StockOut().save(stockOutVO);
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        return new StockIn().save(stockInVO);
    }

    public ResultMessage gathering(GatheringVO gatheringVO) {
        return new Gathering().save(gatheringVO);
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        return new Payment().save(paymentVO);
    }



    public ArrayList<ListVO> push() {
        return new List().push();
    }
}
