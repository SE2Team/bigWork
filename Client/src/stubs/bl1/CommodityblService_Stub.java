package src.stubs.bl1;

import src.vo.StockInVO;
import src.vo.StockOutVO;
import src.po.StockPO;
import src.util.ResultMessage;
import src.businesslogicservice.CommodityblService;

public class CommodityblService_Stub implements CommodityblService{
	
	public CommodityblService_Stub(){
		
	}

    public ResultMessage stockOut(StockOutVO stockOutVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }

    public ResultMessage stockIn(StockInVO stockInVO){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }
    
   public boolean isFull(StockPO stockPO){
   	// TODO Auto-generated method stub
   	return true;
   }
   
    public ResultMessage checkStock(String startDate,String endDate){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }
   
    public ResultMessage StockSum(String startDate,String endDate){
    	// TODO Auto-generated method stub
    	return ResultMessage.SUCCESS;
    }




}
