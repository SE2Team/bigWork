package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
import po.ReceiptPO;
import vo.ListVO;
import vo.ReceiptVO;
import vo.VO2PO;

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
    public boolean save2File(ListVO listVO) throws RemoteException {
        ReceiptVO vo = null;
        vo = (ReceiptVO) listVO;
        ReceiptPO po = VO2PO.convert(vo);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存收款单（快递员）"));
        return listDataService.save(po);

    }
}
