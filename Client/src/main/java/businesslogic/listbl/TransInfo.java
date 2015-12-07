package businesslogic.listbl;

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

    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        TransferVO vo = null;
        vo = (TransferVO) listVO;
        TransferPO po = VO2PO.convert(vo);

        return listDataService.save(po);
    }
}
