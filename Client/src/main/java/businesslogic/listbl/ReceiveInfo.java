package businesslogic.listbl;

import po.ReceivePO;
import vo.ListVO;
import vo.ReceiveVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class ReceiveInfo extends List {
    /**
     * Instantiates a new Receive info.
     *
     * @throws RemoteException the remote exception
     */
    public ReceiveInfo() throws RemoteException {
    }

    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        ReceiveVO vo = null;
        vo = (ReceiveVO) listVO;
        ReceivePO po = VO2PO.convert(vo);


        return listDataService.save(po);
    }
}
