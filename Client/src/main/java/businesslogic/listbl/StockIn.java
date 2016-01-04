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

    public boolean save2File(ListVO listVO) throws RemoteException {
        StockInVO vo = null;
        vo = (StockInVO) listVO;
        String organization =
        new CommodityController().stockIn(vo);
        StockInPO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存入库单"));

        return listDataService.save(po);
    }

    public boolean save(StockInVO vo) throws RemoteException {
        StockInPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建入库单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

    public boolean afterCheck(StockInVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }

}
