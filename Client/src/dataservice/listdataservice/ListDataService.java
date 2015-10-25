package dataservice.listdataservice;

import enumClass.City;
import enumClass.TransportType;
import po.AddresseeInformationPO;
import po.DistributePO;
import po.FinancePO;
import po.LoadingPO;
import po.OrderPO;
import po.PaymentPO;
import po.ReceiptPO;
import po.StockInPO;
import po.StockOutPO;
import po.TransferPO;
import po.TransferReceivePO;

public interface ListDataService {
	public 	boolean saveOrder(OrderPO orderPO);
	public boolean saveAddresseeInfo(AddresseeInformationPO addresseeInformationPO);
    public boolean saveLoadingInfo(LoadingPO loadingPO);
    public boolean saveReceiveInfo(ReceiptPO receiptPO);
    public boolean saveDistributeInfo(DistributePO distributePO);

    public boolean saveReceipt(ReceiptPO receiptPO);

    public boolean saveTransInfo(TransferPO transferPO);

    public boolean saveTransArrive(TransferReceivePO transferReceivePO);
    public boolean saveStockOut(StockOutPO stockOutPO);
    public boolean saveStockIn(StockInPO stockInPO);
    public boolean savePayment(PaymentPO paymentPO);
    public boolean saveFinance(FinancePO financePO);
}
