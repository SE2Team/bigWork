package businesslogic.listbl;

import businesslogic.commoditybl.CommodityController;
import businesslogic.utilitybl.Helper;
import po.OperationLogPO;
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
        StockOutVO vo = (StockOutVO) listVO;
        new CommodityController().stockOut(vo);
        StockOutPO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存出库单"));
        return listDataService.save(po);
    }
}
