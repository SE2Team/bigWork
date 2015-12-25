package businesslogic.listbl;

import businesslogic.utilitybl.Helper;
import po.GatheringPO;
import po.OperationLogPO;
import vo.GatheringVO;
import vo.ListVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class Gathering extends List {

    /**
     * Instantiates a new Gathering.
     *
     * @throws RemoteException the remote exception
     */
    public Gathering() throws RemoteException {
        super();
    }

    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        GatheringVO gatheringVO = (GatheringVO) listVO;

        GatheringPO po = VO2PO.convert(gatheringVO);

        inquiryDataService.saveOperationLog(new OperationLogPO(Helper.getTime(),Helper.getUserType().toString(),
                "保存收款单（财务）"));
        return listDataService.save(po);

    }


}
