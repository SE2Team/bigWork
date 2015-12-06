package businesslogic.listbl;

import po.TransferPO;
import util.ResultMessage;
import vo.ListVO;
import vo.TransferVO;

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
    public ResultMessage save(ListVO listVO) throws RemoteException {
        TransferVO vo = null;
        vo = (TransferVO) listVO;
        TransferPO po = new TransferPO(vo.getLoadingWay(), vo.getLoadingDate(), vo.getTransportNum(), vo.getVehicleNum(),
                vo.getStart(), vo.getEnd(), vo.getContainerNum(), vo.getMonitor(), vo.getSupercargo(), vo.getOrderNum(), vo.getMoney());
        listDataService.saveAsList(po);

        return listDataService.save(po);
    }
}
