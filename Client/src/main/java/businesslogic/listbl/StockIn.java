package businesslogic.listbl;

import businesslogic.commoditybl.CommodityController;
import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
import po.StockInPO;
import vo.ListVO;
import vo.StockInVO;
import vo.VO2PO;

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
    public boolean save(ListVO listVO) throws RemoteException {
        StockInVO vo = null;
        vo = (StockInVO) listVO;
        new CommodityController().stockIn(vo);
        StockInPO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存入库单"));

        return listDataService.save(po);
    }
}
