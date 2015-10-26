package businesslogic.listbl;

import businesslogicservice.ListblService;
import po.ListPO;
import vo.*;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListBL implements ListblService{

    @Override
    public boolean order(OrderVO orderVO) {
        return true;
    }

    @Override
    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO) {

    }

    @Override
    public void loadingInfo(LoadingVO loadingVO) {

    }

    @Override
    public void receiveInfo(ReceiveVO receiveVO) {

    }

    @Override
    public void distributeInfo(DistributeVO distributeVO) {

    }

    @Override
    public void receipt(ReceiptVO receiptVO) {

    }

    @Override
    public void transInfo(TransferVO transferVO) {

    }

    @Override
    public void transArrive(TransferReceiveVO transferReceiveVO) {

    }

    @Override
    public void stockOut(StockOutVO stockOutVO) {

    }

    @Override
    public void stockIn(StockInVO stockInVO) {

    }

    @Override
    public boolean gathering(GatheringVO gatheringVO) {
        System.out.print("我被执行啦");
        return true;
    }

    @Override
    public void payment(PaymentVO paymentVO) {

    }

    @Override
    public void saveList(ListPO list) {

    }

    @Override
    public ListVO push() {
        return null;
    }
}
