package dataservice.impl;

import po.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class ListDataServiceImpl {

    public boolean saveOrder(OrderPO orderPO) {
        return false;
    }


    public boolean saveAddresseeInfo(AddresseeInformationPO addresseeInformationPO) {
        return false;
    }


    public boolean saveLoadingInfo(LoadingPO loadingPO) {
        return false;
    }


    public boolean saveReceiveInfo(ReceivePO receivePO) {
        return false;
    }


    public boolean saveDistributeInfo(DistributePO distributePO) {
        return false;
    }


    public boolean saveReceipt(ReceiptPO receiptPO) {
        return false;
    }


    public boolean saveTransInfo(TransferPO transferPO) {
        return false;
    }


    public boolean saveTransArrive(TransferReceivePO transferReceivePO) {
        return false;
    }


    public boolean saveStockOut(StockOutPO stockOutPO) {
        return false;
    }


    public boolean saveStockIn(StockInPO stockInPO) {
        return false;
    }


    public boolean savePayment(PaymentPO paymentPO) {
        return false;
    }


    public boolean saveGathering(GatheringPO gatheringPO) {
        try {
            FileOutputStream fos = new FileOutputStream("SerializableData/Gathering" + gatheringPO.getId() + ".file");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gatheringPO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
