package businesslogic.listbl;

import po.ReceiptPO;
import util.ResultMessage;
import vo.ListVO;
import vo.ReceiptVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class Receipt extends List {
    /**
     * Instantiates a new Receipt.
     *
     * @throws RemoteException the remote exception
     */
    public Receipt() throws RemoteException {
        super();
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException {
        ReceiptVO vo = null;
        vo = (ReceiptVO) listVO;


        ReceiptPO po = new ReceiptPO(vo.getReceiptDate(), vo.getReceiptMoney(), vo.getReceiptCourier(), vo.getOrderNum());

        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
