package src.businesslogic.listbl;

import src.data.DataFactory;
import src.dataservice.datafactoryservice.DataFactoryService;
import src.dataservice.listdataservice.ListDataService;
import src.po.GatheringPO;
import src.po.ListPO;
import src.vo.*;
import util.ResultMessage;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class List {
    DataFactoryService dataFactory;

    public ResultMessage order(OrderVO orderVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage AddresseeInfomation(AddresseeInformationVO addresseeInformationVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage receipt(ReceiptVO receiptVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage transInfo(TransferVO transferVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage stockOut(StockOutVO stockOutVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage stockIn(StockInVO stockInVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage gathering(GatheringVO gatheringVO) {
//        System.out.print("我被执行啦");
        dataFactory = new DataFactory();
        ListDataService dataService = dataFactory.getListDataService();//通过datafactory去get
        GatheringPO po = new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(), gatheringVO.getMoney(), gatheringVO.getPlace());
        dataService.saveGathering(po);
        return ResultMessage.SUCCESS;
    }

    public ResultMessage payment(PaymentVO paymentVO) {
        return ResultMessage.FAILED;
    }

    public ResultMessage saveList(ListPO list) {
        return ResultMessage.FAILED;
    }

    public ListVO push() {
        return null;
    }
}
