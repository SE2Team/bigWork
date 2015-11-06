package src.stubs.bl;

import src.vo.StockInVO;
import src.vo.StockOutVO;
import src.po.StockPO;
import src.businesslogicservice.CommodityblService;

public class CommodityblService_Stub implements CommodityblService{
	
	public CommodityblService_Stub(){
		
	}

    public boolean stockOut(StockOutVO stockOutVO){
    	// TODO Auto-generated method stub
    	return true;
    }

    public boolean stockIn(StockInVO stockInVO){
    	// TODO Auto-generated method stub
    	return true;
    }
    
   public boolean isFull(StockPO stockPO){
   	// TODO Auto-generated method stub
   	return true;
   }
   
    public boolean checkStock(String startDate,String endDate){
    	// TODO Auto-generated method stub
    	return true;
    }
   
    public boolean StockSum(String startDate,String endDate){
    	// TODO Auto-generated method stub
    	return true;
    }




}
