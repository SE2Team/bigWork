package businesslogic.listbl;

import businesslogic.Exception.OtherException;
import po.OrderPO;
import util.ResultMessage;
import vo.ListVO;
import vo.OrderVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Order extends List {
    public Order() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws OtherException, RemoteException {
        OrderVO vo=null;
        vo= (OrderVO) listVO;
        if(vo.getSenderTelephone()==""||vo.getSenderPhone()=="")
            throw new OtherException("请输入寄件人电话");
        if(vo.getReceiverPhone()==""||vo.getReceiverTelephone()=="")
            throw new OtherException("请输入收件人电话");

        OrderPO po = new OrderPO(vo.getSenderName(),vo.getSenderAddress(),vo.getSenderWorkplace(),vo.getSenderTelephone(),vo.getSenderPhone(),vo.getReceiverName(),vo.getReceiverAddress(),vo.getReceiverWorkplace(),vo.getReceiverTelephone(),vo.getReceiverPhone(),
                vo.getOriginalNum(),vo.getWeight(),vo.getVolume(),vo.getGoods_Name(),vo.getDeliveryType(),vo.getWrapper(),vo.getDeliveryNum());


        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
