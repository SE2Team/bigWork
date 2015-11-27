package businesslogic.listbl;

import po.OrderPO;
import util.ResultMessage;
import vo.ListVO;
import vo.OrderVO;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Order extends List {
    @Override
    public ResultMessage save(ListVO listVO) {
        OrderVO vo=null;
        vo= (OrderVO) listVO;
        OrderPO po = new OrderPO(vo.getSenderName(),vo.getSenderAddress(),vo.getSenderWorkplace(),vo.getSenderTelephone(),vo.getSenderPhone(),vo.getReceiverName(),vo.getReceiverAddress(),vo.getReceiverWorkplace(),vo.getReceiverTelephone(),vo.getReceiverPhone(),
                Integer.parseInt(vo.getOriginalNum()),vo.getWeight(),vo.getVolume(),vo.getGoods_Name(),vo.getDeliveryType(),vo.getWrapper(),vo.getDeliveryNum());

        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
