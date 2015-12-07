package businesslogic.listbl;

import po.LoadingPO;
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


    @Override
    public boolean save(ListVO listVO) throws RemoteException {
        LoadingVO vo = null;
        vo = (LoadingVO) listVO;

        LoadingPO po = VO2PO.convert(vo);

        return listDataService.save(po);
    }

}
