package businesslogic.listbl;

import po.StockInPO;
import util.ResultMessage;
import vo.ListVO;
import vo.StockInVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class StockIn extends List {
    /**
     * Instantiates a new Stock in.
     *
     * @throws RemoteException the remote exception
     */
    public StockIn() throws RemoteException {
    }

    @Override
    public ResultMessage save(ListVO listVO) throws RemoteException {
        StockInVO vo = null;
        vo = (StockInVO) listVO;
        StockInPO po = new StockInPO(vo.getDeliveryNum(), vo.getInDate(), vo.getEnd(), vo.getZoneNum(), vo.getRowNum(), vo.getShelfNum(), vo.getPositionNum());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }
}
