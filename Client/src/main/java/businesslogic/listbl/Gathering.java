package businesslogic.listbl;

import po.GatheringPO;
import util.ResultMessage;
import vo.GatheringVO;
import vo.ListVO;

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
    public ResultMessage save(ListVO listVO) throws RemoteException {
        GatheringVO gatheringVO = (GatheringVO) listVO;

        GatheringPO po = new GatheringPO(gatheringVO.getDate(), gatheringVO.getWorkplace(), gatheringVO.getMan(), gatheringVO.getMoney(), gatheringVO.getPlace());
        listDataService.saveAsList(po);
        return listDataService.save(po);
    }

    @Override
    public ResultMessage get() {
        return super.get();
    }
}
