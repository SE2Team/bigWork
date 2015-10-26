package src.businesslogic.listbl;

import src.businesslogicservice.ListblService;
import src.data.DataFactory;
import src.dataservice.datafactoryservice.DataFactoryService;
import src.dataservice.listdataservice.ListDataService;
import src.po.GatheringPO;
import src.po.ListPO;
import src.vo.GatheringVO;
import src.vo.*;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class ListBL implements ListblService{
    DataFactoryService dataFactory;

    public boolean order(OrderVO orderVO) {
        return true;
    }

    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO) {

    }

    public void loadingInfo(LoadingVO loadingVO) {

    }

    public void receiveInfo(ReceiveVO receiveVO) {

    }

    public void distributeInfo(DistributeVO distributeVO) {

    }

    public void receipt(ReceiptVO receiptVO) {

    }

    public void transInfo(TransferVO transferVO) {

    }

    public void transArrive(TransferReceiveVO transferReceiveVO) {

    }

    public void stockOut(StockOutVO stockOutVO) {

    }

    public void stockIn(StockInVO stockInVO) {

    }

    public boolean gathering(GatheringVO gatheringVO) {
//        System.out.print("我被执行啦");
        dataFactory=new DataFactory();
        ListDataService dataService=dataFactory.getListDataService();
        GatheringPO po=new GatheringPO(gatheringVO.getDate(),gatheringVO.getWorkplace(),gatheringVO.getMan(),gatheringVO.getMoney(),gatheringVO.getPlace());
        dataService.saveGathering(po);
        return true;
    }

    public void payment(PaymentVO paymentVO) {

    }

    public void saveList(ListPO list) {

    }

    public ListVO push() {
        return null;
    }
}
