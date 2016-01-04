package businesslogic.listbl;

import businesslogic.commoditybl.CommodityController;
import businesslogic.managebl.ManageController;
import businesslogic.utilitybl.Helper;
import businesslogicservice.ManageblService;
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

    public boolean save2File(ListVO listVO) throws RemoteException {
        StockOutVO vo = (StockOutVO) listVO;
        ManageblService manageblService = new ManageController();
        String organization = manageblService.checkOrganization(vo.getDeliveryNum().substring(0, 3) + "0").getName();
        new CommodityController(organization).stockOut(vo);
        StockOutPO po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "保存出库单"));
        return listDataService.save(po, organization);
    }

    public boolean save(StockOutVO vo) throws RemoteException {
        StockOutPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建出库单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

    public boolean afterCheck(StockOutVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }

}
