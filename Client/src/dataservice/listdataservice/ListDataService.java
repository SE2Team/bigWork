package src.dataservice.listdataservice;

import src.po.*;

public interface ListDataService {
	public 	boolean saveOrder(OrderPO orderPO);
	public boolean saveAddresseeInfo(AddresseeInformationPO addresseeInformationPO);
    public boolean saveLoadingInfo(LoadingPO loadingPO);
    public boolean saveReceiveInfo(ReceivePO receivePO);
    public boolean saveDistributeInfo(DistributePO distributePO);

    public boolean saveReceipt(ReceiptPO receiptPO);

    public boolean saveTransInfo(TransferPO transferPO);

    public boolean saveTransArrive(TransferReceivePO transferReceivePO);
    public boolean saveStockOut(StockOutPO stockOutPO);
    public boolean saveStockIn(StockInPO stockInPO);
    public boolean savePayment(PaymentPO paymentPO);
    public boolean saveGathering(GatheringPO gatheringPO);
}
