package src.stubs.bl;

import src.vo.AddresseeInformationVO;
import src.vo.DistributeVO;
import src.vo.GatheringVO;
import src.po.ListPO;
import src.vo.ListVO;
import src.vo.LoadingVO;
import src.vo.OrderVO;
import src.vo.PaymentVO;
import src.vo.ReceiptVO;
import src.vo.ReceiveVO;
import src.vo.StockInVO;
import src.vo.StockOutVO;
import src.vo.TransferReceiveVO;
import src.vo.TransferVO;
import src.businesslogicservice.ListblService;

public class ListblService_Stub implements ListblService{
	
	public ListblService_Stub(){
		
	}
	
    public boolean order(OrderVO orderVO){
    	// TODO Auto-generated method stub
    	return true;
    }

    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO){
    	// TODO Auto-generated method stub
    }

    public void loadingInfo(LoadingVO loadingVO){
    	// TODO Auto-generated method stub
    }

    public void receiveInfo(ReceiveVO receiveVO){
    	// TODO Auto-generated method stub
    }

    public void distributeInfo(DistributeVO distributeVO){
    	// TODO Auto-generated method stub
    }

    public void receipt(ReceiptVO receiptVO){
    	// TODO Auto-generated method stub
    }

    public void transInfo(TransferVO transferVO){
    	// TODO Auto-generated method stub
    }

    public void transArrive(TransferReceiveVO transferReceiveVO){
    	// TODO Auto-generated method stub
    }

    public void stockOut(StockOutVO stockOutVO){
    	// TODO Auto-generated method stub
    }

    public void stockIn(StockInVO stockInVO){
    	// TODO Auto-generated method stub
    }

    public boolean gathering(GatheringVO gatheringVO){
		return true;
    	// TODO Auto-generated method stub
    }

    public void payment(PaymentVO paymentVO){
    	// TODO Auto-generated method stub
    }

    public void saveList(ListPO list){
    	// TODO Auto-generated method stub
    }

    public ListVO push(){
    	// TODO Auto-generated method stub
    	return null;
    }
}
