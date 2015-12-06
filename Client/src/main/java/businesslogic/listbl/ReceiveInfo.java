package businesslogic.listbl;

import po.ReceivePO;
import util.ResultMessage;
import vo.ListVO;
import vo.ReceiveVO;

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
    public ResultMessage save(ListVO listVO) throws RemoteException {
        ReceiveVO vo = null;
        vo = (ReceiveVO) listVO;
        ReceivePO po = new ReceivePO(vo.getArriveDate(), vo.getTransferNum(), vo.getStart(), vo.getArriveState());

        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
