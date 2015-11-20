package drivers.bl1;

import businesslogicservice.ListblService;
import util.ResultMessage;
import vo.GatheringVO;
import vo.ListVO;
import vo.OrderVO;

public class ListblService_Driver {
    ListVO listVO;
    OrderVO orderVO;
    GatheringVO gatheringVO;


    public void driver(ListblService listblService) {
        ListVO isListVO = listblService.push();
        if (isListVO == listVO) {
            System.out.println("Success!");
        }

        ResultMessage isOrder = listblService.order(orderVO);
        if (isOrder == ResultMessage.SUCCESS) {
            System.out.println("success!");
        }

        ResultMessage isGathering = listblService.gathering(gatheringVO);
        if (isGathering == ResultMessage.SUCCESS) {
            System.out.println("success!");
        }
    }
}
