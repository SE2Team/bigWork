package src.drivers.bl;

import src.businesslogicservice.ListblService;
import src.vo.GatheringVO;
import src.vo.ListVO;
import src.vo.OrderVO;

public class ListblService_Drivers {
		ListVO listVO;
		OrderVO orderVO;
		GatheringVO gatheringVO;
	
	
		public void driver(ListblService listblService){
			ListVO isListVO=listblService.push();
			if(isListVO==listVO){
				System.out.println("Success!");
			}
			
			boolean isOrder=listblService.order(orderVO);
			if(isOrder==true){
				System.out.println("success!");
			}
			
			boolean isGathering=listblService.gathering(gatheringVO); 
			if(isGathering==true){
				System.out.println("success!");
			}
		}
}
