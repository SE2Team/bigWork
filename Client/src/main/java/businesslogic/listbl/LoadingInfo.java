package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.LoadingPO;
import po.OperationLogPO;
import vo.ListVO;
import vo.LoadingVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class LoadingInfo extends List {
    /**
     * Instantiates a new Loading info.
     *
     * @throws RemoteException the remote exception
     */
    public LoadingInfo() throws RemoteException {
        super();
    }


    public boolean save2File(ListVO listVO) throws RemoteException {
        LoadingVO vo = null;
        vo = (LoadingVO) listVO;

        LoadingPO po = VO2PO.convert(vo);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存装车单"));

        return listDataService.save(po);
    }

    public boolean afterCheck(LoadingVO vo) throws RemoteException {
        return listDataService.deleteList(VO2PO.convert(vo));
    }

    public boolean save(LoadingVO vo) throws RemoteException {
        LoadingPO po = null;
        po = VO2PO.convert(vo);
        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(), Helper.getUserType().toString(),
                "新建装车单"));
        return listDataService.saveAsList(po);//保存为待审批
    }

}
