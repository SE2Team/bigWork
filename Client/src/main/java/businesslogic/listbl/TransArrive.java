package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
import po.TransferReceivePO;
import vo.ListVO;
import vo.TransferReceiveVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class TransArrive extends List {
    /**
     * Instantiates a new Trans arrive.
     *
     * @throws RemoteException the remote exception
     */
    public TransArrive() throws RemoteException {
    }

    @Override
    public boolean save2File(ListVO listVO) throws RemoteException {
        TransferReceiveVO vo = (TransferReceiveVO) listVO;
        TransferReceivePO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存中转到达单"));
        return listDataService.save(po);
    }
}
