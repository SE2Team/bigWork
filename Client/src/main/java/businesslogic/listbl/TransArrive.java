package businesslogic.listbl;

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
    public boolean save(ListVO listVO) throws RemoteException {
        TransferReceiveVO vo = (TransferReceiveVO) listVO;
        TransferReceivePO po = VO2PO.convert(vo);
        return listDataService.save(po);
    }
}
