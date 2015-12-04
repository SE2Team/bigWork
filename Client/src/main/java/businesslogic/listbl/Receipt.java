package businesslogic.listbl;

import businesslogic.Exception.DateException;
import businesslogic.Exception.DeliverNumException;
import businesslogic.Exception.MoneyException;
import po.ReceiptPO;
import util.ResultMessage;
import vo.ListVO;
import vo.ReceiptVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public class Receipt extends List{
    public Receipt() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException, DateException, MoneyException, DeliverNumException {
        ReceiptVO vo=null;
        vo= (ReceiptVO) listVO;
        if(!DateException.isValid(vo.getReceiptDate()))
            throw new DateException("收款日期错误！");
        MoneyException.isValid(vo.getReceiptMoney());
        DeliverNumException.isValid(vo.getOrderNum());

        ReceiptPO po=new ReceiptPO(vo.getReceiptDate(),vo.getReceiptMoney(),vo.getReceiptCourier(),vo.getOrderNum());

        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
