package stubs.bl1;

import businesslogicservice.ListblService;
import po.ListPO;
import util.ResultMessage;
import vo.*;

import java.util.ArrayList;

public class ListblService_Stub implements ListblService {

    public ListblService_Stub() {

    }

    public ResultMessage order(OrderVO orderVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage addresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        return null;
    }

    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        // TODO Auto-generated method stub
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO) {
        return ResultMessage.SUCCESS;
        // TODO Auto-generated method stub

    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO) {
        return ResultMessage.SUCCESS;
        // TODO Auto-generated method stub
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage receipt(ReceiptVO receiptVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage transInfo(TransferVO transferVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockOut(StockOutVO stockOutVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage gathering(GatheringVO gatheringVO) {
        return ResultMessage.SUCCESS;
        // TODO Auto-generated method stub
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ResultMessage saveList(ListPO list) {
        // TODO Auto-generated method stub
        return ResultMessage.SUCCESS;
    }

    public ArrayList<ListVO> push() {
        // TODO Auto-generated method stub
        return null;
    }
}
