package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
import po.TransferPO;
import vo.ListVO;
import vo.TransferVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class TransInfo extends List {
    /**
     * Instantiates a new Trans info.
     *
     * @throws RemoteException the remote exception
     */
    public TransInfo() throws RemoteException {
    }

    public boolean save2File(ListVO listVO) throws RemoteException {
        TransferVO vo = null;
        vo = (TransferVO) listVO;
        TransferPO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存中转信息单"));
        return listDataService.save(po);
    }

    public boolean save(TransferVO vo) throws RemoteException {
        TransferPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建中转单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

    public boolean afterCheck(TransferVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }
}
