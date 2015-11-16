package src.drivers.bl1;

import src.businesslogicservice.ListblService;
import src.util.ResultMessage;
import src.vo.GatheringVO;
import src.vo.ListVO;
import src.vo.OrderVO;

public class ListblService_Driver {
		ListVO listVO;
		OrderVO orderVO;
		GatheringVO gatheringVO;
	
	
		public void driver(ListblService listblService){
			ListVO isListVO=listblService.push();
			if(isListVO==listVO){
				System.out.println("Success!");
			}
			
			ResultMessage isOrder=listblService.order(orderVO);
			if(isOrder==ResultMessage.SUCCESS){
				System.out.println("success!");
			}
			
			ResultMessage isGathering=listblService.gathering(gatheringVO); 
			if(isGathering==ResultMessage.SUCCESS){
				System.out.println("success!");
			}
		}
}
