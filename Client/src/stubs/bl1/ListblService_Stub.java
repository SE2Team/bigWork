package src.stubs.bl1;

import src.vo.AddresseeInformationVO;
import src.vo.DistributeVO;
import src.vo.GatheringVO;
import src.po.ListPO;
import src.util.ResultMessage;
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
	
    public ResultMessage order(OrderVO orderVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public void ddresseeInfomation(AddresseeInformationVO addresseeInformationVO){
    	// TODO Auto-generated method stub
    }

    public ResultMessage loadingInfo(LoadingVO loadingVO){
		return ResultMessage.SUCCESS;
    	// TODO Auto-generated method stub
    	
    }

    public ResultMessage receiveInfo(ReceiveVO receiveVO){
		return ResultMessage.SUCCESS;
    	// TODO Auto-generated method stub
    }

    public ResultMessage distributeInfo(DistributeVO distributeVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage receipt(ReceiptVO receiptVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage transInfo(TransferVO transferVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage transArrive(TransferReceiveVO transferReceiveVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage stockOut(StockOutVO stockOutVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage gathering(GatheringVO gatheringVO){
    	return ResultMessage.SUCCESS;
    	// TODO Auto-generated method stub
    }

    public ResultMessage payment(PaymentVO paymentVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage saveList(ListPO list){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ListVO push(){
    	// TODO Auto-generated method stub
    	return null;
    }
}
