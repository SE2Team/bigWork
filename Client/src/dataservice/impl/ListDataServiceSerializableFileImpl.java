package dataservice.impl;

import dataservice.listdataservice.ListDataService;
import po.*;

import java.io.*;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class ListDataServiceSerializableFileImpl implements ListDataService {
    @Override
    public boolean saveOrder(OrderPO orderPO) {
        return false;
    }

    @Override
    public boolean saveAddresseeInfo(AddresseeInformationPO addresseeInformationPO) {
        return false;
    }

    @Override
    public boolean saveLoadingInfo(LoadingPO loadingPO) {
        return false;
    }

    @Override
    public boolean saveReceiveInfo(ReceiptPO receiptPO) {
        return false;
    }

    @Override
    public boolean saveDistributeInfo(DistributePO distributePO) {
        return false;
    }

    @Override
    public boolean saveReceipt(ReceiptPO receiptPO) {
        return false;
    }

    @Override
    public boolean saveTransInfo(TransferPO transferPO) {
        return false;
    }

    @Override
    public boolean saveTransArrive(TransferReceivePO transferReceivePO) {
        return false;
    }

    @Override
    public boolean saveStockOut(StockOutPO stockOutPO) {
        return false;
    }

    @Override
    public boolean saveStockIn(StockInPO stockInPO) {
        return false;
    }

    @Override
    public boolean savePayment(PaymentPO paymentPO) {
        return false;
    }

    @Override
    public boolean saveGathering(GatheringPO gatheringPO) {
        try {
            FileOutputStream fos = new FileOutputStream("SerializableData/Gathering"+gatheringPO.getId()+".file");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(gatheringPO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
