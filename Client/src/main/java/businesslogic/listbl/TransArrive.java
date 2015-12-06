package businesslogic.listbl;

import po.TransferReceivePO;
import util.ResultMessage;
import vo.ListVO;
import vo.TransferReceiveVO;

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
    public ResultMessage save(ListVO listVO) throws RemoteException {
        TransferReceiveVO vo = null;
        vo = (TransferReceiveVO) listVO;
        TransferReceivePO po = new TransferReceivePO(vo.getOrderNum(), vo.getArriveDate(), vo.getStart(), vo.getCargoState(), vo.getTransferCenterNum(), vo.getTransferNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
