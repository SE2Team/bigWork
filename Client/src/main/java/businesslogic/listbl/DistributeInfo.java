package businesslogic.listbl;

import po.DistributePO;
import vo.DistributeVO;
import vo.ListVO;
import vo.VO2PO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/16 0016.
 *
 * @author myk
 */
public class DistributeInfo extends List {
    /**
     * Instantiates a new Distribute info.
     *
     * @throws RemoteException the remote exception
     */
    public DistributeInfo() throws RemoteException {
        super();
    }

    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        DistributeVO vo = null;
        vo = (DistributeVO) listVO;

        DistributePO po = VO2PO.convert(vo);
        return listDataService.save(po);
    }
}
