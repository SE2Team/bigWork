package businesslogic.listbl;

import po.StockOutPO;
import vo.ListVO;
import vo.StockOutVO;
import vo.VO2PO;

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
    public boolean save(ListVO listVO) throws RemoteException {
        StockOutVO vo = null;
        vo = (StockOutVO) listVO;
        StockOutPO po = VO2PO.convert(vo);
        return listDataService.save(po);
    }
}
