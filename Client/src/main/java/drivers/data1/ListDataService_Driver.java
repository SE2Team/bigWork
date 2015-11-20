package drivers.data1;

import dataservice.listdataservice.ListDataService;
import po.*;

public class ListDataService_Driver {
    OrderPO orderPO;
    AddresseeInformationPO addresseeInformationPO;
    LoadingPO loadingPO;
    ReceiptPO receiptPO;
    DistributePO distributePO;
    TransferPO transferPO;
    StockOutPO stockOutPO;
    StockInPO stockInPO;
    PaymentPO paymentPO;
    GatheringPO gatheringPO;
    TransferReceivePO transferReceivePO;

    public void driver(ListDataService listDataService) {

        boolean isSaveOrder = listDataService.saveOrder(orderPO);
        if (isSaveOrder == true) {
            System.out.println("Success!");
        }

        boolean isSavaAddresseeInfo = listDataService.saveAddresseeInfo(addresseeInformationPO);
        if (isSavaAddresseeInfo == true) {
            System.out.println("Success!");
        }

        boolean isSaveLoadingInfo = listDataService.saveLoadingInfo(loadingPO);
        if (isSaveLoadingInfo == true) {
            System.out.println("Success!");
        }

        boolean isSaveReceiveInfo = listDataService.saveReceiveInfo(receiptPO);
        if (isSaveReceiveInfo == true) {
            System.out.println("Success!");
        }

        boolean isSaveDistributeInfo = listDataService.saveDistributeInfo(distributePO);
        if (isSaveDistributeInfo == true) {
            System.out.println("Success!");
        }

        boolean isSaveReceipt = listDataService.saveReceipt(receiptPO);
        if (isSaveReceipt == true) {
            System.out.println("Success!");
        }

        boolean isSaveTransInfo = listDataService.saveTransInfo(transferPO);
        if (isSaveTransInfo == true) {
            System.out.println("Success!");
        }

        boolean isSaveTransArrive = listDataService.saveTransArrive(transferReceivePO);
        if (isSaveTransArrive == true) {
            System.out.println("Success!");
        }

        boolean isSaveStockOut = listDataService.saveStockOut(stockOutPO);
        if (isSaveStockOut == true) {
            System.out.println("Success!");
        }

        boolean isSavePayment = listDataService.savePayment(paymentPO);
        if (isSavePayment == true) {
            System.out.println("Success!");
        }

//			boolean isSaveFinance=listDataService.saveFinance(gatheringPO);
//			if(isSaveFinance==true){
//				System.out.println("Success!");
//			}
    }
}
