package businesslogic.listbl;

import po.StockOutPO;
import util.ResultMessage;
import vo.ListVO;
import vo.StockOutVO;

import java.rmi.RemoteException;

/**
 * The type Stock out.
 *
 * @author myk
 */
public class StockOut extends List {
    /**
     * Instantiates a new Stock out.
     *
     * @throws RemoteException the remote exception
     */
    public StockOut() throws RemoteException {
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException {
        StockOutVO vo = null;
        vo = (StockOutVO) listVO;
        StockOutPO po = new StockOutPO(vo.getDeliveryNum(), vo.getOutDate(), vo.getEnd(), vo.getTransportType(), vo.getTransferNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
