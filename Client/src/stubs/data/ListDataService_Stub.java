package src.stubs.data;

import src.po.AddresseeInformationPO;
import src.po.DistributePO;
import src.po.GatheringPO;
import src.po.LoadingPO;
import src.po.OrderPO;
import src.po.PaymentPO;
import src.po.ReceiptPO;
import src.po.StockInPO;
import src.po.StockOutPO;
import src.po.TransferPO;
import src.po.TransferReceivePO;
import src.dataservice.listdataservice.ListDataService;

public class ListDataService_Stub implements ListDataService{

	public 	boolean saveOrder(OrderPO orderPO){
		System.out.println("Success");
		return true;
	}
	
	public boolean saveAddresseeInfo(AddresseeInformationPO addresseeInformationPO){
		System.out.println("Success");
		return true;
	}
	
    public boolean saveLoadingInfo(LoadingPO loadingPO){
		System.out.println("Success");
		return true;
	}
    
    public boolean saveReceiveInfo(ReceiptPO receiptPO){
		System.out.println("Success");
		return true;
	}
    
    public boolean saveDistributeInfo(DistributePO distributePO){
		System.out.println("Success");
		return true;
	}

    public boolean saveReceipt(ReceiptPO receiptPO){
		System.out.println("Success");
		return true;
	}

    public boolean saveTransInfo(TransferPO transferPO){
		System.out.println("Success");
		return true;
	}

    public boolean saveTransArrive(TransferReceivePO transferReceivePO){
		System.out.println("Success");
		return true;
	}
    
    public boolean saveStockOut(StockOutPO stockOutPO){
		System.out.println("Success");
		return true;
	}
    
    public boolean saveStockIn(StockInPO stockInPO){
		System.out.println("Success");
		return true;
	}
    
    public boolean savePayment(PaymentPO paymentPO){
		System.out.println("Success");
		return true;
	}

	public boolean saveGathering(src.po.GatheringPO gatheringPO) {
		System.out.println("Success");
		return true;
	}

	public boolean saveFinance(GatheringPO gatheringPO){
		System.out.println("Success");
		return true;
	}
}
