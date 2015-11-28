package dataservice.listdataservice;

import po.*;
import util.ResultMessage;

import java.util.ArrayList;

public interface ListDataService {
    public ResultMessage save(OrderPO orderPO);

    public ResultMessage save(AddresseeInformationPO addresseeInformationPO);

    public ResultMessage save(LoadingPO loadingPO);

    public ResultMessage save(ReceivePO receivePO);

    public ResultMessage save(DistributePO distributePO);

    public ResultMessage save(ReceiptPO receiptPO);

    public ResultMessage save(TransferPO transferPO);

    public ResultMessage save(TransferReceivePO transferReceivePO);

    public ResultMessage save(StockOutPO stockOutPO);

    public ResultMessage save(StockInPO stockInPO);

    public ResultMessage save(PaymentPO paymentPO);

    public ResultMessage save(GatheringPO gatheringPO);

    public ResultMessage saveAsList(ListPO listPO);
    //Orderpo
    //ListPO listpo=orderpo;

    public ArrayList<ListPO> checkList();
}
