package businesslogic.listbl;

import po.OrderPO;
import util.ResultMessage;
import vo.ListVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class Order extends List {
    /**
     * Instantiates a new Order.
     *
     * @throws RemoteException the remote exception
     */
    public Order() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException {
        OrderVO vo = null;
        vo = (OrderVO) listVO;

        OrderPO po = new OrderPO(vo.getSenderName(), vo.getSenderAddress(), vo.getSenderWorkplace(), vo.getSenderTelephone(), vo.getSenderPhone(), vo.getReceiverName(), vo.getReceiverAddress(), vo.getReceiverWorkplace(), vo.getReceiverTelephone(), vo.getReceiverPhone(),
                vo.getOriginalNum(), vo.getWeight(), vo.getVolume(), vo.getGoods_Name(), vo.getDeliveryType(), vo.getWrapper(), "1234", "1234", "1234", "1234", vo.getDeliveryNum());


        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
