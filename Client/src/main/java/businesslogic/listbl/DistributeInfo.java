package businesslogic.listbl;

import po.DistributePO;
import util.ResultMessage;
import vo.DistributeVO;
import vo.ListVO;

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
    public ResultMessage save(ListVO listVO) throws  RemoteException {
        DistributeVO vo = null;
        vo = (DistributeVO) listVO;

        DistributePO po = new DistributePO(vo.getArriveDate(), vo.getOrderNum(), vo.getArriveDate());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
